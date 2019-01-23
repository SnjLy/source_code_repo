package search.sort.model;

/**
 * @Package: search.sort.model
 * @Description:
 * @function:
 * @Author : LiuYong
 * Created by yehao on 2019/1/23.
 */
public class SortRulePlan {

    private Integer id;
    private String plan;//测试方案
    private String serviceType;//业务类型
    private Integer type;//作品规则方案 or 手艺人规则方案 or 品牌馆规则方案 or 其它

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPlan() {
        return plan;
    }

    public void setPlan(String plan) {
        this.plan = plan;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
