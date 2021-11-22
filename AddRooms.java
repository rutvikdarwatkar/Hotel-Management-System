package hotel.management.system;

import b.c.F;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddRooms extends JFrame implements ActionListener {

    JTextField t1,t2;
    JButton b1,b2;
    JComboBox c1,c2,c3;

    AddRooms(){

        JLabel addRooms=new JLabel("Add Rooms");
        addRooms.setForeground(Color.BLACK);
        addRooms.setFont(new Font("Arial Black",Font.BOLD,18));
        addRooms.setBounds(110,20,200,30);
        add(addRooms);

        JLabel roomnumber=new JLabel("Room Number");
        roomnumber.setForeground(Color.BLACK);
        roomnumber.setFont(new Font("serif",Font.BOLD,16));
        roomnumber.setBounds(30,70,150,30);
        add(roomnumber);

        t1 = new JTextField();
        t1.setBounds(170,70,140,30);
        add(t1);

        JLabel availability=new JLabel("Availability");
        availability.setForeground(Color.BLACK);
        availability.setFont(new Font("serif",Font.BOLD,16));
        availability.setBounds(30,120,150,30);
        add(availability);

        String str[]={"Available","Occupied"};
         c1=new JComboBox(str);
        c1.setBackground(Color.white);
        c1.setBounds(170,120,140,30);
        add(c1);

        JLabel cleaning=new JLabel("Cleaning Status");
        cleaning.setForeground(Color.BLACK);
        cleaning.setFont(new Font("serif",Font.BOLD,16));
        cleaning.setBounds(30,170,150,30);
        add(cleaning);

        String clean[]={"Cleaned","Dirty"};
         c2=new JComboBox(clean);
        c2.setBackground(Color.white);
        c2.setBounds(170,170,140,30);
        add(c2);

        JLabel price=new JLabel("Price");
        price.setForeground(Color.BLACK);
        price.setFont(new Font("serif",Font.BOLD,16));
        price.setBounds(30,220,150,30);
        add(price);

        t2 = new JTextField();
        t2.setBounds(170,220,140,30);
        add(t2);

        JLabel bedtype=new JLabel("Bed Type");
        bedtype.setForeground(Color.BLACK);
        bedtype.setFont(new Font("serif",Font.BOLD,16));
        bedtype.setBounds(30,270,150,30);
        add(bedtype);

        String bed[]={"Single Bed","Double Bed"};
         c3=new JComboBox(bed);
        c3.setBackground(Color.white);
        c3.setBounds(170,270,140,30);
        add(c3);

        b1=new JButton("Add Room");
        b1.setBackground(Color.blue);
        b1.setForeground(Color.white);
        b1.setFont(new Font("Arial Black",Font.PLAIN,16));
        b1.setBounds(30,320,130,30);
        b1.addActionListener(this);
        add(b1);

        b2=new JButton("Cancel");
        b2.setBackground(Color.GRAY);
        b2.setForeground(Color.white);
        b2.setFont(new Font("Arial Black",Font.PLAIN,16));
        b2.setBounds(180,320,130,30);
        b2.addActionListener(this);
        add(b2);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("Hotel/Management/System/icons/eight.jpg"));
        Image i2=i1.getImage().getScaledInstance(340,330,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel l3=new JLabel(i3);
        l3.setBounds(340,30,340,330);
        add(l3);

        getContentPane().setBackground(Color.white);

        setBounds(320,120,720,420);
        setLayout(null);
        setVisible(true);
    }

 public static void main(String[] args){
        new AddRooms().setVisible(true);
 }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource()==b1){
            String roomnumber=t1.getText();
            String price=t2.getText();
            String availability=(String)c1.getSelectedItem();
            String cleaningstatus=(String)c2.getSelectedItem();
            String bedtype=(String)c3.getSelectedItem();

            conn c=new conn();
            try {
                String str="insert into room values('"+roomnumber+"','"+availability+"','"+cleaningstatus+"','"+price+"','"+bedtype+"')";
                c.s.executeUpdate(str);

//                JOptionPane.showMessageDialog(null,"New Room Added");
                JOptionPane p1 = new JOptionPane();
                p1.setSize(20,15);
                p1.setFont(new Font("Arial black",Font.PLAIN,15));
                p1.showMessageDialog(null,"New Room Added");
                
                add(p1);
                this.setVisible(false);
            }
            catch(Exception e){
                System.out.println(e);
            }
        }
        else if (ae.getSource()==b2){
            this.setVisible(false);
        }
    }
}
