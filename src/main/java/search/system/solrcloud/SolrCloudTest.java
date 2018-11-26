package search.system.solrcloud;

import com.alibaba.fastjson.JSON;
import org.apache.commons.lang3.StringUtils;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.CloudSolrClient;
import org.apache.solr.client.solrj.impl.CloudSolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrInputDocument;
import org.apache.solr.common.params.SolrParams;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.IOException;

/**
 * @Package: search.system.solrcloud
 * @Description:
 * @function:  solrCloudTest for test solr cloud
 * @Author : LiuYong
 * Created by yehao on 2018/11/26.
 */
@RunWith(JUnit4.class)
public class SolrCloudTest {

    private CloudSolrClient cloudSolrClient;


    public void getSolrClient(){
        String zkHost = "172.16.117.7:2181,172.16.117.7:3181,172.16.117.7:4181";
        cloudSolrClient = new CloudSolrClient(zkHost);
    }

    @Test
    public void addDocument(){
        String collection = "item";
        if (null == cloudSolrClient){
            getSolrClient();
        }
        cloudSolrClient.setDefaultCollection(collection);

        //创建文档
        SolrInputDocument document = new SolrInputDocument();
        document.setField("id", "test1");
        document.setField("name","测试作233adfs品");
        document.setField("des", "美丽的哈测hi");
        document.setField("zhima_price", 2323);
        document.setField("cover_pic", "upload/20161215/f8457a9e647c476e9a2e81ea99d90233.cover_pic");
        try {
            cloudSolrClient.add(document);
            cloudSolrClient.commit();
        } catch (SolrServerException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                cloudSolrClient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void testGetSolr(){
        if (null == cloudSolrClient){
            getSolrClient();
        }
        cloudSolrClient.setDefaultCollection("item");
        SolrQuery params = new SolrQuery();
        params.set("q", "name:\"测试\"");
        //params.setDistrib(true);
        QueryResponse response = new QueryResponse();
        try {
            response = cloudSolrClient.query(params);
            System.out.println(JSON.toJSON(response.getResults()));
        } catch (SolrServerException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                cloudSolrClient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}
