package com.ruoyi.goods.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import com.alibaba.fastjson.JSON;
import com.ruoyi.common.core.constant.UserConstants;
import com.ruoyi.common.core.utils.DateUtils;
import com.ruoyi.common.core.utils.StringUtils;
import com.ruoyi.goods.domain.vo.TreeSelect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.goods.mapper.TProductCategoryMapper;
import com.ruoyi.goods.domain.TProductCategory;
import com.ruoyi.goods.service.ITProductCategoryService;

import javax.annotation.Resource;

/**
 * 商品分类Service业务层处理
 *
 * @author ruoyi
 * @date 2022-01-24
 */
@Service
public class TProductCategoryServiceImpl implements ITProductCategoryService {
    @Resource
    private TProductCategoryMapper tProductCategoryMapper;

    @Override
    public List<TProductCategory> selectTProductCategoryList(TProductCategory tProductCategory) {
        return tProductCategoryMapper.selectTProductCategoryList(tProductCategory);
    }

    /**
     * 构建前端所需要树结构
     *
     * @param categories 分类列表
     * @return 树结构列表
     */
    @Override
    public List<TProductCategory> buildProductCategoryTree(List<TProductCategory> categories) {
        List<TProductCategory> returnList = new ArrayList<TProductCategory>();
        List<Long> tempList = new ArrayList<Long>();
        for (TProductCategory category : categories) {
            tempList.add(category.getCategoryId());
        }
        for (Iterator<TProductCategory> iterator = categories.iterator(); iterator.hasNext(); ) {
            TProductCategory category = (TProductCategory) iterator.next();
            // 如果是顶级节点, 遍历该父节点的所有子节点
            if (!tempList.contains(category.getParentId())) {
                recursionFn(categories, category);
                returnList.add(category);
            }
        }
        if (returnList.isEmpty()) {
            returnList = categories;
        }
        return returnList;
    }

    @Override
    public List<TreeSelect> buildProductCategoryTreeSelect(List<TProductCategory> categories) {
        List<TProductCategory> categoryTrees = buildProductCategoryTree(categories);
        return categoryTrees.stream().map(TreeSelect::new).collect(Collectors.toList());
    }

    @Override
    public boolean checkCategoryExist(Long categoryId) {
        return false;
    }

    @Override
    public int selectNormalChildrenCategoryById(Long categoryId) {
        return tProductCategoryMapper.selectNormalChildrenCategoryById(categoryId);
    }

    @Override
    public String checkCategoryNameUnique(TProductCategory category) {
        Long categoryId = StringUtils.isNull(category.getCategoryId()) ? -1L : category.getCategoryId();
        TProductCategory info = tProductCategoryMapper.checkCategoryNameUnique(category.getCategoryName(), category.getParentId());
        if (StringUtils.isNotNull(info) && info.getCategoryId().longValue() != categoryId.longValue()) {
            return UserConstants.NOT_UNIQUE;
        }
        return UserConstants.UNIQUE;
    }

    @Override
    public List<Long> selectProductCategoryListByRoleId(Long roleId) {
        return null;
    }

    /**
     * 查询商品分类
     *
     * @param categoryId 商品分类主键
     * @return 商品分类
     */
    @Override
    public TProductCategory selectTProductCategoryByCategoryId(Long categoryId) {
        return tProductCategoryMapper.selectTProductCategoryByCategoryId(categoryId);
    }

    /**
     * 新增商品分类
     *
     * @param tProductCategory 商品分类
     * @return 结果
     */
    @Override
    public int insertTProductCategory(TProductCategory tProductCategory) {
        tProductCategory.setCreateTime(DateUtils.getNowDate());
        return tProductCategoryMapper.insertTProductCategory(tProductCategory);
    }

    /**
     * 修改商品分类
     *
     * @param tProductCategory 商品分类
     * @return 结果
     */
    @Override
    public int updateTProductCategory(TProductCategory tProductCategory) {
        tProductCategory.setUpdateTime(DateUtils.getNowDate());
        return tProductCategoryMapper.updateTProductCategory(tProductCategory);
    }

    /**
     * 批量删除商品分类
     *
     * @param categoryIds 需要删除的商品分类主键
     * @return 结果
     */
    @Override
    public int deleteTProductCategoryByCategoryIds(Long[] categoryIds) {
        return tProductCategoryMapper.deleteTProductCategoryByCategoryIds(categoryIds);
    }

    /**
     * 删除商品分类信息
     *
     * @param categoryId 商品分类主键
     * @return 结果
     */
    @Override
    public int deleteTProductCategoryByCategoryId(Long categoryId) {
        return tProductCategoryMapper.deleteTProductCategoryByCategoryId(categoryId);
    }

    /**
     * 递归列表
     */
    private void recursionFn(List<TProductCategory> list, TProductCategory t) {
        // 得到子节点列表
        List<TProductCategory> childList = getChildList(list, t);
        t.setChildren(childList);
        for (TProductCategory tChild : childList) {
            if (hasChild(list, tChild)) {
                recursionFn(list, tChild);
            }
        }
    }

    /**
     * 得到子节点列表
     */
    private List<TProductCategory> getChildList(List<TProductCategory> list, TProductCategory t) {
        List<TProductCategory> tlist = new ArrayList<TProductCategory>();
        Iterator<TProductCategory> it = list.iterator();
        while (it.hasNext()) {
            TProductCategory n = (TProductCategory) it.next();
            if (StringUtils.isNotNull(n.getParentId()) && n.getParentId().longValue() == t.getCategoryId().longValue()) {
                tlist.add(n);
            }
        }
        return tlist;
    }

    /**
     * 判断是否有子节点
     */
    private boolean hasChild(List<TProductCategory> list, TProductCategory t) {
        return getChildList(list, t).size() > 0 ? true : false;
    }
    /**
     * 查询仓库商品的所有分类
     */
    @Override
    public List<TProductCategory> getCategoryByWarehouseId(Long warehouseId) {
        return tProductCategoryMapper.getCategoryByWarehouseId(warehouseId);
    }
}
