package recommend.scene;

import recommend.scene.model.RecommendParam;
import recommend.scene.model.RecommendResult;

import java.util.Map;

/**
 * @author : LiuYong
 * Created by Ly on 2019-08-13.
 * @Package: recommend.scene
 * @Description:
 * @function:
 */
public class RecommendService {

    private Map<String, SceneImpl> sceneMap;

    public RecommendResult recommend(RecommendParam param){

        //省略
        SceneImpl scene = sceneMap.get(param.getSceneId());

        return null;
    }

}
