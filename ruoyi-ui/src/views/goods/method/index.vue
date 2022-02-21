<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="名称" prop="name">
        <el-input
          v-model="queryParams.name"
          placeholder="请输入名称"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="首重" prop="firstWeight">
        <el-input
          v-model="queryParams.firstWeight"
          placeholder="请输入首重"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="续重量" prop="continueWeight">
        <el-input
          v-model="queryParams.continueWeight"
          placeholder="请输入续重量"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="首重价格" prop="defaultFirstPrice">
        <el-input
          v-model="queryParams.defaultFirstPrice"
          placeholder="请输入首重价格"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="续重价格" prop="defaultContinuePrice">
        <el-input
          v-model="queryParams.defaultContinuePrice"
          placeholder="请输入续重价格"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['goods:method:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['goods:method:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['goods:method:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['goods:method:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="methodList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="排序" align="center" prop="orders" />
      <el-table-column label="名称" align="center" prop="name" />
      <el-table-column label="首重" align="center" prop="firstWeight" />
      <el-table-column label="续重量" align="center" prop="continueWeight" />
      <el-table-column label="首重价格" align="center" prop="defaultFirstPrice" />
      <el-table-column label="续重价格" align="center" prop="defaultContinuePrice" />
      <el-table-column label="介绍" align="center" prop="description" />
      <el-table-column label="阿里快递查询编码" align="center" prop="code" />
      <el-table-column label="快递助手物流编码" align="center" prop="courierCode" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['goods:method:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['goods:method:remove']"
          >删除</el-button>
        </template>
      </el-table-column>
    </el-table>

    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改配送方式对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="名称" prop="name">
          <el-input v-model="form.name" placeholder="请输入名称" />
        </el-form-item>
        <el-form-item label="首重" prop="firstWeight">
          <el-input v-model="form.firstWeight" placeholder="请输入首重" />
        </el-form-item>
        <el-form-item label="续重量" prop="continueWeight">
          <el-input v-model="form.continueWeight" placeholder="请输入续重量" />
        </el-form-item>
        <el-form-item label="首重价格" prop="defaultFirstPrice">
          <el-input v-model="form.defaultFirstPrice" placeholder="请输入默认首重价格" />
        </el-form-item>
        <el-form-item label="续重价格" prop="defaultContinuePrice">
          <el-input v-model="form.defaultContinuePrice" placeholder="请输入默认续重价格" />
        </el-form-item>
        <el-form-item label="介绍" prop="description">
          <el-input v-model="form.description" placeholder="请输入介绍" />
        </el-form-item>
        <el-form-item label="阿里快递查询编码" prop="code">
          <el-input v-model="form.code" placeholder="请输入阿里快递查询编码" />
        </el-form-item>
        <el-form-item label="快递助手物流编码" prop="courierCode">
          <el-input v-model="form.courierCode" placeholder="请输入快递助手物流编码" />
        </el-form-item>
        <el-form-item label="排序" prop="orders">
          <el-input v-model="form.orders" placeholder="请输入排序" />
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listMethod, getMethod, delMethod, addMethod, updateMethod } from "@/api/goods/method";

export default {
  name: "Method",
  data() {
    return {
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 配送方式表格数据
      methodList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        name: null,
        firstWeight: null,
        continueWeight: null,
        defaultFirstPrice: null,
        defaultContinuePrice: null,
        description: null,
        code: null,
        courierCode: null,
        orders: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        name: [
          { required: true, message: "名称不能为空", trigger: "blur" }
        ],
        firstWeight: [
          { required: true, message: "首重不能为空", trigger: "blur" }
        ],
        continueWeight: [
          { required: true, message: "续重量不能为空", trigger: "blur" }
        ],
        defaultFirstPrice: [
          { required: true, message: "首重价格不能为空", trigger: "blur" }
        ],
        defaultContinuePrice: [
          { required: true, message: "续重价格不能为空", trigger: "blur" }
        ]
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询配送方式列表 */
    getList() {
      this.loading = true;
      listMethod(this.queryParams).then(response => {
        this.methodList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        id: null,
        name: null,
        firstWeight: null,
        continueWeight: null,
        defaultFirstPrice: null,
        defaultContinuePrice: null,
        description: null,
        code: null,
        alipayCode: null,
        courierCode: null,
        createTime: null,
        updateTime: null,
        version: null,
        orders: null
      };
      this.resetForm("form");
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm");
      this.handleQuery();
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.id)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加配送方式";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getMethod(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改配送方式";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateMethod(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addMethod(this.form).then(response => {
              this.$modal.msgSuccess("新增成功");
              this.open = false;
              this.getList();
            });
          }
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const ids = row.id || this.ids;
      this.$modal.confirm('是否确认删除配送方式编号为"' + ids + '"的数据项？').then(function() {
        return delMethod(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('goods/method/export', {
        ...this.queryParams
      }, `method_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
