package goods;

import com.ruoyi.goods.mapper.TWarehouseMapper;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class TWarehouseControllerTest {
    @Autowired
    private TWarehouseMapper tWarehouseMapper;

    @Test
    public void listChild() {
        tWarehouseMapper.selectTWarehouseByParentId(13L);
    }
}
