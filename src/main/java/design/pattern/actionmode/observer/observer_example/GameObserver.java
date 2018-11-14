package design.pattern.actionmode.observer.observer_example;

/**
 * @Package: design.pattern.actionmode.observer.observer_example
 * @Description:   游戏观察者 （抽象观察者）
 * @function:
 * @Author : LiuYong
 * Created by yehao on 2018/10/9.
 */
public interface GameObserver {

    public String getName();

    public void setName(String name);

    /**
     * 声明游戏角色的救援方法
     * 由具体的角色实现具体的逻辑方法
     */
    public void help();

    /**
     * 声明角色被攻击方法，向中心发出救援
     * @param controllerCenter
     */
    public void beAttacked(ControllerCenter controllerCenter);

}

class Player implements GameObserver{
    private String name;

    public Player(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 声明游戏角色的救援方法
     * 由具体的角色实现具体的逻辑方法
     */
    @Override
    public void help() {
        System.out.println("坚持住，" + this.name + "来救你!");
    }

    /**
     * 声明角色被攻击方法，向中心发出救援
     *
     * @param controllerCenter
     */
    @Override
    public void beAttacked(ControllerCenter controllerCenter) {
        System.out.println("警报警报，" + this.name + "正在遭受攻击");
        controllerCenter.notifyObserver(this);
    }
}
