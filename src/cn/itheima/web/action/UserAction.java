package cn.itheima.web.action;

import cn.itheima.domain.User;
import cn.itheima.service.UserService;
import cn.itheima.service.impl.UserServiceImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class UserAction extends ActionSupport implements ModelDriven<User> {
    private User user = new User();
    private UserService us=new UserServiceImpl();

    public String login() throws Exception {
        //1.调用service执行登录操作
        User u=us.login(user);
        //2.将返回的User对象放入session域中，作为登录标识
        ActionContext.getContext().getSession().put("user",u);
        //3.重定向到项目的首页
        return "toHome";
    }

    @Override
    public User getModel() {
        return user;
    }
}
