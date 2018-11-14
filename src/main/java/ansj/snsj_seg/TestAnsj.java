package ansj.snsj_seg;

import org.ansj.app.keyword.KeyWordComputer;
import org.ansj.app.keyword.Keyword;
import org.ansj.dic.LearnTool;
import org.ansj.domain.Nature;
import org.ansj.domain.Result;
import org.ansj.domain.Term;
import org.ansj.library.AmbiguityLibrary;
import org.ansj.library.DicLibrary;
import org.ansj.library.StopLibrary;
import org.ansj.recognition.impl.NatureRecognition;
import org.ansj.recognition.impl.StopRecognition;
import org.ansj.splitWord.Analysis;
import org.ansj.splitWord.analysis.*;
import org.apache.solr.client.solrj.response.FieldAnalysisResponse;
import org.junit.Test;
import org.nlpcn.commons.lang.tire.domain.Forest;
import org.nlpcn.commons.lang.tire.domain.Value;
import org.nlpcn.commons.lang.tire.library.Library;
import org.nlpcn.commons.lang.util.IOUtil;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.*;

/**
 * @Package: ansj.snsj_seg
 * @Description:  使用ANSJ分词
 * @function:
 * @Author : LiuYong
 * Created by yehao on 2018/7/5.
 */
public class TestAnsj {

    public static void main(String[] args) {
        String str1 = "欢迎使用ansj_seg,(ansj中文分词)在这里如果你遇到什么问题都可以联系我.我一定尽我所能.帮助大家.ansj_seg更快,更准,更自由!" ;
        System.out.println("精准分词:" + ToAnalysis.parse(str1));  //精准分词
        System.out.println("NlpAnalysis分词:" + NlpAnalysis.parse(str1));  //自然语言分词,具有未登录词发现功能
        System.out.println("Base分词:" + BaseAnalysis.parse(str1));  //基本分词
        System.out.println("Index分词:" + IndexAnalysis.parse(str1));  //索引分词，用于检索的分词方式
        System.out.println("DicAnalysis分词:" + DicAnalysis.parse(str1)); //用户默认词典优先



        //只关注这些词性的词
        Set<String> expectedNature = new HashSet<String>() {{
            add("n");add("v");add("vd");add("vn");add("vf");
            add("vx");add("vi");add("vl");add("vg");
            add("nt");add("nz");add("nw");add("nl");
            add("ng");add("userDefine");add("wh");
        }};
        String str = "欢迎使用ansj_seg,(ansj中文分词)在这里如果你遇到什么问题都可以联系我.我一定尽我所能.帮助大家.ansj_seg更快,更准,更自由!" ;
        Result result = ToAnalysis.parse(str); //分词结果的一个封装，主要是一个List<Term>的terms
        System.out.println(result.getTerms());

        List<Term> terms = result.getTerms(); //拿到terms
        System.out.println(terms.size());

        for(int i=0; i<terms.size(); i++) {
            String word = terms.get(i).getName(); //拿到词
            String natureStr = terms.get(i).getNatureStr(); //拿到词性
            if(expectedNature.contains(natureStr)) {
                System.out.println(word + ":" + natureStr);
            }
        }
        //对非ansj分词的词获取词性
        String[] strs = {"对", "非", "ansj", "的", "分词", "结果", "进行", "词性", "标注"} ;
        List<Term> recognition = new NatureRecognition().recognition(Arrays.asList(strs), 0) ;
        System.out.println(recognition);
    }


