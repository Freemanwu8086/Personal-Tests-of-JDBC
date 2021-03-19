package org.claarck.jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataSource {
    public static Connection getConnection() {// �����������ȡmysql������
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");// ����������
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/java?allowPublicKeyRetrieval=true&characterEncoding = utf-8&useSSL = false&serverTimezone = GMT", "root", "wsq.@.990811");
            // ��url���ݿ��IP��ַ��user���ݿ��û�����password���ݿ����룩
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
    public static void main(String[] args) {// �������ݿ��Ƿ����ӳɹ��ķ���
        Connection conn = DataSource.getConnection();
        System.out.println(conn);
    }
}