package auditPlatform.dao;


import auditPlatform.dao.impl.UserService;
import auditPlatform.pojo.User;
import auditPlatform.utils.JdbcUtil;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class UserServiceImpl implements UserService {
    public User existsUsername(Connection con, String name) throws SQLException {
        User resultUser=null;
        String sql="select * from user where username=?";
        PreparedStatement pstmt=con.prepareStatement(sql);
        pstmt.setString(1, name);
        ResultSet rs=pstmt.executeQuery();
        if(rs.next()) {
            resultUser=new User();
            resultUser.setId(rs.getInt("id"));
            resultUser.setUsername(rs.getString("userName"));
            resultUser.setPassword(rs.getString("password"));
        }
        return resultUser;
    }


    public User loginUser(Connection con,User user) throws SQLException {
        User resultUser=null;
        String sql="select * from user where username=? and password=?";
        PreparedStatement pstmt=con.prepareStatement(sql);
        pstmt.setString(1, user.getUsername());
        pstmt.setString(2, user.getPassword());
        ResultSet rs=pstmt.executeQuery();
        if(rs.next()) {
            resultUser=new User();
            resultUser.setId(rs.getInt("id"));
            resultUser.setUsername(rs.getString("userName"));
            resultUser.setPassword(rs.getString("password"));
            resultUser.setAdmin(rs.getInt("admin"));
        }
        return resultUser;
    }

    public static void main(String[] args) throws Exception {
        JdbcUtil db=new JdbcUtil();
        Connection con=db.getCon();
        UserService ss=new UserServiceImpl();
    }

    public int registerUser(Connection con, User user) throws SQLException {
        String sql="insert into user(username,password,admin) values(?,?,?)";
        PreparedStatement pstmt=con.prepareStatement(sql);
        pstmt.setString(1, user.getUsername());
        pstmt.setString(2, user.getPassword());
        pstmt.setInt(3, 0);
        int rs=pstmt.executeUpdate();
        return rs;
    }
}
