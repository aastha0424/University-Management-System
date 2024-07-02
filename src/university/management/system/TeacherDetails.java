package university.management.system;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import net.proteanit.sql.DbUtils;
public class TeacherDetails extends JFrame implements ActionListener{
    
    Choice cempno;
    JTable table;
   JButton search , update, print, add, cancel;
    TeacherDetails(){
        
        getContentPane().setBackground(Color.WHITE);      
        setLayout(null);
        
        JLabel heading = new JLabel("Search by empno Number");
        heading.setBounds(20,20,150,20);
        add(heading);
        
        cempno = new Choice();
        cempno.setBounds(180, 20 , 150, 20);
        add(cempno);
        
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from  Teacher");
            while (rs.next()){
                cempno.add(rs.getString("empno"));
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        
        table = new JTable();
        
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from  Teacher");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e){
            e.printStackTrace();
        }
        
        
        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0,100,900,600);
        add(jsp);
        
        
        search = new JButton("search");
        search.setBounds(20,70,80,20);
        search.addActionListener(this);
        add(search);
                
        print = new JButton("print");
        print.setBounds(120,70,80,20);
        print.addActionListener(this);
        add(print); 
        
        add = new JButton("add");
        add.setBounds(220,70,80,20);
        add.addActionListener(this);
        add(add); 
        
        update = new JButton("update");
        update.setBounds(320,70,80,20);
        update.addActionListener(this);
        add(update);
        
        cancel = new JButton("cancel");
        cancel.setBounds(420,70,80,20);
        cancel.addActionListener(this);
        add(cancel);
                
                
        setSize(900,700);
        setLocation(300,100);
        setVisible (true);
    }
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == print){
            try{
                table.print();
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
        
        else if(ae.getSource()== add){
        setVisible(false);
        new AddTeacher();
    }
        else if (ae.getSource() == cancel){
            setVisible(false);
        }
        else if(ae.getSource() == update){
            setVisible (false);
            //new UpdateTeacher();
        }
        else if (ae.getSource() == search){
            String query = "select * from Teacher where empno = '"+cempno.getSelectedItem()+"'";
            try{
               Conn c = new Conn(); 
               ResultSet rs = c.s.executeQuery(query);
               table.setModel(DbUtils.resultSetToTableModel(rs));
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] srgs){
        new TeacherDetails();
    }
}
