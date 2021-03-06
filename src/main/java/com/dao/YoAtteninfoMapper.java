package com.dao;

import com.model.YoAtteninfo;
import com.model.YoAtteninfoExample;
import java.util.List;

public interface YoAtteninfoMapper {
    int deleteByPrimaryKey(Integer inid);

    int insert(YoAtteninfo record);

    int insertSelective(YoAtteninfo record);

    List<YoAtteninfo> selectByExample(YoAtteninfoExample example);

    YoAtteninfo selectByPrimaryKey(Integer inid);

    int updateByPrimaryKeySelective(YoAtteninfo record);

    int updateByPrimaryKey(YoAtteninfo record);
}