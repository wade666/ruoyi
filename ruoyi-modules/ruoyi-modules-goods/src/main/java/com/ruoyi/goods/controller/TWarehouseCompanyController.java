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
import com.ruoyi.goods.domain.TWarehouseCompany;
import com.ruoyi.goods.service.ITWarehouseCompanyService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 仓库所属公司Controller
 * 
 * @author ruoyi
 * @date 2022-03-07
 */
@RestController
@RequestMapping("/company")
public class TWarehouseCompanyController extends BaseController
{
    @Autowired
    private ITWarehouseCompanyService tWarehouseCompanyService;

    /**
     * 查询仓库所属公司列表
     */
    @RequiresPermissions("goods:company:list")
    @GetMapping("/list")
    public TableDataInfo list(TWarehouseCompany tWarehouseCompany)
    {
        startPage();
        List<TWarehouseCompany> list = tWarehouseCompanyService.selectTWarehouseCompanyList(tWarehouseCompany);
        return getDataTable(list);
    }

    /**
     * 导出仓库所属公司列表
     */
    @RequiresPermissions("goods:company:export")
    @Log(title = "仓库所属公司", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TWarehouseCompany tWarehouseCompany)
    {
        List<TWarehouseCompany> list = tWarehouseCompanyService.selectTWarehouseCompanyList(tWarehouseCompany);
        ExcelUtil<TWarehouseCompany> util = new ExcelUtil<TWarehouseCompany>(TWarehouseCompany.class);
        util.exportExcel(response, list, "仓库所属公司数据");
    }

    /**
     * 获取仓库所属公司详细信息
     */
    @RequiresPermissions("goods:company:query")
    @GetMapping(value = "/{companyId}")
    public AjaxResult getInfo(@PathVariable("companyId") Long companyId)
    {
        return AjaxResult.success(tWarehouseCompanyService.selectTWarehouseCompanyByCompanyId(companyId));
    }

    /**
     * 新增仓库所属公司
     */
    @RequiresPermissions("goods:company:add")
    @Log(title = "仓库所属公司", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TWarehouseCompany tWarehouseCompany)
    {
        return toAjax(tWarehouseCompanyService.insertTWarehouseCompany(tWarehouseCompany));
    }

    /**
     * 修改仓库所属公司
     */
    @RequiresPermissions("goods:company:edit")
    @Log(title = "仓库所属公司", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TWarehouseCompany tWarehouseCompany)
    {
        return toAjax(tWarehouseCompanyService.updateTWarehouseCompany(tWarehouseCompany));
    }

    /**
     * 删除仓库所属公司
     */
    @RequiresPermissions("goods:company:remove")
    @Log(title = "仓库所属公司", businessType = BusinessType.DELETE)
	@DeleteMapping("/{companyIds}")
    public AjaxResult remove(@PathVariable Long[] companyIds)
    {
        return toAjax(tWarehouseCompanyService.deleteTWarehouseCompanyByCompanyIds(companyIds));
    }
}
