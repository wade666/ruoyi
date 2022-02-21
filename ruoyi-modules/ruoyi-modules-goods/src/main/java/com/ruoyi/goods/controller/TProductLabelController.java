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
import com.ruoyi.goods.domain.TProductLabel;
import com.ruoyi.goods.service.ITProductLabelService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 商品标签Controller
 * 
 * @author ruoyi
 * @date 2022-02-16
 */
@RestController
@RequestMapping("/label")
public class TProductLabelController extends BaseController
{
    @Autowired
    private ITProductLabelService tProductLabelService;

    /**
     * 查询商品标签列表
     */
    @RequiresPermissions("goods:label:list")
    @GetMapping("/list")
    public TableDataInfo list(TProductLabel tProductLabel)
    {
        startPage();
        List<TProductLabel> list = tProductLabelService.selectTProductLabelList(tProductLabel);
        return getDataTable(list);
    }

    /**
     * 导出商品标签列表
     */
    @RequiresPermissions("goods:label:export")
    @Log(title = "商品标签", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TProductLabel tProductLabel)
    {
        List<TProductLabel> list = tProductLabelService.selectTProductLabelList(tProductLabel);
        ExcelUtil<TProductLabel> util = new ExcelUtil<TProductLabel>(TProductLabel.class);
        util.exportExcel(response, list, "商品标签数据");
    }

    /**
     * 获取商品标签详细信息
     */
    @RequiresPermissions("goods:label:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(tProductLabelService.selectTProductLabelById(id));
    }

    /**
     * 新增商品标签
     */
    @RequiresPermissions("goods:label:add")
    @Log(title = "商品标签", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TProductLabel tProductLabel)
    {
        return toAjax(tProductLabelService.insertTProductLabel(tProductLabel));
    }

    /**
     * 修改商品标签
     */
    @RequiresPermissions("goods:label:edit")
    @Log(title = "商品标签", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TProductLabel tProductLabel)
    {
        return toAjax(tProductLabelService.updateTProductLabel(tProductLabel));
    }

    /**
     * 删除商品标签
     */
    @RequiresPermissions("goods:label:remove")
    @Log(title = "商品标签", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(tProductLabelService.deleteTProductLabelByIds(ids));
    }
}
