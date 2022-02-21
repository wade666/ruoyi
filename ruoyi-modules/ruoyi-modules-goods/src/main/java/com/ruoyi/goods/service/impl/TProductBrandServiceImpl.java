package com.ruoyi.goods.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import com.ruoyi.common.core.constant.UserConstants;
import com.ruoyi.common.core.utils.DateUtils;
import com.ruoyi.common.core.utils.StringUtils;
import com.ruoyi.goods.domain.TProductBrand;
import com.ruoyi.goods.domain.vo.TreeSelect;
import com.ruoyi.goods.mapper.TProductBrandMapper;
import com.ruoyi.goods.service.ITProductBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 商品品牌Service业务层处理
 *
 * @author ruoyi
 * @date 2022-01-24
 */
@Service
public class TProductBrandServiceImpl implements ITProductBrandService {
    @Autowired
    private TProductBrandMapper tProductBrandMapper;

    @Override
    public List<TProductBrand> selectTProductBrandList(TProductBrand tProductBrand) {
        return tProductBrandMapper.selectTProductBrandList(tProductBrand);
    }

    /**
     * 构建前端所需要树结构
     *
     * @param brands 品牌列表
     * @return 树结构列表
     */
    @Override
    public List<TProductBrand> buildProductBrandTree(List<TProductBrand> brands) {
        List<TProductBrand> returnList = new ArrayList<TProductBrand>();
        List<Long> tempList = new ArrayList<Long>();
        for (TProductBrand brand : brands) {
            tempList.add(brand.getBrandId());
        }
        for (Iterator<TProductBrand> iterator = brands.iterator(); iterator.hasNext(); ) {
            TProductBrand brand = (TProductBrand) iterator.next();
            // 如果是顶级节点, 遍历该父节点的所有子节点
            if (!tempList.contains(brand.getParentId())) {
                recursionFn(brands, brand);
                returnList.add(brand);
            }
        }
        if (returnList.isEmpty()) {
            returnList = brands;
        }
        return returnList;
    }

    @Override
    public List<TreeSelect> buildProductBrandTreeSelect(List<TProductBrand> brands) {
        List<TProductBrand> brandTrees = buildProductBrandTree(brands);
        return brandTrees.stream().map(TreeSelect::new).collect(Collectors.toList());
    }

    @Override
    public boolean checkBrandExist(Long brandId) {
        return false;
    }

    @Override
    public int selectNormalChildrenBrandById(Long brandId) {
        return tProductBrandMapper.selectNormalChildrenBrandById(brandId);
    }

    @Override
    public String checkBrandNameUnique(TProductBrand brand) {
        Long BrandId = StringUtils.isNull(brand.getBrandId()) ? -1L : brand.getBrandId();
        TProductBrand info = tProductBrandMapper.checkBrandNameUnique(brand.getBrandName(), brand.getParentId());
        if (StringUtils.isNotNull(info) && info.getBrandId().longValue() != BrandId.longValue()) {
            return UserConstants.NOT_UNIQUE;
        }
        return UserConstants.UNIQUE;
    }

    @Override
    public List<Long> selectProductBrandListByRoleId(Long roleId) {
        return null;
    }

    /**
     * 查询商品品牌
     *
     * @param brandId 商品品牌主键
     * @return 商品品牌
     */
    @Override
    public TProductBrand selectTProductBrandByBrandId(Long brandId) {
        return tProductBrandMapper.selectTProductBrandByBrandId(brandId);
    }

    /**
     * 新增商品品牌
     *
     * @param tProductBrand 商品品牌
     * @return 结果
     */
    @Override
    public int insertTProductBrand(TProductBrand tProductBrand) {
        tProductBrand.setCreateTime(DateUtils.getNowDate());
        return tProductBrandMapper.insertTProductBrand(tProductBrand);
    }

    /**
     * 修改商品品牌
     *
     * @param tProductBrand 商品品牌
     * @return 结果
     */
    @Override
    public int updateTProductBrand(TProductBrand tProductBrand) {
        tProductBrand.setUpdateTime(DateUtils.getNowDate());
        return tProductBrandMapper.updateTProductBrand(tProductBrand);
    }

    /**
     * 批量删除商品品牌
     *
     * @param brandIds 需要删除的商品品牌主键
     * @return 结果
     */
    @Override
    public int deleteTProductBrandByBrandIds(Long[] brandIds) {
        return tProductBrandMapper.deleteTProductBrandByBrandIds(brandIds);
    }

    /**
     * 删除商品品牌信息
     *
     * @param brandId 商品品牌主键
     * @return 结果
     */
    @Override
    public int deleteTProductBrandByBrandId(Long brandId) {
        return tProductBrandMapper.deleteTProductBrandByBrandId(brandId);
    }

    /**
     * 递归列表
     */
    private void recursionFn(List<TProductBrand> list, TProductBrand t) {
        // 得到子节点列表
        List<TProductBrand> childList = getChildList(list, t);
        t.setChildren(childList);
        for (TProductBrand tChild : childList) {
            if (hasChild(list, tChild)) {
                recursionFn(list, tChild);
            }
        }
    }

    /**
     * 得到子节点列表
     */
    private List<TProductBrand> getChildList(List<TProductBrand> list, TProductBrand t) {
        List<TProductBrand> tlist = new ArrayList<TProductBrand>();
        Iterator<TProductBrand> it = list.iterator();
        while (it.hasNext()) {
            TProductBrand n = (TProductBrand) it.next();
            if (StringUtils.isNotNull(n.getParentId()) && n.getParentId().longValue() == t.getBrandId().longValue()) {
                tlist.add(n);
            }
        }
        return tlist;
    }

    /**
     * 判断是否有子节点
     */
    private boolean hasChild(List<TProductBrand> list, TProductBrand t) {
        return getChildList(list, t).size() > 0 ? true : false;
    }
}
