package search.sort.service.impl;

import search.sort.service.RuleContext;

import java.util.HashMap;
import java.util.Map;

/**
 * @Package: search.sort.service.impl
 * @Description:
 * @function:
 * @Author : LiuYong
 * Created by yehao on 2019/1/23.
 */
public class DefaultRuleContext<T> implements RuleContext<T>{

    private Map<String, Object> variables = new HashMap<>();

    private T body;

    @Override
    public void setVariables(Map<String, Object> variables) {
        if (variables == null || variables.isEmpty()) {
            return;
        }
        for (Map.Entry<String, Object> entry : variables.entrySet()) {
            addVariable(entry.getKey(), entry.getValue());
        }
    }

    @Override
    public Map<String, Object> getVariables() {
        Map<String, Object> result = new HashMap<>();
        result.putAll(variables);
        return result;
    }

    @Override
    public void addVariable(String name, Object value) {
        if (name == null || name.isEmpty()) {
            throw new NullPointerException("name not null.");
        }
        variables.put(name, value);
    }

    @Override
    public void deleteVariable(String name, Object value) {
        if (name == null || name.isEmpty()) {
            throw new NullPointerException("name not null.");
        }
        variables.remove(name);
    }

    @Override
    public void clearVariables() {
        variables.clear();
    }

    @Override
    public T getBody() {
        return this.body;
    }

    public void setBody(T body) {
        this.body = body;
    }
}
