
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class course {
    
      public void insertUpdateDeleteStudent(char operation, Integer id, String courseTitle,Integer hours)
    {
        Connection con =myConnection.getConnection();
        PreparedStatement ps;
        //i for insert
        if(operation =='i')
        {
            try {
                ps=con.prepareStatement("INSERT INTO `course`( `Lable`, `hours number`) VALUES (?,?)");
                ps.setString(1, courseTitle);
                ps.setInt(2, hours);
                
                if(ps.executeUpdate()>0)
                {
                    JOptionPane.showMessageDialog(null,"new course is added");
                }
                
                
                
            } catch (SQLException ex) {
                Logger.getLogger(student.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        //u for update
        if(operation =='u')
        {
            try {
                ps=con.prepareStatement("UPDATE `course` SET `Lable`=?,`hours number`=? WHERE `ID`=?");
                ps.setString(1, courseTitle);
                ps.setInt(2, hours);
                
                ps.setInt(3,id);
                if(ps.executeUpdate()>0)
                {
                    JOptionPane.showMessageDialog(null,"course info is updated.");
                }
           
                
                
                
            } catch (SQLException ex) {
                Logger.getLogger(student.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        //d for remove
        if(operation =='d')
        {int yesOrNo = JOptionPane.showConfirmDialog(null, "the relevant scores also will be deleted","delete student",JOptionPane.OK_CANCEL_OPTION);
            if(yesOrNo==JOptionPane.OK_OPTION)
            {
                try {
                ps=con.prepareStatement("DELETE FROM `course` WHERE `id`=?");
                
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
      public boolean isCourseExist(String courseName)
      {
         boolean isExist = false; 
        Connection con = myConnection.getConnection();
        PreparedStatement ps;
        try {
            ps = con.prepareStatement("SELECT * FROM course WHERE Lable = ?");
            ps.setString(1, courseName);
            
            ResultSet rs =ps.executeQuery();
           
            
            if(rs.next())
            {
                   isExist = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(student.class.getName()).log(Level.SEVERE, null, ex);
        }
          
          return  isExist;
      }
      
      public static void fillCourseJtable(JTable table) {
        Connection con = myConnection.getConnection();
        PreparedStatement ps;
        try {
            ps = con.prepareStatement("SELECT * FROM `course` ");
           
            
            ResultSet rs =ps.executeQuery();
            DefaultTableModel model =(DefaultTableModel)table.getModel();
            Object[] row;
            
            while(rs.next())
            {
                row= new Object[3];
                row[0]=rs.getInt(1);
                row[1]=rs.getString(2);
                row[2]=rs.getInt(3);
                
                
                model.addRow(row);   
            }
        } catch (SQLException ex) {
            Logger.getLogger(student.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
      public int getCourseId (String courseTitle)
      {
            int courseId = 0;
            Connection con = myConnection.getConnection();
            PreparedStatement ps;
            try {
                ps = con.prepareStatement("SELECT * FROM course WHERE Lable = ?");
                ps.setString(1, courseTitle);

                ResultSet rs =ps.executeQuery();


                if(rs.next())
                {
                       courseId = rs.getInt("Id");
                }
            } catch (SQLException ex) {
                Logger.getLogger(student.class.getName()).log(Level.SEVERE, null, ex);
            }
          
          return courseId;
      }
      
      public static void fillCourseCombo(JComboBox combo) {
        Connection con = myConnection.getConnection();
        PreparedStatement ps;
        try {
            ps = con.prepareStatement("SELECT * FROM `course` ");
           
            
            ResultSet rs =ps.executeQuery();
            
            
            while(rs.next())
            {
                combo.addItem(rs.getString(2));
                
                
               
            }
        } catch (SQLException ex) {
            Logger.getLogger(student.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
        
    
}
