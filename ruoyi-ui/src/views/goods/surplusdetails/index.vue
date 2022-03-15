<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="商品id" prop="productId">
        <el-input
          v-model="queryParams.productId"
          placeholder="请输入商品id"
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
          v-hasPermi="['goods:surplusdetails:add']"
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
          v-hasPermi="['goods:surplusdetails:edit']"
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
          v-hasPermi="['goods:surplusdetails:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['goods:surplusdetails:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="surplusdetailsList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="主键id" align="center" prop="id" />
      <el-table-column label="商品id" align="center" prop="productId" />
      <el-table-column label="商品名" align="center" prop="productName" />
      <el-table-column label="商品编码id" align="center" prop="productCode" />
      <el-table-column label="仓库id" align="center" prop="warehouseId" />
      <el-table-column label="仓库名" align="center" prop="warehouseName" />
      <el-table-column label="价格" align="center" prop="price" />
      <el-table-column label="厂家编码" align="center" prop="makertCode" />
      <el-table-column label="出入库类型" align="center" prop="surplusTypeName" />
      <el-table-column label="出入库详情" align="center" prop="detailTypeName" />
      <el-table-column label="备注" align="center" prop="bak" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['goods:surplusdetails:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['goods:surplusdetails:remove']"
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

    <!-- 添加或修改出入库明细对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="商品id" prop="productId">
          <el-input v-model="form.productId" placeholder="请输入商品id" />
        </el-form-item>
        <el-form-item label="商品编码id" prop="productCode">
          <el-input v-model="form.productCode" placeholder="请输入商品编码id" />
        </el-form-item>
        <el-form-item label="仓库id" prop="warehouseId">
          <el-input v-model="form.warehouseId" placeholder="请输入仓库id" />
        </el-form-item>
        <el-form-item label="价格" prop="price">
          <el-input v-model="form.price" placeholder="请输入价格" />
        </el-form-item>
        <el-form-item label="厂家编码" prop="makertCode">
          <el-input v-model="form.makertCode" placeholder="请输入厂家编码" />
        </el-form-item>
        <el-form-item label="备注" prop="bak">
          <el-input v-model="form.bak" placeholder="请输入备注" />
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
import { listSurplusdetails, getSurplusdetails, delSurplusdetails, addSurplusdetails, updateSurplusdetails } from "@/api/goods/surplusdetails";

export default {
  name: "Surplusdetails",
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
      // 出入库明细表格数据
      surplusdetailsList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        productId: null,
        productCode: null,
        warehouseId: null,
        price: null,
        makertCode: null,
        surplusType: null,
        detailType: null,
        bak: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        productId: [
          { required: true, message: "商品id不能为空", trigger: "blur" }
        ],
        productCode: [
          { required: true, message: "商品编码id不能为空", trigger: "blur" }
        ],
        warehouseId: [
          { required: true, message: "仓库id不能为空", trigger: "blur" }
        ],
        price: [
          { required: true, message: "价格不能为空", trigger: "blur" }
        ],
        makertCode: [
          { required: true, message: "厂家编码不能为空", trigger: "blur" }
        ],
        surplusType: [
          { required: true, message: "出入库类型不能为空", trigger: "change" }
        ],
        detailType: [
          { required: true, message: "出入库详情不能为空", trigger: "change" }
        ],
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询出入库明细列表 */
    getList() {
      this.loading = true;
      listSurplusdetails(this.queryParams).then(response => {
        this.surplusdetailsList = response.rows;
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
        productId: null,
        productCode: null,
        warehouseId: null,
        price: null,
        makertCode: null,
        createTime: null,
        surplusType: null,
        detailType: null,
        bak: null
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
      this.title = "添加出入库明细";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getSurplusdetails(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改出入库明细";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateSurplusdetails(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addSurplusdetails(this.form).then(response => {
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
      this.$modal.confirm('是否确认删除出入库明细编号为"' + ids + '"的数据项？').then(function() {
        return delSurplusdetails(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('goods/surplusdetails/export', {
        ...this.queryParams
      }, `surplusdetails_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
