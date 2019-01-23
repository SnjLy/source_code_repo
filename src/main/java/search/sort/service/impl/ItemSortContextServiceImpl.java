package search.sort.service.impl;


import search.sort.model.ArtisanModel;
import search.sort.model.ItemModel;
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
public class ItemSortContextServiceImpl implements SortContextService<ItemModel> {

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
    public List<DefaultRuleContext<ItemModel>> getSortContextList(List<ItemModel> ens) {
        List<DefaultRuleContext<ItemModel>> contextList = new ArrayList<DefaultRuleContext<ItemModel>>();
        for (ItemModel model : ens) {
            DefaultRuleContext<ItemModel> context = new DefaultRuleContext<ItemModel>();
            context.setBody(model);
            context.addVariable("item", model);
            context.addVariable(model.getProductId(), model);
            contextList.add(context);
        }
        return contextList;
    }


}
