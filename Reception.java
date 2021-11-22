package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Reception extends JFrame implements ActionListener {
JButton b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12;

    Reception(){

        b1=new JButton("New Customer Form");
        b1.setBounds(20,20,175,30);
        b1.setFont(new Font("Arial black",Font.PLAIN,12));
        b1.setBackground(Color.black);
        b1.setForeground(Color.white);
        b1.addActionListener(this);
        add(b1);

        b2=new JButton("Room");
        b2.setBounds(20,60,175,30);
        b2.setFont(new Font("Arial black",Font.PLAIN,12));
        b2.setBackground(Color.black);
        b2.setForeground(Color.white);
        b2.addActionListener(this);
        add(b2);

        b3=new JButton("Department");
        b3.setBounds(20,100,175,30);
        b3.setFont(new Font("Arial black",Font.PLAIN,12));
        b3.setBackground(Color.black);
        b3.setForeground(Color.white);
        b3.addActionListener(this);
        add(b3);

        b4=new JButton("All Employee Info");
        b4.setBounds(20,140,175,30);
        b4.setFont(new Font("Arial black",Font.PLAIN,12));
        b4.setBackground(Color.black);
        b4.setForeground(Color.white);
        b4.addActionListener(this);
        add(b4);

        b5=new JButton("Customer Info");
        b5.setBounds(20,180,175,30);
        b5.setFont(new Font("Arial black",Font.PLAIN,12));
        b5.setBackground(Color.black);
        b5.setForeground(Color.white);
        b5.addActionListener(this);
        add(b5);

        b6=new JButton("Manager Info");
        b6.setBounds(20,220,175,30);
        b6.setFont(new Font("Arial black",Font.PLAIN,12));
        b6.setBackground(Color.black);
        b6.setForeground(Color.white);
        b6.addActionListener(this);
        add(b6);

        b7=new JButton("Check Out");
        b7.setBounds(20,260,175,30);
        b7.setFont(new Font("Arial black",Font.PLAIN,12));
        b7.setBackground(Color.black);
        b7.setForeground(Color.white);
        b7.addActionListener(this);
        add(b7);

        b8=new JButton("Update Check Status");
        b8.setBounds(20,300,175,30);
        b8.setFont(new Font("Arial black",Font.PLAIN,12));
        b8.setBackground(Color.black);
        b8.setForeground(Color.white);
        b8.addActionListener(this);
        add(b8);

        b9=new JButton("Update Room Status");
        b9.setBounds(20,340,175,30);
        b9.setFont(new Font("Arial black",Font.PLAIN,12));
        b9.setBackground(Color.black);
        b9.setForeground(Color.white);
        b9.addActionListener(this);
        add(b9);

        b10=new JButton("Pick up Service");
        b10.setBounds(20,380,175,30);
        b10.setFont(new Font("Arial black",Font.PLAIN,12));
        b10.setBackground(Color.black);
        b10.setForeground(Color.white);
        b10.addActionListener(this);
        add(b10);

        b11=new JButton("Search Room");
        b11.setBounds(20,420,175,30);
        b11.setFont(new Font("Arial black",Font.PLAIN,12));
        b11.setBackground(Color.black);
        b11.setForeground(Color.white);
        b11.addActionListener(this);
        add(b11);

        b12=new JButton("Logout");
        b12.setBounds(20,460,175,30);
        b12.setFont(new Font("Arial black",Font.PLAIN,12));
        b12.setBackground(Color.black);
        b12.setForeground(Color.white);
        b12.addActionListener(this);
        add(b12);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/fourth.jpg"));
        Image i2= i1.getImage().getScaledInstance(430,430,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel l1=new JLabel(i3);
        l1.setBounds(230,20,430,430);
        add(l1);


        setLayout(null);
        setBounds(320,120,700,550);
        setVisible(true);
        getContentPane().setBackground(Color.white);

    
}

    public static void main(String[] args) {
        new Reception().setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==b1){
            new AddCustomer().setVisible(true);
            this.setVisible(false);
        }
        else if(ae.getSource()==b2){
            new Room().setVisible(true);
            this.setVisible(false);
        }
        else if(ae.getSource()==b3){
            new Department().setVisible(true);
            this.setVisible(false);
        }
        else if(ae.getSource()==b4){
            new Employeeinfo().setVisible(true);
            this.setVisible(false);
        }
        else if(ae.getSource()==b5){
            new CustomerInfo().setVisible(true);
            this.setVisible(false);
        }
        else if(ae.getSource()==b6){
            new Managerinfo().setVisible(true);
            this.setVisible(false);
        }
        else if(ae.getSource()==b7){
            new CheckOut().setVisible(true);
            this.setVisible(false);
        }
        else if(ae.getSource()==b8){
            new UpdateCheck().setVisible(true);
            this.setVisible(false);
        }
        else if(ae.getSource()==b9){
            new UpdateRoom().setVisible(true);
        this.setVisible(false);}
        else if(ae.getSource()==b10){
            new PickUp().setVisible(true);
            this.setVisible(false);
        }
        else if(ae.getSource()==b11){
            new SearchRoom().setVisible(true);
            this.setVisible(false);
        }
        else if(ae.getSource()==b12){setVisible(false);}

    }
}
