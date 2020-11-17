package auditPlatform.dao.impl;



import auditPlatform.pojo.User;

import java.sql.Connection;
import java.sql.SQLException;

public interface UserService {
    /**
     * 判断用户名是否存在
     * @param con
     * @param account account账号
     * @return 空 或 用户所有信息
     * @throws SQLException
     */
    User existsUsername(Connection con, String account) throws SQLException;
    /**
     * 用户登录
     * @param con
     * @param user
     * @return 用户所有信息
     * @throws SQLException
     */
    User loginUser(Connection con, User user) throws SQLException;
    /**
     * 用户注册
     * @param con
     * @param user  /account,password,0,tel,postbox/
     * @return int 成功与否状态
     * @throws SQLException
     */
    int registerUser(Connection con, User user) throws SQLException;
}
