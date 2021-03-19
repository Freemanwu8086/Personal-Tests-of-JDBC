package org.claarck.jdbc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class TestDelete {
    public TestDelete(){
        init();
    }

    void init(){
        JFrame f = new JFrame("ɾ���鼮��Ϣ");
        f.setLayout(null);
        f.setBounds(500,100,700,1000);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);

        JLabel isbn = new JLabel("isbn(Ҫɾ�����鼮��)��");
        isbn.setBounds(150, 100, 170, 25);
        f.add(isbn);

        JTextField �鼮�� = new JTextField();
        �鼮��.setBounds(320, 100, 150, 25);
        f.add(�鼮��);

        JButton delete = new JButton("ȷ��ɾ��");
        delete.setBounds(350, 350, 90, 25);
        f.add(delete);

        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    String isbn = �鼮��.getText();
                    Cbook cbook = new Cbook();
                    CbookDAO dao = new CbookDAO();
                    try {
                        cbook = dao.delete(isbn);
                        if (cbook != null) {
                            JOptionPane.showMessageDialog(f, "ɾ�����");
                            f.setVisible(false);
                            yemian run = new yemian();
                        }
                        else {
                            JOptionPane.showMessageDialog(f,"ɾ��ʧ��");
                            f.setVisible(false);
                            yemian run = new yemian();
                        }
                    }catch (ClassNotFoundException | SQLException e1){
                        e1.printStackTrace();
                    }finally {
                        System.out.println("������ɾ���¼�");
                    }
                }catch (Exception e2){
                    JOptionPane.showMessageDialog(f,"ɾ��ʧ��");
                    f.setVisible(false);
                    yemian run = new yemian();
                }
            }
        });
    }
}
