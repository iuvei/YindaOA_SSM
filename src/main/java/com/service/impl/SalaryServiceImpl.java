package com.service.impl;


import com.dao.YoSalaryMapper;
import com.model.YoSalary;
import com.model.YoSalaryExample;
import com.service.ISalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by pwj on 2016/10/31.
 */
@Transactional
@Service
public class SalaryServiceImpl implements ISalaryService {

    @Autowired
    private YoSalaryMapper yoSalaryMapper;

    //添加工资生成表

    public int insert(YoSalary record) {
        return yoSalaryMapper.insertSelective(record);
    }


    public List<YoSalary> searchYoSalaryByEntity(YoSalary yoSalary) {
        return yoSalaryMapper.selectAllUser(yoSalary);
    }




//    @Override
//    public int updateStaffByID(YoSalary yoSalaryid) {
//        return usermapper.updateByPrimaryKey(yoSalaryid);
//    }
//
//    @Override
//    public List<YoSalary> searchYoSalaryByEntity(YoSalary yoSalary) {
//        return usermapper.selectByExample(yoSalary);
//    }

//    @Override
//    public List<YoSalary> selectYoSalary(YoSalary yoSalary) {
//        return null;
//    }
}
