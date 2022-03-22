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
import com.ruoyi.goods.domain.TProjectDept;
import com.ruoyi.goods.service.ITProjectDeptService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 项目部门关联中间Controller
 * 
 * @author ruoyi
 * @date 2022-03-15
 */
@RestController
@RequestMapping("/dept")
public class TProjectDeptController extends BaseController
{
    @Autowired
    private ITProjectDeptService tProjectDeptService;

    /**
     * 查询项目部门关联中间列表
     */
    @RequiresPermissions("goods:dept:list")
    @GetMapping("/list")
    public TableDataInfo list(TProjectDept tProjectDept)
    {
        startPage();
        List<TProjectDept> list = tProjectDeptService.selectTProjectDeptList(tProjectDept);
        return getDataTable(list);
    }

    /**
     * 导出项目部门关联中间列表
     */
    @RequiresPermissions("goods:dept:export")
    @Log(title = "项目部门关联中间", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TProjectDept tProjectDept)
    {
        List<TProjectDept> list = tProjectDeptService.selectTProjectDeptList(tProjectDept);
        ExcelUtil<TProjectDept> util = new ExcelUtil<TProjectDept>(TProjectDept.class);
        util.exportExcel(response, list, "项目部门关联中间数据");
    }

    /**
     * 获取项目部门关联中间详细信息
     */
    @RequiresPermissions("goods:dept:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(tProjectDeptService.selectTProjectDeptById(id));
    }

    /**
     * 新增项目部门关联中间
     */
    @RequiresPermissions("goods:dept:add")
    @Log(title = "项目部门关联中间", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TProjectDept tProjectDept)
    {
        return toAjax(tProjectDeptService.insertTProjectDept(tProjectDept));
    }

    /**
     * 修改项目部门关联中间
     */
    @RequiresPermissions("goods:dept:edit")
    @Log(title = "项目部门关联中间", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TProjectDept tProjectDept)
    {
        return toAjax(tProjectDeptService.updateTProjectDept(tProjectDept));
    }

    /**
     * 删除项目部门关联中间
     */
    @RequiresPermissions("goods:dept:remove")
    @Log(title = "项目部门关联中间", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(tProjectDeptService.deleteTProjectDeptByIds(ids));
    }
}
