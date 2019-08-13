package recommend.scene;

import recommend.scene.api.Context;
import recommend.scene.api.SolutionHandler;
import recommend.scene.api.StrategyHandler;
import recommend.scene.model.EngineContext;
import recommend.scene.model.RecommendConfig;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * @author : LiuYong
 * Created by Ly on 2019-08-13.
 * @Package: recommend.scene
 * @Description:
 * @function:
 */
public class SolutionImpl implements SolutionHandler {

    private String sceneId;
    private String solutionName;

    private String solutionPath;
    private RecommendConfig recomEngineConfig;
    private StrategyHandler handler;
    private EngineContext context;

    private SolutionImpl(RecommendConfig recommendConfig, Context context, String sceneId, String solutionName)
    {
        this.sceneId = sceneId;
        this.solutionName = solutionName;
        this.recomEngineConfig = recommendConfig;
        this.solutionPath = File.separator + solutionName + ".jar";
        this.context = (EngineContext) context;

        try {
            File jarFile = new File(solutionPath);
            URLClassLoader classLoader = new URLClassLoader(new URL[]{new File(solutionPath).toURI().toURL()},
                    Thread.currentThread().getContextClassLoader());
            Class<?> clazz = classLoader.loadClass("");
            handler = (StrategyHandler) (clazz.newInstance());
            handler.init(context);
        } catch (Throwable t) {
            // 省略相关代码
        }
    }

    public static SolutionImpl build(final EngineContext context, final RecommendConfig recomEngineConfig,
                                     String sceneId, String solutionName) {
        SolutionHandler solution = null;
        try {
            solution = new SolutionImpl(recomEngineConfig, context, sceneId, solutionName);
            return (SolutionImpl) solution;
        } catch (Throwable t) {
            t.printStackTrace();
        }
        return null;

    }
}
