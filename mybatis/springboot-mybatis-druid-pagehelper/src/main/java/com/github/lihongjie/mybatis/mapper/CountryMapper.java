package com.github.lihongjie.mybatis.mapper;

import com.github.lihongjie.mybatis.model.Country;
import com.github.lihongjie.mybatis.util.MyMapper;
import org.apache.ibatis.annotations.Select;

public interface CountryMapper extends MyMapper<Country> {

    @Select("select * from country limit 1")
    Country findOne();
}