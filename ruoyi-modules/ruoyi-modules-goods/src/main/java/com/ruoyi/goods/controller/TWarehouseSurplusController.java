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
import com.ruoyi.goods.domain.TWarehouseSurplus;
import com.ruoyi.goods.service.ITWarehouseSurplusService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;
import springfox.documentation.annotations.ApiIgnore;

/**
 * 库存Controller
 * 
 * @author ruoyi
 * @date 2022-03-08
 */
@Api(description = "库存管理")
@RestController
@RequestMapping("/surplus")
public class TWarehouseSurplusController extends BaseController
{
    @Autowired
    private ITWarehouseSurplusService tWarehouseSurplusService;

    /**
     * 查询库存列表
     */
    @ApiOperation("查询库存列表")
    @RequiresPermissions("goods:surplus:list")
    @GetMapping("/list")
    public TableDataInfo list(TWarehouseSurplus tWarehouseSurplus)
    {
        startPage();
        List<TWarehouseSurplus> list = tWarehouseSurplusService.selectTWarehouseSurplusList(tWarehouseSurplus);
        return getDataTable(list);
    }

    /**
     * 导出库存列表
     */
    @ApiOperation("导出库存列表")
    @RequiresPermissions("goods:surplus:export")
    @Log(title = "库存", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TWarehouseSurplus tWarehouseSurplus)
    {
        List<TWarehouseSurplus> list = tWarehouseSurplusService.selectTWarehouseSurplusList(tWarehouseSurplus);
        ExcelUtil<TWarehouseSurplus> util = new ExcelUtil<TWarehouseSurplus>(TWarehouseSurplus.class);
        util.exportExcel(response, list, "库存数据");
    }

    /**
     * 获取库存详细信息
     */
    @ApiOperation("获取库存详细信息")
    @RequiresPermissions("goods:surplus:query")
    @GetMapping(value = "/{surplusId}")
    public AjaxResult getInfo(@ApiParam(value = "库存id", required = true) @PathVariable("surplusId") Long surplusId)
    {
        return AjaxResult.success(tWarehouseSurplusService.selectTWarehouseSurplusBySurplusId(surplusId));
    }

    /**
     * 新增库存
     */
    @ApiOperation("新增库存")
    @RequiresPermissions("goods:surplus:add")
    @Log(title = "库存", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TWarehouseSurplus tWarehouseSurplus)
    {
        return toAjax(tWarehouseSurplusService.insertTWarehouseSurplus(tWarehouseSurplus));
    }

    /**
     * 修改库存
     */
    @ApiOperation("修改库存")
    @RequiresPermissions("goods:surplus:edit")
    @Log(title = "库存", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TWarehouseSurplus tWarehouseSurplus)
    {
        return toAjax(tWarehouseSurplusService.updateTWarehouseSurplus(tWarehouseSurplus));
    }

    /**
     * 删除库存
     */
    @ApiIgnore
    @RequiresPermissions("goods:surplus:remove")
    @Log(title = "库存", businessType = BusinessType.DELETE)
	@DeleteMapping("/{surplusIds}")
    public AjaxResult remove(@PathVariable Long[] surplusIds)
    {
        return toAjax(tWarehouseSurplusService.deleteTWarehouseSurplusBySurplusIds(surplusIds));
    }
    /**
     * 根据仓库id查询商品库存
     */
    @ApiOperation("根据仓库id查询商品库存")
    @RequiresPermissions("goods:surplus:query")
    @GetMapping(value = "/{warehouseId}")
    public TableDataInfo getProductInfo(@ApiParam(value = "仓库id", required = true) @PathVariable("warehouseId") Long warehouseId)
    {
        startPage();
        List<TWarehouseSurplus> list = tWarehouseSurplusService.selectTWarehouseSurplusByWarehouseId(warehouseId);
        return getDataTable(list);
    }
}
