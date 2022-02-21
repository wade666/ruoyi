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
import com.ruoyi.goods.domain.TProductConversionProportion;
import com.ruoyi.goods.service.ITProductConversionProportionService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 商品规格换算Controller
 * 
 * @author ruoyi
 * @date 2022-02-15
 */
@RestController
@RequestMapping("/proportion")
public class TProductConversionProportionController extends BaseController
{
    @Autowired
    private ITProductConversionProportionService tProductConversionProportionService;

    /**
     * 查询商品规格换算列表
     */
    @RequiresPermissions("goods:proportion:list")
    @GetMapping("/list")
    public TableDataInfo list(TProductConversionProportion tProductConversionProportion)
    {
        startPage();
        List<TProductConversionProportion> list = tProductConversionProportionService.selectTProductConversionProportionList(tProductConversionProportion);
        return getDataTable(list);
    }

    /**
     * 导出商品规格换算列表
     */
    @RequiresPermissions("goods:proportion:export")
    @Log(title = "商品规格换算", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TProductConversionProportion tProductConversionProportion)
    {
        List<TProductConversionProportion> list = tProductConversionProportionService.selectTProductConversionProportionList(tProductConversionProportion);
        ExcelUtil<TProductConversionProportion> util = new ExcelUtil<TProductConversionProportion>(TProductConversionProportion.class);
        util.exportExcel(response, list, "商品规格换算数据");
    }

    /**
     * 获取商品规格换算详细信息
     */
    @RequiresPermissions("goods:proportion:query")
    @GetMapping(value = "/{conversionId}")
    public AjaxResult getInfo(@PathVariable("conversionId") Long conversionId)
    {
        return AjaxResult.success(tProductConversionProportionService.selectTProductConversionProportionByConversionId(conversionId));
    }

    /**
     * 新增商品规格换算
     */
    @RequiresPermissions("goods:proportion:add")
    @Log(title = "商品规格换算", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TProductConversionProportion tProductConversionProportion)
    {
        tProductConversionProportion.setSpecificationValues("[\"1瓶装\", \"2瓶装\"]");
        return toAjax(tProductConversionProportionService.insertTProductConversionProportion(tProductConversionProportion));
    }

    /**
     * 修改商品规格换算
     */
    @RequiresPermissions("goods:proportion:edit")
    @Log(title = "商品规格换算", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TProductConversionProportion tProductConversionProportion)
    {
        return toAjax(tProductConversionProportionService.updateTProductConversionProportion(tProductConversionProportion));
    }

    /**
     * 删除商品规格换算
     */
    @RequiresPermissions("goods:proportion:remove")
    @Log(title = "商品规格换算", businessType = BusinessType.DELETE)
	@DeleteMapping("/{conversionIds}")
    public AjaxResult remove(@PathVariable Long[] conversionIds)
    {
        return toAjax(tProductConversionProportionService.deleteTProductConversionProportionByConversionIds(conversionIds));
    }
}
