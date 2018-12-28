package recommend.librec;

import com.alibaba.fastjson.JSON;
import net.librec.conf.Configuration;
import net.librec.data.DataModel;
import net.librec.data.model.TextDataModel;
import net.librec.eval.RecommenderEvaluator;
import net.librec.eval.rating.MAEEvaluator;
import net.librec.filter.GenericRecommendedFilter;
import net.librec.filter.RecommendedFilter;
import net.librec.recommender.Recommender;
import net.librec.recommender.RecommenderContext;
import net.librec.recommender.cf.UserKNNRecommender;
import net.librec.similarity.PCCSimilarity;
import net.librec.similarity.RecommenderSimilarity;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Package: recommend.librec
 * @Description:
 * @function:
 * @Author : LiuYong
 * Created by yehao on 2018/12/11.
 */
public class LibRecFirst {

    public static void main(String[] args) throws Exception {
        Map<String, Object> map = new HashMap<>();
        map.put("topNum", 30);
        map.put("categories", Arrays.asList("tag_mei_jia", "tag_mei_rong","tag_mei_jie", "tag_li_liao"));

        System.out.println(JSON.toJSON(map));
       /*
        // recommender configuration
        Configuration conf = new Configuration();
        Configuration.Resource resource = new Configuration.Resource("rec/cf/userknn-test.properties");
        conf.addResource(resource);

        // build data model
        DataModel dataModel = new TextDataModel(conf);
        dataModel.buildDataModel();

        // set recommendation context
        RecommenderContext context = new RecommenderContext(conf, dataModel);
        RecommenderSimilarity similarity = new PCCSimilarity();
        similarity.buildSimilarityMatrix(dataModel);
        context.setSimilarity(similarity);

        // training
        Recommender recommender = new UserKNNRecommender();
        recommender.recommend(context);

        // evaluation
        RecommenderEvaluator evaluator = new MAEEvaluator();
        recommender.evaluate(evaluator);

        // recommendation results
        List recommendedItemList = recommender.getRecommendedList();
        RecommendedFilter filter = new GenericRecommendedFilter();
        recommendedItemList = filter.filter(recommendedItemList);*/
    }
}
