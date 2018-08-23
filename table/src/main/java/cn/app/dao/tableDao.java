package cn.app.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface tableDao {
    @Select("select * from tableinfo")
    @ResultType(value = java.util.HashMap.class)
    @Results({
            @Result(column = "tablename", property = "tablename"),
            @Result(column = "tabledesc", property = "tabledesc")
    })
    public List<Map> selectAllTable();

    @Update("CREATE TABLE ${tname} (`objectid` varchar(255),`createat` date,`updateat` date,PRIMARY KEY (`objectid`));")
    public int createTable(@Param("tname") String tname);

    @Insert("insert into tableinfo values(#{tname},#{tdesc});")
    public int createTableDesc(@Param("tname") String tablename, @Param("tdesc") String tabledesc);


}
