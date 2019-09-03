package pipeline.pip;

/**
 * @author : LiuYong at 2019-09-03
 * @package: pipeline.pip
 */
public interface Pipe<In> {

    /**
     * 用于接收前一阶段的处理结果，用作该处理阶段的输入。
     */
    <Out> Out process(In in);

    /**
     * ：初始化当前处理阶段对外提供的服务。
     */
    void init(In in);

    /**
     * ：关闭当前处理阶段对外提供的服务。
     */
    boolean shutdown();

    /**
     * ：设置当前处理阶段的下一个处理阶段。
     */
    void setNextPipe(Pipe pipe);
}
