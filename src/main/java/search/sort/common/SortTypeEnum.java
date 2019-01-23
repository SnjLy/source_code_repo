package search.sort.common;

/**
 * @Package: search.sort.common
 * @Description:
 * @function:
 * @Author : LiuYong
 * Created by yehao on 2019/1/23.
 */
public enum SortTypeEnum {

    PRODUCT_RULE("产品规则",1),
    ARTISAN_RULE("产品规则",2),
    CONDITION_RULE("条件规则",3),
    CACULATE_ACCUMULATE_VALUE("累积权重值 ",1),
    CACULATE_ASSIGNMENT_VALUE("指定权重值 ",2),
    OPERATE_TYPE_ADD("加法",1),
    OPERATE_TYPE_SUBSTRACT("减法",2);

    ;
    private String name;
    private int value;

    private SortTypeEnum(String name, int value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

}
