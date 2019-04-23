package recommend.platform.model;

import java.io.Serializable;
import java.util.Date;

/**
 * @Package: com.helijia.personalise.model
 * @Description:
 * @function:
 * @Author : LiuYong
 * Created by yehao on 2019-04-04.
 */
public class ScopeModule implements Serializable {

    private Long id;
    /**
     * 组件的状态
     * 参照常量定义${CommonStatus}
     */
    private Integer status;

    private String code;
    /**
     * 组件的数据类型
     * 参见${DataTypeEnum}
     */
    private Integer dataType;
    /**
     * 描述组件的具体数据来源
     * 参见${DataSourceEnum}
     */
    private Integer sourceFrom;

    private String description;
    /**
     * 推荐解释
     */
    private String moduleExplain;

    /**
     * 配置的参数，底层以JSON存储
     */
    private String params;

    private String creator;

    private Date createTime;

    private String updateUser;

    private Date updateTime;
    /**
     *
     * */
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getDataType() {
        return dataType;
    }

    public void setDataType(Integer dataType) {
        this.dataType = dataType;
    }

    public Integer getSourceFrom() {
        return sourceFrom;
    }

    public void setSourceFrom(Integer sourceFrom) {
        this.sourceFrom = sourceFrom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getModuleExplain() {
        return moduleExplain;
    }

    public void setModuleExplain(String moduleExplain) {
        this.moduleExplain = moduleExplain;
    }

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
