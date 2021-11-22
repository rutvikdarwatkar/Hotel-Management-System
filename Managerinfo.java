package hotel.management.system;

import com.intellij.util.indexing.storage.UpdatableSnapshotInputMappingIndex;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import net.proteanit.sql.*;

public class Managerinfo extends JFrame implements ActionListener {
    JTable t1;
    JButton b1,b2;

    Managerinfo(){
        t1=new JTable();
        t1.setBounds(0,50,1000,500);
        add(t1);

        b1=new JButton("Load Data");
        b1.setBounds(350,560,120,30);
        b1.setFont(new Font("Arial Black",Font.PLAIN,13));
        b1.setForeground(Color.white);
        b1.setBackground(Color.blue);
        b1.addActionListener(this);
        add(b1);

        b2=new JButton("Back");
        b2.setFont(new Font("Arial Black",Font.PLAIN,13));
        b2.setForeground(Color.black);
        b2.setBackground(Color.gray);
        b2.setBounds(520,560,120,30);
        b2.addActionListener(this);
        add(b2);

        JLabel l1 = new JLabel("Name");
        l1.setBounds(30,10,50,30);
        add(l1);

        JLabel l2 = new JLabel("Age");
        l2.setBounds(170,10,50,30);
        add(l2);

        JLabel l3 = new JLabel("Gender");
        l3.setBounds(280,10,50,30);
        add(l3);

        JLabel l4 = new JLabel("Job");
        l4.setBounds(420,10,50,30);
        add(l4);

        JLabel l5 = new JLabel("Salary");
        l5.setBounds(530,10,50,30);
        add(l5);

        JLabel l6 = new JLabel("Phone no.");
        l6.setBounds(650,10,80,30);
        add(l6);

        JLabel l7 = new JLabel("Aadhar no.");
        l7.setBounds(780,10,80,30);
        add(l7);

        JLabel l8 = new JLabel("E-Mail");
        l8.setBounds(920,10,50,30);
        add(l8);

        setLayout(null);
        setBounds(230,60,1000,650);
        setVisible(true);
        getContentPane().setBackground(Color.white);
    }

    public static void main(String[] args) {
        new Managerinfo().setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==b1){
            try {
                conn c=new conn();
                String str="select * from employee where job='Manager'";
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
