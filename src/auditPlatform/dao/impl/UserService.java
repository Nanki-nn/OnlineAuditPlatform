package auditPlatform.dao.impl;



import auditPlatform.pojo.User;

import java.sql.Connection;
import java.sql.SQLException;

public interface UserService {
    User existsUsername(Connection con, String name) throws SQLException;

    User loginUser(Connection con, User user) throws SQLException;

    int registerUser(Connection con, User user) throws SQLException;
}
