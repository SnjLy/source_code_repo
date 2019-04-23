package recommend.platform.model;

import java.util.List;

/**
 * @Package: com.helijia.search.recommend.model
 * @Description:
 * @function:
 * @Author : LiuYong
 * Created by yehao on 2019-04-04.
 */
public class ScopeRequest {

    private String requestId;

    /**
     * 推荐的场景 #{ScopeEnum}
     */
    private int scope;

    private String userId;

    private String cityCode;

    private List<Integer> areaIds;

    private double latitude;
    private double longitude;

    private int start = 0;
    private int num = 10;

    @Override
    public String toString() {
        return "ScopeRequest{" +
                "requestId='" + requestId + '\'' +
                ", scope=" + scope +
                ", userId='" + userId + '\'' +
                ", cityCode='" + cityCode + '\'' +
                ", areaIds=" + areaIds +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", start=" + start +
                ", num=" + num +
                '}';
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public int getScope() {
        return scope;
    }

    public void setScope(int scope) {
        this.scope = scope;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public List<Integer> getAreaIds() {
        return areaIds;
    }

    public void setAreaIds(List<Integer> areaIds) {
        this.areaIds = areaIds;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}
