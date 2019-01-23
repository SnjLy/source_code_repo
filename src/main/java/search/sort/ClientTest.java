package search.sort;

import com.alibaba.fastjson.JSON;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import search.sort.common.SortTypeEnum;
import search.sort.model.ArtisanModel;
import search.sort.model.SortRule;
import search.sort.service.AbstractWeightUtil;
import search.sort.service.Rule;
import search.sort.service.RuleContext;
import search.sort.service.SortContextService;
import search.sort.service.impl.ArtisanSortContextServiceImpl;
import search.sort.service.impl.ArtisanWeightUtil;
import search.sort.service.impl.ItemWeightUtil;
import search.sort.service.impl.RuleCreatorImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @Package: search.sort
 * @Description:
 * @function:
 * @Author : LiuYong
 * Created by yehao on 2019/1/23.
 */
@RunWith(JUnit4.class)
public class ClientTest {

    public static int getNum(int start,int end) {
        return (int)(Math.random()*(end-start+1)+start);
    }

    private static String[] telFirst="134,135,136,137,138,139,150,151,152,157,158,159,130,131,132,155,156,133,153".split(",");
    private static String getTel() {
        int index=getNum(0,telFirst.length-1);
        String first=telFirst[index];   //134
        String second=String.valueOf(getNum(1,888)+10000).substring(1);
        String third=String.valueOf(getNum(1,9100)+10000).substring(1);
        return first+second+third;
    }

    @Test
    public void testLoad(){
        AbstractWeightUtil weightUtil = new ItemWeightUtil();
        RuleCreatorImpl ruleCreator = new RuleCreatorImpl(weightUtil);

        SortRule sortRule = new SortRule();
        sortRule.setType(SortTypeEnum.CONDITION_RULE.getValue());
        Rule rule = ruleCreator.createRule(sortRule);
        System.out.println(JSON.toJSON(rule.isExclusived()));


        sortRule.setType(SortTypeEnum.PRODUCT_RULE.getValue());
        rule = ruleCreator.createRule(sortRule);
        System.out.println(JSON.toJSON(rule.isExclusived()));

    }

    @Test
    public void testLoadContext(){
        AbstractWeightUtil weightUtil = new ArtisanWeightUtil();
        RuleCreatorImpl ruleCreator = new RuleCreatorImpl(weightUtil);

        SortRule sortRule = new SortRule();
        sortRule.setType(SortTypeEnum.CONDITION_RULE.getValue());
        sortRule.setRuleCondition("{\"id\":\"nxxxxxx\"}");
        List<SortRule> sortRules = new ArrayList<>();
        sortRules.add(sortRule);
        SortRule sortRule1 = new SortRule();
        sortRule1.setType(SortTypeEnum.PRODUCT_RULE.getValue());
        sortRule1.setRuleCondition("#name");
        sortRules.add(sortRule1);

        List<Rule> rules = new ArrayList<>();
        for (SortRule su : sortRules) {
            Rule rule = ruleCreator.createRule(su);
            rules.add(rule);
        }

        SortContextService acxt = new ArtisanSortContextServiceImpl();
        List<ArtisanModel> artisans = loadArtisans();
        List<RuleContext> ruleContexts = acxt.getSortContextList(artisans);
        for (RuleContext context : ruleContexts) {
            ArtisanModel model = (ArtisanModel) context.getBody();
            ArtisanModel model1 = (ArtisanModel) context.getVariables().get(model.getArtisanId());
            Assert.assertTrue(model.getArtisanId().equals(model1.getArtisanId()));
            for (Rule rule : rules) {
                int i = rule.calculateWeight(context);
                System.out.println(model.getArtisanId() +" 对规则:" + JSON.toJSON(rule.isExclusived() + " weight:" + i));
            }
        }


    }


    public List<ArtisanModel> loadArtisans(){
        List<ArtisanModel> artisanModels = new ArrayList<>();
        for (int i =0; i< 5; i++){
            String s =UUID.randomUUID().toString();
            ArtisanModel model = new ArtisanModel();
            model.setArtisanId(s);
            model.setNick("nick"+i);
            model.setMobile(getTel());
            artisanModels.add(model);
        }
        return artisanModels;
    }


}
