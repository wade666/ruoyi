package com.ruoyi.goods.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 采购入库单Controller
 * @author ruoyi
 * @date 2022-03-24
 */
@RestController
@RequestMapping("/purchaseintoCheck")
public class TWarehousePurchaseintoCheckController extends BaseController
{
    @Autowired
    private ITWarehousePurchaseintoService tWarehousePurchaseintoService;

    /**
     * 查询采购入库单列表
     */
    @RequiresPermissions("goods:purchaseintoCheck:list")
    @GetMapping("/list")
    public TableDataInfo list(TWarehousePurchaseinto tWarehousePurchaseinto)
    {
        startPage();
        List<TWarehousePurchaseinto> list = tWarehousePurchaseintoService.purchaseintoCheckList(tWarehousePurchaseinto);
        return getDataTable(list);
    }

    /**
     * 获取采购入库单详细信息
     */
    @RequiresPermissions("goods:purchaseintoCheck:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(tWarehousePurchaseintoService.selectTWarehousePurchaseintoById(id));
    }

    /**
     * 修改采购入库单
     */
    @RequiresPermissions("goods:purchaseintoCheck:edit")
    @Log(title = "采购入库单", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TWarehousePurchaseinto tWarehousePurchaseinto)
    {
        return toAjax(tWarehousePurchaseintoService.updateTWarehousePurchaseIntoCheck(tWarehousePurchaseinto));
    }
}
