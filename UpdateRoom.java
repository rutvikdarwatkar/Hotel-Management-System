package hotel.management.system;

import com.intellij.ui.components.JBLabel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UpdateRoom extends JFrame implements ActionListener {
    JTextField t1,t2,t3,t4;
    JButton b1,b2,b3;
    Choice c1;

    UpdateRoom(){

        JLabel updateRoom=new JLabel("Update Room Status");
        updateRoom.setBounds(50,20,250,30);
        updateRoom.setFont(new Font("Arial black",Font.BOLD,19));
        updateRoom.setForeground(Color.blue);
        add(updateRoom);
        
        JLabel guestid=new JLabel("Guest ID");
        guestid.setBounds(20,70,100,30);
        guestid.setFont(new Font("tahoma",Font.BOLD,15));
        add(guestid);

        c1=new Choice();
        try{
            conn c=new conn();
            ResultSet rs =c.s.executeQuery("select * from customer");
            while(rs.next()){
                c1.add(rs.getString("number"));

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        c1.setBounds(180,70,150,30);
        add(c1);

        JLabel roomnumber=new JLabel("Room number");
        roomnumber.setBounds(20,120,120,30);
        roomnumber.setFont(new Font("tahoma",Font.BOLD,15));
        add(roomnumber);

        t1=new JTextField();
        t1.setBounds(180,120,150,30);
        add(t1);


        JLabel avaiability=new JLabel("Availability");
        avaiability.setBounds(20,170,120,30);
        avaiability.setFont(new Font("tahoma",Font.BOLD,15));
        add(avaiability);

        t2=new JTextField();
        t2.setBounds(180,170,150,30);
        add(t2);

        JLabel cleanstatus=new JLabel("Clean status");
        cleanstatus.setBounds(20,220,120,30);
        cleanstatus.setFont(new Font("tahoma",Font.BOLD,15));
        add(cleanstatus);

        t3=new JTextField();
        t3.setBounds(180,220,150,30);
        add(t3);

        b1=new JButton("Check");
        b1.setBounds(130,290,120,30);
        b1.setFont(new Font("Arial black",Font.BOLD,15));
        b1.setForeground(Color.white);
        b1.setBackground(Color.RED);
        b1.addActionListener(this);
        add(b1);

        b2=new JButton("Update");
        b2.setBounds(20,340,120,30);
        b2.setFont(new Font("Arial black",Font.BOLD,15));
        b2.setForeground(Color.white);
        b2.setBackground(Color.blue);
        b2.addActionListener(this);
        add(b2);

        b3=new JButton("Back");
        b3.setBounds(230,340,120,30);
        b3.setFont(new Font("Arial black",Font.BOLD,15));
        b3.setForeground(Color.black);
        b3.setBackground(Color.lightGray);
        b3.addActionListener(this);
        add(b3);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/seventh.jpg"));
        Image i2=i1.getImage().getScaledInstance(500,320,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel l1=new JLabel(i3);
        l1.setBounds(370,45,500,320);
        add(l1);

        getContentPane().setBackground(Color.white);
        setLayout(null);
        setBounds(300,100,900,430);
        setVisible(true);

    }

    public static void main(String[] args) {
        new UpdateRoom().setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==b1){
            String room=null;
            String s1=c1.getSelectedItem();
            conn c=new conn();
            try{
                ResultSet rs=c.s.executeQuery("select * from customer where number='"+s1+"'");
                while(rs.next()){
                    t1.setText(rs.getString("room"));
                    room=rs.getString("room");
                }
                ResultSet rs2=c.s.executeQuery("select * from room where room_number='"+room+"'");
                while(rs2.next()){
                    t2.setText(rs2.getString("availability"));
                    t3.setText(rs2.getString("cleaning_status"));
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        else if(ae.getSource()==b2){
            try{
                conn c=new conn();
                String roomnumber=t1.getText();
                String availability=t2.getText();
                String cleanstatus=t3.getText();

                String str="update room set availability='"+availability+"',cleaning_status='"+cleanstatus+"' where room_number='"+roomnumber+"' ";
                c.s.executeUpdate(str);
                JOptionPane.showMessageDialog(null,"Room Updated succesfully");
                new Reception().setVisible(true);
                this.setVisible(false);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        else if(ae.getSource()==b3){
            new Reception().setVisible(true);
            this.setVisible(false);
        }

    }
}

