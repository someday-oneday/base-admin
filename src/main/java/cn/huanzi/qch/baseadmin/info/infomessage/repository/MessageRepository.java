package cn.huanzi.qch.baseadmin.info.infomessage.repository;

import cn.huanzi.qch.baseadmin.common.repository.CommonRepository;
import cn.huanzi.qch.baseadmin.info.infomessage.pojo.Message;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends CommonRepository<Message, String> {

}
