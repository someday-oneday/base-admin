package cn.huanzi.qch.baseadmin.info.infocar.repository;

import cn.huanzi.qch.baseadmin.common.repository.CommonRepository;
import cn.huanzi.qch.baseadmin.info.infocar.pojo.InfoCar;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InfoCarRepository extends CommonRepository<InfoCar, String> {
    List<InfoCar> findInfoCarsByCarName(String infoCarName);
}
