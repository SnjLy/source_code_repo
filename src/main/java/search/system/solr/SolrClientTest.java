package search.system.solr;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.impl.HttpClientUtil;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.impl.LBHttpSolrClient;
import org.apache.solr.common.params.ModifiableSolrParams;

import java.io.IOException;

/**
 * Created by yehao on 2018/3/26.
 */
public class SolrClientTest {

    private static String     url= "http://172.16.254.23:8081/solr/";
    private static SolrClient solrClient;
    private static int        connectionTimeout = 2000;
    private static int        defaultConns      = 200;
    private static int        maxConns          = 500;
    private static int        soTimeout         = 5000;

    public void setConnectionTimeout(int connectionTimeout) {
        this.connectionTimeout = connectionTimeout;
    }

    public void setDefaultConns(int defaultConns) {
        this.defaultConns = defaultConns;
    }

    public void setMaxConns(int maxConns) {
        this.maxConns = maxConns;
    }

    public void setSoTimeout(int soTimeout) {
        this.soTimeout = soTimeout;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public SolrClientTest() {
        init();
    }

    public void init() {
        if (StringUtils.isEmpty(url)) {
            throw new IllegalArgumentException("the solr urls is null !!!");
        }
        url = url.replace(";", ",");
        String urls[] = url.split(",");
        HttpClient httpClient;
        ModifiableSolrParams params = new ModifiableSolrParams();
        httpClient = HttpClientUtil.createClient(params);
        HttpClientUtil.setConnectionTimeout(httpClient, connectionTimeout);
        HttpClientUtil.setMaxConnectionsPerHost(httpClient, defaultConns);
        HttpClientUtil.setMaxConnections(httpClient, maxConns);
        HttpClientUtil.setSoTimeout(httpClient, soTimeout);
        HttpClientUtil.setFollowRedirects(httpClient, false);
        HttpClientUtil.setAllowCompression((DefaultHttpClient) httpClient, true);


        //solrClient = new LBHttpSolrClient(httpClient, urls);
        solrClient=new HttpSolrClient(url, httpClient);

        //solrClient= new LBHttpSolrClient(httpClient, "http://host1:8080/solr/", "http://host2:8080/solr", "http://host2:8080/solr");
    }

    public SolrClient getSolrClient() {
        if (solrClient == null) {
            throw new IllegalStateException("the solr client is null !!!");
        }
        return solrClient;
    }

    public void closeSolrClient(){
        if (solrClient == null) {
            throw new IllegalStateException("the solr client is null !!!");
        }
        try {
            solrClient.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
