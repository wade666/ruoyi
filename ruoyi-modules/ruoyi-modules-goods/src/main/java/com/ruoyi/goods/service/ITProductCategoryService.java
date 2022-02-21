package com.ruoyi.goods.service;

import java.util.List;

import com.ruoyi.goods.domain.TProductCategory;
import com.ruoyi.goods.domain.vo.TreeSelect;

/**
 * 商品分类Service接口
 *
 * @author ruoyi
 * @date 2022-01-24
 */
public interface ITProductCategoryService {
    /**
     * 查询分类管理数据
     *
     * @param tProductCategory 分类信息
     * @return 分类信息集合
     */
    public List<TProductCategory> selectTProductCategoryList(TProductCategory tProductCategory);

    /**
     * 构建前端所需要树结构
     *
     * @param categories 分类列表
     * @return 树结构列表
     */
    public List<TProductCategory> buildProductCategoryTree(List<TProductCategory> categories);

    /**
     * 构建前端所需要下拉树结构
     *
     * @param tProductCategory 分类列表
     * @return 下拉树结构列表
     */
    public List<TreeSelect> buildProductCategoryTreeSelect(List<TProductCategory> tProductCategory);

    /**
     * 查询分类是否存在商品
     *
     * @param categoryId 分类ID
     * @return 结果 true 存在 false 不存在
     */
    public boolean checkCategoryExist(Long categoryId);

    /**
     * 根据ID查询所有子分类（正常状态）
     *
     * @param categoryId 分类ID
     * @return 子分类数
     */
    public int selectNormalChildrenCategoryById(Long categoryId);

    /**
     * 校验分类名称是否唯一
     *
     * @param category 分类信息
     * @return 结果
     */
    public String checkCategoryNameUnique(TProductCategory category);

    /**
     * 根据角色ID查询分类树信息
     *
     * @param roleId 角色ID
     * @return 选中分类列表
     */
    public List<Long> selectProductCategoryListByRoleId(Long roleId);

    /**
     * 查询商品分类
     *
     * @param categoryId 商品分类主键
     * @return 商品分类
     */
    public TProductCategory selectTProductCategoryByCategoryId(Long categoryId);

    /**
     * 新增商品分类
     *
     * @param tProductCategory 商品分类
     * @return 结果
     */
    public int insertTProductCategory(TProductCategory tProductCategory);

    /**
     * 修改商品分类
     *
     * @param tProductCategory 商品分类
     * @return 结果
     */
    public int updateTProductCategory(TProductCategory tProductCategory);

    /**
     * 批量删除商品分类
     *
     * @param categoryIds 需要删除的商品分类主键集合
     * @return 结果
     */
    public int deleteTProductCategoryByCategoryIds(Long[] categoryIds);

    /**
     * 删除商品分类信息
     *
     * @param categoryId 商品分类主键
     * @return 结果
     */
    public int deleteTProductCategoryByCategoryId(Long categoryId);
}
