package com.ruoyi.goods.mapper;

import java.util.List;
import com.ruoyi.goods.domain.TProductBrand;
import org.apache.ibatis.annotations.Param;

/**
 * 商品品牌Mapper接口
 *
 * @author ruoyi
 * @date 2022-01-27
 */
public interface TProductBrandMapper {
    /**
     * 查询商品品牌
     *
     * @param brandId 商品品牌主键
     * @return 商品品牌
     */
    public TProductBrand selectTProductBrandByBrandId(Long brandId);

    /**
     * 查询商品品牌列表
     *
     * @param tProductBrand 商品品牌
     * @return 商品品牌集合
     */
    public List<TProductBrand> selectTProductBrandList(TProductBrand tProductBrand);

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
     * 删除商品品牌
     *
     * @param brandId 商品品牌主键
     * @return 结果
     */
    public int deleteTProductBrandByBrandId(Long brandId);

    /**
     * 批量删除商品品牌
     *
     * @param brandIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTProductBrandByBrandIds(Long[] brandIds);

    /**
     * 校验品牌名称是否唯一
     *
     * @param brandName 品牌名称
     * @param parentId  父品牌ID
     * @return 结果
     */
    public TProductBrand checkBrandNameUnique(@Param("brandName") String brandName, @Param("parentId") Long parentId);

    /**
     * 根据ID查询所有子品牌（正常状态）
     *
     * @param brandId 品牌ID
     * @return 子品牌数
     */
    public int selectNormalChildrenBrandById(Long brandId);
}
