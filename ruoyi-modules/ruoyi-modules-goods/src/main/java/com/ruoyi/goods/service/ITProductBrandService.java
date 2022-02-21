package com.ruoyi.goods.service;

import java.util.List;

import com.ruoyi.goods.domain.TProductBrand;
import com.ruoyi.goods.domain.vo.TreeSelect;

/**
 * 商品品牌Service接口
 *
 * @author ruoyi
 * @date 2022-01-24
 */
public interface ITProductBrandService {
    /**
     * 查询品牌管理数据
     *
     * @param tProductBrand 品牌信息
     * @return 品牌信息集合
     */
    public List<TProductBrand> selectTProductBrandList(TProductBrand tProductBrand);

    /**
     * 构建前端所需要树结构
     *
     * @param categories 品牌列表
     * @return 树结构列表
     */
    public List<TProductBrand> buildProductBrandTree(List<TProductBrand> categories);

    /**
     * 构建前端所需要下拉树结构
     *
     * @param tProductBrand 品牌列表
     * @return 下拉树结构列表
     */
    public List<TreeSelect> buildProductBrandTreeSelect(List<TProductBrand> tProductBrand);

    /**
     * 查询品牌是否存在商品
     *
     * @param brandId 品牌ID
     * @return 结果 true 存在 false 不存在
     */
    public boolean checkBrandExist(Long brandId);

    /**
     * 根据ID查询所有子品牌（正常状态）
     *
     * @param brandId 品牌ID
     * @return 子品牌数
     */
    public int selectNormalChildrenBrandById(Long brandId);

    /**
     * 校验品牌名称是否唯一
     *
     * @param brand 品牌信息
     * @return 结果
     */
    public String checkBrandNameUnique(TProductBrand brand);

    /**
     * 根据角色ID查询品牌树信息
     *
     * @param roleId 角色ID
     * @return 选中品牌列表
     */
    public List<Long> selectProductBrandListByRoleId(Long roleId);

    /**
     * 查询商品品牌
     *
     * @param brandId 商品品牌主键
     * @return 商品品牌
     */
    public TProductBrand selectTProductBrandByBrandId(Long brandId);

    /**
     * 新增商品品牌
     *
     * @param tProductBrand 商品品牌
     * @return 结果
     */
    public int insertTProductBrand(TProductBrand tProductBrand);

    /**
     * 修改商品品牌
     *
     * @param tProductBrand 商品品牌
     * @return 结果
     */
    public int updateTProductBrand(TProductBrand tProductBrand);

    /**
     * 批量删除商品品牌
     *
     * @param brandIds 需要删除的商品品牌主键集合
     * @return 结果
     */
    public int deleteTProductBrandByBrandIds(Long[] brandIds);

    /**
     * 删除商品品牌信息
     *
     * @param brandId 商品品牌主键
     * @return 结果
     */
    public int deleteTProductBrandByBrandId(Long brandId);
}
