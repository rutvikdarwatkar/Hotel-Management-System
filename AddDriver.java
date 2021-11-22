package hotel.management.system;

import com.intellij.ui.components.JBLabel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class AddDriver extends JFrame implements ActionListener {

    JTextField t1,t2,t3,t4,t5;
    JRadioButton r1,r2;
    ButtonGroup G;
    JComboBox c1;
    JButton b1,b2;

    AddDriver() {

        JLabel l1=new JLabel("Add Drivers");
        l1.setBounds(90,15,170,30);
        l1.setFont(new Font("Arial black",Font.BOLD,22));
        l1.setForeground(Color.black);
        add(l1);

        JLabel name=new JLabel("Name");
        name.setForeground(Color.BLACK);
        name.setFont(new Font("serif",Font.BOLD,16));
        name.setBounds(30,70,150,30);
        add(name);

        t1 = new JTextField();
        t1.setBounds(150,70,140,30);
        add(t1);

        //--------------------------------------------------

        JLabel age=new JLabel("Age");
        age.setForeground(Color.BLACK);
        age.setFont(new Font("serif",Font.BOLD,16));
        age.setBounds(30,120,150,30);
        add(age);

        t2 = new JTextField();
        t2.setBounds(150,120,140,30);
        add(t2);

        //-----------------------------------------------------

        JLabel gender=new JLabel("Gender");
        gender.setForeground(Color.BLACK);
        gender.setFont(new Font("serif",Font.BOLD,16));
        gender.setBounds(30,170,150,30);
        add(gender);

         r1 = new JRadioButton("Male");
         r1.setBounds(150,170,70,30);
        r1.setFont(new Font("serif",Font.BOLD,17));
        r1.setBackground(Color.WHITE);
         add(r1);

        r2=new JRadioButton("Female");
        r2.setFont(new Font("serif",Font.BOLD,17));
        r2.setBackground(Color.WHITE);
        r2.setBounds(220,170,100,30);
        add(r2);

         G=new ButtonGroup();
         G.add(r1);
         G.add(r2);

         //---------------------------------------------------------

        JLabel carCompany=new JLabel("Car Company");
        carCompany.setForeground(Color.BLACK);
        carCompany.setFont(new Font("serif",Font.BOLD,16));
        carCompany.setBounds(30,220,150,30);
        add(carCompany);

        t3 = new JTextField();
        t3.setBounds(150,220,140,30);
        add(t3);

        //-------------------------------------------------------------

        JLabel carModel=new JLabel("Car Model");
        carModel.setForeground(Color.BLACK);
        carModel.setFont(new Font("serif",Font.BOLD,16));
        carModel.setBounds(30,270,150,30);
        add(carModel);

        t4 = new JTextField();
        t4.setBounds(150,270,140,30);
        add(t4);

        //----------------------------------------------------------------

        JLabel available=new JLabel("Available");
        available.setForeground(Color.BLACK);
        available.setFont(new Font("serif",Font.BOLD,16));
        available.setBounds(30,320,150,30);
        add(available);

        String str[]={"Yes","No"};
        c1=new JComboBox(str);
        c1.setBackground(Color.white);
        c1.setBounds(150,320,140,30);
        add(c1);

        //-------------------------------------------------------

        JLabel location=new JLabel("Location");
        location.setBounds(30,370,150,30);
        location.setFont(new Font("serif",Font.BOLD,16));
        location.setForeground(Color.BLACK);
        add(location);

        t5=new JTextField();
        t5.setBounds(150,370,140,30);
        add(t5);

        //--------------------------------------------------------

        b1=new JButton("Add Driver");
        b1.setBounds(30,420,130,30);
        b1.setFont(new Font("Arial black",Font.BOLD,16));
        b1.setBackground(Color.BLUE);
        b1.setForeground(Color.white);
        b1.addActionListener(this);
        add(b1);

        b2=new JButton("Cancel");
        b2.setBounds(175,420,120,30);
        b2.setFont(new Font("Arial black",Font.BOLD,16));
        b2.setBackground(Color.GRAY);
        b2.setForeground(Color.white);
        b2.addActionListener(this);
        add(b2);

        //--------------------------------------------------------------

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/eleven.jpg"));
        Image i2=i1.getImage().getScaledInstance(430,360,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel l2=new JLabel(i3);
        l2.setBounds(330,80,430,360);
        add(l2);


        setBounds(320, 120, 800, 510);
        setLayout(null);
        setVisible(true);
        getContentPane().setBackground(Color.white);
    }

    public static void main(String[] args) {

        new AddDriver().setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==b1){
            String name = t1.getText();
            String age=t2.getText();
            String carCompany=t3.getText();
            String carModel=t4.getText();
            String available=(String)c1.getSelectedItem();
            String location=t5.getText();

            String gender=null;
            if(r1.isSelected()){
                gender="Male";
            }else{
                gender="Female";
            }

            conn c=new conn();
            try {
                String str="insert into drivers values('"+name+"','"+age+"','"+gender+"','"+carCompany+"','"+carModel+"','"+available+"','"+location+"')";
                c.s.executeUpdate(str);
                JOptionPane.showMessageDialog(null,"New Driver Added");
                this.setVisible(false);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        }
        else if(ae.getSource()==b2){
            this.setVisible(false);
        }
    }
}