    //新词发现
    @Test
    public void testLearn(){
        //构建一个新词学习的工具类。这个对象。保存了所有分词中出现的新词。出现次数越多。相对权重越大。
        LearnTool learn = new LearnTool();
        NlpAnalysis nlpAnalysis = new NlpAnalysis().setLearnTool(learn);
        System.out.println(nlpAnalysis.parseStr("说过，社交软件也是打着沟通的平台，让无数寂寞男女有了肉体与精神的寄托。"));
        System.out.println(nlpAnalysis.parseStr("其实可以社交软件打着这个需求点去运作的互联网公司不应只是社交类软件与可穿戴设备，还有携程网，去哪儿网等等互联网公司，订房订酒店多好的寓意"));
        System.out.println(nlpAnalysis.parseStr("社交软件张艺谋的卡宴，马明哲的戏"));
        //取得学习到的topn新词,返回前10个。这里如果设置为0则返回全部
        System.out.println(learn.getTopTree(10));
        //只取得词性为Nature.NR的新词
        System.out.println(learn.getTopTree(10, Nature.NR));
        List<Map.Entry<String, Double>> topTree = learn.getTopTree(0);
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Double> entry : topTree) {
            sb.append(entry.getKey() + "\t" + entry.getValue() + "\n");
        }
        //写入文件
        System.out.println(sb.toString());
    }

    //歧义纠正
    @Test
    public void testChange(){
        //测试发现NLP新词发现导致 `川府办发` 依然被搞成了 `川府  办发` 因为字典分词在新词发现之前调用
        System.out.println(NlpAnalysis.parse("据说川府办发的发文很厉害"));
        System.out.println(NlpAnalysis.parse("京财企业务繁忙"));

        //method 1
        Value value = new Value("川府办", "川府办", "n");
        Library.insertWord(AmbiguityLibrary.get(), value);
        // method 2
        value = new Value("京财企业务", "京财企", "nt", "业务", "j");
        AmbiguityLibrary.insert(AmbiguityLibrary.DEFAULT, value);

        // 将新构建的辞典树替换掉旧的。
        AmbiguityLibrary.put(AmbiguityLibrary.DEFAULT, AmbiguityLibrary.DEFAULT, AmbiguityLibrary.get());
        System.out.println(NlpAnalysis.parse("据说川府办发的发文很厉害"));
        System.out.println(NlpAnalysis.parse("京财企业务繁忙"));

        Forest forest = null;
        try {
            String  s = "习近平和李明工作的三个动漫的确实张三和邓毅超生前的一个世界限";
            System.out.println("before:" + NlpAnalysis.parse(s));
            forest = Library.makeForest("library/ambiguity.dic");
            // 将新构建的辞典树替换掉舊的。
            AmbiguityLibrary.put(AmbiguityLibrary.DEFAULT, AmbiguityLibrary.DEFAULT, forest);
            System.out.println("after:" + NlpAnalysis.parse(s));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    //停用词
    @Test
    public void testStopWord(){
        //动态添加停用词
        String str = "欢迎使用ansj_seg,(ansj中文分词)在这里如果你遇到什么问题都可以联系我.我一定尽我所能.帮助大家.ansj_seg更快,更准,更自由!" ;
        System.out.println("stopWord before:" + ToAnalysis.parse(str));
        StopRecognition filter = new StopRecognition();
        filter.insertStopWords("我"); //过滤单词
        filter.insertStopWords("你");
        filter.insertStopWords("的");
        filter.insertStopWords(")");
        filter.insertStopWords("(");
        filter.insertStopWords("ansj");
        System.out.println("stopWordAfter:" + ToAnalysis.parse(str).recognition(filter));
    }


    @Test
    public void wordTest(){

        String str = "这是一段测试南京市长江大桥文字";
        System.out.println(NlpAnalysis.parse(str).recognition(new NatureRecognition()).getTerms());
        Forest forest = null;
        try {
            forest=Library.makeForest(new File("library/default.dic").getPath());//加载字典文件
            Result result= NlpAnalysis.parse(str,forest);//传入forest
            List<Term> termList=result.getTerms();
            for(Term term:termList){
                System.out.println(term.getName()+":"+term.getNatureStr());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //自定义词典
    @Test
    public void testMulDic(){
        // 多用户词典
        String str1 = "神探夏洛克这部电影作者.是一个dota迷,这是一段测试南京市长江大桥文字";
        System.out.println(ToAnalysis.parse(str1));
        // 两个词汇 神探夏洛克 douta迷
        Forest dic1 = new Forest();
        Library.insertWord(dic1, new Value("神探夏洛克", "define", "1000"));
        Forest dic2 = new Forest();
        Library.insertWord(dic2, new Value("dota迷", "define", "1000"));
        System.out.println(ToAnalysis.parse(str1, dic1, dic2));
    }


    //关键词提取 词性 位置 词频
    @Test
    public void computeWord(){
        KeyWordComputer kwc = new KeyWordComputer(3);
        String title = "中国海上搜救中心确定中国搜救船舶搜救方案";
        String content = " \n \n中新网北京3月10日电 10日上午，中国海上搜救中心组织召开马航失联客机海上搜救紧急会商会议，中国交通运输部副部长、中国海上搜救中心主任何建中对当前搜救工作做出部署：一要加强与马来西亚等多方搜救组织的沟通协调；二要根据搜救现场情况进一步完善搜救方案；三要加强信息交流共享，做好内外联动。 \n \n马航客机失联事件发生后，交通运输部启动一级应急响应，3月8日、9日4次召开马航失联客机应急反应领导小组工作会议，研判形势，部署搜寻工作。根据《国家海上搜救和重大海上溢油应急处置紧急会商工作制度》，交通运输部、国家海洋局、中国海警局、总参、海军等共同研究制定了中国船舶及航空器赴马航客机失联海域搜救方案，初步明确了“海巡31”、“南海救101”、“南海救115”、中国海警3411、海军528和999舰等6艘中国搜救船舶的海上搜救区域。 \n \n截至3月10日8时，中国海军528舰和中国海警3411舰已在相关区域开展搜救工作，预计交通运输部所属“南海救115”、“海巡31”轮、“南海救101”将先后于10日16时、11时17时、11日22时抵达马航客机疑似失联海域。中国海上搜救中心已将有关情况通报马来西亚海上搜救机构，并将与马来西亚、越南海上搜救机构保持密切联系，开展深度配合。同时，继续协调中国商船参与搜救。(完)(周音)";
        Collection<Keyword> result = kwc.computeArticleTfidf(title, content);
        System.out.println(result);
    }


}
