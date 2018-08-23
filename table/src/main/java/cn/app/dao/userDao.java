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
import org.apache.ibatis.annotations.SelectKey;

@Mapper
public interface userDao {
//	@Select("select * from user")
//	@ResultType(value = java.util.HashMap.class)
//	@Results({
//		@Result(id=true, column="id", property="id"),
//		@Result(column="userName", property="userName")
//		})
//    public List<Map> findCount();


    /**
     * 创建注册用户
     *
     * @param uid
     * @param uname
     * @param upwd
     * @param regtime
     * @return 0 没有成功
     */
    @Insert("insert IGNORE into `user` (uid, uname,upwd,regtime) values(#{uid}, #{uname}, #{upwd}, #{regtime})")
    public int createUser(@Param("uid") String uid, @Param("uname") String uname, @Param("upwd") String upwd, @Param("regtime") String regtime);

    /**
     * 登陆用户
     *
     * @param uname
     * @param upwd
     * @return
     */
    @Select("select count(*) count from user where uname = #{uname} and upwd = #{upwd}")
    @ResultType(value = Integer.class)
    @Results({
            @Result(column = "count", property = "count")
    })
    public int loginUser(@Param("uname") String uname, @Param("upwd") String upwd);

    /**
     * 创建注册用户
     *
     * @param uid
     * @param uname
     * @param upwd
     * @param regtime
     * @return 0 没有成功
     */
    @Insert("insert IGNORE into `role` (uid, name,regtime,grant) values(#{uid}, #{name}, #{regtime}, #{grant})")
    public int createRole(@Param("uid") String uid, @Param("name") String name, @Param("regtime") String regtime, @Param("grant") String grant);


}
