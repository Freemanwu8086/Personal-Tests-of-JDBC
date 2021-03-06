package org.claarck.jdbc;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class TestAdd {
    public TestAdd(){
        init();//
    }

    void init(){
        JFrame f = new JFrame("添加书籍信息");//添加书籍信息的窗口
        f.setLayout(null);
        f.setBounds(700,200,1000,700);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);

        JLabel isbn = new JLabel("isbn:");
        isbn.setBounds(250,200,100,25);
        f.add(isbn);

        JLabel a_class = new JLabel("class:");
        a_class.setBounds(250,175,100,25);
        f.add(a_class);

        JLabel subclass = new JLabel("subclass:");
        subclass.setBounds(250,150,100,25);
        f.add(subclass);

        JLabel name = new JLabel("name:");
        name.setBounds(250,125,100,25);
        f.add(name);

        JLabel author = new JLabel("author:");
        author.setBounds(250,100,100,25);
        f.add(author);

        JLabel price = new JLabel("price:");
        price.setBounds(250,75,100,25);
        f.add(price);

        JLabel pubdate = new JLabel("pubdate:");
        pubdate.setBounds(250,50,100,25);
        f.add(pubdate);

        JLabel introduction = new JLabel("introduction:");
        introduction.setBounds(250,25,100,25);
        f.add(introduction);

        JTextField 书籍号 = new JTextField();
        书籍号.setBounds(320, 200, 150, 25);
        f.add(书籍号);

        JTextField 主类别 = new JTextField();
        主类别.setBounds(320, 175, 150, 25);
        f.add(主类别);

        JTextField 次类别 = new JTextField();
        次类别.setBounds(320, 150, 150, 25);
        f.add(次类别);

        JTextField 书名 = new JTextField();
        书名.setBounds(320, 125, 150, 25);
        f.add(书名);

        JTextField 作者 = new JTextField();
        作者.setBounds(320, 100, 150, 25);
        f.add(作者);

        JTextField 价格 = new JTextField();
        价格.setBounds(320, 75, 150, 25);
        f.add(价格);

        JTextField 出版日期 = new JTextField();
        出版日期.setBounds(320, 50, 150, 25);
        f.add(出版日期);

        JTextField 简介 = new JTextField();
        简介.setBounds(320, 25, 150, 25);
        f.add(简介);

        JButton add = new JButton("确定添加");
        add.setBounds(350, 350, 90, 25);
        f.add(add);

        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    try {
                        String isbn = 书籍号.getText();
                        String a_class = 主类别.getText();
                        String subclass = 次类别.getText();
                        String name = 书名.getText();
                        String author = 作者.getText();
                        Double price = Double.valueOf((价格.getText()));
                        Date pubdate = Date.valueOf(出版日期.getText());
                        String introduction = 简介.getText();

                        Cbook cbook = new Cbook(isbn, a_class, subclass, name, author, introduction, pubdate, price);
                        CbookDAO dao = new CbookDAO();
                        try {
                            dao.add(cbook);
                            JOptionPane.showMessageDialog(f, "添加完成");
                            f.setVisible(false);
                            yemian run = new yemian();
                        } catch (ClassNotFoundException | SQLException e1) {
                            e1.printStackTrace();
                        } finally {
                            System.out.println("发生了添加事件");
                        }
                    }catch (Exception e2){
                        JOptionPane.showMessageDialog(f,"添加失败");
                        f.setVisible(false);
                        yemian run  = new yemian();
                }
            }
        });
    }
}
