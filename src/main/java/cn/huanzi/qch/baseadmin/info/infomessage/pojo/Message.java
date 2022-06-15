package cn.huanzi.qch.baseadmin.info.infomessage.pojo;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "message")
@Data
public class Message implements Serializable {
    @Id
    private String mId;//留言id

    private String mContent;//留言内容

    private String mTime;//留言时间

    private String userName;//留言用户id

}
