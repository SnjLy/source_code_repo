package com.yehao_test.Properties;

import java.io.Serializable;
import java.util.Date;

/**
 * @Title
 * @author yehao
 * @param <T>
 *
 */
public class BaseEntity<T> implements Serializable{
    private static final long serialVersionUID = 1L;
    
    private String id;
    private Date createDate;
    private String creator;
    private Date updateDate;
    private String updateby;
    private String isDel;
    private String remarks;
    
   
    
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public Date getCreateDate() {
        return createDate;
    }
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
    public String getIsDel() {
        return isDel;
    }
    public void setIsDel(String isDel) {
        this.isDel = isDel;
    }
    public String getRemarks() {
        return remarks;
    }
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
    public String getCreator() {
        return creator;
    }
    public void setCreator(String creator) {
        this.creator = creator;
    }
    public Date getUpdateDate() {
        return updateDate;
    }
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
    public String getUpdateby() {
        return updateby;
    }
    public void setUpdateby(String updateby) {
        this.updateby = updateby;
    }

    @Override
    public String toString() {
        return "BaseEntity{" +
                "id='" + id + '\'' +
                ", createDate=" + createDate +
                ", creator='" + creator + '\'' +
                ", updateDate=" + updateDate +
                ", updateby='" + updateby + '\'' +
                ", isDel='" + isDel + '\'' +
                ", remarks='" + remarks + '\'' +
                '}';
    }
}
