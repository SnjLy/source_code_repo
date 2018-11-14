package design.pattern.createmode.singlepattern;

/**
 * 静态内部类实现单例模式
 * 通过使用IoDH，我们既可以实现延迟加载，又可以保证线程安全，不影响系统性能，不失为 一种最好的Java语言单例模式实现方式
 * 推荐
 * Created by yehao on 2018/5/16.
 */
public class FinalSingleton {

    private FinalSingleton() {
    }

    public static FinalSingleton getInstance(){
        //return StaticInnerClass.instance;
        return StaticInnerClass.loadSingleton();
    }

    private static class StaticInnerClass{
        //private static FinalSingleton instance = new FinalSingleton();

        private static FinalSingleton loadSingleton(){
            return new FinalSingleton();
        }
    }
}
