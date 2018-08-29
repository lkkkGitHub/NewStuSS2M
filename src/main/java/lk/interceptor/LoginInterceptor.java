package lk.interceptor;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;
import lk.pojo.User;

import java.util.Map;

public class LoginInterceptor implements Interceptor {

    @Override
    public void destroy() {

    }

    @Override
    public void init() {

    }

    @Override
    public String intercept(ActionInvocation actionInvocation) throws Exception {
        //如果不是管理员，不能访问任何管理员页面
        Map session = actionInvocation.getInvocationContext().getSession();
        User loginUser = (User) session.get("loginUser");
        if (loginUser != null && loginUser.getPrivilege() == 0) {
            //是管理员登录了，通过
            return actionInvocation.invoke();
        }
        return Action.LOGIN;
    }
}
