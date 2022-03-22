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
import com.ruoyi.goods.domain.TProject;
import com.ruoyi.goods.service.ITProjectService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 项目管理Controller
 * 
 * @author ruoyi
 * @date 2022-03-15
 */
@RestController
@RequestMapping("/project")
public class TProjectController extends BaseController
{
    @Autowired
    private ITProjectService tProjectService;

    /**
     * 查询项目管理列表
     */
    @RequiresPermissions("goods:project:list")
    @GetMapping("/list")
    public TableDataInfo list(TProject tProject)
    {
        startPage();
        List<TProject> list = tProjectService.selectTProjectList(tProject);
        return getDataTable(list);
    }
    /**
     * 项目管理列表-下拉框
     */
    @RequiresPermissions("goods:project:list")
    @GetMapping("/projectList")
    public AjaxResult projectList(TProject tProject)
    {
        List<TProject> list = tProjectService.selectTProjectList(tProject);
        return AjaxResult.success(list);
    }
    /**
     * 导出项目管理列表
     */
    @RequiresPermissions("goods:project:export")
    @Log(title = "项目管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TProject tProject)
    {
        List<TProject> list = tProjectService.selectTProjectList(tProject);
        ExcelUtil<TProject> util = new ExcelUtil<TProject>(TProject.class);
        util.exportExcel(response, list, "项目管理数据");
    }

    /**
     * 获取项目管理详细信息
     */
    @RequiresPermissions("goods:project:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(tProjectService.selectTProjectById(id));
    }

    /**
     * 新增项目管理
     */
    @RequiresPermissions("goods:project:add")
    @Log(title = "项目管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TProject tProject)
    {
        return toAjax(tProjectService.insertTProject(tProject));
    }

    /**
     * 修改项目管理
     */
    @RequiresPermissions("goods:project:edit")
    @Log(title = "项目管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TProject tProject)
    {
        return toAjax(tProjectService.updateTProject(tProject));
    }

    /**
     * 删除项目管理
     */
    @RequiresPermissions("goods:project:remove")
    @Log(title = "项目管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(tProjectService.deleteTProjectByIds(ids));
    }
}
