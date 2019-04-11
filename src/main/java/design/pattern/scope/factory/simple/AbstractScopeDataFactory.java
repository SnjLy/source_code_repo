package design.pattern.scope.factory.simple;

import design.pattern.scope.factory.simple.model.BaseDataResult;

import java.util.List;

/**
 * @author : LiuYong
 * Created by yehao on 2019-04-11.
 * @Package: com.helijia.personalise.spi
 * @Description: 抽象工厂方法
 * @function:
 */
public abstract class AbstractScopeDataFactory {

    protected AbstractFactory factory;

    public AbstractScopeDataFactory(AbstractFactory factory) {
        this.factory = factory;
    }

    public List<BaseDataResult> getDatas(Object module) {

        List<BaseDataResult> dataList = this.buildDatas(module);
        for (BaseDataResult baseScopeData : dataList) {
            fillResData(baseScopeData, module);
        }
        return dataList;
    }

    /**
     * 填充推荐标签等数据
     * @param baseScopeData
     * @param module
     */
     void fillResData(BaseDataResult baseScopeData, Object module){
         //填充返回信息
     }

    /**
     * 根据配置的组件构建具体的返回数据
     *
     * @param module
     * @return
     */
     public List<BaseDataResult> buildDatas(Object module){
         return factory.getDatas(0);
     }

}
