<template>
  <div class="app-container">
    <el-row :gutter="20">
      <!--品牌数据-->
      <el-col :span="4" :xs="24">
        <div class="head-container">
          <el-input
            v-model="brandName"
            placeholder="请输入品牌名称"
            clearable
            size="small"
            prefix-icon="el-icon-search"
            style="margin-bottom: 20px"
          />
        </div>
        <div class="head-container">
          <el-tree
            :data="brandOptions"
            :props="defaultProps"
            :expand-on-click-node="false"
            :filter-node-method="filterNode"
            ref="tree"
            default-expand-all
            @node-click="handleNodeClick"
          />
        </div>
      </el-col>
      <!--商品数据-->
      <el-col :span="20" :xs="24">
        <el-form :model="queryParams" ref="queryForm" :inline="true" v-show="showSearch" label-width="68px">
          <el-form-item label="商品名称" prop="productName">
            <el-input
              v-model="queryParams.productName"
              placeholder="请输入商品名称"
              clearable
              size="small"
              style="width: 240px"
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
              v-hasPermi="['goods:product:add']"
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
              v-hasPermi="['goods:product:edit']"
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
              v-hasPermi="['goods:product:remove']"
            >删除</el-button>
          </el-col>
          <el-col :span="1.5">
            <el-button
              type="info"
              plain
              icon="el-icon-upload2"
              size="mini"
              @click="handleImport"
              v-hasPermi="['goods:product:import']"
            >导入</el-button>
          </el-col>
          <el-col :span="1.5">
            <el-button
              type="warning"
              plain
              icon="el-icon-download"
              size="mini"
              @click="handleExport"
              v-hasPermi="['goods:product:export']"
            >导出</el-button>
          </el-col>
          <right-toolbar :showSearch.sync="showSearch" @queryTable="getList" :columns="columns"></right-toolbar>
        </el-row>

        <el-table v-loading="loading" :data="productList" @selection-change="handleSelectionChange">
          <el-table-column type="selection" width="50" align="center" />
          <el-table-column label="商品编号" align="center" key="id" prop="id" v-if="columns[0].visible" />
          <el-table-column label="商品名称" align="center" key="productName" prop="productName" v-if="columns[1].visible" :show-overflow-tooltip="true" />
          <el-table-column label="是否上架" align="center" key="isMarketable" v-if="columns[2].visible">
            <template slot-scope="scope">
              <el-switch
                v-model="scope.row.isMarketable"
                active-value="1"
                inactive-value="2"
                @change="handleStatusChange(scope.row)"
              ></el-switch>
            </template>
          </el-table-column>
          <el-table-column label="创建时间" align="center" prop="createTime" v-if="columns[3].visible" width="160">
            <template slot-scope="scope">
              <span>{{ parseTime(scope.row.createTime) }}</span>
            </template>
          </el-table-column>
          <el-table-column
            label="操作"
            align="center"
            width="160"
            class-name="small-padding fixed-width"
          >
            <template slot-scope="scope">
              <el-button
                size="mini"
                type="text"
                icon="el-icon-edit"
                @click="handleUpdate(scope.row)"
                v-hasPermi="['goods:product:edit']"
              >修改</el-button>
              <el-button
                size="mini"
                type="text"
                icon="el-icon-delete"
                @click="handleDelete(scope.row)"
                v-hasPermi="['goods:product:remove']"
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
      </el-col>
    </el-row>

    <!-- 添加或修改商品对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="商品标号" prop="sn">
          <el-input v-model="form.sn" placeholder="请输入商品标号" />
        </el-form-item>
        <el-form-item label="商品名称" prop="productName">
          <el-input v-model="form.productName" placeholder="请输入商品名称" />
        </el-form-item>
        <el-form-item label="商品主图">
          <image-upload v-model="form.image"/>
        </el-form-item>
        <el-form-item label="商品销售价" prop="price">
          <el-input v-model="form.price" placeholder="请输入商品销售价" />
        </el-form-item>
        <el-form-item label="会员价格" prop="vipPrice">
          <el-input v-model="form.vipPrice" placeholder="请输入会员价格" />
        </el-form-item>
        <el-form-item label="关联商品分类" prop="productCategoryId">
          <el-input v-model="form.productCategoryId" placeholder="请输入关联商品分类" />
        </el-form-item>
        <el-form-item label="单位名" prop="unit">
          <el-input v-model="form.unit" placeholder="请输入单位名" />
        </el-form-item>
        <el-form-item label="排序正序" prop="sort">
          <el-input v-model="form.sort" placeholder="请输入排序正序" />
        </el-form-item>
        <el-form-item label="销量" prop="sales">
          <el-input v-model="form.sales" placeholder="请输入销量" />
        </el-form-item>
        <el-form-item label="产品描述" prop="introduction">
          <el-input v-model="form.introduction" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="是否删除" prop="isDel">
          <el-input v-model="form.isDel" placeholder="请输入是否删除" />
        </el-form-item>
        <el-form-item label="副标题" prop="caption">
          <el-input v-model="form.caption" placeholder="请输入副标题" />
        </el-form-item>
        <el-form-item label="市场价" prop="marketPrice">
          <el-input v-model="form.marketPrice" placeholder="请输入市场价" />
        </el-form-item>
        <el-form-item label="是否上架" prop="isMarketable">
          <el-input v-model="form.isMarketable" placeholder="请输入是否上架" />
        </el-form-item>
        <el-form-item label="备注" prop="memo">
          <el-input v-model="form.memo" placeholder="请输入备注" />
        </el-form-item>
        <el-form-item label="冗余" prop="seoTitle">
          <el-input v-model="form.seoTitle" placeholder="请输入冗余" />
        </el-form-item>
        <el-form-item label="搜索关键词" prop="keyword">
          <el-input v-model="form.keyword" placeholder="请输入搜索关键词" />
        </el-form-item>
        <el-form-item label="品牌id" prop="brandId">
          <el-input v-model="form.brandId" placeholder="请输入品牌id" />
        </el-form-item>
        <el-form-item label="版本号" prop="version">
          <el-input v-model="form.version" placeholder="请输入版本号" />
        </el-form-item>
        <el-form-item label="配送方式" prop="shippingMethodId">
          <el-input v-model="form.shippingMethodId" placeholder="请输入配送方式" />
        </el-form-item>
        <el-form-item label="仓库id" prop="warehouseId">
          <el-input v-model="form.warehouseId" placeholder="请输入仓库id" />
        </el-form-item>
        <el-form-item label="项目id" prop="projectId">
          <el-input v-model="form.projectId" placeholder="请输入项目id" />
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>

    <!-- 用户导入对话框 -->
    <el-dialog :title="upload.title" :visible.sync="upload.open" width="400px" append-to-body>
      <el-upload
        ref="upload"
        :limit="1"
        accept=".xlsx, .xls"
        :headers="upload.headers"
        :action="upload.url + '?updateSupport=' + upload.updateSupport"
        :disabled="upload.isUploading"
        :on-progress="handleFileUploadProgress"
        :on-success="handleFileSuccess"
        :auto-upload="false"
        drag
      >
        <i class="el-icon-upload"></i>
        <div class="el-upload__text">将文件拖到此处，或<em>点击上传</em></div>
        <div class="el-upload__tip text-center" slot="tip">
          <div class="el-upload__tip" slot="tip">
            <el-checkbox v-model="upload.updateSupport" /> 是否更新已经存在的商品数据
          </div>
          <span>仅允许导入xls、xlsx格式文件。</span>
          <el-link type="primary" :underline="false" style="font-size:12px;vertical-align: baseline;" @click="importTemplate">下载模板</el-link>
        </div>
      </el-upload>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitFileForm">确 定</el-button>
        <el-button @click="upload.open = false">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listProduct, getProduct, delProduct, addProduct, updateProduct, resetProductPwd, changeProductStatus } from "@/api/goods/product";
