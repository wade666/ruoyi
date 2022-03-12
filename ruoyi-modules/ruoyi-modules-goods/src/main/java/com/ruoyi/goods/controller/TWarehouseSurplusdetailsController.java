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
import com.ruoyi.goods.domain.TWarehouseSurplusdetails;
import com.ruoyi.goods.service.ITWarehouseSurplusdetailsService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 出入库明细Controller
 * 
 * @author ruoyi
 * @date 2022-03-08
 */
@RestController
@RequestMapping("/surplusdetails")
public class TWarehouseSurplusdetailsController extends BaseController
{
    @Autowired
    private ITWarehouseSurplusdetailsService tWarehouseSurplusdetailsService;

    /**
     * 查询出入库明细列表
     */
    @RequiresPermissions("goods:surplusdetails:list")
    @GetMapping("/list")
    public TableDataInfo list(TWarehouseSurplusdetails tWarehouseSurplusdetails)
    {
        startPage();
        List<TWarehouseSurplusdetails> list = tWarehouseSurplusdetailsService.selectTWarehouseSurplusdetailsList(tWarehouseSurplusdetails);
        return getDataTable(list);
    }

    /**
     * 导出出入库明细列表
     */
    @RequiresPermissions("goods:surplusdetails:export")
    @Log(title = "出入库明细", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TWarehouseSurplusdetails tWarehouseSurplusdetails)
    {
        List<TWarehouseSurplusdetails> list = tWarehouseSurplusdetailsService.selectTWarehouseSurplusdetailsList(tWarehouseSurplusdetails);
        ExcelUtil<TWarehouseSurplusdetails> util = new ExcelUtil<TWarehouseSurplusdetails>(TWarehouseSurplusdetails.class);
        util.exportExcel(response, list, "出入库明细数据");
    }

    /**
     * 获取出入库明细详细信息
     */
    @RequiresPermissions("goods:surplusdetails:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(tWarehouseSurplusdetailsService.selectTWarehouseSurplusdetailsById(id));
    }

    /**
     * 新增出入库明细
     */
    @RequiresPermissions("goods:surplusdetails:add")
    @Log(title = "出入库明细", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TWarehouseSurplusdetails tWarehouseSurplusdetails)
    {
        return toAjax(tWarehouseSurplusdetailsService.insertTWarehouseSurplusdetails(tWarehouseSurplusdetails));
    }

    /**
     * 修改出入库明细
     */
    @RequiresPermissions("goods:surplusdetails:edit")
    @Log(title = "出入库明细", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TWarehouseSurplusdetails tWarehouseSurplusdetails)
    {
        return toAjax(tWarehouseSurplusdetailsService.updateTWarehouseSurplusdetails(tWarehouseSurplusdetails));
    }

    /**
     * 删除出入库明细
     */
    @RequiresPermissions("goods:surplusdetails:remove")
    @Log(title = "出入库明细", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(tWarehouseSurplusdetailsService.deleteTWarehouseSurplusdetailsByIds(ids));
    }
}
