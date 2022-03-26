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
      <el-form-item label="审核状态" prop="applyState">
        <el-input
          v-model="queryParams.applyState"
          placeholder="请输入审核状态"
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
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>
    <el-table v-loading="loading" :data="purchaseintoList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="主键id" align="center" prop="id" />
      <el-table-column label="仓库名" align="center" prop="warehouseName" />
      <el-table-column label="供货商" align="center" prop="supplierName" />
      <el-table-column label="审核状态" align="center" prop="applyStateName" />
      <el-table-column label="采购入库人id" align="center" prop="sysUserId" />
      <el-table-column label="当前审核人id" align="center" prop="nowCheckId" />
      <el-table-column label="审核人流程" align="center" prop="checkStep" />
      <el-table-column label="付款金额(元)" align="center" prop="payMoney" />
      <el-table-column label="备注" align="center" prop="remark" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['goods:purchaseintoCheck:edit']"
          >审核</el-button>
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

    <!-- 添加或修改采购入库单对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="审核状态" prop="applyState">
          <el-input v-model="form.applyState" placeholder="请输入审核状态" />
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
import { listPurchaseinto, getPurchaseinto, delPurchaseinto, addPurchaseinto, updatePurchaseinto } from "@/api/goods/purchaseintoCheck";

export default {
  name: "Purchaseinto",
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
      // 采购入库单表格数据
      purchaseintoList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        warehouseId: null,
        supplierId: null,
        applyState: null,
        sysUserId: null,
        nowCheckId: null,
        checkStep: null,
        checkIds: null,
        checkIndex: null,
        payMoney: null,
        version: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        warehouseId: [
          { required: true, message: "仓库id不能为空", trigger: "blur" }
        ],
        supplierId: [
          { required: true, message: "供货商id不能为空", trigger: "blur" }
        ],
        sysUserId: [
          { required: true, message: "采购入库人id不能为空", trigger: "blur" }
        ],
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询采购入库单列表 */
    getList() {
      this.loading = true;
      listPurchaseinto(this.queryParams).then(response => {
        this.purchaseintoList = response.rows;
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
        warehouseId: null,
        supplierId: null,
        applyState: null,
        sysUserId: null,
        nowCheckId: null,
        checkStep: null,
        checkIds: null,
        checkIndex: null,
        payMoney: null,
        createBy: null,
        createTime: null,
        updateTime: null,
        version: null,
        remark: null,
        delFlag: null
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

    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getPurchaseinto(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改采购入库单";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updatePurchaseinto(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addPurchaseinto(this.form).then(response => {
              this.$modal.msgSuccess("新增成功");
              this.open = false;
              this.getList();
            });
          }
        }
      });
    }
  }
};
</script>
