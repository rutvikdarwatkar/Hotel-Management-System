package hotel.management.system;

import b.a.J;
import com.intellij.ui.components.JBLabel;
import com.mysql.cj.protocol.Resultset;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class AddCustomer extends JFrame implements ActionListener {
    JComboBox c1;
    Choice c2;
    JComboBox c3;
    JTextField t1,t2,t3,t4,t5;
    JRadioButton r1,r2;
    ButtonGroup g1;
    JButton b1,b2;

    AddCustomer(){
        JLabel l1=new JLabel("New Customer Form");
        l1.setBounds(70,20,250,30);
        l1.setFont(new Font("Arial black",Font.BOLD,18));
        l1.setForeground(Color.BLUE);
        add(l1);

        JLabel id=new JLabel("ID");
        id.setBounds(40,70,80,30);
        id.setFont(new Font("arial black",Font.PLAIN,13));
        id.setForeground(Color.black);
        add(id);

        String str[]={"Passport","Aadhar card","Driving license"};
        c1=new JComboBox(str);
        c1.setBounds(200,70,150,30);
        c1.setBackground(Color.white);
        add(c1);

        JLabel number=new JLabel("Number");
        number.setBounds(40,110,80,30);
        number.setFont(new Font("arial black",Font.PLAIN,13));
        number.setForeground(Color.black);
        add(number);

        t1=new JTextField();
        t1.setBounds(200,110,150,30);
        add(t1);

        JLabel name=new JLabel("Name");
        name.setBounds(40,150,80,30);
        name.setFont(new Font("arial black",Font.PLAIN,13));
        name.setForeground(Color.black);
        add(name);

        t2=new JTextField();
        t2.setBounds(200,150,150,30);
        add(t2);

        JLabel gender=new JLabel("Gender");
        gender.setBounds(40,190,80,30);
        gender.setFont(new Font("arial black",Font.PLAIN,13));
        gender.setForeground(Color.black);
        add(gender);

        r1=new JRadioButton("Male");
        r1.setBounds(200,190,70,30);
        r1.setFont(new Font("serif",Font.BOLD,14));
        r1.setBackground(Color.white);
        add(r1);

        r2=new JRadioButton("Female");
        r2.setBounds(270,190,80,30);
        r2.setFont(new Font("serif",Font.BOLD,14));
        r2.setBackground(Color.white);
        add(r2);

        g1=new ButtonGroup();
        g1.add(r1);
        g1.add(r2);

        JLabel country=new JLabel("Country");
        country.setBounds(40,230,80,30);
        country.setFont(new Font("arial black",Font.PLAIN,13));
        country.setForeground(Color.black);
        add(country);

        t3=new JTextField();
        t3.setBounds(200,230,150,30);
        add(t3);

        JLabel room=new JLabel("Allocated Room no.");
        room.setBounds(40,270,150,30);
        room.setFont(new Font("arial black",Font.PLAIN,13));
        room.setForeground(Color.black);
        add(room);


        c2=new Choice();
        try{
            conn c=new conn();
            String st="select * from room where availability='Available'";
            ResultSet rs= c.s.executeQuery(st);
            while (rs.next()){
                c2.add(rs.getString("room_number"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


//        c2=new JComboBox(s1);
        c2.setBounds(200,270,150,30);
        c2.setBackground(Color.white);
        add(c2);

        JLabel status=new JLabel("Checked in");
        status.setBounds(40,310,150,30);
        status.setFont(new Font("arial black",Font.PLAIN,13));
        status.setForeground(Color.black);
        add(status);

        t4=new JTextField();
        t4.setBounds(200,310,150,30);
        add(t4);

        JLabel deposit=new JLabel("Deposit");
        deposit.setBounds(40,350,150,30);
        deposit.setFont(new Font("arial black",Font.PLAIN,13));
        deposit.setForeground(Color.black);
        add(deposit);

        t5=new JTextField();
        t5.setBounds(200,350,150,30);
        add(t5);

        b1=new JButton("Add Customer");
        b1.setBounds(40,400,150,30);
        b1.setForeground(Color.white);
        b1.setBackground(Color.blue);
        b1.setFont(new Font("Arial black",Font.BOLD,14));
        b1.addActionListener(this);
        add(b1);

        b2=new JButton("Back");
        b2.setBounds(200,400,150,30);
        b2.setForeground(Color.black);
        b2.setBackground(Color.lightGray);
        b2.setFont(new Font("Arial black",Font.BOLD,14));
        b2.addActionListener(this);
        add(b2);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("Hotel/Management/System/icons/one.png"));
        Image i2=i1.getImage().getScaledInstance(490,500,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel f1=new JLabel(i3);
        f1.setBounds(350,0,500,500);
        add(f1);


        getContentPane().setBackground(Color.white);
        setLayout(null);
        setBounds(250,100,850,500);
        setVisible(true);
    }

    public static void main(String[] args) {
        new AddCustomer().setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==b1){
            String id= (String) c1.getSelectedItem();
            String number=t1.getText();
            String name=t2.getText();
            String country=t3.getText();
            String room= (String) c2.getSelectedItem();
            String status=t4.getText();
            String deposit=t5.getText();

            String gender=null;
            if(r1.isSelected()){
                gender="Male";
            }else {
                gender="Female";
            }

            String str="insert into customer values('"+id+"','"+number+"','"+name+"','"+gender+"','"+country+"','"+room+"','"+status+"','"+deposit+"')";
            String str2="update room set availability ='Occupied' where room_number ='"+room+"'";

            try{
                conn c=new conn();

                c.s.executeUpdate(str);
                c.s.executeUpdate(str2);

                JOptionPane.showMessageDialog(null,"New Customer Added");
                new Reception().setVisible(true);
                this.setVisible(false);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else if(ae.getSource()==b2){
            new Reception().setVisible(true);
            this.setVisible(false);}


    }
}
