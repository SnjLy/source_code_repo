package design.pattern.scope.factory.simple.model;

import lombok.Data;

import java.util.List;

/**
 * @author : LiuYong
 * Created by yehao on 2019-04-11.
 * @Package: design.pattern.scope.model
 * @Description:
 * @function:
 */
@Data
public class BaseDataResult {
    private int type;

    private String title;
    private String subTitle;
    private List<String> tags;


}
