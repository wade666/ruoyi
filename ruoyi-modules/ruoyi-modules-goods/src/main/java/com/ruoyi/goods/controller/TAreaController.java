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
import com.ruoyi.goods.domain.TArea;
import com.ruoyi.goods.service.ITAreaService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 省市区数据Controller
 * 
 * @author ruoyi
 * @date 2022-03-18
 */
@RestController
@RequestMapping("/area")
public class TAreaController extends BaseController
{
    @Autowired
    private ITAreaService tAreaService;

    /**
     * 查询省市区数据列表-分层查询
     */
    @RequiresPermissions("goods:area:list")
    @GetMapping("/areaList")
    public AjaxResult areaList(TArea tArea)
    {
        List<TArea> list = tAreaService.selectTAreaList(tArea);
        return AjaxResult.success(list);
    }
}
