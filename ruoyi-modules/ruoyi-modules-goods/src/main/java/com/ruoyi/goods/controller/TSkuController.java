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
import com.ruoyi.goods.domain.TSku;
import com.ruoyi.goods.service.ITSkuService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 商品skuController
 * 
 * @author ruoyi
 * @date 2022-02-12
 */
@RestController
@RequestMapping("/sku")
public class TSkuController extends BaseController
{
    @Autowired
    private ITSkuService tSkuService;

    /**
     * 查询商品sku列表
     */
    @RequiresPermissions("goods:sku:list")
    @GetMapping("/list")
    public TableDataInfo list(TSku tSku)
    {
        startPage();
        List<TSku> list = tSkuService.selectTSkuList(tSku);
        return getDataTable(list);
    }

    /**
     * 导出商品sku列表
     */
    @RequiresPermissions("goods:sku:export")
    @Log(title = "商品sku", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TSku tSku)
    {
        List<TSku> list = tSkuService.selectTSkuList(tSku);
        ExcelUtil<TSku> util = new ExcelUtil<TSku>(TSku.class);
        util.exportExcel(response, list, "商品sku数据");
    }

    /**
     * 获取商品sku详细信息
     */
    @RequiresPermissions("goods:sku:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(tSkuService.selectTSkuById(id));
    }

    /**
     * 新增商品sku
     */
    @RequiresPermissions("goods:sku:add")
    @Log(title = "商品sku", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TSku tSku)
    {
        return toAjax(tSkuService.insertTSku(tSku));
    }

    /**
     * 修改商品sku
     */
    @RequiresPermissions("goods:sku:edit")
    @Log(title = "商品sku", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TSku tSku)
    {
        return toAjax(tSkuService.updateTSku(tSku));
    }

    /**
     * 删除商品sku
     */
    @RequiresPermissions("goods:sku:remove")
    @Log(title = "商品sku", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(tSkuService.deleteTSkuByIds(ids));
    }
}
