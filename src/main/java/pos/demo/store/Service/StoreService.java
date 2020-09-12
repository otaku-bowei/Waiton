package pos.demo.store.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pos.demo.store.DAO.StoreMapper;

@Service
public class StoreService {
    @Autowired
    StoreMapper storeMapper ;


}
