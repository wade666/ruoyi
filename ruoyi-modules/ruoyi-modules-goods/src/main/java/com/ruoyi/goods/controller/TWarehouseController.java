package com.ruoyi.goods.controller;

import java.util.List;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;

import io.swagger.annotations.*;
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
import com.ruoyi.goods.domain.TWarehouse;
import com.ruoyi.goods.service.ITWarehouseService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;
import springfox.documentation.annotations.ApiIgnore;

/**
 * 仓库Controller
 * 
 * @author ruoyi
 * @date 2022-02-12
 */
@Api(description = "仓库管理")
@RestController
@RequestMapping("/warehouse")
public class TWarehouseController extends BaseController
{
    @Autowired
    private ITWarehouseService tWarehouseService;

    /**
     * 查询仓库列表-真实
     */
    @ApiOperation("查询仓库列表-真实")
    @ApiImplicitParams({@ApiImplicitParam(name = "warehouseName",value = "仓库名",dataType = "String",paramType = "query"),
            @ApiImplicitParam(name = "pageNum",value = "页码",dataType = "Integer",paramType = "query"),
            @ApiImplicitParam(name = "pageSize",value = "每页条数",dataType = "Integer",paramType = "query")})
    @RequiresPermissions("goods:warehouse:list")
    @GetMapping("/list")
    public TableDataInfo list(@ApiIgnore TWarehouse tWarehouse)
    {
        startPage();
        List<TWarehouse> list = tWarehouseService.selectTWarehouseList(tWarehouse);
        return getDataTable(list);
    }
    /**
     * 查询仓库列表-所有
     */
    @ApiOperation("查询仓库列表-所有")
    @ApiImplicitParams({@ApiImplicitParam(name = "warehouseName",value = "仓库名",dataType = "String",paramType = "query"),
            @ApiImplicitParam(name = "pageNum",value = "页码",dataType = "Integer",paramType = "query"),
            @ApiImplicitParam(name = "pageSize",value = "每页条数",dataType = "Integer",paramType = "query")})
    @RequiresPermissions("goods:warehouse:list")
    @GetMapping("/listAll")
    public TableDataInfo listAll(@ApiIgnore TWarehouse tWarehouse)
    {
        startPage();
        List<TWarehouse> list = tWarehouseService.selectTWarehouseListAll(tWarehouse);
        return getDataTable(list);
    }
    /**
     * 导出仓库列表
     */
    @ApiOperation("导出仓库列表")

    @RequiresPermissions("goods:warehouse:export")
    @ApiImplicitParams({@ApiImplicitParam(name = "warehouseName",value = "仓库名",dataType = "String",paramType = "query"),
            @ApiImplicitParam(name = "pageNum",value = "页码",dataType = "Integer",paramType = "query"),
            @ApiImplicitParam(name = "pageSize",value = "每页条数",dataType = "Integer",paramType = "query")})
    @Log(title = "仓库", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response,@ApiIgnore TWarehouse tWarehouse)
    {
        List<TWarehouse> list = tWarehouseService.selectTWarehouseList(tWarehouse);
        ExcelUtil<TWarehouse> util = new ExcelUtil<TWarehouse>(TWarehouse.class);
        util.exportExcel(response, list, "仓库数据");
    }

    /**
     * 获取仓库详细信息
     */
    @ApiOperation("获取仓库详细信息")
    @RequiresPermissions("goods:warehouse:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@ApiParam(value = "主键id", required = true) @PathVariable("id") Long id)
    {
        return AjaxResult.success(tWarehouseService.selectTWarehouseById(id));
    }

    /**
     * 新增仓库
     */
    @ApiOperation("新增仓库")
    @Log(title = "仓库", businessType = BusinessType.INSERT)
    @RequiresPermissions("goods:warehouse:add")
    @PostMapping
    public AjaxResult add(@RequestBody TWarehouse tWarehouse)
    {
        return toAjax(tWarehouseService.insertTWarehouse(tWarehouse));
    }

    /**
     * 修改仓库
     */
    @ApiOperation("修改仓库")
    @RequiresPermissions("goods:warehouse:edit")
    @Log(title = "仓库", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TWarehouse tWarehouse)
    {
        return toAjax(tWarehouseService.updateTWarehouse(tWarehouse));
    }

    /**
     * 删除仓库
     */
    @ApiIgnore
    @RequiresPermissions("goods:warehouse:remove")
    @Log(title = "仓库", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(tWarehouseService.deleteTWarehouseByIds(ids));
    }
    /**
     * 新增子仓库
     */
    @ApiOperation("新增子仓库")
    @RequiresPermissions("goods:warehouse:add")
    @Log(title = "仓库", businessType = BusinessType.INSERT)
    @PostMapping("addChild")
    public AjaxResult addChild(@RequestBody TWarehouse tWarehouse)
    {
        return toAjax(tWarehouseService.insertTWarehouseChild(tWarehouse));
    }

    /**
     * 修改子仓库
     */
    @ApiOperation("修改子仓库")
    @RequiresPermissions("goods:warehouse:edit")
    @Log(title = "仓库", businessType = BusinessType.UPDATE)
    @PutMapping("editChild")
    public AjaxResult editChild(@RequestBody TWarehouse tWarehouse)
    {
        return toAjax(tWarehouseService.updateTWarehouseChild(tWarehouse));
    }
    /**
     * 查询子仓库列表
     */
    @ApiOperation("查询子仓库列表")
    @RequiresPermissions("goods:warehouse:list")
    @GetMapping("/listChild")
    public List<TWarehouse> listChild(TWarehouse tWarehouse)
    {
        List<TWarehouse> list = tWarehouseService.selectTWarehouseListChild(tWarehouse);
        return list;
    }
}
