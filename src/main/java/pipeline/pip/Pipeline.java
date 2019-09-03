package pipeline.pip;

/**
 * @author : LiuYong at 2019-09-03
 * @package: pipeline.pip
 */
public interface Pipeline {

    void addPipe(Pipe pipe);

    Pipe head();

    int size();
}
