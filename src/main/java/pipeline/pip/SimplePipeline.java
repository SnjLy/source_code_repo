package pipeline.pip;

/**
 * @author : LiuYong at 2019-09-03
 * @package: pipeline.pip
 */
public class SimplePipeline extends AbstractPipe implements Pipeline {

    @Override
    public void addPipe(Pipe pipe) {

    }

    @Override
    public Pipe head() {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public Object doProcess(Object o) {
        return null;
    }
}
