package org.claarck.jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataSource {
    public static Connection getConnection() {// 用这个方法获取mysql的连接
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");// 加载驱动类
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/java?allowPublicKeyRetrieval=true&characterEncoding = utf-8&useSSL = false&serverTimezone = GMT", "root", "wsq.@.990811");
            // （url数据库的IP地址，user数据库用户名，password数据库密码）
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
    public void close(Connection con, Statement st, ResultSet rs) throws ClassNotFoundException, SQLException{
        if(rs != null) {
            rs.close();
        }
        if(st != null) {
            st.close();
        }
        if(con != null) {
            con.close();
        }
    }
    public static void main(String[] args) {// 测试数据库是否连接成功的方法
        Connection conn = DataSource.getConnection();
        System.out.println(conn);
    }
}