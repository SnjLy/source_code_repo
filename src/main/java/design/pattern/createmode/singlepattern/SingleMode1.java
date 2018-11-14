package design.pattern.createmode.singlepattern;

/**
 * 懒汉模式1
 * 最简单的单例模式，在多线程下执行时会不满足单例，会生成多个对象
 * 此单例模式 不使用
 * Created by yehao on 2018/5/16.
 */
public class SingleMode1 {

    private String name ;
    private static SingleMode1 instatnce = null;
    private SingleMode1(){

    }
    public static SingleMode1 getInstance(){
        if (null == instatnce){  //多线程下执行判断和new 实例时会耗时，可能出现多个对象，不满足单例模式
            instatnce = new SingleMode1();
        }
        return instatnce;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    /*
    *  执行结果：
    *   mode1 name:model1
        mode2 name:model1
        mode3 name:model1
     */
    //模拟客户端， 调用单例模式，实际上是同一个对象
    public static void main(String[] args) {

        SingleMode1 mode1 = SingleMode1.getInstance();
        mode1.setName("model1");
        System.out.println("mode1 name:" + mode1.getName());
        SingleMode1 mode2 = SingleMode1.getInstance();
        System.out.println("mode2 name:" + mode2.getName());
        SingleMode1 mode3 = SingleMode1.getInstance();
        System.out.println("mode3 name:" + mode3.getName());
    }
}
