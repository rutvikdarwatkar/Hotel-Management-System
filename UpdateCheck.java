package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UpdateCheck extends JFrame implements ActionListener {
    Choice c1;
    JTextField t1,t2,t3,t4,t5;
    JButton b1,b2,b3;
    UpdateCheck(){

        JLabel check=new JLabel("Check-in Details");
        check.setBounds(80,20,250,30);
        check.setFont(new Font("Arial black",Font.BOLD,19));
        check.setForeground(Color.blue);
        add(check);

        JLabel customerid=new JLabel("Customer-ID");
        customerid.setBounds(30,80,150,20);
        customerid.setFont(new Font("tahoma",Font.BOLD,15));
        add(customerid);
        c1=new Choice();
        try{
            conn c=new conn();
            ResultSet rs=c.s.executeQuery("select * from customer");
            while(rs.next()){
                c1.add(rs.getString("number"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        c1.setBounds(200,80,150,20);
        add(c1);

        JLabel roomnumber=new JLabel("Room Number");
        roomnumber.setBounds(30,120,150,20);
        roomnumber.setFont(new Font("tahoma",Font.BOLD,15));
        add(roomnumber);

        t1=new JTextField();
        t1.setBounds(200,120,150,25);
        add(t1);

        JLabel name=new JLabel("Name");
        name.setBounds(30,160,100,20);
        name.setFont(new Font("tahoma",Font.BOLD,15));
        add(name);

        t2=new JTextField();
        t2.setBounds(200,160,150,25);
        add(t2);

        JLabel checkin=new JLabel("Check-in");
        checkin.setBounds(30,200,100,20);
        checkin.setFont(new Font("tahoma",Font.BOLD,15));
        add(checkin);

        t3=new JTextField();
        t3.setBounds(200,200,150,25);
        add(t3);

        JLabel amountpaid=new JLabel("Amount paid");
        amountpaid.setBounds(30,240,150,20);
        amountpaid.setFont(new Font("tahoma",Font.BOLD,15));
        add(amountpaid);

        t4=new JTextField();
        t4.setBounds(200,240,150,25);
        add(t4);

        JLabel pendingamount=new JLabel("Pending amount");
        pendingamount.setBounds(30,280,150,20);
        pendingamount.setFont(new Font("tahoma",Font.BOLD,15));
        add(pendingamount);

        t5=new JTextField();
        t5.setBounds(200,280,150,25);
        add(t5);

        b1=new JButton("Check");
        b1.setBounds(130,320,120,30);
        b1.setFont(new Font("Arial black",Font.BOLD,15));
        b1.setForeground(Color.white);
        b1.setBackground(Color.RED);
        b1.addActionListener(this);
        add(b1);

        b2=new JButton("Update");
        b2.setBounds(20,365,120,30);
        b2.setFont(new Font("Arial black",Font.BOLD,15));
        b2.setForeground(Color.white);
        b2.setBackground(Color.blue);
        b2.addActionListener(this);
        add(b2);

        b3=new JButton("Back");
        b3.setBounds(230,365,120,30);
        b3.setFont(new Font("Arial black",Font.BOLD,15));
        b3.setForeground(Color.black);
        b3.setBackground(Color.lightGray);
        b3.addActionListener(this);
        add(b3);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/nine.jpg"));
        Image i2=i1.getImage().getScaledInstance(364,200,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel l1=new JLabel(i3);
        l1.setBounds(400,100,364,200);
        add(l1);



        setLayout(null);
        setBounds(300,100,830,450);
        setVisible(true);
        getContentPane().setBackground(Color.white);
    }

    public static void main(String[] args) {
        new UpdateCheck().setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource()==b1){
            try{
                String room=null;
                String deposit=null;
                int amountPaid;
                String price=null;

                conn c=new conn();
                String id= c1.getSelectedItem();
                String str="select * from customer where number='"+id+"'";
                ResultSet rs=c.s.executeQuery(str);
                while(rs.next()){
                    t1.setText(rs.getString("room"));
                    t2.setText(rs.getString("name"));
                    t3.setText(rs.getString("status"));
                    t4.setText(rs.getString("deposit"));
                    room=rs.getString("room");
                    deposit=rs.getString("deposit");
                }

                ResultSet rs2=c.s.executeQuery("select * from room where room_number='"+room+"'");
                while (rs2.next()){
                    price=rs2.getString("price");

                    amountPaid=Integer.parseInt(price)-Integer.parseInt(deposit);
                    t5.setText(Integer.toString(amountPaid));

                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        else if (ae.getSource()==b2){

        }
        else if (ae.getSource()==b3){
            new Reception().setVisible(true);
            this.setVisible(false);
        }

    }
}
