package com.ruoyi.goods.controller;

import java.util.List;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.goods.domain.TWarehousePurchase;
import com.ruoyi.goods.domain.TWarehousePurchaserecord;
import org.springframework.beans.factory.annotation.Autowired;
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
import com.ruoyi.goods.domain.TWarehousePurchaseinto;
import com.ruoyi.goods.service.ITWarehousePurchaseintoService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 采购入库单Controller
 * 
 * @author ruoyi
 * @date 2022-03-24
 */
@RestController
@RequestMapping("/purchaseinto")
public class TWarehousePurchaseintoController extends BaseController
{
    @Autowired
    private ITWarehousePurchaseintoService tWarehousePurchaseintoService;

    /**
     * 查询采购入库单列表
     */
    @RequiresPermissions("goods:purchaseinto:list")
    @GetMapping("/list")
    public TableDataInfo list(TWarehousePurchaseinto tWarehousePurchaseinto)
    {
        startPage();
        List<TWarehousePurchaseinto> list = tWarehousePurchaseintoService.selectTWarehousePurchaseintoList(tWarehousePurchaseinto);
        return getDataTable(list);
    }

    /**
     * 导出采购入库单列表
     */
    @RequiresPermissions("goods:purchaseinto:export")
    @Log(title = "采购入库单", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TWarehousePurchaseinto tWarehousePurchaseinto)
    {
        List<TWarehousePurchaseinto> list = tWarehousePurchaseintoService.selectTWarehousePurchaseintoList(tWarehousePurchaseinto);
        ExcelUtil<TWarehousePurchaseinto> util = new ExcelUtil<TWarehousePurchaseinto>(TWarehousePurchaseinto.class);
        util.exportExcel(response, list, "采购入库单数据");
    }

    /**
     * 获取采购入库单详细信息
     */
    @RequiresPermissions("goods:purchaseinto:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(tWarehousePurchaseintoService.selectTWarehousePurchaseintoById(id));
    }

    /**
     * 新增采购入库单
     */
    @RequiresPermissions("goods:purchaseinto:add")
    @Log(title = "采购入库单", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TWarehousePurchaseinto tWarehousePurchaseinto)
    {
        return toAjax(tWarehousePurchaseintoService.insertTWarehousePurchaseinto(tWarehousePurchaseinto));
    }

    /**
     * 修改采购入库单
     */
    @RequiresPermissions("goods:purchaseinto:edit")
    @Log(title = "采购入库单", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TWarehousePurchaseinto tWarehousePurchaseinto)
    {
        return toAjax(tWarehousePurchaseintoService.updateTWarehousePurchaseinto(tWarehousePurchaseinto));
    }

    /**
     * 删除采购入库单
     */
    @RequiresPermissions("goods:purchaseinto:remove")
    @Log(title = "采购入库单", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(tWarehousePurchaseintoService.deleteTWarehousePurchaseintoByIds(ids));
    }
    /**
     * 采购入库审核记录列表
     */
    @RequiresPermissions("goods:purchaseinto:list")
    @GetMapping("/checkList")
    public AjaxResult checkList(TWarehousePurchaseinto tWarehousePurchaseinto)
    {
        List<TWarehousePurchaserecord> list = tWarehousePurchaseintoService.selectTWarehousePurchaseIntoCheckList(tWarehousePurchaseinto);
        return AjaxResult.success(list);
    }
}
