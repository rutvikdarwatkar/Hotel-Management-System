package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


public class Login extends JFrame implements ActionListener {

    JLabel l1,l2;
    JTextField t1;
    
    JPasswordField t2;
    JButton b1,b2;

    Login(){

        setBounds(450,200,520,250);

        l1=new JLabel("Username");
        l1.setFont(new Font("Arial",Font.BOLD,13));
        l1.setBounds(40,40,100,30);
        add(l1);

        l2=new JLabel("Password");
        l2.setFont(new Font("Arial",Font.BOLD,13));
        l2.setBounds(40,90,100,30);
        add(l2);

        t1=new JTextField();                          //blank box for text
        t1.setBounds(150,40,140,30);
        add(t1);

        t2=new JPasswordField();                        //only . are seen for password
        t2.setBounds(150,90,140,30);
        add(t2);

        b1=new JButton("Login");        //creating Login button
        b1.setBackground(Color.blue);

        b1.setForeground(Color.white);
        b1.setFont(new Font("Arial black",Font.BOLD,15));
        b1.setBounds(40,150,100,30);
        b1.addActionListener(this);
        add(b1);

        b2=new JButton("Cancel");       //creating cancel button
        b2.setBackground(Color.GRAY);
        b2.setForeground(Color.white);
        b2.setFont(new Font("Arial black",Font.BOLD,15));
        b2.setBounds(180,150,100,30);
        b2.addActionListener(this);
        add(b2);

        //inserting image in frame
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/second.jpg"));

        //for resizing width and height of given image
        Image i2=i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2); //again convert it in image icon and put in label
        JLabel l3=new JLabel(i3);
        l3.setBounds(300,10,200,200);
        add(l3);

        getContentPane().setBackground(Color.white);    //change background of the frame

        setLayout(null);
        setVisible(true);
    }
    
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b1){
            String username=t1.getText();
            String password=t2.getText();
            conn c=new conn();

            String str="select * from login where username = '"+username+"' and password = '"+password+"'";
            try{
                ResultSet rs=c.s.executeQuery(str);
                
                if(rs.next()){
                    new Dashboard().setVisible(true);  //connect next screen
                    this.setVisible(false);
                }
                else{
                    JOptionPane.showMessageDialog(null,"Invalid Username & Password");
                    this.setVisible(true);
                    }

            }
            catch(Exception e){

            }

        }
        else if(ae.getSource()==b2){
            this.setVisible(false);
        }
    }

    public static void main(String[] args) {

        new Login().setVisible(true);
    }

}


