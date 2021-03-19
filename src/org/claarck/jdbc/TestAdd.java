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
        JFrame f = new JFrame("����鼮��Ϣ");//����鼮��Ϣ�Ĵ���
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

        JTextField �鼮�� = new JTextField();
        �鼮��.setBounds(320, 200, 150, 25);
        f.add(�鼮��);

        JTextField ����� = new JTextField();
        �����.setBounds(320, 175, 150, 25);
        f.add(�����);

        JTextField ����� = new JTextField();
        �����.setBounds(320, 150, 150, 25);
        f.add(�����);

        JTextField ���� = new JTextField();
        ����.setBounds(320, 125, 150, 25);
        f.add(����);

        JTextField ���� = new JTextField();
        ����.setBounds(320, 100, 150, 25);
        f.add(����);

        JTextField �۸� = new JTextField();
        �۸�.setBounds(320, 75, 150, 25);
        f.add(�۸�);

        JTextField �������� = new JTextField();
        ��������.setBounds(320, 50, 150, 25);
        f.add(��������);

        JTextField ��� = new JTextField();
        ���.setBounds(320, 25, 150, 25);
        f.add(���);

        JButton add = new JButton("ȷ�����");
        add.setBounds(350, 350, 90, 25);
        f.add(add);

        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    try {
                        String isbn = �鼮��.getText();
                        String a_class = �����.getText();
                        String subclass = �����.getText();
                        String name = ����.getText();
                        String author = ����.getText();
                        Double price = Double.valueOf((�۸�.getText()));
                        Date pubdate = Date.valueOf(��������.getText());
                        String introduction = ���.getText();

                        Cbook cbook = new Cbook(isbn, a_class, subclass, name, author, introduction, pubdate, price);
                        CbookDAO dao = new CbookDAO();
                        try {
                            dao.add(cbook);
                            JOptionPane.showMessageDialog(f, "������");
                            f.setVisible(false);
                            yemian run = new yemian();
                        } catch (ClassNotFoundException | SQLException e1) {
                            e1.printStackTrace();
                        } finally {
                            System.out.println("����������¼�");
                        }
                    }catch (Exception e2){
                        JOptionPane.showMessageDialog(f,"���ʧ��");
                        f.setVisible(false);
                        yemian run  = new yemian();
                }
            }
        });
    }
}
