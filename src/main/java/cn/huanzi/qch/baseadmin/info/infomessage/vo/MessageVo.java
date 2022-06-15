package cn.huanzi.qch.baseadmin.info.infomessage.vo;

import cn.huanzi.qch.baseadmin.common.pojo.PageCondition;
import lombok.Data;

import java.io.Serializable;

@Data
public class MessageVo extends PageCondition implements Serializable {
    private String mId;//留言id

    private String mContent;//留言内容

    private String mTime;//留言时间

    private String userName;//留言用户id
}
