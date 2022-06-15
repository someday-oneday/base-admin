package cn.huanzi.qch.baseadmin.info.infonew.service;

import cn.huanzi.qch.baseadmin.common.pojo.PageInfo;
import cn.huanzi.qch.baseadmin.common.pojo.Result;
import cn.huanzi.qch.baseadmin.common.service.CommonServiceImpl;
import cn.huanzi.qch.baseadmin.info.infonew.pojo.New;
import cn.huanzi.qch.baseadmin.info.infonew.repository.NewRepository;
import cn.huanzi.qch.baseadmin.info.infonew.vo.NewVo;
import cn.huanzi.qch.baseadmin.util.SqlUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Service
@Transactional
public class NewServiceImpl extends CommonServiceImpl<NewVo, New, String> implements NewService {
    @PersistenceContext
    private EntityManager em;

    @Autowired
    private NewRepository newRepository;

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    @Override
    public Result<NewVo> save(NewVo entityVo) {
        //调用父类
        Result<NewVo> result = super.save(entityVo);

        //发布 系统设置，更新/保存事件
        applicationEventPublisher.publishEvent(result.getData());
        return result;
    }

//    @Override
//    public Result<List<InfoNewVo>> findInfoHousesByHName(String hName) {
//        return Result.of(CopyUtil.copyList(infoHouseRepository.findInfoHousesByHName(hName), InfoNewVo.class));
//    }

    @Override
    public Result<PageInfo<NewVo>> page(NewVo entityVo) {
        //这里可以直接调父类的page方法，当然也可以像下面这样自定义SQL
        //Result<PageInfo<SysUserVo>> result = super.page(entityVo);

        //根据实体、Vo直接拼接全部SQL
        StringBuilder sql = SqlUtil.joinSqlByEntityAndVo(New.class,entityVo);

        //设置SQL、映射实体，以及设置值，返回一个Query对象
        Query query = em.createNativeQuery(sql.toString(), New.class);

        //分页设置，page从0开始
        PageRequest pageRequest = entityVo.getPageable();

        //获取最终分页结果
        Result<PageInfo<NewVo>> result = Result.of(PageInfo.of(PageInfo.getJpaPage(query, pageRequest,em), NewVo.class));

        //置空密码
        //result.getData().getRows().forEach((orderVo) -> orderVo.setGarbageName(null));
        return result;
    }
}
