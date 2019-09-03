package pipeline.pip;

/**
 * @author : LiuYong at 2019-09-03
 * @package: pipeline.pip
 */
public abstract class AbstractPipe<In>  implements Pipe<In>{


    private Pipe<?> nextPipe;
    private PipeContext pipeContext;

    /**
     * 用于接收前一阶段的处理结果，用作该处理阶段的输入。
     *
     * @param in
     */
    @Override
    public <Out> Out process(In in) {
        In process = this.doProcess(in);
        if (null != nextPipe){
            Object o = ((Pipe<In>) nextPipe).process(process);
        }
        return null;
    }

    /**
     * ：初始化当前处理阶段对外提供的服务。
     *
     * @param in
     */
    @Override
    public void init(In in) {
        pipeContext = new PipeContext() {
            @Override
            public Object getContext() {
                return in;
            }
        };
    }

    /**
     * ：关闭当前处理阶段对外提供的服务。
     */
    @Override
    public boolean shutdown() {
        return false;
    }

    /**
     * ：设置当前处理阶段的下一个处理阶段。
     *
     * @param pipe
     */
    @Override
    public void setNextPipe(Pipe pipe) {
        nextPipe = pipe;
    }

    public abstract <T> T doProcess(In in);
}
