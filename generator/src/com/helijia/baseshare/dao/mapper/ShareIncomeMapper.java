package com.helijia.baseshare.core.dao.mapper;

import com.helijia.baseshare.core.dao.entity.ShareIncome;

public interface ShareIncomeMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ShareIncome record);

    int insertSelective(ShareIncome record);

    ShareIncome selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ShareIncome record);

    int updateByPrimaryKey(ShareIncome record);
}