package cn.huanzi.qch.baseadmin.info.infohouse.repository;

import cn.huanzi.qch.baseadmin.common.repository.CommonRepository;
import cn.huanzi.qch.baseadmin.info.infohouse.pojo.InfoHouse;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InfoHouseRepository extends CommonRepository<InfoHouse, String> {
    List<InfoHouse> findInfoHousesByHName(String hName);
    InfoHouse findInfoHouseByHId(String hid);
}
