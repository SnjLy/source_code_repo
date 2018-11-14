package search.system.solr;

import lombok.Data;

import javax.xml.bind.annotation.XmlElement;

/**
 * Created by yehao on 2018/3/26.
 */
@Data
public class SolrTestCoreIndex {

   @XmlElement(name="id")
   private String id;
   @XmlElement(name="nick")
   private String nick;
   @XmlElement(name="name")
   private String name;
   @XmlElement(name="manu")
   private String manu;
   @XmlElement(name="cat")
   private String cat;
   @XmlElement(name="features")
   private String features;
   @XmlElement(name="includes")
   private String includes;
   @XmlElement(name="weight")
   private String weight;
   @XmlElement(name="price")
   private String price;
   @XmlElement(name="popularity")
   private String popularity;
   @XmlElement(name="inStock")
   private String inStock;
   @XmlElement(name="store")
   private String store;
   @XmlElement(name="title")
   private String title;
   @XmlElement(name="subject")
   private String subject;
   @XmlElement(name="description")
   private String description;
   @XmlElement(name="comments")
   private String comments;
   @XmlElement(name="author")
   private String author;
   @XmlElement(name="keywords")
   private String keywords;
   @XmlElement(name="category")
   private String category;
   @XmlElement(name="resource_name")
   private String resourceName;
   @XmlElement(name="url")
   private String url;
   @XmlElement(name="content_type")
   private String contentType;
   @XmlElement(name="last_modified")
   private String lastModified;
   @XmlElement(name="links")
   private String links;
}
