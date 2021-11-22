package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class HotelManagementSystem extends JFrame implements ActionListener {

    HotelManagementSystem(){
        setBounds(10,55,1366,565);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/first.jpg"));
        JLabel l1=new JLabel(i1);
        l1.setBounds(0,0,1366,565);
        add(l1);

        JLabel l2=new JLabel("Hotel Management System");
        l2.setBounds(20,420,1000,90);
        l2.setForeground(Color.white);        //Font colour
        l2.setFont(new Font("serif",Font.BOLD,70));
        l1.add(l2);

        JButton b1=new JButton("Next");
        b1.setBackground(Color.WHITE);      //background colour
        b1.setForeground(Color.black);
        b1.setBounds(1150,455,100,30);
        b1.setFont(new Font("serif",Font.BOLD,25));  //Font settings
        b1.addActionListener(this);         //button performs action
        l1.add(b1);

        setLayout(null);
        setVisible(true);

        while(true){                //blinking main screen
            l2.setVisible(false);
            try{
                Thread.sleep(500);

            }
            catch(Exception e){

            }
            l2.setVisible(true);
            try {Thread.sleep(500);
        }
            catch(Exception e){}
        }
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        new Login().setVisible(true);
        this.setVisible(false);

    }

    public static void main(String[] args) {
        HotelManagementSystem hsm=  new HotelManagementSystem();

    }


}
