package design.pattern.scope.factory.simple;

import design.pattern.scope.factory.simple.model.BaseDataResult;

import java.util.List;

/**
 * @author : LiuYong
 * Created by yehao on 2019-04-11.
 * @Package: design.pattern.scope
 * @Description:
 * @function:
 */
public abstract class AbstractFactory {

    abstract public List<BaseDataResult> getDatas(int type, String... params);

}
