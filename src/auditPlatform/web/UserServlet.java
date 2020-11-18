package auditPlatform.web;


import auditPlatform.dao.UserServiceImpl;
import auditPlatform.dao.impl.UserService;
import com.google.gson.Gson;

import auditPlatform.pojo.User;
import auditPlatform.utils.JdbcUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class UserServlet extends BaseServlet {
    /**
     * 是否存在用户名
     * @param req username
     * @param resp
     */
    protected void existsUsername(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        UserService userService=new UserServiceImpl();
        JdbcUtil dbutil=new JdbcUtil();
        Connection con = null;

        String username=req.getParameter("username");

        try {
            con=dbutil.getCon();
            User u=userService.existsUsername(con, username);
            Map<String,String> map=new HashMap<>();
            if(u!= null){
                map.put("existsUsername","t");
            }else{
                map.put("existsUsername","f");
            }
            Gson gson=new Gson();
            //转换成json
            String json=gson.toJson(map);
            resp.getWriter().write(json);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            dbutil.closeCon(con);
        }
    }

    /**
     * 验证码
     * @param req code验证码
     * @param resp
     * @throws IOException
     */
    protected void code(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String verifyCode = req.getParameter("code");
        String kaptchaValue = (String) req.getSession().getAttribute(com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY);
//        System.out.println("用户输入"+verifyCode+"验证码"+kaptchaValue);
        Map<String,String> map=new HashMap<>();
        if(kaptchaValue == null || kaptchaValue == ""||!verifyCode.equalsIgnoreCase(kaptchaValue)) {
            map.put("result","f");
        }else {
            map.put("result","t");
        }
        Gson gson=new Gson();
        //转换成json
        String json=gson.toJson(map);
        resp.getWriter().write(json);
    }

    /**
     * 注册
     * @param req username,password,tel,postbox
     * @param resp
     */
    protected void register(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        UserService userService=new UserServiceImpl();
        JdbcUtil dbutil=new JdbcUtil();
        Connection con = null;
        Gson gson=new Gson();

        String username=req.getParameter("username");
        String password=req.getParameter("password");
        String tel=req.getParameter("tel");
        String postbox=req.getParameter("postbox");

        String md5password=getMD5Str(password);
        try {
            con=dbutil.getCon();
            User u=userService.existsUsername(con, username);
            if(u== null){//用户不存在，可以注册
                int registerU=userService.registerUser(con,new User(username,md5password,tel,postbox));
                if(registerU>0){//注册成功

                    User uRegister=userService.existsUsername(con, username);
                    //转换成json
                    String json=gson.toJson(uRegister);
                    resp.getWriter().write(json);

                }else{//注册失败
                    String status="注册失败";
                    String json=gson.toJson(status);
                    resp.getWriter().write(json);
                }

            }else{//用户已存在不可注册

                String status="用户已存在无法注册";
                String json=gson.toJson(status);
                resp.getWriter().write(json);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            dbutil.closeCon(con);
        }
    }

    /**
     * 注销用户
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void logout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().invalidate();
        resp.sendRedirect(req.getContextPath());
    }

    /**
     * 用户登录
     * @param req username password
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void login(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        UserService userService=new UserServiceImpl();
        JdbcUtil dbutil=new JdbcUtil();
        Connection con = null;
        Gson gson=new Gson();
        String username=req.getParameter("username");
        String password=req.getParameter("password");
        String md5password=getMD5Str(password);

        try {
            con=dbutil.getCon();
            User u=userService.existsUsername(con, username);
            if(u!= null){//用户存在
                User loginU=userService.loginUser(con,new User(username,md5password));
                if(loginU!=null){//登录成功
                    req.setAttribute("user",loginU);
                    req.getSession().setAttribute("user",loginU);
                    String json=gson.toJson(loginU);
                    resp.getWriter().write(json);
                }else{//登录失败
                    String status="登录失败";
                    String json=gson.toJson(status);
                    resp.getWriter().write(json);
                }

            }else{//用户不存在
                String status="用户不存在";
                String json=gson.toJson(status);
                resp.getWriter().write(json);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            dbutil.closeCon(con);
        }
    }

}
