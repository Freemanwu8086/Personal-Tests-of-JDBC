package org.claarck.jdbc;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

public class yemian {
    public yemian(){
        init();
    }

    void init(){
        JFrame f = new JFrame("�鼮����");
        Container con = f.getContentPane();
        con.setBackground(Color.white);
        f.setBounds(500,100,1000,800);
        f.setLocationRelativeTo(null);
        f.setLayout(new FlowLayout());
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton add = new JButton("����");// �������Ӱ�ť
        add.setBounds(50, 300, 60, 25);// ���ð�ť��С

        JButton delete = new JButton("ɾ��");// ����ɾ����ť
        delete.setBounds(120, 300, 60, 25);
 
        JButton update = new JButton("�޸�");// �����޸İ�ť
        update.setBounds(190, 300, 60, 25);

        JButton find = new JButton("��isbn�Ų�ѯ");// ������isbn�Ų�ѯ��ť
        find.setBounds(50, 330, 100, 25);

        JButton findall = new JButton("��ѯ����");// ������ѯ���а�ť
        findall.setBounds(160, 330, 90, 25);

        JButton b = new JButton("");// ������һ����ť������ť������ʾ�����ڵ�
        b.setContentAreaFilled(false);// �Ƿ����
        b.setBorderPainted(false);// �Ƿ񻭱߿�
        b.setEnabled(false);// ���ɰ�

        f.add(add);
        f.add(delete);
        f.add(find);
        f.add(update);
        f.add(findall);
        f.add(b);
        JTextArea area = new JTextArea();
        area.setBounds(350,150,800,800);
        JScrollPane jsp  = new JScrollPane(area);
        try{
            Cbook cbook = new Cbook();
            CbookDAO dao = new CbookDAO();

            List<Cbook> list = new ArrayList<Cbook>();
            list = dao.findAll();

            area.append("|      isbn" + "\t" + "|          class" + "\t" + "|       subclass" + "\t" + "|       name" + "\t" + "|       author" + "\t" + "|       price" + "\t" + "|       pubdate" + "\t" + "|       intrduction\n");
            area.append("|---------------------|---------------------|---------------------|---------------------|---------------------|---------------------|---------------------|---------------------|\n");
            for(Cbook Cbook : list){
                area.append("|" + Cbook.getIsbn() + "   |   " + Cbook.getA_class() + "|    " + Cbook.getSubclass() + "| " + Cbook.getName() + "|    " + Cbook.getAuthor() + "|    " + Cbook.getPrice() + "|    " + Cbook.getPubdate() + "   |    " + Cbook.getIntroduction() + "\n");
                area.append("|---------------------|------------------------|---------------------------|-----------------------|-------------------------|--------------------------|------------------------|-------------------|\n");
            }
        }catch (Exception e2){
        }
        f.add(area);
        add.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.setVisible(false);
                TestAdd d = new TestAdd();
            }
        });
        delete.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.setVisible(false);
                TestDelete d = new TestDelete();
            }
        });
        update.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.setVisible(false);
                TestUpdate d = new TestUpdate();
            }
        });
        find.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.setVisible(false);
                TestFindByName d = new TestFindByName();
            }
        });
        findall.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.setVisible(false);
                TestFindAll d = new TestFindAll();
            }
        });
    }
}
