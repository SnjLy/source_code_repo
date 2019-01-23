package search.sort.service.impl;


import search.sort.model.ArtisanModel;
import search.sort.service.SortContextService;

import java.util.ArrayList;
import java.util.List;

/**
 * @Package: search.sort.service.impl
 * @Description:
 * @function:
 * @Author : LiuYong
 * Created by yehao on 2019/1/23.
 */
public class ArtisanSortContextServiceImpl implements SortContextService<ArtisanModel> {

    /**
     * 清空资源
     */
    @Override
    public void clear() {
        System.out.println(this.getClass().getSimpleName() + "调用clean方法，清除缓存");
    }

    /**
     * 批量获取上下文对象集合
     *
     * @param ens 需要获取上线文的产品list
     * @return 获取的排序使用的上下文
     */
    @Override
    public List<DefaultRuleContext<ArtisanModel>> getSortContextList(List<ArtisanModel> ens) {
        List<DefaultRuleContext<ArtisanModel>> contextList = new ArrayList<DefaultRuleContext<ArtisanModel>>();
        for (ArtisanModel model : ens) {
            DefaultRuleContext<ArtisanModel> context = new DefaultRuleContext<ArtisanModel>();
            context.setBody(model);
            context.addVariable("artisan", model);
            context.addVariable(model.getArtisanId(), model);
            contextList.add(context);
        }
        return contextList;
    }
}
