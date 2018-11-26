package recommend.mahout;

import org.apache.mahout.cf.taste.impl.common.FastByIDMap;
import org.apache.mahout.cf.taste.impl.common.LongPrimitiveIterator;
import org.apache.mahout.cf.taste.impl.model.GenericDataModel;
import org.apache.mahout.cf.taste.impl.model.GenericPreference;
import org.apache.mahout.cf.taste.impl.model.GenericUserPreferenceArray;
import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.impl.neighborhood.NearestNUserNeighborhood;
import org.apache.mahout.cf.taste.impl.recommender.GenericItemBasedRecommender;
import org.apache.mahout.cf.taste.impl.recommender.GenericUserBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.EuclideanDistanceSimilarity;
import org.apache.mahout.cf.taste.impl.similarity.PearsonCorrelationSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.model.PreferenceArray;
import org.apache.mahout.cf.taste.neighborhood.UserNeighborhood;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.recommender.Recommender;
import org.apache.mahout.cf.taste.similarity.ItemSimilarity;
import org.apache.mahout.cf.taste.similarity.UserSimilarity;

import java.io.File;
import java.util.List;

/**
 * @Package: recommend.mahout
 * @Description:
 * @function:
 * @Author : LiuYong
 * Created by yehao on 2018/11/23.
 */
public class RecommendDemo {

    public static void main(String[] args) throws Exception {
        userBasedRecommender();
        itemBasedRecommender();
        CFDemo();
    }

    /**
     * 基于用户相似度的推荐引擎
     *
     * @throws Exception
     */
    public static void userBasedRecommender() throws Exception {
        // step1 构建模型
        DataModel model = new FileDataModel(new File("recommend/data.txt"));
        // step2 计算相似度 （基于皮尔逊相关系数计算相似度）
        UserSimilarity similarity = new PearsonCorrelationSimilarity(model);
        // step3 查找k紧邻
        UserNeighborhood neighborhood = new NearestNUserNeighborhood(2,
                similarity, model);
        // 构造推荐引擎
        Recommender recommender = new GenericUserBasedRecommender(model,
                neighborhood, similarity);

        // 为用户1推荐两个ItemID
        List<RecommendedItem> recommendations = recommender.recommend(1, 2);
        for (RecommendedItem recommendation : recommendations) {
            System.out.println(recommendation);
        }
    }

    /**
     * 基于内容的推荐引擎
     *
     * @throws Exception
     */
    public static void itemBasedRecommender() throws Exception {
        DataModel model = new FileDataModel(new File("recommend/data.txt"));
        ItemSimilarity similarity = new PearsonCorrelationSimilarity(model);
        Recommender recommender = new GenericItemBasedRecommender(model,
                similarity);
        List<RecommendedItem> recommendations = recommender.recommend(1, 1);
        for (RecommendedItem recommendation : recommendations) {
            System.out.println(recommendation);
        }
    }

