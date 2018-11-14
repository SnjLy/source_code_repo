package search.system.solr;

import lombok.Data;
import org.apache.solr.client.solrj.beans.Field;


/**
 * Created by yehao on 2018/3/26.
 */
@Data
public class SolrTestCoreDTO {

   @Field("id")
   private String id;
   @Field("nick")
   private String nick;
   @Field("mobile")
   private String mobile;
   @Field("cat")
   private String cat;
   @Field("features")
   private String features;
   @Field("includes")
   private String includes;
   @Field("weight")
   private Integer weight;
   @Field("price")
   private Double price;
   @Field("popularity")
   private String popularity;
   @Field("inStock")
   private String in_stock;
   @Field("store")
   private String store;
   @Field("title")
   private String title;
   @Field("subject")
   private String subject;
   @Field("description")
   private String description;
   @Field("comments")
   private String comments;
   @Field("author")
   private String author;
   @Field("keywords")
   private String keywords;
   @Field("category")
   private String category;
   @Field("resource_name")
   private String resourceName;
   @Field("url")
   private String url;
   @Field("content_type")
   private String contentType;
   @Field("last_modified")
   private String lastModified;
   @Field("links")
   private String links;
}
