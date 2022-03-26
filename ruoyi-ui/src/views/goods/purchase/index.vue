<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="仓库id" prop="warehouseId">
        <el-input
          v-model="queryParams.warehouseId"
          placeholder="请输入仓库id"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="供货商id" prop="supplierId">
        <el-input
          v-model="queryParams.supplierId"
          placeholder="请输入供货商id"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="查询类型" prop="queryType">
        <el-input
          v-model="queryParams.queryType"
          placeholder="查询类型：1查本人 2查仓库"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
       <el-form-item label="审核状态" prop="applyState">
              <el-input
                v-model="queryParams.applyState"
                placeholder="请输入审核状态"
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
          v-hasPermi="['goods:purchase:add']"
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
          v-hasPermi="['goods:purchase:edit']"
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
          v-hasPermi="['goods:purchase:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['goods:purchase:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="purchaseList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="主键id" align="center" prop="id" />
      <el-table-column label="仓库名" align="center" prop="warehouseName" />
      <el-table-column label="供货商" align="center" prop="supplierName" />
      <el-table-column label="审核状态" align="center" prop="applyStateName" />
      <el-table-column label="订单状态" align="center" prop="intoStateName" />
      <el-table-column label="预付款(元)" align="center" prop="deposit" />
      <el-table-column label="创建人" align="center" prop="createBy" />
      <el-table-column label="审核流程" align="center" prop="checkStep" />
      <el-table-column label="备注" align="center" prop="remark" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['goods:purchase:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['goods:purchase:remove']"
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

    <!-- 添加或修改采购申请对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="商品id" prop="productId">
          <el-input v-model="form.productId" placeholder="请输入商品id" />
        </el-form-item>
        <el-form-item label="仓库id" prop="warehouseId">
          <el-input v-model="form.warehouseId" placeholder="请输入仓库id" />
        </el-form-item>
        <el-form-item label="供货商id" prop="supplierId">
          <el-input v-model="form.supplierId" placeholder="请输入供货商id" />
        </el-form-item>
        <el-form-item label="采购数量" prop="applyNum">
          <el-input v-model="form.applyNum" placeholder="请输入采购数量" />
        </el-form-item>
        <el-form-item label="采购总价" prop="applyPrice">
          <el-input v-model="form.applyPrice" placeholder="请输入采购总价" />
        </el-form-item>
        <el-form-item label="采购时间" prop="applyTime">
          <el-date-picker clearable size="small"
            v-model="form.applyTime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="选择采购时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="预计到货时间" prop="arriveTime">
          <el-date-picker clearable size="small"
            v-model="form.arriveTime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="选择预计到货时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="预付款(元)" prop="deposit">
          <el-input v-model="form.deposit" placeholder="请输入预付款(元)" />
        </el-form-item>
        <el-form-item label="待入库数量" prop="realNum">
          <el-input v-model="form.realNum" placeholder="请输入待入库数量" />
        </el-form-item>
        <el-form-item label="已入库数量" prop="alreadyNum">
          <el-input v-model="form.alreadyNum" placeholder="请输入已入库数量" />
        </el-form-item>
        <el-form-item label="批次号" prop="goodsCode">
          <el-input v-model="form.goodsCode" placeholder="请输入批次号" />
        </el-form-item>
        <el-form-item label="审核状态" prop="applyState">
          <el-input v-model="form.applyState" placeholder="请输入审核状态" />
        </el-form-item>
        <el-form-item label="采购人id" prop="sysUserId">
          <el-input v-model="form.sysUserId" placeholder="请输入采购人id" />
        </el-form-item>
        <el-form-item label="备注" prop="remark">
          <el-input v-model="form.remark" placeholder="请输入备注" />
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
import { listPurchase, getPurchase, delPurchase, addPurchase, updatePurchase } from "@/api/goods/purchase";

export default {
  name: "Purchase",
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
      // 采购申请表格数据
      purchaseList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        productId: null,
        warehouseId: null,
        supplierId: null,
        applyNum: null,
        applyPrice: null,
        applyTime: null,
        realNum: null,
        applyState: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        productId: [
          { required: true, message: "商品id不能为空", trigger: "blur" }
        ],
        warehouseId: [
          { required: true, message: "仓库id不能为空", trigger: "blur" }
        ],
        supplierId: [
          { required: true, message: "供货商id不能为空", trigger: "blur" }
        ],
        applyNum: [
          { required: true, message: "采购数量不能为空", trigger: "blur" }
        ],
        applyPrice: [
          { required: true, message: "采购总价不能为空", trigger: "blur" }
        ],
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询采购申请列表 */
    getList() {
      this.loading = true;
      listPurchase(this.queryParams).then(response => {
        this.purchaseList = response.rows;
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
        warehouseId: null,
        supplierId: null,
        applyNum: null,
        applyPrice: null,
        applyTime: null,
        realNum: null,
        applyState: null,
        remark: null
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
      this.title = "添加采购申请";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getPurchase(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改采购申请";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updatePurchase(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addPurchase(this.form).then(response => {
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
      this.$modal.confirm('是否确认删除采购申请编号为"' + ids + '"的数据项？').then(function() {
        return delPurchase(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('goods/purchase/export', {
        ...this.queryParams
      }, `purchase_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
