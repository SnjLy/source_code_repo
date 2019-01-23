package search.sort.service;

import java.util.Map;

/**
 * @Package: search.sort.service
 * @Description:
 * @function:
 * @Author : LiuYong
 * Created by yehao on 2019/1/23.
 */
public interface RuleContext<T> {

    void setVariables(Map<String, Object> variables);

    Map<String, Object> getVariables();

    void addVariable(String name, Object value);

    void deleteVariable(String name, Object value);

    void clearVariables();

    T getBody();
}
