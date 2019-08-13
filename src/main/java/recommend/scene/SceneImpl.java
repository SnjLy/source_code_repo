package recommend.scene;

import recommend.scene.api.RecommendHandler;
import recommend.scene.api.SolutionHandler;
import recommend.scene.model.RecommendParam;

import java.util.Map;

/**
 * @author : LiuYong
 * Created by Ly on 2019-08-13.
 * @Package: recommend.scene.api
 * @Description:  推荐引擎的场景服务
 * @function:
 */
public class SceneImpl implements RecommendHandler {
    private String sceneId;
    private Map<String, SolutionHandler> solutions;
    private SolutionSelector selector;


    public Object sceneRecommend(RecommendParam param){

        return null;
    }
}
