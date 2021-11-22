package hotel.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;




import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

    public class PickUp extends JFrame implements ActionListener {

        JCheckBox c2;
        JTable t1;
        JButton b1,b2;
        Choice c1;

        PickUp(){
            JLabel search = new JLabel("PickUp Service");
            search.setBounds(400, 20, 250, 30);
            search.setFont(new Font("Arial black", Font.BOLD, 19));
            search.setForeground(Color.black);
            search.setBackground(Color.black);
            add(search);

            JLabel cartype=new JLabel("Type of Car");
            cartype.setBounds(40,70,150,30);
            cartype.setFont(new Font("arial black",Font.PLAIN,13));
            cartype.setForeground(Color.black);
            add(cartype);

            c1=new Choice();
            try{
                conn c=new conn();
                ResultSet rs=c.s.executeQuery("select * from drivers");
                while(rs.next()){
                    c1.add(rs.getString("Model"));
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
            c1.setBounds(200,70,150,30);
            c1.setBackground(Color.white);
            add(c1);

//            String str[]={"Single Bed","Double Bed"};
//            c1=new JComboBox(str);
//            c1.setBounds(200,70,150,30);
//            c1.setBackground(Color.white);
//            add(c1);

            JLabel l1=new JLabel("Name");
            l1.setBounds(10,120,80,30);
            add(l1);

            JLabel l2=new JLabel("Age");
            l2.setBounds(145,120,80,30);
            add(l2);

            JLabel l3=new JLabel("Gender");
            l3.setBounds(285,120,150,30);
            add(l3);

            JLabel l4=new JLabel("Car company");
            l4.setBounds(430,120,150,30);
            add(l4);

            JLabel l6=new JLabel("Car model");
            l6.setBounds(580,120,150,30);
            add(l6);

            JLabel l5=new JLabel("Available");
            l5.setBounds(720,120,150,30);
            add(l5);

            JLabel l7=new JLabel("Location");
            l7.setBounds(850,120,150,30);
            add(l7);


//            c2=new JCheckBox("Only display available");
//            c2.setBounds(600,70,200,30);
//            c2.setBackground(Color.white);
//            add(c2);

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
            new PickUp().setVisible(true);
        }

        @Override
        public void actionPerformed(ActionEvent ae) {
            if(ae.getSource()==b1){
                try{
                    String str="select * from drivers where Model='"+c1.getSelectedItem()+"'";
                    conn c=new conn();
                    ResultSet rs=c.s.executeQuery(str);
                    t1.setModel(DbUtils.resultSetToTableModel(rs));

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


