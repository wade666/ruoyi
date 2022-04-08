package com.ruoyi.goods.controller;

import java.util.Iterator;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import com.ruoyi.common.core.constant.UserConstants;
import com.ruoyi.common.core.utils.StringUtils;
import com.ruoyi.common.security.utils.SecurityUtils;
import com.ruoyi.goods.domain.TProductBrand;
import com.ruoyi.goods.service.ITProductBrandService;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.log.annotation.Log;
import com.ruoyi.common.log.enums.BusinessType;
import com.ruoyi.common.security.annotation.RequiresPermissions;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;

/**
 * 商品品牌Controller
 *
 * @author ruoyi
 * @date 2022-01-24
 */
@RestController
@RequestMapping("/brand")
public class TProductBrandController extends BaseController {
    @Autowired
    private ITProductBrandService tProductBrandService;

    /**
     * 查询商品品牌列表
     */
    @RequiresPermissions("goods:brand:list")
    @GetMapping("/list")
    public AjaxResult list(TProductBrand tProductBrand) {
        List<TProductBrand> lists = tProductBrandService.selectTProductBrandList(tProductBrand);
        return AjaxResult.success(lists);
    }

    /**
     * 查询商品品牌列表（排除节点）
     */
    @RequiresPermissions("goods:brand:list")
    @GetMapping("/list/exclude/{brandId}")
    public AjaxResult excludeChild(@PathVariable(value = "brandId", required = false) Long brandId) {
        List<TProductBrand> categories = tProductBrandService.selectTProductBrandList(new TProductBrand());
        Iterator<TProductBrand> it = categories.iterator();
        while (it.hasNext()) {
            TProductBrand c = (TProductBrand) it.next();
            if (c.getBrandId().intValue() == brandId
                    || ArrayUtils.contains(StringUtils.split(c.getAncestors(), ","), brandId + "")) {
                it.remove();
            }
        }
        return AjaxResult.success(categories);
    }

    /**
     * 导出商品品牌列表
     */
    @RequiresPermissions("goods:brand:export")
    @Log(title = "商品品牌", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TProductBrand tProductBrand) {
        List<TProductBrand> list = tProductBrandService.selectTProductBrandList(tProductBrand);
        ExcelUtil<TProductBrand> util = new ExcelUtil<TProductBrand>(TProductBrand.class);
        util.exportExcel(response, list, "商品品牌数据");
    }

    /**
     * 获取商品品牌详细信息
     */
    @RequiresPermissions("goods:brand:query")
    @GetMapping(value = "/{brandId}")
    public AjaxResult getInfo(@PathVariable("brandId") Long brandId) {
        return AjaxResult.success(tProductBrandService.selectTProductBrandByBrandId(brandId));
    }

    /**
     * 获取商品品牌下拉树列表
     */
    @GetMapping("/treeselect")
    public AjaxResult treeselect(TProductBrand tProductBrand) {
        List<TProductBrand> categories = tProductBrandService.selectTProductBrandList(tProductBrand);
        return AjaxResult.success(tProductBrandService.buildProductBrandTreeSelect(categories));
    }

    /**
     * 加载对应商品品牌列表树
     */
    @GetMapping(value = "/roleTProductBrandTreeselect/{roleId}")
    public AjaxResult roleTProductBrandTreeselect(@PathVariable("roleId") Long roleId) {
        List<TProductBrand> categories = tProductBrandService.selectTProductBrandList(new TProductBrand());
        AjaxResult ajax = AjaxResult.success();
        ajax.put("checkedKeys", tProductBrandService.selectProductBrandListByRoleId(roleId));
        ajax.put("categories", tProductBrandService.buildProductBrandTreeSelect(categories));
        return ajax;
    }

    /**
     * 新增商品品牌
     */
    @RequiresPermissions("goods:brand:add")
    @Log(title = "商品品牌", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@Validated @RequestBody TProductBrand tProductBrand) {
        if (UserConstants.NOT_UNIQUE.equals(tProductBrandService.checkBrandNameUnique(tProductBrand))) {
            return AjaxResult.error("新增品牌'" + tProductBrand.getBrandName() + "'失败，品牌名称已存在");
        }
        tProductBrand.setCreateBy(SecurityUtils.getUsername());
        return toAjax(tProductBrandService.insertTProductBrand(tProductBrand));
    }

    /**
     * 修改商品品牌
     */
    @RequiresPermissions("goods:brand:edit")
    @Log(title = "商品品牌", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TProductBrand tProductBrand) {
        if (UserConstants.NOT_UNIQUE.equals(tProductBrandService.checkBrandNameUnique(tProductBrand))) {
            return AjaxResult.error("修改品牌'" + tProductBrand.getBrandName() + "'失败，品牌名称已存在");
        } else if (tProductBrand.getParentId().equals(tProductBrand.getBrandId())) {
            return AjaxResult.error("修改品牌'" + tProductBrand.getBrandName() + "'失败，上级品牌不能是自己");
        } else if (StringUtils.equals(UserConstants.DEPT_DISABLE, tProductBrand.getStatus())
                && tProductBrandService.selectNormalChildrenBrandById(tProductBrand.getBrandId()) > 0) {
            return AjaxResult.error("该品牌包含未停用的子品牌！");
        }
        tProductBrand.setUpdateBy(SecurityUtils.getUsername());
        return toAjax(tProductBrandService.updateTProductBrand(tProductBrand));
    }

    /**
     * 删除商品品牌
     */
    @RequiresPermissions("goods:brand:remove")
    @Log(title = "商品品牌", businessType = BusinessType.DELETE)
    @DeleteMapping("/{brandIds}")
    public AjaxResult remove(@PathVariable Long[] brandIds) {
        return toAjax(tProductBrandService.deleteTProductBrandByBrandIds(brandIds));
    }
}
