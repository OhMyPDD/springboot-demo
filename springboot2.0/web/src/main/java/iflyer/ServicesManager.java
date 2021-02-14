package iflyer;

import org.springframework.context.ApplicationContext;
import iflyer.service.UserService;

public class ServicesManager {
	private UserService sysUserService;

	public static ServicesManager instance = new ServicesManager();

	public static ServicesManager getInstance(ApplicationContext context) {
		instance.sysUserService = context.getBean("userService", UserService.class);
		return instance;
	}

	public UserService getISysUserService() {
		return sysUserService;
	}

}
