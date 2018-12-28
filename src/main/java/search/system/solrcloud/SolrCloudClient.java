package search.system.solrcloud;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.solr.client.solrj.impl.CloudSolrClient;
import org.apache.solr.client.solrj.impl.HttpClientUtil;
import org.apache.solr.common.params.ModifiableSolrParams;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * @Package: search.system.solrcloud
 * @Description:
 * @function:
 * @Author : LiuYong
 * Created by yehao on 2018/11/29.
 */
@Service
public class SolrCloudClient extends SolrClientFactory {

    private String zkHost = "172.16.117.7:2181,172.16.117.7:3181,172.16.117.7:4181";

    private int        connectionTimeout = 2000;
    private int        defaultConns      = 200;
    private int        maxConns          = 500;
    private int        soTimeout         = 5000;

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

    /**
     * 声明solrClient初始化方法，实现类实现具体的获取逻辑
     */
    @PostConstruct
    @Override
    public void init() {
        if (StringUtils.isBlank(zkHost)){
            throw new IllegalArgumentException("zookeeper url is null...");
        }
        ModifiableSolrParams params = new ModifiableSolrParams();
        HttpClient httpClient = HttpClientUtil.createClient(params);
        HttpClientUtil.setConnectionTimeout(httpClient, connectionTimeout);
        HttpClientUtil.setMaxConnectionsPerHost(httpClient, defaultConns);
        HttpClientUtil.setMaxConnections(httpClient, maxConns);
        HttpClientUtil.setSoTimeout(httpClient, soTimeout);
        HttpClientUtil.setFollowRedirects(httpClient, false);
        HttpClientUtil.setAllowCompression((DefaultHttpClient) httpClient, true);

        solrClient = new CloudSolrClient(zkHost, httpClient);

    }
}
