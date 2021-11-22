package hotel.management.system;

import com.intellij.ui.components.JBLabel;
import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Room extends JFrame implements ActionListener {
    JTable t1;
    JButton b1,b2;

    Room(){
        t1=new JTable();
        t1.setBounds(0,50,500,500);
        add(t1);

        b1=new JButton("Load Data");
        b1.setBounds(150,560,120,30);
        b1.setFont(new Font("Arial Black",Font.PLAIN,13));
        b1.setForeground(Color.white);
        b1.setBackground(Color.blue);
        b1.addActionListener(this);
        add(b1);

        b2=new JButton("Back");
        b2.setFont(new Font("Arial Black",Font.PLAIN,13));
        b2.setForeground(Color.black);
        b2.setBackground(Color.gray);
        b2.setBounds(300,560,120,30);
        b2.addActionListener(this);
        add(b2);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/eight.jpg"));
        Image i2=i1.getImage().getScaledInstance(550,600,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel l1=new JLabel(i3);
        l1.setBounds(510,10,550,600);
        add(l1);

        JLabel l2=new JLabel("Room no.");
        l2.setBounds(10,10,80,30);
        add(l2);

        JLabel l3=new JLabel("Availability");
        l3.setBounds(110,10,80,30);
        add(l3);

        JLabel l4=new JLabel("Status");
        l4.setBounds(230,10,80,30);
        add(l4);

        JLabel l5=new JLabel("Price");
        l5.setBounds(320,10,80,30);
        add(l5);

        JLabel l6=new JLabel("Bed Type");
        l6.setBounds(420,10,80,30);
        add(l6);


        setLayout(null);
        setBounds(230,60,1000,650);
        setVisible(true);
        getContentPane().setBackground(Color.white);
    }

    public static void main(String[] args) {
        new Room().setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==b1){
            try{
                conn c = new conn();
                String str="select * from room";
                ResultSet rs=c.s.executeQuery(str);
                t1.setModel(DbUtils.resultSetToTableModel(rs));
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        }
        else if(ae.getSource()==b2){
            new Reception().setVisible(true);
            this.setVisible(false);
        }
    }
}
