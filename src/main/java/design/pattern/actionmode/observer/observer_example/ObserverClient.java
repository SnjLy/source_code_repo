package design.pattern.actionmode.observer.observer_example;

/**
 * @Package: design.pattern.actionmode.observer.observer_example
 * @Description:
 * @function:
 * @Author : LiuYong
 * Created by yehao on 2018/10/9.
 */
public class ObserverClient {

    public static void main(String[] args) {
        //定义目标对象
        ConcreteControllerCenter ccc ;
        ccc = new ConcreteControllerCenter("五岳剑派");

        GameObserver player1,player2, player3, player4;

        player1 = new Player("杨过");
        player2 = new Player("张无忌");
        player3 = new Player("令狐冲");
        player4 = new Player("乔峰");

        ccc.register(player1);
        ccc.register(player2);
        ccc.register(player3);
        ccc.register(player4);

        player1.beAttacked(ccc);
    }
}
