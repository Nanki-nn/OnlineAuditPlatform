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
import java.util.HashMap;
import java.util.Map;

public class UserServlet extends BaseServlet {
    protected void existsUsername(HttpServletRequest req, HttpServletResponse resp) {
        UserService userService=new UserServiceImpl();
        JdbcUtil dbutil=new JdbcUtil();
        Connection con;

        String username=req.getParameter("username");
        //String password=req.getParameter("password");

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
        }
    }
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
    protected void register(HttpServletRequest req, HttpServletResponse resp) {
        UserService userService=new UserServiceImpl();
        JdbcUtil dbutil=new JdbcUtil();
        Connection con;

        String username=req.getParameter("username");
        String password=req.getParameter("password");
        String md5password=getMD5Str(password);
        try {
            con=dbutil.getCon();
            User u=userService.existsUsername(con, username);
            if(u== null){
                int registerU=userService.registerUser(con,new User(username,md5password));
                if(registerU>0){
                    User uRegister=userService.existsUsername(con, username);
                    //userService.addResume(con,uRegister);
                    req.getRequestDispatcher("/pages/login.jsp").forward(req,resp);
                }else{
                    req.getRequestDispatcher("/pages/register.jsp").forward(req,resp);
                }

            }else{
                req.getRequestDispatcher("/pages/register.jsp").forward(req,resp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    protected void logout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().invalidate();
        resp.sendRedirect(req.getContextPath());
    }
    protected void getdata(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String name="zqw";
        Map<String,String[] > mm=new HashMap<>();
        String[] strs = {"zwq", "1", "0"};
        mm.put("name",strs);
//        mm.put("id","55");
//        req.setAttribute("name",mm);
        Gson gson=new Gson();
        //转换成json
        String json=gson.toJson(mm);
        System.out.println(json);
        //resp.getWriter().write(json);
        req.setAttribute("name",json);
        req.getRequestDispatcher("/pages/end.jsp").forward(req,resp);
    }
    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserService userService=new UserServiceImpl();
        JdbcUtil dbutil=new JdbcUtil();
        Connection con;
        String username=req.getParameter("username");
        String password=req.getParameter("password");
        String md5password=getMD5Str(password);

        try {
            con=dbutil.getCon();
            User u=userService.existsUsername(con, username);
            if(u!= null){
                User loginU=userService.loginUser(con,new User(username,md5password));
                if(loginU!=null){
                    req.getSession().setAttribute("user",loginU);
                    req.getRequestDispatcher("resumeServlet?action=listwrite&id="+loginU.getId()).forward(req,resp);
                }else{
                    req.getRequestDispatcher("/pages/login.jsp").forward(req,resp);
                }

            }else{
                req.getRequestDispatcher("/pages/login.jsp").forward(req,resp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
