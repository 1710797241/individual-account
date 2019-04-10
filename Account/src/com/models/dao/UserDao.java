package com.models.dao;

import java.util.List;
import java.util.Map;

import com.models.entity.User;

public interface UserDao {
	public List<User> selectAll(Map<String , Object> map);
	
	public List<User> selectNameAndID ();
	
	public Integer checkForInsert(User user);
	
	public Integer insertMany(User user);
	
	public User selectByCodeForModify(String user_identity);
	public Integer modifyUser(User user);
	
	public Integer checkBeforeDel(String user_identity);
	
	public Integer delUser(String user_identity);
			
}