import { getToken } from "@/utils/auth";
import { treeselect } from "@/api/goods/brand";
import Treeselect from "@riophae/vue-treeselect";
import "@riophae/vue-treeselect/dist/vue-treeselect.css";

export default {
  name: "Product",
  dicts: ['sys_normal_disable', 'sys_product_sex'],
  components: { Treeselect },
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
      // 用户表格数据
      productList: null,
      // 弹出层标题
      title: "",
      // 部门树选项
      brandOptions: undefined,
      // 是否显示弹出层
      open: false,
      // 品牌名称
      brandName: undefined,
      // 默认密码
      initPassword: undefined,
      // 日期范围
      dateRange: [],
      // 岗位选项
      postOptions: [],
      // 角色选项
      roleOptions: [],
      // 表单参数
      form: {},
      defaultProps: {
        children: "children",
        label: "label"
      },
      // 用户导入参数
      upload: {
        // 是否显示弹出层（用户导入）
        open: false,
        // 弹出层标题（用户导入）
        title: "",
        // 是否禁用上传
        isUploading: false,
        // 是否更新已经存在的用户数据
        updateSupport: 0,
        // 设置上传的请求头部
        headers: { Authorization: "Bearer " + getToken() },
        // 上传的地址
        url: process.env.VUE_APP_BASE_API + "/goods/product/importData"
      },
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        productName: undefined,
        status: undefined,
        brandId: undefined
      },
      // 列信息
      columns: [
        { key: 0, label: `商品编号`, visible: true },
        { key: 1, label: `商品名称`, visible: true },
        { key: 2, label: `是否上架`, visible: true },
        { key: 3, label: `创建时间`, visible: true }
      ],
      // 表单校验
      rules: {
        productName: [
          { required: true, message: "商品名称不能为空", trigger: "blur" },
          { min: 2, max: 20, message: '商品名称长度必须介于 2 和 20 之间', trigger: 'blur' }
        ]
      }
    };
  },
  watch: {
    // 根据名称筛选部门树
    brandName(val) {
      this.$refs.tree.filter(val);
    }
  },
  created() {
    this.getList();
    this.getTreeselect();
    this.getConfigKey("sys.product.initPassword").then(response => {
      this.initPassword = response.msg;
    });
  },
  methods: {
    /** 查询商品列表 */
    getList() {
      this.loading = true;
      listProduct(this.addDateRange(this.queryParams, this.dateRange)).then(response => {
          this.productList = response.rows;
          this.total = response.total;
          this.loading = false;
        }
      );
    },
    /** 查询品牌下拉树结构 */
    getTreeselect() {
      treeselect().then(response => {
        this.brandOptions = response.data;
      });
    },
    // 筛选节点
    filterNode(value, data) {
      if (!value) return true;
      return data.label.indexOf(value) !== -1;
    },
    // 节点单击事件
    handleNodeClick(data) {
      this.queryParams.brandId = data.id;
      this.handleQuery();
    },
    // 上下架修改
    handleStatusChange(row) {
      let text = row.isMarketable === "1" ? "上架" : "下架";
      this.$modal.confirm('确认要"' + text + '""' + row.productName + '"商品吗？').then(function() {
        return changeProductStatus(row.id, row.isMarketable);
      }).then(() => {
        this.$modal.msgSuccess(text + "成功");
      }).catch(function() {
        row.isMarketable = row.isMarketable === "1" ? "2" : "1";
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
        id: undefined,
        brandId: undefined,
        productName: undefined,
        remark: undefined,
        postIds: [],
        roleIds: []
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
      this.dateRange = [];
      this.resetForm("queryForm");
      this.handleQuery();
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.id);
      this.single = selection.length != 1;
      this.multiple = !selection.length;
    },
    /** 新增按钮操作 */
    handleAdd() {
    console.log("新增按钮操作");
      this.reset();
      // this.getTreeselect();
      getProduct().then(response => {
      console.log("新增按钮："+response.posts);
        this.postOptions = response.posts;
        this.open = true;
        this.title = "添加商品";
      });
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      // this.getTreeselect();
      const id = row.id || this.ids;
      getProduct(id).then(response => {
        this.form = response.data;
        this.postOptions = response.posts;
        this.form.postIds = response.postIds;
        this.open = true;
        this.title = "修改商品";
      });
    },
    /** 提交按钮 */
    submitForm: function() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != undefined) {
            updateProduct(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addProduct(this.form).then(response => {
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
      this.$modal.confirm('是否确认删除用户编号为"' + ids + '"的数据项？').then(function() {
        return delProduct(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('goods/product/export', {
        ...this.queryParams
      }, `product_${new Date().getTime()}.xlsx`)
    },
    /** 导入按钮操作 */
    handleImport() {
      this.upload.title = "用户导入";
      this.upload.open = true;
    },
    /** 下载模板操作 */
    importTemplate() {
      this.download('goods/product/importTemplate', {
      }, `product_template_${new Date().getTime()}.xlsx`)
    },
    // 文件上传中处理
    handleFileUploadProgress(event, file, fileList) {
      this.upload.isUploading = true;
    },
    // 文件上传成功处理
    handleFileSuccess(response, file, fileList) {
      this.upload.open = false;
      this.upload.isUploading = false;
      this.$refs.upload.clearFiles();
      this.$alert("<div style='overflow: auto;overflow-x: hidden;max-height: 70vh;padding: 10px 20px 0;'>" + response.msg + "</div>", "导入结果", { dangerouslyUseHTMLString: true });
      this.getList();
    },
    // 提交上传文件
    submitFileForm() {
      this.$refs.upload.submit();
    }
  }
};
</script>
