package design.pattern.actionmode.mediator.mediator_example;

/**
 * @Package: design.pattern.actionmode.mediator.mediator_example
 * @Description: 抽象组件类：抽象同事类 声明同事方法
 * @function:
 * @Author : LiuYong
 * Created by yehao on 2018/9/26.
 */
public abstract class Component {

    protected Mediator mediator;

    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    /**
     * 组件调用中介者，注册方法
     */
    public void changed() {
        mediator.componentChanged(this);
    }

    /**
     * 抽象业务方法
     */
    public abstract void update();
}

/**
 * 具体同事类：按钮类
 */
class Button extends Component {
    /**
     * 抽象业务方法
     */
    @Override
    public void update() {
        System.out.println("点击按钮，不产生交互");
    }
}

/**
 * 列表框类:具体同事类
 */
class List extends Component {
    /**
     * 抽象业务方法
     */
    @Override
    public void update() {
        System.out.println("列表框增加一项:张无忌。");
    }

    public void select() {
        System.out.println("列表框选中项:小龙女。");
    }
}


//组合框类:具体同事类
class ComboBox extends Component {
    @Override
    public void update() {
        System.out.println("组合框增加一项:张无忌。");
    }

    public void select() {
        System.out.println("组合框选中项:小龙女。");
    }
}


/**
 * 文本框类:具体同事类
 */
class TextBox extends Component {

    @Override
    public void update() {
        System.out.println("客户信息增加成功后文本框清空。");
    }

    public void setText() {
        System.out.println("文本框显示:小龙女。");
    }
}
