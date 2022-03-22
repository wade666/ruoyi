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
import com.ruoyi.goods.domain.TSupplier;
import com.ruoyi.goods.service.ITSupplierService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 供货商Controller
 * 
 * @author ruoyi
 * @date 2022-03-18
 */
@RestController
@RequestMapping("/supplier")
public class TSupplierController extends BaseController
{
    @Autowired
    private ITSupplierService tSupplierService;

    /**
     * 查询供货商列表
     */
    @RequiresPermissions("goods:supplier:list")
    @GetMapping("/list")
    public TableDataInfo list(TSupplier tSupplier)
    {
        startPage();
        List<TSupplier> list = tSupplierService.selectTSupplierList(tSupplier);
        return getDataTable(list);
    }
    /**
     * 导出供货商列表
     */
    @RequiresPermissions("goods:supplier:export")
    @Log(title = "供货商", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TSupplier tSupplier)
    {
        List<TSupplier> list = tSupplierService.selectTSupplierList(tSupplier);
        ExcelUtil<TSupplier> util = new ExcelUtil<TSupplier>(TSupplier.class);
        util.exportExcel(response, list, "供货商数据");
    }

    /**
     * 获取供货商详细信息
     */
    @RequiresPermissions("goods:supplier:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(tSupplierService.selectTSupplierById(id));
    }

    /**
     * 新增供货商
     */
    @RequiresPermissions("goods:supplier:add")
    @Log(title = "供货商", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TSupplier tSupplier)
    {
        return toAjax(tSupplierService.insertTSupplier(tSupplier));
    }

    /**
     * 修改供货商
     */
    @RequiresPermissions("goods:supplier:edit")
    @Log(title = "供货商", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TSupplier tSupplier)
    {
        return toAjax(tSupplierService.updateTSupplier(tSupplier));
    }

    /**
     * 删除供货商
     */
    @RequiresPermissions("goods:supplier:remove")
    @Log(title = "供货商", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(tSupplierService.deleteTSupplierByIds(ids));
    }
}
