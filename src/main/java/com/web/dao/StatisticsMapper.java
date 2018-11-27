package com.web.dao;

import org.apache.ibatis.annotations.Param;

import java.util.Date;

/**
 * @author crystalzhao
 * @version V1.0
 * @date 2018/11/18
 */
public interface StatisticsMapper {
    int getCountByDay(@Param("date") String date);
}
