package algorithm.shorturl;

import net.sf.json.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import javax.servlet.http.HttpServletRequest;
import java.net.URLEncoder;

/**
 * Created by admin on 2017/1/7.
 */
public class ShortURL {
    public final static String CNURL="http://50r.cn/short_url.json?url=";//短链接生成接口

    public static String getHtmlByUrl(String url){
        String html = null;
        HttpClient httpClient = new DefaultHttpClient();//创建httpClient对象
        HttpGet httpget = new HttpGet(url);//以get方式请求该URL
        try {
            HttpResponse responce = httpClient.execute(httpget);//得到responce对象
            int resStatu = responce.getStatusLine().getStatusCode();//返回码
            if (resStatu== HttpStatus.SC_OK) {//200正常  其他就不对
                //获得相应实体
                HttpEntity entity = responce.getEntity();
                if (entity!=null) {
                    html = EntityUtils.toString(entity);//获得html源代码
                }
            }
        } catch (Exception e) {
            //System.out.println("访问【"+url+"】出现异常!");
            e.printStackTrace();
        } finally {
            httpClient.getConnectionManager().shutdown();
        }

        return html;
    }

    public static String  geturl(String url){
        String ret=getHtmlByUrl(url);
        JSONObject json=JSONObject.fromObject(ret);
        String returl=json.getString("url");
        return returl;

    }

    public void getEntity(HttpServletRequest request){
        StringBuffer rootUrl=request.getRequestURL();

        String path=request.getContextPath();//项目名称
        String tempContextUrl = rootUrl.delete(rootUrl.length() - request.getRequestURI().length(), rootUrl.length()).toString();//域名

        String an= URLEncoder.encode("&");//&转码

        String durl=ShortURL.CNURL+tempContextUrl+path+"/userInfo/areward_jump" +
                            ".htm?userId="+123456+an+"param=0";//短链接(里面写跳转路径以及携带参数)

        String retdurl=ShortURL.geturl(durl);//短链接
    }


    public static void main(String[] args) {
        Integer f1 = 100, f2 = 100, f3 = 150, f4 = 150;

        System.out.println(f1 == f2);
        System.out.println("f1.getClass:" + f1.getClass().getName() + " f2.getClass:" + f2.getClass().getName());
        System.out.println("f1.hash:"+f1.hashCode()+" f2.hash:"+f2.hashCode());
        System.out.println(f3 == f4);
        System.out.println("f3.getClass:" + f3.getClass().getName() + " f4.getClass:" + f4.getClass().getName());
        System.out.println("f3.hash:"+f3.hashCode()+" f4.hash:"+f4.hashCode());

    }

}
