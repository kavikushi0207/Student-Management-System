
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class student {
    public void insertUpdateDeleteStudent(char operation, Integer id, String fname,String lname,String sex, String dob,String phone,String address)
    {
        Connection con =myConnection.getConnection();
        PreparedStatement ps;
        //i for insert
        if(operation =='i')
        {
            try {
                ps=con.prepareStatement("INSERT INTO student( first_name, last_name, sex, DoB, phone, address) VALUES (?,?,?,?,?,?)");
                ps.setString(1, fname);
                ps.setString(2, lname);
                ps.setString(3, sex);
                ps.setString(4, dob);
                ps.setString(5, phone);
                ps.setString(6, address);
                if(ps.executeUpdate()>0)
                {
                    JOptionPane.showMessageDialog(null,"new student is added");
                }
                
                
                
            } catch (SQLException ex) {
                Logger.getLogger(student.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        //u for update
        if(operation =='u')
        {
            try {
                ps=con.prepareStatement("UPDATE student SET first_name = ? ,last_name = ? ,sex = ? ,DoB = ? ,phone = ? ,address = ? WHERE ID = ?");
                ps.setString(1, fname);
                ps.setString(2, lname);
                ps.setString(3, sex);
                ps.setString(4, dob);
                ps.setString(5, phone);
                ps.setString(6, address);
                ps.setInt(7,id);
                if(ps.executeUpdate()>0)
                {
                    JOptionPane.showMessageDialog(null,"student data is updated.");
                }
           
                
                
                
            } catch (SQLException ex) {
                Logger.getLogger(student.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        //d for remove
        if(operation =='d')
        {
            int yesOrNo = JOptionPane.showConfirmDialog(null, "the relevant scores also will be deleted","delete student",JOptionPane.OK_CANCEL_OPTION);
            if(yesOrNo==0)
            {
                try {
                ps=con.prepareStatement("DELETE FROM `student` WHERE `id`=?");
                
                ps.setInt(1,id);
                if(ps.executeUpdate()>0)
                {
                    JOptionPane.showMessageDialog(null,"A data row is deleted successfully!");
                }
                
                
                
            } catch (SQLException ex) {
                Logger.getLogger(student.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
            
        }
        
    }
    public static void fillStudentJtable(JTable table, String valueToSearch) {
        Connection con = myConnection.getConnection();
        PreparedStatement ps;
        try {
            ps = con.prepareStatement("SELECT * FROM `student` WHERE CONCAT(`first_name`,`last_name`,`phone`,`address`) LIKE ?");
            ps.setString(1, "%"+valueToSearch+"%");
            
            ResultSet rs =ps.executeQuery();
            DefaultTableModel model =(DefaultTableModel)table.getModel();
            Object[] row;
            
            while(rs.next())
            {
                row= new Object[7];
                row[0]=rs.getInt(1);
                row[1]=rs.getString(2);
                row[2]=rs.getString(3);
                row[3]=rs.getString(4);
                row[4]=rs.getString(5);
                row[5]=rs.getString(6);
                row[6]=rs.getString(7);
                
                model.addRow(row);   
            }
        } catch (SQLException ex) {
            Logger.getLogger(student.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
   
}
