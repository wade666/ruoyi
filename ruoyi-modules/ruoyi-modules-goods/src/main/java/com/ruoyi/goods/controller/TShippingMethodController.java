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
import com.ruoyi.goods.domain.TShippingMethod;
import com.ruoyi.goods.service.ITShippingMethodService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 配送方式Controller
 * 
 * @author ruoyi
 * @date 2022-02-15
 */
@RestController
@RequestMapping("/method")
public class TShippingMethodController extends BaseController
{
    @Autowired
    private ITShippingMethodService tShippingMethodService;

    /**
     * 查询配送方式列表
     */
    @RequiresPermissions("goods:method:list")
    @GetMapping("/list")
    public TableDataInfo list(TShippingMethod tShippingMethod)
    {
        startPage();
        List<TShippingMethod> list = tShippingMethodService.selectTShippingMethodList(tShippingMethod);
        return getDataTable(list);
    }

    /**
     * 导出配送方式列表
     */
    @RequiresPermissions("goods:method:export")
    @Log(title = "配送方式", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TShippingMethod tShippingMethod)
    {
        List<TShippingMethod> list = tShippingMethodService.selectTShippingMethodList(tShippingMethod);
        ExcelUtil<TShippingMethod> util = new ExcelUtil<TShippingMethod>(TShippingMethod.class);
        util.exportExcel(response, list, "配送方式数据");
    }

    /**
     * 获取配送方式详细信息
     */
    @RequiresPermissions("goods:method:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(tShippingMethodService.selectTShippingMethodById(id));
    }

    /**
     * 新增配送方式
     */
    @RequiresPermissions("goods:method:add")
    @Log(title = "配送方式", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TShippingMethod tShippingMethod)
    {
        return toAjax(tShippingMethodService.insertTShippingMethod(tShippingMethod));
    }

    /**
     * 修改配送方式
     */
    @RequiresPermissions("goods:method:edit")
    @Log(title = "配送方式", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TShippingMethod tShippingMethod)
    {
        return toAjax(tShippingMethodService.updateTShippingMethod(tShippingMethod));
    }

    /**
     * 删除配送方式
     */
    @RequiresPermissions("goods:method:remove")
    @Log(title = "配送方式", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(tShippingMethodService.deleteTShippingMethodByIds(ids));
    }
}
