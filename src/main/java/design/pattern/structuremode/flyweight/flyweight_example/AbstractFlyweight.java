package design.pattern.structuremode.flyweight.flyweight_example;

import com.alibaba.fastjson.JSON;

/**
 * @Package: design.pattern.structuremode.flyweight.flyweight_example
 * @Description:  抽象享元类
 * @function:
 * @Author : LiuYong
 * Created by yehao on 2018/9/6.
 */
public abstract class AbstractFlyweight {

    /**
     * 子类实现具体享元类的获取颜色的方法
     * @return
     */
    public abstract String getColor();

    public void display(Coordinates coordinates){
        System.out.println("棋子的颜色是：" + this.getColor() + " 棋子的位子是:" + JSON.toJSONString(coordinates)) ;
    }

}

/**
 * 黑色棋子，具体享元类
 */
class BlackChessman extends AbstractFlyweight{
    /**
     * 子类实现具体享元类的获取颜色的方法
     *
     * @return
     */
    @Override
    public String getColor() {
        return "黑色";
    }
}

/**
 * 白色棋子，具体享元类
 */
class WhiteChessman extends  AbstractFlyweight{
    /**
     * 子类实现具体享元类的获取颜色的方法
     *
     * @return
     */
    @Override
    public String getColor() {
        return "白色";
    }
}
