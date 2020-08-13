/**
 * Copyright 2020 bejson.com
 */
package flow.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

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
public class Edges {

    private String source;
    private int sourceAnchor;
    private String target;
    private int targetAnchor;
    private String id;
    private String shape;
    private int index;

    //边连线扩展信息
}
