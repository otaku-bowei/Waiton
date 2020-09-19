package pos.demo.store.Service;

import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pos.demo.common.DateFormat;
import pos.demo.store.DAO.StoreMapper;

@Service
@MapperScan("pos.demo.store.DAO")
public class StoreService {
    @Autowired
    StoreMapper storeMapper ;

    /*
    * @author   王柏伟
    * @param    storeCode   店铺编号
    * @param    storeName   店铺名称
    * @param    owerEmail   用户邮箱
    * @param    owerUsername    用户名
    * @param    storeType   店铺类型
    */
    public void buildStore(String storeCode,String storeName,String owerEmail,
                           String owerUsername,String storeType){

        storeMapper.buildStore(storeCode,storeName,owerEmail,owerUsername,storeType, DateFormat.getTimeNow());
    }


}
