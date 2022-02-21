package com.ruoyi.goods.controller;

import java.util.List;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.common.core.utils.DateUtils;
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
import com.ruoyi.goods.domain.TSpecification;
import com.ruoyi.goods.service.ITSpecificationService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 商品规格Controller
 * 
 * @author ruoyi
 * @date 2022-02-12
 */
@RestController
@RequestMapping("/specification")
public class TSpecificationController extends BaseController
{
    @Autowired
    private ITSpecificationService tSpecificationService;

    /**
     * 查询商品规格列表
     */
    @RequiresPermissions("goods:specification:list")
    @GetMapping("/list")
    public TableDataInfo list(TSpecification tSpecification)
    {
        startPage();
        List<TSpecification> list = tSpecificationService.selectTSpecificationList(tSpecification);
        return getDataTable(list);
    }

    /**
     * 导出商品规格列表
     */
    @RequiresPermissions("goods:specification:export")
    @Log(title = "商品规格", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TSpecification tSpecification)
    {
        List<TSpecification> list = tSpecificationService.selectTSpecificationList(tSpecification);
        ExcelUtil<TSpecification> util = new ExcelUtil<TSpecification>(TSpecification.class);
        util.exportExcel(response, list, "商品规格数据");
    }

    /**
     * 获取商品规格详细信息
     */
    @RequiresPermissions("goods:specification:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(tSpecificationService.selectTSpecificationById(id));
    }
    /**
     * 根据分类id获取商品规格详细信息
     */
    @RequiresPermissions("goods:specification:query")
    @GetMapping(value = "/{productCategoryId}")
    public AjaxResult getInfoByProductCategoryId(@PathVariable("productCategoryId") Long productCategoryId)
    {
        return AjaxResult.success(tSpecificationService.selectTSpecificationByProductCategoryId(productCategoryId));
    }
    /**
     * 新增商品规格
     */
    @RequiresPermissions("goods:specification:add")
    @Log(title = "商品规格", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TSpecification tSpecification)
    {
        tSpecification.setOptions("[\"1瓶装\",\"2瓶装\"]");
        return toAjax(tSpecificationService.insertTSpecification(tSpecification));
    }

    /**
     * 修改商品规格
     */
    @RequiresPermissions("goods:specification:edit")
    @Log(title = "商品规格", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TSpecification tSpecification)
    {
        return toAjax(tSpecificationService.updateTSpecification(tSpecification));
    }

    /**
     * 删除商品规格
     */
    @RequiresPermissions("goods:specification:remove")
    @Log(title = "商品规格", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(tSpecificationService.deleteTSpecificationByIds(ids));
    }
}
