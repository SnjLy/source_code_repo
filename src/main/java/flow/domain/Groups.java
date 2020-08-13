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
public class Groups {

    private String id;
    private double x;
    private double y;
    private String label;
    private int index;
    //组里面可以嵌套组
    private String parent;

    private int type;
    protected String name;
    protected String desc;
    //组的扩展信息
}
