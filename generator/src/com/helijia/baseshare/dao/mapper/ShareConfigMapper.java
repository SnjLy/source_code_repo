package com.helijia.baseshare.core.dao.mapper;

import com.helijia.baseshare.core.dao.entity.ShareConfig;

public interface ShareConfigMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ShareConfig record);

    int insertSelective(ShareConfig record);

    ShareConfig selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ShareConfig record);

    int updateByPrimaryKey(ShareConfig record);
}