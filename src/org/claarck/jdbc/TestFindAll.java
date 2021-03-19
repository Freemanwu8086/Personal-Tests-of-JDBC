package org.claarck.jdbc;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

public class TestFindAll {
    public TestFindAll(){
        init();
    }

    void init(){
        JFrame f = new JFrame("查询所有书籍信息");
        f.setBounds(500,100,700,800);
        f.setLayout(new FlowLayout());
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
        try{
            Cbook cbook = new Cbook();
            CbookDAO dao = new CbookDAO();

            List<Cbook> list = new ArrayList<Cbook>();
            list = dao.findAll();

            JTextArea area = new JTextArea();
            area.setBounds(50,150,300,150);
            JScrollPane jsp = new JScrollPane(area);
            area.append("|      isbn" + "\t" + "|       class" + "\t" + "|       subclass" + "\t" + "|       name" + "\t" + "|       author" + "\t" + "|       pubdate" + "\t" + "|       price" + "\t" + "|       intrduction\n");
            area.append("|----------------------|------------------------|---------------------------|-----------------------|-------------------------|--------------------------|------------------------|-------------------|\n");
            for(Cbook Cbook : list){
                area.append("|    " + Cbook.getIsbn() + "\t|    " + Cbook.getA_class() + "\t|    " + Cbook.getSubclass() + "\t|    " + Cbook.getName() + "\t|    " + Cbook.getAuthor() + "\t|    " + Cbook.getPrice() + "\t|    " + Cbook.getPubdate() + "\t|    " + Cbook.getIntroduction() + "\n");
                area.append("|----------------------|------------------------|---------------------------|-----------------------|-------------------------|--------------------------|------------------------|-------------------|\n");
            }
            f.addWindowListener(new WindowAdapter() {
                @Override
                public void windowOpened(WindowEvent e) {

                }
            });

            JButton findall = new JButton("返回");
            findall.setBounds(100, 340, 100, 25);
            f.add(area);
            f.add(findall);
            findall.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JOptionPane.showMessageDialog(f,"查询完成");
                    f.setVisible(false);
                    yemian run = new yemian();
                }
            });
        }catch (Exception e2){
            JOptionPane.showMessageDialog(f,"查询失败");
            f.setVisible(false);
            yemian run = new yemian();
        }
    }
}
