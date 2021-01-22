package kr.green.test.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import kr.green.test.vo.Uservo;



public interface UserDao {
	
	public Uservo getUser(@Param("id")String id);

	public void insertUser(@Param("user")Uservo user);

	public ArrayList<Uservo> getAllUser();

	public void updateAuthor(@Param("user")Uservo userVo);

	public void updateUser(@Param("user")Uservo getUser);


}
