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
import com.ruoyi.goods.domain.TPurchaseReviewer;
import com.ruoyi.goods.service.ITPurchaseReviewerService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 审核人配置Controller
 * 
 * @author ruoyi
 * @date 2022-03-19
 */
@RestController
@RequestMapping("/reviewer")
public class TPurchaseReviewerController extends BaseController
{
    @Autowired
    private ITPurchaseReviewerService tPurchaseReviewerService;

    /**
     * 查询审核人配置列表
     */
    @RequiresPermissions("goods:reviewer:list")
    @GetMapping("/list")
    public TableDataInfo list(TPurchaseReviewer tPurchaseReviewer)
    {
        startPage();
        List<TPurchaseReviewer> list = tPurchaseReviewerService.selectTPurchaseReviewerList(tPurchaseReviewer);
        return getDataTable(list);
    }

    /**
     * 导出审核人配置列表
     */
    @RequiresPermissions("goods:reviewer:export")
    @Log(title = "审核人配置", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TPurchaseReviewer tPurchaseReviewer)
    {
        List<TPurchaseReviewer> list = tPurchaseReviewerService.selectTPurchaseReviewerList(tPurchaseReviewer);
        ExcelUtil<TPurchaseReviewer> util = new ExcelUtil<TPurchaseReviewer>(TPurchaseReviewer.class);
        util.exportExcel(response, list, "审核人配置数据");
    }

    /**
     * 获取审核人配置详细信息
     */
    @RequiresPermissions("goods:reviewer:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(tPurchaseReviewerService.selectTPurchaseReviewerById(id));
    }

    /**
     * 新增审核人配置
     */
    @RequiresPermissions("goods:reviewer:add")
    @Log(title = "审核人配置", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TPurchaseReviewer tPurchaseReviewer)
    {
        return toAjax(tPurchaseReviewerService.insertTPurchaseReviewer(tPurchaseReviewer));
    }

    /**
     * 修改审核人配置
     */
    @RequiresPermissions("goods:reviewer:edit")
    @Log(title = "审核人配置", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TPurchaseReviewer tPurchaseReviewer)
    {
        return toAjax(tPurchaseReviewerService.updateTPurchaseReviewer(tPurchaseReviewer));
    }

    /**
     * 删除审核人配置
     */
    @RequiresPermissions("goods:reviewer:remove")
    @Log(title = "审核人配置", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(tPurchaseReviewerService.deleteTPurchaseReviewerByIds(ids));
    }
}
