package search.system.solr;

import com.alibaba.fastjson.JSON;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.junit.Assert;

import java.io.IOException;
import java.util.List;


/**
 * Created by yehao on 2018/3/30.
 */
public class SolrClientQueryTest {


    public static void main(String[] args) {

        SolrClient client = new SolrClientTest().getSolrClient();

        SolrQuery sq=new SolrQuery();

        String fl = "id,mobile,price,nick,weight";
        sq.setQuery("*:*");
        sq.set("fl", fl);
        sq.setStart(0);
        sq.setRows(100);
//
//        Map<String, String> param = new HashMap<String, String>();
//        param.put("q", "*:*");
//        param.put("fl", fl);
//        param.put("start", "0");
//        param.put("rows", "100");
//
//        MapSolrParams queryParams = new MapSolrParams(param);
        QueryResponse response = null;
        try {
            response = client.query("artisan", sq);
        } catch (SolrServerException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        List<SolrTestCoreDTO> dtoList = response.getBeans(SolrTestCoreDTO.class);
        System.out.println(JSON.toJSON(dtoList));
        if (null != response) {
            SolrDocumentList documents = response.getResults();
            for (SolrDocument document : documents) {
                Assert.assertTrue(document.getFieldNames().contains("id"));
            }
        }

        try {
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
