
package emp.gui;

import emp.dao.*;

import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.logging.*;

import javax.swing.*;
import javax.swing.UIManager.LookAndFeelInfo;


@SuppressWarnings("serial")
public class DeleteEmployee extends javax.swing.JFrame {

 
    public DeleteEmployee() {
    	JPanel  jPanel1 = new javax.swing.JPanel();
        JLabel   jLabel1 = new javax.swing.JLabel();
        JLabel  jLabel2 = new javax.swing.JLabel();
        JButton  btnDelete = new javax.swing.JButton();
        JButton  jButton2 = new javax.swing.JButton();
        JTextField  txtEmpNo = new javax.swing.JTextField();

          setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

          jPanel1.setBackground(new Color(0, 0, 0));

          jLabel1.setFont(new Font("Tahoma", 0, 14)); // NOI18N
          jLabel1.setForeground(new Color(255, 255, 255));
          jLabel1.setText("Delete Employee Frame");

          jLabel2.setForeground(new Color(255, 255, 255));
          jLabel2.setText("Emp No");

          btnDelete.setText("Delete Employee");
          btnDelete.addActionListener(new ActionListener() {
              public void actionPerformed(ActionEvent evt) {
            	  if(txtEmpNo.getText().isEmpty())
            	    {
            	        JOptionPane.showMessageDialog(null,"Please enter the emp no","Input not entered",JOptionPane.ERROR_MESSAGE);
            	    }
            	    else
            	    {
            	        try {
            	        int empno=Integer.parseInt(txtEmpNo.getText());
            	        
            	            if(EmpDao.deleteEmp(empno))
            	            {
            	                JOptionPane.showMessageDialog(null, "Record Successfully Deleted","Success!",JOptionPane.INFORMATION_MESSAGE);
            	            }
            	            else
            	            {
            	                JOptionPane.showMessageDialog(null, "Record deosn't exist","Error!",JOptionPane.ERROR_MESSAGE);
            	            }
            	        } 
            	        catch (SQLException ex) {
            	                JOptionPane.showMessageDialog(null, "SQL Exception","Exception",JOptionPane.ERROR_MESSAGE);
            	        }
            	    }
              }
          });

          jButton2.setText("Back");
          jButton2.addActionListener(new ActionListener() {
              public void actionPerformed(ActionEvent evt) {
            	  OptionFrame option = new OptionFrame();
            	  option.setVisible(true);
                 dispose();
              }
          });

          GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
          jPanel1.setLayout(jPanel1Layout);
          jPanel1Layout.setHorizontalGroup(
              jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
              .addGroup(jPanel1Layout.createSequentialGroup()
                  .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                      .addGroup(jPanel1Layout.createSequentialGroup()
                          .addGap(84, 84, 84)
                          .addComponent(btnDelete)
                          .addGap(52, 52, 52)
                          .addComponent(jButton2))
                      .addGroup(jPanel1Layout.createSequentialGroup()
                          .addGap(105, 105, 105)
                          .addComponent(jLabel2)))
                  .addContainerGap(96, Short.MAX_VALUE))
              .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                  .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                  .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                      .addComponent(jLabel1, GroupLayout.Alignment.TRAILING)
                      .addComponent(txtEmpNo, GroupLayout.Alignment.TRAILING,GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE))
                  .addGap(126, 126, 126))
          );
          jPanel1Layout.setVerticalGroup(
              jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
              .addGroup(jPanel1Layout.createSequentialGroup()
                  .addGap(49, 49, 49)
                  .addComponent(jLabel1)
                  .addGap(34, 34, 34)
                  .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                      .addComponent(jLabel2)
                      .addComponent(txtEmpNo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE))
                  .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 71, Short.MAX_VALUE)
                  .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                      .addComponent(btnDelete)
                      .addComponent(jButton2))
                  .addGap(86, 86, 86))
          );

          GroupLayout layout = new GroupLayout(getContentPane());
          getContentPane().setLayout(layout);
          layout.setHorizontalGroup(
              layout.createParallelGroup(GroupLayout.Alignment.LEADING)
              .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          );
          layout.setVerticalGroup(
              layout.createParallelGroup(GroupLayout.Alignment.LEADING)
              .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          );

          pack();
    	this.setLocationRelativeTo(this);
    }

    public static void main(String args[]) {
      
        try {
            for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DeleteEmployee.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(DeleteEmployee.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(DeleteEmployee.class.getName()).log(Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            Logger.getLogger(DeleteEmployee.class.getName()).log(Level.SEVERE, null, ex);
        }
     
       EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DeleteEmployee().setVisible(true);
            }
        });
    }
}