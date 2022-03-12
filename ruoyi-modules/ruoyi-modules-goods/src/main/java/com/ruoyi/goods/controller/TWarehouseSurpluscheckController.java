package com.ruoyi.goods.controller;

import java.util.List;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;
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
import com.ruoyi.goods.domain.TWarehouseSurpluscheck;
import com.ruoyi.goods.service.ITWarehouseSurpluscheckService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 库存盘点Controller
 * 
 * @author ruoyi
 * @date 2022-03-10
 */
@RestController
@RequestMapping("/surpluscheck")
public class TWarehouseSurpluscheckController extends BaseController
{
    @Autowired
    private ITWarehouseSurpluscheckService tWarehouseSurpluscheckService;

    /**
     * 查询库存盘点列表
     */
    @RequiresPermissions("goods:surpluscheck:list")
    @GetMapping("/list")
    public TableDataInfo list(TWarehouseSurpluscheck tWarehouseSurpluscheck)
    {
        startPage();
        List<TWarehouseSurpluscheck> list = tWarehouseSurpluscheckService.selectTWarehouseSurpluscheckList(tWarehouseSurpluscheck);
        return getDataTable(list);
    }

    /**
     * 导出库存盘点列表
     */
    @RequiresPermissions("goods:surpluscheck:export")
    @Log(title = "库存盘点", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TWarehouseSurpluscheck tWarehouseSurpluscheck)
    {
        List<TWarehouseSurpluscheck> list = tWarehouseSurpluscheckService.selectTWarehouseSurpluscheckList(tWarehouseSurpluscheck);
        ExcelUtil<TWarehouseSurpluscheck> util = new ExcelUtil<TWarehouseSurpluscheck>(TWarehouseSurpluscheck.class);
        util.exportExcel(response, list, "库存盘点数据");
    }

    /**
     * 获取库存盘点详细信息
     */
    @RequiresPermissions("goods:surpluscheck:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(tWarehouseSurpluscheckService.selectTWarehouseSurpluscheckById(id));
    }

    /**
     * 新增库存盘点
     */
    @RequiresPermissions("goods:surpluscheck:add")
    @Log(title = "库存盘点", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TWarehouseSurpluscheck tWarehouseSurpluscheck)
    {
        return toAjax(tWarehouseSurpluscheckService.insertTWarehouseSurpluscheck(tWarehouseSurpluscheck));
    }

    /**
     * 修改库存盘点
     */
    @RequiresPermissions("goods:surpluscheck:edit")
    @Log(title = "库存盘点", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TWarehouseSurpluscheck tWarehouseSurpluscheck)
    {
        return toAjax(tWarehouseSurpluscheckService.updateTWarehouseSurpluscheck(tWarehouseSurpluscheck));
    }

    /**
     * 删除库存盘点
     */
    @RequiresPermissions("goods:surpluscheck:remove")
    @Log(title = "库存盘点", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(tWarehouseSurpluscheckService.deleteTWarehouseSurpluscheckByIds(ids));
    }
}
