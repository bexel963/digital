package kr.green.test.dao;

import org.apache.ibatis.annotations.Param;

import kr.green.test.vo.Uservo;



public interface UserDao {
	
	public Uservo getUser(@Param("id")String id);

}
