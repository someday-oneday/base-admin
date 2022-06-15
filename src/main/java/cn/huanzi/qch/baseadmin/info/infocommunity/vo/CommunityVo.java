package cn.huanzi.qch.baseadmin.info.infocommunity.vo;

import cn.huanzi.qch.baseadmin.common.pojo.PageCondition;
import lombok.Data;

import java.io.Serializable;

@Data
public class CommunityVo extends PageCondition implements Serializable {
    private String comId;//社区id

    private String comName;//社区名

    private String comDescription;//社区描述
}
