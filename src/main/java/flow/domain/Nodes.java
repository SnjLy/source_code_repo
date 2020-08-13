/**
 * Copyright 2020 bejson.com
 */
package flow.domain;

import lombok.*;

/**
 * {
 * "type": "node",
 * "shape": "flow-circle",
 * "size": "72*72",
 * "label": "开始节点",
 * "color": "#FA8C16",
 * "nodetype": "startNode",
 * "x": 639,
 * "y": 102,
 * "id": "79d7d0f8",
 * "index": 5
 * },
 * Auto-generated: 2020-08-12 13:43:9
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
@Setter
@Getter
@NoArgsConstructor
@ToString
public class Nodes {

  private String type;
  private String size;
  private String label;
  private String color;
  private double x;
  private double y;
  private String id;
  private String parent;  //关联组
  private int index;
  private String nodeType;

  private String name;
  private String desc;
  //节点扩展信息


  @Getter
  @AllArgsConstructor
  public enum NodeType {
    START("startNode"),
    END("endNode");

    private String value;
  }

}
