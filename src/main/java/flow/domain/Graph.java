/**
  * Copyright 2020 bejson.com 
  */
package flow.domain;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * Auto-generated: 2020-08-12 13:43:9
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
@Setter
@Getter
@NoArgsConstructor
@ToString
public class Graph {

    private List<Nodes> nodes;
    private List<Edges> edges;
    private List<Groups> groups;
    private GraphInfo graphInfo;

}
