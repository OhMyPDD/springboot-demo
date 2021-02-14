package iflyer.model;

import org.springframework.stereotype.Repository;

/**
 * Created by liuxin on 17/1/20.
 */

@Repository
public class User {
	private Integer id;
	private String name;
	private int age;

	public User() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
