package hotel.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;


    public class Department extends JFrame implements ActionListener {

        JCheckBox c2;
        JTable t1;
        JButton b1,b2;
        Choice c1;

            Department(){
//
            t1=new JTable();
            t1.setBounds(0,80,700,300);
            add(t1);

            b1=new JButton("Submit");
            b1.setBounds(160,400,120,30);
            b1.setFont(new Font("Arial Black",Font.PLAIN,13));
            b1.setForeground(Color.white);
            b1.setBackground(Color.blue);
            b1.addActionListener(this);
            add(b1);

            b2=new JButton("Back");
            b2.setFont(new Font("Arial Black",Font.PLAIN,13));
            b2.setForeground(Color.black);
            b2.setBackground(Color.gray);
            b2.setBounds(400,400,120,30);
            b2.addActionListener(this);
            add(b2);

                JLabel l1=new JLabel("Department");
                l1.setBounds(130,15,200,30);
                l1.setFont(new Font("Arial black", Font.BOLD, 19));
                l1.setForeground(Color.black);

                add(l1);

                JLabel l2=new JLabel("Budget");
                l2.setBounds(420,15,200,30);
                l2.setFont(new Font("Arial black", Font.BOLD, 19));
                l2.setForeground(Color.black);
                add(l2);



            setLayout(null);
            setBounds(300,120,700,500);
            setVisible(true);
            getContentPane().setBackground(Color.white);
        }

        public static void main(String[] args) {
            new Department().setVisible(true);
        }

        @Override
        public void actionPerformed(ActionEvent ae) {
            if(ae.getSource()==b1){
                try{
                    String str="select * from department";
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




