package com.adminlte.repositories;

import java.util.List;
import java.util.Optional;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;
import com.adminlte.models.User;
import com.adminlte.models.UserRole;

@Repository
public interface UserRepository {
   
	/* for login */
	@Select("SELECT *FROM tbuser WHERE username=#{username}")
	@Results({
		@Result(property = "id",column = "id"),
		@Result(property = "roles",column = "id",many = @Many(select = "getRoleByUserId"))
	})
	public User findByUsername(@Param("username") String username);
	
	
	@Select("SELECT *FROM tbrole WHERE user_id=#{user_id}")
	
	List<UserRole> getRoleByUserId(@Param("user_id") int user_id);
	
	
	/*--- End for login ---*/
	
	@Select("SELECT * FROM tbuser")
	public List<User> findAll();
	
	/*
	 * 
	 */
	@Select("SELECT id,rolename FROM tbuserrole")
	public List<UserRole> findRole();
	
	/*
	 * Save User to Database
	 * By using @Param
	 */
	
	@Insert("INSERT INTO tbuser(username,password,status,roleid)"
			+"VALUES(#{user.username},#{user.password},'1','1')")
	public boolean save(@Param("user") User user);
	/*
	 * Get Single User 
	 */
	@Select("SELECT * FROM tbuser  WHERE useid=#{useid}")
	public Optional<User> findById(@Param("useid")  int useid);
	/*
	 * Update User
	 */
	@Update("UPDATE tbuser SET username=#{user.username},password=#{user.password} WHERE useid=#{user.useid}")
	public boolean update(@Param("user") User user); 
	/*
	 * Delete
	 */
	@Delete("DELETE tbuser WHERE useid=#{useid}")
	public boolean delete(@Param("useid") int useid);
	
}
