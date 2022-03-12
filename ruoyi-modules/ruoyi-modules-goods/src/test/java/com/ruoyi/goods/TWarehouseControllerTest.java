//package com.ruoyi.goods;
//
//import com.ruoyi.goods.domain.TWarehouse;
//import com.ruoyi.goods.mapper.TWarehouseMapper;
//import com.ruoyi.goods.service.ITWarehouseService;
//import org.junit.Assert;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//import javax.annotation.Resource;
//import java.util.List;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class TWarehouseControllerTest {
//    @Resource
//    private TWarehouseMapper tWarehouseMapper;
//    @Resource
//    private ITWarehouseService tWarehouseService;
//    /**
//     * 查询子仓库列表
//     */
//    @Test
//    public void listChild() {
//        List<TWarehouse> list = tWarehouseMapper.selectTWarehouseByParentId(12L);
//        for(TWarehouse t : list){
//            System.out.println(t.getWarehouseName());
//            System.out.println(t.getAddress());
//        }
//    }
//    /**
//     * 修改仓库
//     */
//    @Test
//    public void edit() {
//        TWarehouse tWarehouse = new TWarehouse();
//        tWarehouse.setId(12L);
//        tWarehouse.setWarehouseName("仓库9A");
//        tWarehouse.setAddress("郑州市金水区");
//        tWarehouse.setPhone("15022222223");
//        tWarehouse.setSysUserId(6L);
//        int count = tWarehouseService.updateTWarehouse(tWarehouse);
//        System.out.println(count);
//        Assert.assertEquals(1, count);
//    }
//}
