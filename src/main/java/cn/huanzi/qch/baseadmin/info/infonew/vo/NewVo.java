package cn.huanzi.qch.baseadmin.info.infonew.vo;

import cn.huanzi.qch.baseadmin.common.pojo.PageCondition;
import lombok.Data;

import java.io.Serializable;

@Data
public class NewVo extends PageCondition implements Serializable {
    private String newId;//公告id

    private String newTitle;//公告标题

    private String newText;//公告内容

    private String newTime;//公告发布时间

//    private String newAuthor;//公告作者
}
