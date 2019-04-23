package recommend.platform.model;

/**
 * @author : LiuYong
 * Created by yehao on 2019-04-11.
 * @Package: com.helijia.personalise.model
 * @Description:
 * @function:
 */
public class BaseScopeData<T> {

    private Integer type;
    /**
     * 组件共有信息
     */
    private String code;
    private String explain;


    /**
     * 组件内封装信息
     */
    private T data;


    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getExplain() {
        return explain;
    }

    public void setExplain(String explain) {
        this.explain = explain;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
