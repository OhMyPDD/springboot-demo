package iflyer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import iflyer.dao.UserMapper;
import iflyer.model.User;

/**
 * Created by liuxin on 17/1/20.
 */
@Service
public class UserService {

	@Autowired
	UserMapper userDao;

	public User getUser(Integer id) {
		return userDao.selectByPrimaryKey(id);
	}

	public int saveUser(String name, Integer age) {
		User record = new User();
		record.setName(name);
		record.setAge(age);
		return userDao.insert(record);
	}
}
