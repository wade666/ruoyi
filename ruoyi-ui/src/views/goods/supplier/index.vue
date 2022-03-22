<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="供货商编码" prop="supplierCode">
        <el-input
          v-model="queryParams.supplierCode"
          placeholder="请输入供货商编码"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="供货商名称" prop="supplierName">
        <el-input
          v-model="queryParams.supplierName"
          placeholder="请输入供货商名称"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="供货商状态 1正常 2禁用" prop="supplierState">
        <el-input
          v-model="queryParams.supplierState"
          placeholder="请输入供货商状态 1正常 2禁用"
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
          v-hasPermi="['goods:supplier:add']"
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
          v-hasPermi="['goods:supplier:edit']"
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
          v-hasPermi="['goods:supplier:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['goods:supplier:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="supplierList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="主键ID" align="center" prop="id" />
      <el-table-column label="供货商编码" align="center" prop="supplierCode" />
      <el-table-column label="供货商名称" align="center" prop="supplierName" />
      <el-table-column label="期初应付款" align="center" prop="startPay" />
      <el-table-column label="省" align="center" prop="provinceCode" />
      <el-table-column label="市" align="center" prop="cityCode" />
      <el-table-column label="区" align="center" prop="areaCode" />
      <el-table-column label="详细地址" align="center" prop="address" />
      <el-table-column label="邮编" align="center" prop="postalCode" />
      <el-table-column label="联系人" align="center" prop="contactName" />
      <el-table-column label="手机号" align="center" prop="contactPhone" />
      <el-table-column label="固话" align="center" prop="fixedTel" />
      <el-table-column label="税号" align="center" prop="taxNum" />
      <el-table-column label="开户行" align="center" prop="bankName" />
      <el-table-column label="开户账号" align="center" prop="bankAccount" />
      <el-table-column label="欠款额度" align="center" prop="arrears" />
      <el-table-column label="供货商状态" align="center" prop="supplierState" />
      <el-table-column label="备注" align="center" prop="remark" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['goods:supplier:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['goods:supplier:remove']"
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

    <!-- 添加或修改供货商对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="供货商编码" prop="supplierCode">
          <el-input v-model="form.supplierCode" placeholder="请输入供货商编码" />
        </el-form-item>
        <el-form-item label="供货商名称" prop="supplierName">
          <el-input v-model="form.supplierName" placeholder="请输入供货商名称" />
        </el-form-item>
        <el-form-item label="网站网址" prop="website">
          <el-input v-model="form.website" placeholder="请输入网站网址" />
        </el-form-item>
        <el-form-item label="期初应付款" prop="startPay">
          <el-input v-model="form.startPay" placeholder="请输入期初应付款" />
        </el-form-item>
        <el-form-item label="省" prop="provinceCode">
          <el-input v-model="form.provinceCode" placeholder="请输入省" />
        </el-form-item>
        <el-form-item label="市" prop="cityCode">
          <el-input v-model="form.cityCode" placeholder="请输入市" />
        </el-form-item>
        <el-form-item label="区" prop="areaCode">
          <el-input v-model="form.areaCode" placeholder="请输入区" />
        </el-form-item>
        <el-form-item label="详细地址" prop="address">
          <el-input v-model="form.address" placeholder="请输入详细地址" />
        </el-form-item>
        <el-form-item label="邮编" prop="postalCode">
          <el-input v-model="form.postalCode" placeholder="请输入邮编" />
        </el-form-item>
        <el-form-item label="联系人" prop="contactName">
          <el-input v-model="form.contactName" placeholder="请输入联系人" />
        </el-form-item>
        <el-form-item label="手机号" prop="contactPhone">
          <el-input v-model="form.contactPhone" placeholder="请输入手机号" />
        </el-form-item>
        <el-form-item label="固话" prop="fixedTel">
          <el-input v-model="form.fixedTel" placeholder="请输入固话" />
        </el-form-item>
        <el-form-item label="税号" prop="taxNum">
          <el-input v-model="form.taxNum" placeholder="请输入税号" />
        </el-form-item>
        <el-form-item label="开户行" prop="bankName">
          <el-input v-model="form.bankName" placeholder="请输入开户行" />
        </el-form-item>
        <el-form-item label="开户账号" prop="bankAccount">
          <el-input v-model="form.bankAccount" placeholder="请输入开户账号" />
        </el-form-item>
        <el-form-item label="欠款额度" prop="arrears">
          <el-input v-model="form.arrears" placeholder="请输入欠款额度" />
        </el-form-item>
        <el-form-item label="供货商状态" prop="supplierState">
          <el-input v-model="form.supplierState" placeholder="请输入供货商状态 1正常 2禁用" />
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
import { listSupplier, getSupplier, delSupplier, addSupplier, updateSupplier } from "@/api/goods/supplier";

export default {
  name: "Supplier",
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
      // 供货商表格数据
      supplierList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        supplierCode: null,
        supplierName: null,
        website: null,
        startPay: null,
        provinceCode: null,
        cityCode: null,
        areaCode: null,
        address: null,
        postalCode: null,
        contactName: null,
        contactPhone: null,
        fixedTel: null,
        taxNum: null,
        bankName: null,
        bankAccount: null,
        arrears: null,
        supplierState: null,
        version: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        supplierCode: [
          { required: true, message: "供货商编码不能为空", trigger: "blur" }
        ],
        supplierName: [
          { required: true, message: "供货商名称不能为空", trigger: "blur" }
        ],
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询供货商列表 */
    getList() {
      this.loading = true;
      listSupplier(this.queryParams).then(response => {
        this.supplierList = response.rows;
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
        supplierCode: null,
        supplierName: null,
        website: null,
        startPay: null,
        provinceCode: null,
        cityCode: null,
        areaCode: null,
        address: null,
        postalCode: null,
        contactName: null,
        contactPhone: null,
        fixedTel: null,
        taxNum: null,
        bankName: null,
        bankAccount: null,
        arrears: null,
        supplierState: null,
        createBy: null,
        createTime: null,
        updateTime: null,
        version: null,
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
      this.title = "添加供货商";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getSupplier(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改供货商";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateSupplier(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addSupplier(this.form).then(response => {
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
      this.$modal.confirm('是否确认删除供货商编号为"' + ids + '"的数据项？').then(function() {
        return delSupplier(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('goods/supplier/export', {
        ...this.queryParams
      }, `supplier_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
