package com.ruoyi.goods.controller;

import java.util.List;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
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
import com.ruoyi.goods.domain.TWarehouseDispatch;
import com.ruoyi.goods.service.ITWarehouseDispatchService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 调拨单Controller
 * 
 * @author ruoyi
 * @date 2022-03-30
 */
@Api("调拨单")
@RestController
@RequestMapping("/dispatch")
public class TWarehouseDispatchController extends BaseController
{
    @Autowired
    private ITWarehouseDispatchService tWarehouseDispatchService;

    /**
     * 查询调拨单列表
     */
    @ApiOperation("查询调拨单列表")
    @RequiresPermissions("goods:dispatch:list")
    @GetMapping("/list")
    public TableDataInfo list(TWarehouseDispatch tWarehouseDispatch)
    {
        startPage();
        List<TWarehouseDispatch> list = tWarehouseDispatchService.selectTWarehouseDispatchList(tWarehouseDispatch);
        return getDataTable(list);
    }

    /**
     * 导出调拨单列表
     */
    @ApiOperation("导出调拨单列表")
    @RequiresPermissions("goods:dispatch:export")
    @Log(title = "调拨单", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TWarehouseDispatch tWarehouseDispatch)
    {
        List<TWarehouseDispatch> list = tWarehouseDispatchService.selectTWarehouseDispatchList(tWarehouseDispatch);
        ExcelUtil<TWarehouseDispatch> util = new ExcelUtil<TWarehouseDispatch>(TWarehouseDispatch.class);
        util.exportExcel(response, list, "调拨单数据");
    }

    /**
     * 获取调拨单详细信息
     */
    @ApiOperation("获取调拨单详细信息")
    @RequiresPermissions("goods:dispatch:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(tWarehouseDispatchService.selectTWarehouseDispatchById(id));
    }

    /**
     * 新增调拨单
     */
    @ApiOperation("新增调拨单")
    @RequiresPermissions("goods:dispatch:add")
    @Log(title = "调拨单", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@ApiParam(value = "新增调拨单", required = true) @RequestBody TWarehouseDispatch tWarehouseDispatch)
    {
        return toAjax(tWarehouseDispatchService.insertTWarehouseDispatch(tWarehouseDispatch));
    }

    /**
     * 修改调拨单
     */
    @ApiOperation("修改调拨单")
    @RequiresPermissions("goods:dispatch:edit")
    @Log(title = "调拨单", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TWarehouseDispatch tWarehouseDispatch)
    {
        return toAjax(tWarehouseDispatchService.updateTWarehouseDispatch(tWarehouseDispatch));
    }

    /**
     * 删除调拨单
     */
    @ApiOperation("删除调拨单")
    @RequiresPermissions("goods:dispatch:remove")
    @Log(title = "调拨单", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(tWarehouseDispatchService.deleteTWarehouseDispatchByIds(ids));
    }
}
