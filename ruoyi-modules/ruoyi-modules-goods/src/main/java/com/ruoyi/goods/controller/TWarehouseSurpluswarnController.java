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
import com.ruoyi.goods.domain.TWarehouseSurpluswarn;
import com.ruoyi.goods.service.ITWarehouseSurpluswarnService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 库存预警设置Controller
 * 
 * @author ruoyi
 * @date 2022-03-09
 */
@RestController
@RequestMapping("/surpluswarn")
public class TWarehouseSurpluswarnController extends BaseController
{
    @Autowired
    private ITWarehouseSurpluswarnService tWarehouseSurpluswarnService;

    /**
     * 查询库存预警设置列表
     */
    @RequiresPermissions("goods:surpluswarn:list")
    @GetMapping("/list")
    public TableDataInfo list(TWarehouseSurpluswarn tWarehouseSurpluswarn)
    {
        startPage();
        List<TWarehouseSurpluswarn> list = tWarehouseSurpluswarnService.selectTWarehouseSurpluswarnList(tWarehouseSurpluswarn);
        return getDataTable(list);
    }

    /**
     * 导出库存预警设置列表
     */
    @RequiresPermissions("goods:surpluswarn:export")
    @Log(title = "库存预警设置", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TWarehouseSurpluswarn tWarehouseSurpluswarn)
    {
        List<TWarehouseSurpluswarn> list = tWarehouseSurpluswarnService.selectTWarehouseSurpluswarnList(tWarehouseSurpluswarn);
        ExcelUtil<TWarehouseSurpluswarn> util = new ExcelUtil<TWarehouseSurpluswarn>(TWarehouseSurpluswarn.class);
        util.exportExcel(response, list, "库存预警设置数据");
    }

    /**
     * 获取库存预警设置详细信息
     */
    @RequiresPermissions("goods:surpluswarn:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(tWarehouseSurpluswarnService.selectTWarehouseSurpluswarnById(id));
    }

    /**
     * 新增库存预警设置
     */
    @RequiresPermissions("goods:surpluswarn:add")
    @Log(title = "库存预警设置", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TWarehouseSurpluswarn tWarehouseSurpluswarn)
    {
        return toAjax(tWarehouseSurpluswarnService.insertTWarehouseSurpluswarn(tWarehouseSurpluswarn));
    }

    /**
     * 修改库存预警设置
     */
    @RequiresPermissions("goods:surpluswarn:edit")
    @Log(title = "库存预警设置", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TWarehouseSurpluswarn tWarehouseSurpluswarn)
    {
        return toAjax(tWarehouseSurpluswarnService.updateTWarehouseSurpluswarn(tWarehouseSurpluswarn));
    }

    /**
     * 删除库存预警设置
     */
    @RequiresPermissions("goods:surpluswarn:remove")
    @Log(title = "库存预警设置", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(tWarehouseSurpluswarnService.deleteTWarehouseSurpluswarnByIds(ids));
    }
}
