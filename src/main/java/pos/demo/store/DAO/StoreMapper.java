package pos.demo.store.DAO;


import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;


@Mapper
@Component(value = "StoreMapper")
public interface StoreMapper {


    //插入一个店铺记录
    @Insert("insert into store(storeCode,storeName,owerEmail,owerUsername,storeType,buildDatetime)" +
            "values (\'${storeCode}\',\'${storeName}\',\'${owerEmail}\',\'${owerUsername}\'," +
            "\'${storeType}\',\'${buildDatetime}\')")
    public void buildStore(@Param("storeCode") String storeCode,@Param("storeName") String storeName,
                           @Param("owerEmail") String owerEmail, @Param("owerUsername") String owerUsername,
                           @Param("storeType") String storeType,@Param("buildDatetime") String buildDatetime) ;


    //
}
