package cn.huanzi.qch.baseadmin.info.infogarbage.vo;

import cn.huanzi.qch.baseadmin.common.pojo.PageCondition;
import lombok.Data;
import org.hibernate.annotations.NotFound;

import java.io.Serializable;

@Data
public class GarbageVo extends PageCondition implements Serializable {
    private String gId;//垃圾id
    @NotFound
    private String gName;//垃圾名

    private String gDescribe;//垃圾描述

    private String gPrice;//垃圾价格
}
