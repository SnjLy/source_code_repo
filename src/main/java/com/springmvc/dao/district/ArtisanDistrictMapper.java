package com.springmvc.dao.district;

import com.springmvc.model.district.ArtisanDistrictInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Package: com.springmvc.dao.district
 * @Description:
 * @function:
 * @Author : LiuYong
 * Created by yehao on 2018/9/18.
 */
public interface ArtisanDistrictMapper {

    int insertArtisanDistrict(ArtisanDistrictInfo districtInfo);

    ArtisanDistrictInfo selectByPrimaryKey(Integer id);

    List<ArtisanDistrictInfo> selectAll(@Param("size") Integer size);
}
