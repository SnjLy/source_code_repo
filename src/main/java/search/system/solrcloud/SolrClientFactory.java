package search.system.solrcloud;

import org.apache.solr.client.solrj.SolrClient;

import javax.annotation.PostConstruct;
import java.io.IOException;

/**
 * @Package: search.system.solrcloud
 * @Description:
 * @function:  声明solrClient接口方法，实现类实现具体的client生成逻辑
 * @Author : LiuYong
 * Created by yehao on 2018/11/29.
 */
public abstract class SolrClientFactory {

    public SolrClient solrClient;
    /**
     * 声明获取client方法
     * @return
     */
    public SolrClient getSolrClient() throws IllegalAccessException {
        if (null == solrClient){
            throw new IllegalAccessException("the solr client is null");
        }
        return solrClient;
    }

    /**
     * 声明solrClient初始化方法，实现类实现具体的获取逻辑
     */
    public abstract void init();


    public void close(){
        try {
            solrClient.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
