package com.ruoyi.goods.controller;

import java.util.List;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;

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
import com.ruoyi.goods.domain.TWarehousePurchase;
import com.ruoyi.goods.service.ITWarehousePurchaseService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 采购申请Controller
 * 
 * @author ruoyi
 * @date 2022-03-10
 */
@RestController
@RequestMapping("/purchase")
public class TWarehousePurchaseController extends BaseController
{
    @Autowired
    private ITWarehousePurchaseService tWarehousePurchaseService;

    /**
     * 查询采购申请列表
     */
    @RequiresPermissions("goods:purchase:list")
    @GetMapping("/list")
    public TableDataInfo list(TWarehousePurchase tWarehousePurchase)
    {
        startPage();
        List<TWarehousePurchase> list = tWarehousePurchaseService.selectTWarehousePurchaseList(tWarehousePurchase);
        return getDataTable(list);
    }

    /**
     * 导出采购申请列表
     */
    @RequiresPermissions("goods:purchase:export")
    @Log(title = "采购申请", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TWarehousePurchase tWarehousePurchase)
    {
        List<TWarehousePurchase> list = tWarehousePurchaseService.selectTWarehousePurchaseList(tWarehousePurchase);
        ExcelUtil<TWarehousePurchase> util = new ExcelUtil<TWarehousePurchase>(TWarehousePurchase.class);
        util.exportExcel(response, list, "采购申请数据");
    }

    /**
     * 获取采购申请详细信息
     */
    @RequiresPermissions("goods:purchase:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(tWarehousePurchaseService.selectTWarehousePurchaseById(id));
    }

    /**
     * 新增采购申请
     */
    @RequiresPermissions("goods:purchase:add")
    @Log(title = "采购申请", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TWarehousePurchase tWarehousePurchase)
    {
        return toAjax(tWarehousePurchaseService.insertTWarehousePurchase(tWarehousePurchase));
    }

    /**
     * 修改采购申请
     */
    @RequiresPermissions("goods:purchase:edit")
    @Log(title = "采购申请", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TWarehousePurchase tWarehousePurchase)
    {
        return toAjax(tWarehousePurchaseService.updateTWarehousePurchase(tWarehousePurchase));
    }

    /**
     * 删除采购申请
     */
    @RequiresPermissions("goods:purchase:remove")
    @Log(title = "采购申请", businessType = BusinessType.DELETE)
	@PutMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(tWarehousePurchaseService.deleteTWarehousePurchaseByIds(ids));
    }
    /**
     * 采购审核记录列表
     */
    @RequiresPermissions("goods:purchase:list")
    @GetMapping("/checkList")
    public AjaxResult checkList(TWarehousePurchase tWarehousePurchase)
    {
        List<TWarehousePurchaserecord> list = tWarehousePurchaseService.selectTWarehousePurchaseCheckList(tWarehousePurchase);
        return AjaxResult.success(list);
    }
}
