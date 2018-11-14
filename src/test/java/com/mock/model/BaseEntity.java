package com.mock.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>base entity for other entity extends this</p>
 * Created by admin on 2017/9/1.
 */
@Data
public class BaseEntity {
    public Long id;
    public int offset = 0;
    public int pageNo = 1;
    public int pageSize = 20;

    public void initPage(){
        if (pageNo != 0){
            offset = (pageNo - 1)* pageSize;
        }
    }
}
