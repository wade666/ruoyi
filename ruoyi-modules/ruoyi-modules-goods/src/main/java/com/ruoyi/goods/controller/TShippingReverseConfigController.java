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
import com.ruoyi.goods.domain.TShippingReverseConfig;
import com.ruoyi.goods.service.ITShippingReverseConfigService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 物流拒收配置Controller
 * 
 * @author ruoyi
 * @date 2022-02-15
 */
@RestController
@RequestMapping("/config")
public class TShippingReverseConfigController extends BaseController
{
    @Autowired
    private ITShippingReverseConfigService tShippingReverseConfigService;

    /**
     * 查询物流拒收配置列表
     */
    @RequiresPermissions("goods:config:list")
    @GetMapping("/list")
    public TableDataInfo list(TShippingReverseConfig tShippingReverseConfig)
    {
        startPage();
        List<TShippingReverseConfig> list = tShippingReverseConfigService.selectTShippingReverseConfigList(tShippingReverseConfig);
        return getDataTable(list);
    }
    /**
     * 快递列表下拉框
     */
    @RequiresPermissions("goods:config:list")
    @GetMapping("/expressList")
    public AjaxResult expressList(TShippingReverseConfig tShippingReverseConfig)
    {
        List<TShippingReverseConfig> list = tShippingReverseConfigService.selectTShippingReverseConfigList(tShippingReverseConfig);
        return AjaxResult.success(list);
    }
    /**
     * 导出物流拒收配置列表
     */
    @RequiresPermissions("goods:config:export")
    @Log(title = "物流拒收配置", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TShippingReverseConfig tShippingReverseConfig)
    {
        List<TShippingReverseConfig> list = tShippingReverseConfigService.selectTShippingReverseConfigList(tShippingReverseConfig);
        ExcelUtil<TShippingReverseConfig> util = new ExcelUtil<TShippingReverseConfig>(TShippingReverseConfig.class);
        util.exportExcel(response, list, "物流拒收配置数据");
    }

    /**
     * 获取物流拒收配置详细信息
     */
    @RequiresPermissions("goods:config:query")
    @GetMapping(value = "/{reverseId}")
    public AjaxResult getInfo(@PathVariable("reverseId") Long reverseId)
    {
        return AjaxResult.success(tShippingReverseConfigService.selectTShippingReverseConfigByReverseId(reverseId));
    }

    /**
     * 新增物流拒收配置
     */
    @RequiresPermissions("goods:config:add")
    @Log(title = "物流拒收配置", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TShippingReverseConfig tShippingReverseConfig)
    {
        return toAjax(tShippingReverseConfigService.insertTShippingReverseConfig(tShippingReverseConfig));
    }

    /**
     * 修改物流拒收配置
     */
    @RequiresPermissions("goods:config:edit")
    @Log(title = "物流拒收配置", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TShippingReverseConfig tShippingReverseConfig)
    {
        return toAjax(tShippingReverseConfigService.updateTShippingReverseConfig(tShippingReverseConfig));
    }

    /**
     * 删除物流拒收配置
     */
    @RequiresPermissions("goods:config:remove")
    @Log(title = "物流拒收配置", businessType = BusinessType.DELETE)
	@DeleteMapping("/{reverseIds}")
    public AjaxResult remove(@PathVariable Long[] reverseIds)
    {
        return toAjax(tShippingReverseConfigService.deleteTShippingReverseConfigByReverseIds(reverseIds));
    }
}
