package cn.huanzi.qch.baseadmin.sys.sysusercompany.vo;

import cn.huanzi.qch.baseadmin.annotation.Like;
import cn.huanzi.qch.baseadmin.common.pojo.PageCondition;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class SysUserCompanyVo extends PageCondition implements Serializable {
    private String userId;//用户id

    private String loginName;//登录名

    private String userName;//用户名称

    private String password;//登录密码

    private String valid;//软删除标识，Y/N

    private String limitedIp;//限制允许登录的IP集合

    private Date expiredTime;//账号失效时间，超过时间将不能登录系统

    private Date lastChangePwdTime;//最近修改密码时间，超出时间间隔，提示用户修改密码

    private Date lastLoginTime;//最近登录时间，最后活跃时间

    private String limitMultiLogin;//是否允许账号同一个时刻多人在线，Y/N

    private Date createTime;//创建时间

    private Date updateTime;//修改时间

    private String companyId;//公司id

    private String userSex;//性别

    private String userTelephone;//电话

    private String companyName;//公司名

    private String companyBusiness;//公司业务

    private String companyTel;//公司电话

}
