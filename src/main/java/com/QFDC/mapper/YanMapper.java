package com.QFDC.mapper;
import com.QFDC.bean.YanData;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface YanMapper {

    @Insert("insert into test1(name, sex) values(#{name},#{sex})")
    void insertIntoDataBase(@Param("name") String name, @Param("sex") String sex);

    @Select("select * from test1 limit 5")
    List<YanData> getData();
}
