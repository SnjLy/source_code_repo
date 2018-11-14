package com.helijia.baseshare.core.dao.mapper;

import com.helijia.baseshare.core.dao.entity.ShareRecord;

public interface ShareRecordMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ShareRecord record);

    int insertSelective(ShareRecord record);

    ShareRecord selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ShareRecord record);

    int updateByPrimaryKey(ShareRecord record);
}