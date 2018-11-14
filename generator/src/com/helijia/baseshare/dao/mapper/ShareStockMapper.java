package com.helijia.baseshare.core.dao.mapper;

import com.helijia.baseshare.core.dao.entity.ShareStock;

public interface ShareStockMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ShareStock record);

    int insertSelective(ShareStock record);

    ShareStock selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ShareStock record);

    int updateByPrimaryKey(ShareStock record);
}