package hotel.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class SearchRoom extends JFrame implements ActionListener {
    JComboBox c1;
    JCheckBox c2;
    JTable t1;
    JButton b1,b2;


    SearchRoom(){
        JLabel search = new JLabel("Search For Room");
        search.setBounds(400, 20, 250, 30);
        search.setFont(new Font("Arial black", Font.BOLD, 19));
        search.setForeground(Color.black);
        search.setBackground(Color.black);
        add(search);

        JLabel bedtype=new JLabel("Room Bed Type");
        bedtype.setBounds(40,70,150,30);
        bedtype.setFont(new Font("arial black",Font.PLAIN,13));
        bedtype.setForeground(Color.black);
        add(bedtype);

        String str[]={"Single Bed","Double Bed"};
        c1=new JComboBox(str);
        c1.setBounds(200,70,150,30);
        c1.setBackground(Color.white);
        add(c1);

        JLabel l1=new JLabel("Room no.");
        l1.setBounds(10,120,80,30);
        add(l1);

        JLabel l2=new JLabel("Availability");
        l2.setBounds(200,120,80,30);
        add(l2);

        JLabel l3=new JLabel("Cleaning status");
        l3.setBounds(400,120,150,30);
        add(l3);

        JLabel l4=new JLabel("Price");
        l4.setBounds(600,120,150,30);
        add(l4);

        JLabel l5=new JLabel("Bed type");
        l5.setBounds(800,120,150,30);
        add(l5);


        c2=new JCheckBox("Only display available");
        c2.setBounds(600,70,200,30);
        c2.setBackground(Color.white);
        add(c2);

        t1=new JTable();
        t1.setBounds(0,150,1000,300);
        add(t1);

        b1=new JButton("Submit");
        b1.setBounds(300,500,120,30);
        b1.setFont(new Font("Arial Black",Font.PLAIN,13));
        b1.setForeground(Color.white);
        b1.setBackground(Color.blue);
        b1.addActionListener(this);
        add(b1);

        b2=new JButton("Back");
        b2.setFont(new Font("Arial Black",Font.PLAIN,13));
        b2.setForeground(Color.black);
        b2.setBackground(Color.gray);
        b2.setBounds(500,500,120,30);
        b2.addActionListener(this);
        add(b2);

        setLayout(null);
        setBounds(200,120,1000,600);
        setVisible(true);
        getContentPane().setBackground(Color.white);
    }

    public static void main(String[] args) {
        new SearchRoom().setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==b1){
            try{
                String str="select * from room where bed_type='"+c1.getSelectedItem()+"'";
                String str2="select * from room where availability='Available' AND bed_type='"+c1.getSelectedItem()+"'";
                conn c=new conn();
                ResultSet rs=c.s.executeQuery(str);
                t1.setModel(DbUtils.resultSetToTableModel(rs));

                if(c2.isSelected()){
                    ResultSet rs2=c.s.executeQuery(str2);
                    t1.setModel(DbUtils.resultSetToTableModel(rs2));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        else if(ae.getSource()==b2){
            new Reception().setVisible(true);
            this.setVisible(false);
        }
    }
}
