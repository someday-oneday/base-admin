package cn.huanzi.qch.baseadmin.info.infonew.pojo;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "new1")
@Data
public class New implements Serializable {
    @Id
    private String newId;//公告id

    private String newTitle;//公告标题

    private String newText;//公告内容

    private String newTime;//公告发布时间

//    private String newAuthor;//公告作者

}
