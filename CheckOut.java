package hotel.management.system;

import com.intellij.ui.components.JBLabel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CheckOut extends JFrame implements ActionListener {
    Choice c1;
    JTextField t1, t2;
    JButton b1, b2, b3;

    CheckOut() {
        JLabel checkout = new JLabel("Check-out");
        checkout.setBounds(90, 20, 150, 30);
        checkout.setFont(new Font("Arial black", Font.BOLD, 19));
        checkout.setForeground(Color.blue);
        add(checkout);

        JLabel customerid = new JLabel("Customer-ID");
        customerid.setBounds(30, 80, 140, 20);
        customerid.setFont(new Font("tahoma", Font.BOLD, 15));
        add(customerid);
        c1 = new Choice();
        try {
            conn c = new conn();
            ResultSet rs = c.s.executeQuery("select * from customer");
            while (rs.next()) {
                c1.add(rs.getString("number"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        c1.setBounds(170, 80, 130, 20);
        add(c1);

        JLabel roomnumber = new JLabel("Room Number");
        roomnumber.setBounds(30, 120, 150, 20);
        roomnumber.setFont(new Font("tahoma", Font.BOLD, 15));
        add(roomnumber);

        t1 = new JTextField();
        t1.setBounds(170, 120, 130, 25);
        add(t1);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/tick.png"));
        Image i2 = i1.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        b3 = new JButton(i3);
        b3.setBounds(310, 80, 20, 20);
        b3.addActionListener(this);
        add(b3);

        b1 = new JButton("Checkout");
        b1.setBounds(30, 180, 120, 30);
        b1.setFont(new Font("Arial black", Font.BOLD, 15));
        b1.setForeground(Color.white);
        b1.setBackground(Color.RED);
        b1.addActionListener(this);
        add(b1);

        b2 = new JButton("Back");
        b2.setBounds(175, 180, 120, 30);
        b2.setFont(new Font("Arial black", Font.BOLD, 15));
        b2.setForeground(Color.black);
        b2.setBackground(Color.lightGray);
        b2.addActionListener(this);
        add(b2);

        ImageIcon q1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/sixth.jpg"));
        Image q2 = q1.getImage().getScaledInstance(400, 260, Image.SCALE_DEFAULT);
        ImageIcon q3 = new ImageIcon(q2);
        JLabel q4 = new JLabel(q3);
        q4.setBounds(345, 0, 400, 260);
        add(q4);


        getContentPane().setBackground(Color.white);
        setLayout(null);
        setBounds(450, 200, 780, 300);
        setVisible(true);
    }

    public static void main(String[] args) {
        new CheckOut().setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource()==b1){
            String id=c1.getSelectedItem();
            String room=t1.getText();
            String str="delete from customer where number='"+id+"'";
            String str2="update room set availability='Available' where room_number='"+room+"' ";
            conn c=new conn();
            try {
                c.s.executeUpdate(str);
                c.s.executeUpdate(str2);
                JOptionPane.showMessageDialog(null,"Checkout done");
                new Reception().setVisible(true);
                this.setVisible(false);

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        }
        else if(ae.getSource()==b2){
            new Reception().setVisible(true);
            this.setVisible(false);
        }
        else if(ae.getSource()==b3){
            conn c=new conn();
            String id=c1.getSelectedItem();
            try {
                ResultSet rs=c.s.executeQuery("select * from customer where number='"+id+"'");
                while(rs.next()){
                    t1.setText(rs.getString("room"));
                }
            }
         catch (Exception e) {
                e.printStackTrace();
            }

        }
}
}