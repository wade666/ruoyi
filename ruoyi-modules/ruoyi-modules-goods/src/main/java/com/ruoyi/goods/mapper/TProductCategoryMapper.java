package com.ruoyi.goods.mapper;

import java.util.List;

import com.ruoyi.system.api.domain.SysDept;
import com.ruoyi.goods.domain.TProductCategory;
import org.apache.ibatis.annotations.Param;

/**
 * 商品分类Mapper接口
 *
 * @author ruoyi
 * @date 2022-01-24
 */
public interface TProductCategoryMapper {
    /**
     * 查询商品分类
     *
     * @param categoryId 商品分类主键
     * @return 商品分类
     */
    public TProductCategory selectTProductCategoryByCategoryId(Long categoryId);

    /**
     * 查询商品分类列表
     *
     * @param tProductCategory 商品分类
     * @return 商品分类集合
     */
    public List<TProductCategory> selectTProductCategoryList(TProductCategory tProductCategory);

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
     * 删除商品分类
     *
     * @param categoryId 商品分类主键
     * @return 结果
     */
    public int deleteTProductCategoryByCategoryId(Long categoryId);

    /**
     * 批量删除商品分类
     *
     * @param categoryIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTProductCategoryByCategoryIds(Long[] categoryIds);

    /**
     * 校验分类名称是否唯一
     *
     * @param categoryName 分类名称
     * @param parentId     父分类ID
     * @return 结果
     */
    public TProductCategory checkCategoryNameUnique(@Param("categoryName") String categoryName, @Param("parentId") Long parentId);

    /**
     * 根据ID查询所有子分类（正常状态）
     *
     * @param categoryId 分类ID
     * @return 子分类数
     */
    public int selectNormalChildrenCategoryById(Long categoryId);
}