    /**
     *
     * @throws Exception
     */
    public static void CFDemo() throws Exception {
        // 创建dataModel
        FastByIDMap<PreferenceArray> preferences = new FastByIDMap<PreferenceArray>();

        // 用户1喜欢物品1、2、3
        PreferenceArray userPref1 = new GenericUserPreferenceArray(3);
//		userPref1.setUserID(1, 1);
//		userPref1.setItemID(0, 1);
//		userPref1.setValue(0, 5.0f);
//		userPref1.setItemID(1, 2);
//		userPref1.setValue(1, 3.0f);
//		userPref1.setItemID(2, 3);
//		userPref1.setValue(2, 2.5f);
        userPref1.set(0, new GenericPreference(1, 1, 5.0f));
        userPref1.set(1, new GenericPreference(1, 2, 3.0f));
        userPref1.set(2, new GenericPreference(1, 3, 2.5f));

        // 用户2喜欢物品1、2、3、4
        PreferenceArray userPref2 = new GenericUserPreferenceArray(4);
        userPref2.set(0, new GenericPreference(2, 1, 2.0f));
        userPref2.set(1, new GenericPreference(2, 2, 2.5f));
        userPref2.set(2, new GenericPreference(2, 3, 5.0f));
        userPref2.set(3, new GenericPreference(2, 4, 2.0f));

        // 用户3喜欢物品1、4、5、7
        PreferenceArray userPref3 = new GenericUserPreferenceArray(4);
        userPref3.set(0, new GenericPreference(3, 1, 2.5f));
        userPref3.set(1, new GenericPreference(3, 4, 4.0f));
        userPref3.set(2, new GenericPreference(3, 5, 4.5f));
        userPref3.set(3, new GenericPreference(3, 7, 5.0f));

        // 用户4喜欢物品1、3、4、6
        PreferenceArray userPref4 = new GenericUserPreferenceArray(4);
        userPref4.set(0, new GenericPreference(4, 1, 5.0f));
        userPref4.set(1, new GenericPreference(4, 3, 3.0f));
        userPref4.set(2, new GenericPreference(4, 4, 4.5f));
        userPref4.set(3, new GenericPreference(4, 6, 4.0f));

        // 用户5喜欢物品1、2、3、4、5、6
        PreferenceArray userPref5 = new GenericUserPreferenceArray(6);
        userPref5.set(0, new GenericPreference(5, 1, 4.0f));
        userPref5.set(1, new GenericPreference(5, 2, 3.0f));
        userPref5.set(2, new GenericPreference(5, 3, 2.0f));
        userPref5.set(3, new GenericPreference(5, 4, 4.0f));
        userPref5.set(4, new GenericPreference(5, 5, 3.5f));
        userPref5.set(5, new GenericPreference(5, 6, 4.0f));

        preferences.put(1, userPref1);
        preferences.put(2, userPref2);
        preferences.put(3, userPref3);
        preferences.put(4, userPref4);
        preferences.put(5, userPref5);

        //基于程序构建的dataModel
        DataModel model = new GenericDataModel(preferences);
        //基于文件的dataModel
//		DataModel model = new FileDataModel(new File("testCF.csv"));

        //基于用户的、欧氏距离、最近邻的协同过滤算法
        UserSimilarity similarity = new EuclideanDistanceSimilarity(model);
        UserNeighborhood neighborhood = new NearestNUserNeighborhood(2,
                similarity, model);
        Recommender recommender = new GenericUserBasedRecommender(model,
                neighborhood, similarity);


        //打印用户4的推荐信息
        List<RecommendedItem> recommendations = recommender.recommend(4, 3);
        for (RecommendedItem recommendation : recommendations) {
            System.out.println(recommendation);
        }

        //打印所有用户的推荐信息
        LongPrimitiveIterator iter = model.getUserIDs();
        while (iter.hasNext()) {
            long uid = iter.nextLong();
            List<RecommendedItem> list = recommender.recommend(uid, 3);
            System.out.printf("uid:%s", uid);
            for (RecommendedItem ritem : list) {
                System.out.printf("(%s,%f)", ritem.getItemID(),
                        ritem.getValue());
            }
            System.out.println();
        }

        //基于内容的、欧氏距离、最近邻的协同过滤算法
        ItemSimilarity similarity1 = new EuclideanDistanceSimilarity(model);
        Recommender recommender1 = new GenericItemBasedRecommender(model,similarity1);
        LongPrimitiveIterator iter1 = model.getUserIDs();
        while (iter1.hasNext()) {
            long uid = iter1.nextLong();
            List<RecommendedItem> list = recommender1.recommend(uid, 3);
            System.out.printf("uid:%s", uid);
            for (RecommendedItem ritem : list) {
                System.out.printf("(%s,%f)", ritem.getItemID(),
                        ritem.getValue());
            }
            System.out.println();
        }
    }
}