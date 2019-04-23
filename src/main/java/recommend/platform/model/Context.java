package recommend.platform.model;

import java.util.HashMap;
import java.util.Map;

/**
 * @Package: com.helijia.personalise.spi
 * @Description:  封装请求是用户的上下文数据，用于判断条件和执行获取具体的推荐组件
 * @function:
 * @Author : LiuYong
 * Created by yehao on 2019-04-04.
 */
public class Context<T> {
    private Map<String, Object> variables = new HashMap<>();

    private T body;

    public void setVariables(Map<String, Object> variables) {
        if (variables == null || variables.isEmpty()) {
            return;
        }
        for (Map.Entry<String, Object> entry : variables.entrySet()) {
            addVariable(entry.getKey(), entry.getValue());
        }
    }

    public Map<String, Object> getVariables() {
        Map<String, Object> result = new HashMap<>(variables.size());
        result.putAll(variables);
        return result;
    }

    public void addVariable(String name, Object value) {
        if (name == null || name.isEmpty()) {
            throw new NullPointerException("name not null.");
        }
        variables.put(name, value);
    }

    public void deleteVariable(String name, Object value) {
        if (name == null || name.isEmpty()) {
            throw new NullPointerException("name not null.");
        }
        variables.remove(name);
    }

    public void clearVariables() {
        variables.clear();
    }

    public T getBody() {
        return body;
    }

    public void setBody(T body) {
        this.body = body;
    }
}
