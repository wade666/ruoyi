package com.ruoyi.goods.controller;

import java.util.List;

import com.alibaba.fastjson.JSON;
import com.ruoyi.common.security.utils.SecurityUtils;
import com.ruoyi.goods.domain.TProduct;
import com.ruoyi.goods.service.ITProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletResponse;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.web.page.TableDataInfo;
import com.ruoyi.common.log.annotation.Log;
import com.ruoyi.common.log.enums.BusinessType;
import com.ruoyi.common.security.annotation.RequiresPermissions;

/**
 * 商品Controller
 *
 * @author ruoyi
 * @date 2022-01-22
 */
@RestController
@RequestMapping("/product")
public class TProductController extends BaseController {
    @Autowired
    private ITProductService tProductService;

    /**
     * 查询商品列表
     */
    @RequiresPermissions("goods:product:list")
    @GetMapping("/list")
    public TableDataInfo list(TProduct tProduct) {
        startPage();
        List<TProduct> list = tProductService.selectTProductList(tProduct);
        return getDataTable(list);
    }

    /**
     * 导出商品列表
     */
    @RequiresPermissions("goods:product:export")
    @Log(title = "商品", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TProduct tProduct) {
        List<TProduct> list = tProductService.selectTProductList(tProduct);
        ExcelUtil<TProduct> util = new ExcelUtil<TProduct>(TProduct.class);
        util.exportExcel(response, list, "商品数据");
    }

    /**
     * 获取商品详细信息
     */
    @RequiresPermissions("goods:product:query")
    @GetMapping(value = {"/", "/{id}"})
    public AjaxResult getInfo(@PathVariable(value = "id", required = false) Long id) {
        return AjaxResult.success(tProductService.selectTProductById(id));
    }

    /**
     * 新增商品
     */
    @RequiresPermissions("goods:product:add")
    @Log(title = "商品", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TProduct tProduct) {
        tProduct.setImage("https://www.baidu.com/img/PC_880906d2a4ad95f5fafb2e540c5cdad7.png");
        tProduct.setProductType(1);
        return toAjax(tProductService.insertTProduct(tProduct));
    }

    /**
     * 修改商品
     */
    @RequiresPermissions("goods:product:edit")
    @Log(title = "商品", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TProduct tProduct) {
        return toAjax(tProductService.updateTProduct(tProduct));
    }

    /**
     * 删除商品
     */
    @RequiresPermissions("goods:product:remove")
    @Log(title = "商品", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(tProductService.deleteTProductByIds(ids));
    }

    /**
     * 上下架修改
     */
    @RequiresPermissions("goods:product:edit")
    @Log(title = "商品管理", businessType = BusinessType.UPDATE)
    @PutMapping("/changeProductStatus")
    public AjaxResult changeProductStatus(@RequestBody TProduct tProduct) {
        System.out.println("上下架修改:" + JSON.toJSONString(tProduct));
        tProduct.setUpdateBy(SecurityUtils.getUsername());
        return toAjax(tProductService.updateTProductStatus(tProduct));
    }
}
