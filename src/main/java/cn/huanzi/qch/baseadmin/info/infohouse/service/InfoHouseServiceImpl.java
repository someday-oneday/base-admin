package cn.huanzi.qch.baseadmin.info.infohouse.service;

import cn.huanzi.qch.baseadmin.common.pojo.PageInfo;
import cn.huanzi.qch.baseadmin.common.pojo.Result;
import cn.huanzi.qch.baseadmin.common.service.CommonServiceImpl;
import cn.huanzi.qch.baseadmin.info.infohouse.pojo.InfoHouse;
import cn.huanzi.qch.baseadmin.info.infohouse.repository.InfoHouseRepository;
import cn.huanzi.qch.baseadmin.info.infohouse.vo.InfoHouseVo;
import cn.huanzi.qch.baseadmin.util.CopyUtil;
import cn.huanzi.qch.baseadmin.util.SqlUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Service
@Transactional
public class InfoHouseServiceImpl extends CommonServiceImpl<InfoHouseVo, InfoHouse, String> implements InfoHouseService {
    @PersistenceContext
    private EntityManager em;

    @Autowired
    private InfoHouseRepository infoHouseRepository;

    @Override
    public Result<List<InfoHouseVo>> findInfoHousesByHName(String hName) {
        return Result.of(CopyUtil.copyList(infoHouseRepository.findInfoHousesByHName(hName), InfoHouseVo.class));
    }

    @Override
    public Result<InfoHouseVo> findInfoHouseByHId(String hid) {
        return Result.of(CopyUtil.copy(infoHouseRepository.findInfoHouseByHId(hid), InfoHouseVo.class));
    }

    @Override
    public Result<PageInfo<InfoHouseVo>> page(InfoHouseVo entityVo) {
        //这里可以直接调父类的page方法，当然也可以像下面这样自定义SQL
        //Result<PageInfo<SysUserVo>> result = super.page(entityVo);

        //根据实体、Vo直接拼接全部SQL
        StringBuilder sql = SqlUtil.joinSqlByEntityAndVo(InfoHouse.class,entityVo);

        //设置SQL、映射实体，以及设置值，返回一个Query对象
        Query query = em.createNativeQuery(sql.toString(), InfoHouse.class);

        //分页设置，page从0开始
        PageRequest pageRequest = entityVo.getPageable();

        //获取最终分页结果
        Result<PageInfo<InfoHouseVo>> result = Result.of(PageInfo.of(PageInfo.getJpaPage(query, pageRequest,em), InfoHouseVo.class));

        //置空密码
        //result.getData().getRows().forEach((orderVo) -> orderVo.setGarbageName(null));
        return result;
    }
}
