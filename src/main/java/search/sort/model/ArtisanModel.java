package search.sort.model;

/**
 * @Package: search.sort.model
 * @Description:
 * @function:
 * @Author : LiuYong
 * Created by yehao on 2019/1/23.
 */
public class ArtisanModel {


    public ArtisanModel(String artisanId, String mobile) {
        this.artisanId = artisanId;
        this.mobile = mobile;
    }

    public ArtisanModel() {
    }

    private String artisanId;
    private String mobile;
    private String nick;
    /**
     * 手艺人状态  0：新建待审核 1：正常 2：注销 3：待安排试手 4：待试手 5：待安排培训 6：待培训 7：待审核资质 8：待安排领取物料 9：待领取物料 10：入驻失败 11：入驻资质审核失败 12:关入小黑屋
     */
    private Integer status;
    /**
     * 手艺人图像
     */
    private String avatar;
    /**
     * 手艺人作品均价
     */
    private Double averagePrice;
    /**
     * 手艺人接单数
     */
    private Double serviceAmount;

    public String getArtisanId() {
        return artisanId;
    }

    public void setArtisanId(String artisanId) {
        this.artisanId = artisanId;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Double getAveragePrice() {
        return averagePrice;
    }

    public void setAveragePrice(Double averagePrice) {
        this.averagePrice = averagePrice;
    }

    public Double getServiceAmount() {
        return serviceAmount;
    }

    public void setServiceAmount(Double serviceAmount) {
        this.serviceAmount = serviceAmount;
    }
}
