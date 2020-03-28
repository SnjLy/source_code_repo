package engine.search.spi;

import java.io.Serializable;
import java.util.Map;

/**
 * @author : LiuYong
 * Created by Ly on 2019-08-14.
 * @Package: com.techwolf.oceanus.search.engine.api
 * @Description:  上下文
 * @function:
 */
public interface Context<T> extends Serializable {

    boolean isDebug();

    void debug(boolean debug);

    /**
     * 设置上下文
     * @param variables
     */
    void setVariables(Map<String, Object> variables) ;

    /**
     * 获取上下文
     * @return
     */
    Map<String, Object> getVariables();

    /**
     * 设置上下文变量
     * @param name   变量key
     * @param value  变量值
     */
    void addVariable(String name, Object value);

    /**
     * 移除上下文环境变量
     * @param name   变量key
     * @param value  变量值
     */
    void deleteVariable(String name, Object value);

    /**
     * 清空上下文环境变量
     */
    void clearVariables();

    T getBody();

    void setBody(T body);

}
