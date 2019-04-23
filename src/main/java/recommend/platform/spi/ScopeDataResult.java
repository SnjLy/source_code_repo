package recommend.platform.spi;

import java.io.Serializable;
import java.util.List;

/**
 * 数据加载结果
 */
public class ScopeDataResult<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    private T       data;
    private int     num;
    private List<T> list;

    public ScopeDataResult() {
    }

    public ScopeDataResult(T data) {
        this.data = data;
    }

    public ScopeDataResult(int num, List<T> list) {
        this.num = num;
        this.list = list;
    }

    public boolean isList() {
        return list != null;
    }
    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public static <T> ScopeDataResult<T> result(T data){
        return new ScopeDataResult<>(data);
    }

    public static <T> ScopeDataResult<T> result(int num, List<T> list){
        return new ScopeDataResult<>(num, list);
    }

}
