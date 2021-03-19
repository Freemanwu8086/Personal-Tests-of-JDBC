package org.claarck.jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CbookDAO extends DataSource {
    //添加的方法
    public void add(Cbook cbook) throws ClassNotFoundException,SQLException{
        Connection con = null;
        PreparedStatement ps = null;
        String sql = "insert into cbook (isbn, class, subclass, name, author, price, pubdate, introduction) values(?,?,?,?,?,?,?,?)";
        try {
            con = this.getConnection();
            ps = con.prepareStatement(sql);
            // 设置占位符对应的参数
            ps.setString(1, cbook.getIsbn());
            ps.setString(2, cbook.getA_class());
            ps.setString(3, cbook.getSubclass());
            ps.setString(4, cbook.getName());
            ps.setString(5, cbook.getAuthor());
            ps.setDouble(6, cbook.getPrice());
            ps.setDate(7, (Date) cbook.getPubdate());
            ps.setString(8, cbook.getIntroduction());
            ps.executeUpdate();
        }finally {
            this.close(con, ps, null);
        }
    }


    public void update(Cbook cbook) throws ClassNotFoundException, SQLException{
        Connection con = null;
        PreparedStatement ps = null;
        String sql = "update cbook set class = ?, subclass = ?, name = ?, author = ?, price = ?, pubdate = ?, introduction = ? where isbn = ?";
        try{
            con = this.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, cbook.getA_class());
            ps.setString(2, cbook.getSubclass());
            ps.setString(3, cbook.getName());
            ps.setString(4, cbook.getAuthor());
            ps.setDouble(5, cbook.getPrice());
            ps.setDate(6, (Date) cbook.getPubdate());
            ps.setString(7, cbook.getIntroduction());
            ps.setString(8, cbook.getIsbn());
            ps.executeUpdate();
        }finally {
            this.close(con,ps,null);
        }
    }

    public Cbook delete(String isbn) throws ClassNotFoundException, SQLException{
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "delete from cbook where isbn = ?";
        String sql1 = "select * from cbook where isbn = ?";
        Cbook s = null;
        try{
            con = this.getConnection();
            ps = con.prepareStatement(sql1);
            ps.setString(1,isbn);
            rs = ps.executeQuery();
            while(rs.next()){
                s = new Cbook(rs.getString(1),rs.getString(2),rs.getString(3),
                        rs.getString(4),rs.getString(5), rs.getString(8),rs.getDate(7),
                        rs.getDouble(6));
            }
            ps = con.prepareStatement(sql);
            ps.setString(1,isbn);
            ps.executeUpdate();
        }finally {
            this.close(con,ps,null);
            return s;
        }
    }
    public List<Cbook> findAll() throws ClassNotFoundException, SQLException{
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Cbook> list = new ArrayList<Cbook>();
        String sql = "select cbook.* from cbook";
        try{
            con = this.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Cbook s = new Cbook(rs.getString(1),rs.getString(2),rs.getString(3),
                        rs.getString(4),rs.getString(5), rs.getString(8),rs.getDate(7),
                        rs.getDouble(6));
                list.add(s);
            }
        }finally {
            this.close(con,ps,rs);
        }
        return list;
    }
    public Cbook findByName(String name) throws ClassNotFoundException,SQLException{
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select * from cbook where isbn = ?";
        Cbook s = null;
        try{
            con = this.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1,name);
            rs = ps.executeQuery();
            while(rs.next()){
                s = new Cbook(rs.getString(1),rs.getString(2),rs.getString(3),
                        rs.getString(4),rs.getString(5), rs.getString(8),rs.getDate(7),
                        rs.getDouble(6));
            }
        }finally {
            this.close(con,ps,rs);
        }
        return s;
    }

}
