package com.springmvc.service.serviceImpl;

import com.springmvc.dao.district.ArtisanDistrictMapper;
import com.springmvc.model.district.ArtisanDistrictInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Package: com.springmvc.service
 * @Description:
 * @function:
 * @Author : LiuYong
 * Created by yehao on 2018/9/18.
 */
@Service
public class ArtisanDistrictServiceImpl {

    @Autowired
    private ArtisanDistrictMapper artisanDistrictMapper;


    public int insertArtisanDistrict(ArtisanDistrictInfo districtInfo){
        return artisanDistrictMapper.insertArtisanDistrict(districtInfo);
    }

    public ArtisanDistrictInfo selectByPrimaryKey(Integer id){
        return artisanDistrictMapper.selectByPrimaryKey(id);
    }

    public List<ArtisanDistrictInfo> selectAll(Integer size){
        return artisanDistrictMapper.selectAll(size);
    }

}
