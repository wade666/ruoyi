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
import com.ruoyi.goods.domain.TWarehousePurchase;
import com.ruoyi.goods.service.ITWarehousePurchaseService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 采购审核Controller
 * 
 * @author ruoyi
 * @date 2022-03-10
 */
@RestController
@RequestMapping("/purchaseCheck")
public class TWarehousePurchaseCheckController extends BaseController
{
    @Autowired
    private ITWarehousePurchaseService tWarehousePurchaseService;

    /**
     * 查询采购审核列表
     */
    @RequiresPermissions("goods:purchaseCheck:list")
    @GetMapping("/list")
    public TableDataInfo list(TWarehousePurchase tWarehousePurchase)
    {
        startPage();
        List<TWarehousePurchase> list = tWarehousePurchaseService.checkList(tWarehousePurchase);
        return getDataTable(list);
    }

    /**
     * 获取采购审核详细信息
     */
    @RequiresPermissions("goods:purchaseCheck:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(tWarehousePurchaseService.selectTWarehousePurchaseById(id));
    }

    /**
     * 修改采购审核
     */
    @RequiresPermissions("goods:purchaseCheck:edit")
    @Log(title = "采购审核", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TWarehousePurchase tWarehousePurchase)
    {
        return toAjax(tWarehousePurchaseService.updateTWarehousePurchaseCheck(tWarehousePurchase));
    }

}
