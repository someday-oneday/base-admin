package cn.huanzi.qch.baseadmin.sys.carcompany.repository;

import cn.huanzi.qch.baseadmin.common.repository.CommonRepository;
import cn.huanzi.qch.baseadmin.sys.carcompany.pojo.CarCompany;
import cn.huanzi.qch.baseadmin.sys.sysauthority.pojo.SysAuthority;
import org.springframework.stereotype.Repository;

@Repository
public interface CarCompanyRepository extends CommonRepository<CarCompany, String> {
}
