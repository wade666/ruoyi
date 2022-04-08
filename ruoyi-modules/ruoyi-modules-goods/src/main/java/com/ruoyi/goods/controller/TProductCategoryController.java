package com.ruoyi.goods.controller;

import java.util.Iterator;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import com.ruoyi.common.core.constant.UserConstants;
import com.ruoyi.common.core.utils.StringUtils;
import com.ruoyi.common.core.web.page.TableDataInfo;
import com.ruoyi.common.security.utils.SecurityUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.common.log.annotation.Log;
import com.ruoyi.common.log.enums.BusinessType;
import com.ruoyi.common.security.annotation.RequiresPermissions;
import com.ruoyi.goods.domain.TProductCategory;
import com.ruoyi.goods.service.ITProductCategoryService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import springfox.documentation.annotations.ApiIgnore;

/**
 * 商品分类Controller
 *
 * @author ruoyi
 * @date 2022-01-24
 */
@Api(description = "商品分类")
@RestController
@RequestMapping("/category")
public class TProductCategoryController extends BaseController {
    @Autowired
    private ITProductCategoryService tProductCategoryService;

    /**
     * 查询商品分类列表
     */
    @ApiOperation("查询仓库列表-真实")
    @ApiImplicitParams({@ApiImplicitParam(name = "categoryName",value = "分类名称",dataType = "String",paramType = "query"),
            @ApiImplicitParam(name = "status",value = "分类状态",dataType = "String",paramType = "query"),
            @ApiImplicitParam(name = "pageNum",value = "页码",dataType = "Integer",paramType = "query"),
            @ApiImplicitParam(name = "pageSize",value = "每页条数",dataType = "Integer",paramType = "query")})
    @RequiresPermissions("goods:category:list")
    @GetMapping("/list")
    public AjaxResult list(@ApiIgnore TProductCategory tProductCategory) {
        List<TProductCategory> lists = tProductCategoryService.selectTProductCategoryList(tProductCategory);
        return AjaxResult.success(lists);
    }

    /**
     * 查询商品分类列表（排除节点）
     */
    @ApiOperation("查询商品分类列表（排除节点）")
    @RequiresPermissions("goods:category:list")
    @GetMapping("/list/exclude/{categoryId}")
    public AjaxResult excludeChild(@PathVariable(value = "categoryId", required = false) Long categoryId) {
        List<TProductCategory> categories = tProductCategoryService.selectTProductCategoryList(new TProductCategory());
        Iterator<TProductCategory> it = categories.iterator();
        while (it.hasNext()) {
            TProductCategory c = (TProductCategory) it.next();
            if (c.getCategoryId().intValue() == categoryId
                    || ArrayUtils.contains(StringUtils.split(c.getAncestors(), ","), categoryId + "")) {
                it.remove();
            }
        }
        return AjaxResult.success(categories);
    }

    /**
     * 导出商品分类列表
     */
    @ApiOperation("导出商品分类列表")
    @RequiresPermissions("goods:category:export")
    @Log(title = "商品分类", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TProductCategory tProductCategory) {
        List<TProductCategory> list = tProductCategoryService.selectTProductCategoryList(tProductCategory);
        ExcelUtil<TProductCategory> util = new ExcelUtil<TProductCategory>(TProductCategory.class);
        util.exportExcel(response, list, "商品分类数据");
    }

    /**
     * 获取商品分类详细信息
     */
    @ApiOperation("获取商品分类详细信息")
    @RequiresPermissions("goods:category:query")
    @GetMapping(value = "/{categoryId}")
    public AjaxResult getInfo(@PathVariable("categoryId") Long categoryId) {
        return AjaxResult.success(tProductCategoryService.selectTProductCategoryByCategoryId(categoryId));
    }

    /**
     * 获取下拉树列表
     */
    @ApiOperation("获取下拉树列表")
    @GetMapping("/treeselect")
    public AjaxResult treeselect(TProductCategory tProductCategory) {
        List<TProductCategory> categories = tProductCategoryService.selectTProductCategoryList(tProductCategory);
        return AjaxResult.success(tProductCategoryService.buildProductCategoryTreeSelect(categories));
    }

    /**
     * 加载对应商品分类列表树
     */
    @ApiOperation("加载对应商品分类列表树")
    @GetMapping(value = "/roleTProductCategoryTreeselect/{roleId}")
    public AjaxResult roleTProductCategoryTreeselect(@PathVariable("roleId") Long roleId) {
        List<TProductCategory> categories = tProductCategoryService.selectTProductCategoryList(new TProductCategory());
        AjaxResult ajax = AjaxResult.success();
        ajax.put("checkedKeys", tProductCategoryService.selectProductCategoryListByRoleId(roleId));
        ajax.put("categories", tProductCategoryService.buildProductCategoryTreeSelect(categories));
        return ajax;
    }

    /**
     * 新增商品分类
     */
    @ApiOperation("新增商品分类")
    @RequiresPermissions("goods:category:add")
    @Log(title = "商品分类", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@Validated @RequestBody TProductCategory tProductCategory) {
        if (UserConstants.NOT_UNIQUE.equals(tProductCategoryService.checkCategoryNameUnique(tProductCategory))) {
            return AjaxResult.error("新增分类'" + tProductCategory.getCategoryName() + "'失败，分类名称已存在");
        }
        tProductCategory.setCreateBy(SecurityUtils.getUsername());
        return toAjax(tProductCategoryService.insertTProductCategory(tProductCategory));
    }

    /**
     * 修改商品分类
     */
    @ApiOperation("修改商品分类")
    @RequiresPermissions("goods:category:edit")
    @Log(title = "商品分类", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TProductCategory tProductCategory) {
        if (UserConstants.NOT_UNIQUE.equals(tProductCategoryService.checkCategoryNameUnique(tProductCategory))) {
            return AjaxResult.error("修改分类'" + tProductCategory.getCategoryName() + "'失败，分类名称已存在");
        } else if (tProductCategory.getParentId().equals(tProductCategory.getCategoryId())) {
            return AjaxResult.error("修改分类'" + tProductCategory.getCategoryName() + "'失败，上级分类不能是自己");
        } else if (StringUtils.equals(UserConstants.DEPT_DISABLE, tProductCategory.getStatus())
                && tProductCategoryService.selectNormalChildrenCategoryById(tProductCategory.getCategoryId()) > 0) {
            return AjaxResult.error("该分类包含未停用的子分类！");
        }
        tProductCategory.setUpdateBy(SecurityUtils.getUsername());
        return toAjax(tProductCategoryService.updateTProductCategory(tProductCategory));
    }

    /**
     * 删除商品分类
     */
    @ApiOperation("删除商品分类")
    @RequiresPermissions("goods:category:remove")
    @Log(title = "商品分类", businessType = BusinessType.DELETE)
    @DeleteMapping("/{categoryIds}")
    public AjaxResult remove(@PathVariable Long[] categoryIds) {
        return toAjax(tProductCategoryService.deleteTProductCategoryByCategoryIds(categoryIds));
    }
    /**
     * 查询仓库商品的所有分类
     */
    @ApiOperation("查询仓库商品的所有分类")
    @ApiImplicitParam(name = "warehouseId",value = "仓库id",dataType = "Long",paramType = "query",required = true)
    @RequiresPermissions("goods:category:query")
    @GetMapping(value = "/getCategory")
    public AjaxResult getProductInfo(@RequestParam("warehouseId") Long warehouseId){
        return AjaxResult.success(tProductCategoryService.getCategoryByWarehouseId(warehouseId));
    }
}
