package com.hlj_search.mapping;

import com.hlj_search.entity.ChoiceCityResourceEntity;

public interface ChoiceCityResourceEntityMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ChoiceCityResourceEntity record);

    int insertSelective(ChoiceCityResourceEntity record);

    ChoiceCityResourceEntity selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ChoiceCityResourceEntity record);

    int updateByPrimaryKey(ChoiceCityResourceEntity record);
}