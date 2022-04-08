package com.ruoyi.goods.controller;

import java.util.List;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
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
import com.ruoyi.goods.domain.TWarehouseDispatchinto;
import com.ruoyi.goods.service.ITWarehouseDispatchintoService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;
import springfox.documentation.annotations.ApiIgnore;

/**
 * 调拨出入库单Controller
 * 
 * @author ruoyi
 * @date 2022-03-30
 */
@Api(description = "调拨出入库单")
@RestController
@RequestMapping("/dispatchinto")
public class TWarehouseDispatchintoController extends BaseController
{
    @Autowired
    private ITWarehouseDispatchintoService tWarehouseDispatchintoService;

    /**
     * 查询调拨出入库单列表
     */
    @ApiOperation("查询调拨出入库单列表")
    @ApiImplicitParams({@ApiImplicitParam(name = "dispatchintoNo",value = "出入库单号",dataType = "Long",paramType = "query"),
            @ApiImplicitParam(name = "intoType",value = "调拨类型 1调拨入库 2调拨出库",dataType = "Integer",paramType = "query"),
            @ApiImplicitParam(name = "pageNum",value = "页码",dataType = "Integer",paramType = "query"),
            @ApiImplicitParam(name = "pageSize",value = "每页条数",dataType = "Integer",paramType = "query")})
    @RequiresPermissions("goods:dispatchinto:list")
    @GetMapping("/list")
    public TableDataInfo<TWarehouseDispatchinto> list(@ApiIgnore TWarehouseDispatchinto tWarehouseDispatchinto)
    {
        startPage();
        List<TWarehouseDispatchinto> list = tWarehouseDispatchintoService.selectTWarehouseDispatchintoList(tWarehouseDispatchinto);
        return getDataTable(list);
    }

    /**
     * 导出调拨出入库单列表
     */
    @ApiOperation("导出调拨出入库单列表")
    @ApiImplicitParams({@ApiImplicitParam(name = "dispatchintoNo",value = "出入库单号",dataType = "Long",paramType = "query"),
            @ApiImplicitParam(name = "intoType",value = "调拨类型 1调拨入库 2调拨出库",dataType = "Integer",paramType = "query"),
            @ApiImplicitParam(name = "pageNum",value = "页码",dataType = "Integer",paramType = "query"),
            @ApiImplicitParam(name = "pageSize",value = "每页条数",dataType = "Integer",paramType = "query")})
    @RequiresPermissions("goods:dispatchinto:export")
    @Log(title = "调拨出入库单", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, @ApiIgnore TWarehouseDispatchinto tWarehouseDispatchinto)
    {
        List<TWarehouseDispatchinto> list = tWarehouseDispatchintoService.selectTWarehouseDispatchintoList(tWarehouseDispatchinto);
        ExcelUtil<TWarehouseDispatchinto> util = new ExcelUtil<TWarehouseDispatchinto>(TWarehouseDispatchinto.class);
        util.exportExcel(response, list, "调拨出入库单数据");
    }

    /**
     * 获取调拨出入库单详细信息
     */
    @ApiOperation("获取调拨出入库单详细信息")
    @RequiresPermissions("goods:dispatchinto:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(tWarehouseDispatchintoService.selectTWarehouseDispatchintoById(id));
    }

    /**
     * 新增调拨出入库单
     */
    @ApiOperation("新增调拨出入库单")
    @RequiresPermissions("goods:dispatchinto:add")
    @Log(title = "调拨出入库单", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TWarehouseDispatchinto tWarehouseDispatchinto)
    {
        return toAjax(tWarehouseDispatchintoService.insertTWarehouseDispatchinto(tWarehouseDispatchinto));
    }

    /**
     * 修改调拨出入库单
     */
    @ApiOperation("修改调拨出入库单")
    @RequiresPermissions("goods:dispatchinto:edit")
    @Log(title = "调拨出入库单", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TWarehouseDispatchinto tWarehouseDispatchinto)
    {
        return toAjax(tWarehouseDispatchintoService.updateTWarehouseDispatchinto(tWarehouseDispatchinto));
    }

    /**
     * 删除调拨出入库单
     */
    @ApiOperation("删除调拨出入库单")
    @RequiresPermissions("goods:dispatchinto:remove")
    @Log(title = "调拨出入库单", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(tWarehouseDispatchintoService.deleteTWarehouseDispatchintoByIds(ids));
    }
}
