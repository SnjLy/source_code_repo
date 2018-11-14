package design.pattern.actionmode.responsibility.responsibility_example;

/**
 * @Package: design.pattern.actionmode.responsibility.responsibility_example
 * @Description: 审批者类:抽象处理者    职责链模式
 * @function:
 * @Author : LiuYong
 * Created by yehao on 2018/9/11.
 */
public abstract class AbstractApprover {
    /**
     * 下一任处理者， 职责链中的下一个节点
     */
    protected AbstractApprover nextApprover;
    /**
     * 当前处理者信息，这个处理节点的标识信息
     */
    protected String name;

    public void setNextApprover(AbstractApprover nextApprover) {
        this.nextApprover = nextApprover;
    }

    public AbstractApprover(String name) {
        this.name = name;
    }

    /**
     * 抽象请求处理方法 由子类实现具体处理逻辑，构成职责链处理链
     */
    public abstract void processRequest(PurchaseRequest request);
}

/**
 * 主任类:具体处理者
 */
class Director extends AbstractApprover {
    public Director(String name) {
        super(name);
    }

    /**
     * 抽象请求处理方法 由子类实现具体处理逻辑，构成职责链处理链
     *
     * @param request
     */
    @Override
    public void processRequest(PurchaseRequest request) {
        if (request.getAmount() < 50000) {
            System.out.println("主任" + this.name + "审批采购单:" + request);
        } else {
            //转发请求
            this.nextApprover.processRequest(request);
        }
    }
}

/**
 * CEO处理逻辑
 */
class VicePresident extends AbstractApprover {
    public VicePresident(String name) {
        super(name);
    }

    /**
     * 抽象请求处理方法 由子类实现具体处理逻辑，构成职责链处理链
     *
     * @param request
     */
    @Override
    public void processRequest(PurchaseRequest request) {
        if (request.getAmount() < 100000) {
            System.out.println("副董事长" + this.name + "审批采购单:" +request);
        } else {
            //转发请求
            this.nextApprover.processRequest(request);
        }
    }
}


/**
 * 董事长类:具体处理者
 */
class President extends AbstractApprover {
    public President(String name) {
        super(name);
    }

    /**
     * 抽象请求处理方法 由子类实现具体处理逻辑，构成职责链处理链
     *
     * @param request
     */
    @Override
    public void processRequest(PurchaseRequest request) {
        if (request.getAmount() < 500000) {
            System.out.println("董事长" + this.name + "审批采购单:" + request);
        } else {
            //转发请求
            this.nextApprover.processRequest(request);
        }
    }
}


/**
 * 董事会类:具体处理者   ------最后节点处理类。
 */
class Congress extends AbstractApprover {
    public Congress(String name) {
        super(name);
    }

    /**
     * 抽象请求处理方法 由子类实现具体处理逻辑，构成职责链处理链
     *
     * @param request
     */
    @Override
    public void processRequest(PurchaseRequest request) {
        System.out.println("召开董事会审批采购单:" + request);
    }
}


