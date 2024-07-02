package university.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class Login extends JFrame implements ActionListener{
    JButton b1,b2;
    JTextField tfusername , tfpassword;
    Login(){
        
    getContentPane().setBackground(Color.white);
    setLayout(null);
    
    JLabel lbusername = new JLabel ("Username");
    lbusername.setBounds(40, 20, 100, 20);
    lbusername.setFont(new Font("Tahoma", Font.BOLD, 16));
    add(lbusername);
    
    tfusername = new JTextField();
    tfusername.setBounds(150,20,200,20);
    tfusername.setFont(new Font("Tahoma", Font.BOLD, 16));
    add(tfusername);
    
    
    JLabel lbpassword = new JLabel ("Password");
    lbpassword.setBounds(40, 60, 100, 20);
    lbpassword.setFont(new Font("Tahoma", Font.BOLD, 16));
    add(lbpassword);
    
    tfpassword = new JPasswordField();
    tfpassword.setBounds(150,60,200,20);
    add(tfpassword);
    
    b1 = new JButton("Login");
    b1.setBounds(40, 100, 120, 30);
    b1.setBackground(Color.pink);
    b1.setForeground(Color.black);
    b1.setFont(new Font("Tahoma", Font.BOLD, 16));
    b1.addActionListener(this);
    add(b1);
    
    b2 = new JButton("Cancel");
    b2.setBounds(180, 100, 120, 30);
    b2.setBackground(Color.pink);
    b2.setFont(new Font("Tahoma", Font.BOLD, 16));
    b2.addActionListener(this);
    add(b2);
    
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350,20,200,200);
        add(image);
    
    setSize(600,300);
    setLocation(500,250);
    setVisible(true);
    
    }
    public void actionPerformed(ActionEvent ae){
    
     if (ae.getSource()== b2) {
         setVisible(false);
     } 
     else if(ae.getSource()== b1){
        String username = tfusername.getText();
        String password = tfpassword.getText();
        
        String query =" select * from login where username='"+username+"' and password='"+password+"'";
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery(query);
            
            if(rs.next()){
                setVisible(false);
                new Project();
            }else {
               JOptionPane.showMessageDialog(null, "Invalid Username or password");
        }
            c.s.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    }
    public static void main (String[] args){
        new Login();
    }
}