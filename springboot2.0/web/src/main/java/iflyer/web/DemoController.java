package iflyer.web;

import iflyer.model.User;
import iflyer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author pdd
 * @date 2021/2/13 下午10:58
 */
@RestController
@RequestMapping("/springboot")
public class DemoController {

    @Autowired
    private UserService userService;

    @RequestMapping("/hello")
    public String sayHello() {
        User user=userService.getUser(2);
        return String.valueOf(user.getName());
    }
}