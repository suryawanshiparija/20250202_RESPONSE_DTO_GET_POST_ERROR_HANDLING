package org.dnyanyog.service;

import org.dnyanyog.common.DBUtils;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserService {
    public String getUserName(int userId) {
        try {
            ResultSet rs = DBUtils.executeSelectQuery("SELECT UserName FROM user WHERE userID = " + userId);
            if (rs.next()) {
                return rs.getString("UserName");
            }
            return "No user found!";
        } catch (SQLException e) {
            return "Some error occurred!";
        }
    }
}
