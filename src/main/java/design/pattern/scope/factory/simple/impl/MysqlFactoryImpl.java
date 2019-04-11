package design.pattern.scope.factory.simple.impl;

import design.pattern.scope.factory.simple.AbstractFactory;
import design.pattern.scope.factory.simple.model.BaseDataResult;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : LiuYong
 * Created by yehao on 2019-04-11.
 * @Package: design.pattern.scope.impl
 * @Description:
 * @function:
 */
public class MysqlFactoryImpl extends AbstractFactory {

    /**
     * 获取手艺人数据
     *
     * @param size
     * @param params
     * @return
     */
    public List<BaseDataResult> getArtisans(int size, String... params) {
        System.out.println("mysql 查询 artisans over");
        return new ArrayList<>();
    }

    /**
     * 创建作品
     *
     * @param size   数量
     * @param params 参数
     * @return
     */
    public List<BaseDataResult> getProducts(int size, String... params) {
        System.out.println("mysql 查询 products over");
        return new ArrayList<>();
    }

    /**
     * 获取工作室实现
     *
     * @param size
     * @param params
     * @return
     */
    public List<BaseDataResult> getStudios(int size, String... params) {
        System.out.println("mysql 查询 studio over");
        return new ArrayList<>();
    }

    @Override
    public List<BaseDataResult> getDatas(int type, String... params) {

        return null;
    }
}
