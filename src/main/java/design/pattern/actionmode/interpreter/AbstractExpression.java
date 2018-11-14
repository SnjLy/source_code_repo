package design.pattern.actionmode.interpreter;

/**
 * @Package: design.pattern.actionmode.interpreter
 * @Description:
 * @function:
 * @Author : LiuYong
 * Created by yehao on 2018/9/14.
 */
public abstract class AbstractExpression {
    /**
     * 声明了抽象的解释操作，它是所有终结 符表达式和非终结符表达式的公共父类。
     */
    public abstract void interpret(Context cxt);
}


class TerminalExpression extends AbstractExpression{

    /**
     * 声明了抽象的解释操作，它是所有终结 符表达式和非终结符表达式的公共父类。
     *
     * @param cxt
     */
    @Override
    public void interpret(Context cxt) {
        //终结解释符表达式操作
    }
}

class NonterminalExpression extends  AbstractExpression{
    private AbstractExpression left;
    private AbstractExpression right;


    public NonterminalExpression(AbstractExpression left, AbstractExpression right) {
        this.left = left;
        this.right = right;
    }

    /**
     * 声明了抽象的解释操作，它是所有终结 符表达式和非终结符表达式的公共父类。
     *
     * @param cxt
     */
    @Override
    public void interpret(Context cxt) {
        //递归调用每一个组成部分的interpret()方法
        // 在递归调用时指定组成部分的连接方式，即非终结符的功能
    }
}