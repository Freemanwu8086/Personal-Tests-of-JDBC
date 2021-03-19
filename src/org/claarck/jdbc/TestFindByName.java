package org.claarck.jdbc;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class TestFindByName {
    public TestFindByName() {
        init();
    }

    void init(){
        JFrame f = new JFrame("��ѯ�鼮��Ϣ");
        f.setLayout(null);
        f.setBounds(500,100,700,700);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);

        JLabel isbn = new JLabel("��ѯisbn:");
        isbn.setBounds(250, 100, 100, 25);
        f.add(isbn);

        JTextField �鼮�� = new JTextField();
        �鼮��.setBounds(320,100,150,25);
        f.add(�鼮��);

        JButton sel = new JButton("ȷ����ѯ");
        sel.setBounds(350, 350, 90, 25);
        f.add(sel);

        JFrame f1 = new JFrame("��ѯ�鼮��Ϣ");// ��ѯѧ����Ϣ�Ĵ���
        f1.setLayout(null);
        f1.setBounds(280, 100, 380, 330);// ���ڴ�С
        f1.setLayout(new FlowLayout());
        f1.setLocationRelativeTo(null);// �Ѵ������õ���Ļ����
        f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        sel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    String isbn = �鼮��.getText();
                    Cbook Cbook = new Cbook();
                    CbookDAO dao = new CbookDAO();
                    try{
                        Cbook = dao.findByName(isbn);
                        f.setVisible(false);
                        f1.setVisible(true);
                        JTextArea area = new JTextArea();
                        area.setBounds(30, 50, 300, 150);
                        JScrollPane jsp = new JScrollPane(area);
                        area.append("|      isbn" + "\t" + "|       class" + "\t" + "|       subclass" + "\t" + "|       name" + "\t" + "|       author" + "\t" + "|       pubdate" + "\t" + "|       price" + "\t" + "|       intrduction\n");
                        area.append("|----------------------|------------------------|---------------------------|-----------------------|-------------------------|--------------------------|------------------------|-------------------|\n");
                        area.append("|" + Cbook.getIsbn() + "\t|    " + Cbook.getA_class() + "\t|    " + Cbook.getSubclass() + "\t|    " + Cbook.getName() + "\t|    " + Cbook.getAuthor() + "\t|    " + Cbook.getPrice() + "\t|    " + Cbook.getPubdate() + "\t|    " + Cbook.getIntroduction() + "\n");
                        area.append("|----------------------|------------------------|---------------------------|-----------------------|-------------------------|--------------------------|------------------------|-------------------|\n");

                        JButton findall = new JButton("����");
                        findall.setBounds(100, 240, 100, 25);
                        f1.add(area);
                        f1.add(findall);
                        findall.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                JOptionPane.showMessageDialog(f,"��ѯ���");
                                f1.setVisible(false);
                                yemian run = new yemian();
                            }
                        });
                    }catch (ClassNotFoundException | SQLException e1){
                        e1.printStackTrace();
                    }finally {
                        System.out.println("�����˲�ѯ�¼�");
                    }
                }catch (Exception e2){
                    JOptionPane.showMessageDialog(f1,"��ѯʧ��");
                    f1.setVisible(false);
                    yemian run = new yemian();
                }
            }
        });
    }
}
