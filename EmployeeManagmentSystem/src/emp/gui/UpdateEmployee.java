
package emp.gui;

import emp.dao.EmpDao;
import emp.pojo.Employee;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.logging.*;
import javax.swing.*;
import javax.swing.UIManager.LookAndFeelInfo;


@SuppressWarnings("serial")
public class UpdateEmployee extends JFrame {

    public UpdateEmployee() {
    	JPanel jPanel1 = new JPanel();
        JLabel jLabel1 = new JLabel();
        JLabel jLabel2 = new JLabel();
        JLabel jLabel3 = new JLabel();
        JLabel jLabel4 = new JLabel();
        JButton btnUpdateEmp = new JButton();
        JButton jButton2 = new JButton();
        JTextField txtEmpNo = new JTextField();
        JTextField txtEmpName = new JTextField();
        JTextField txtSal = new JTextField();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new Color(0, 0, 40));

        jLabel1.setFont(new Font("Courier New", 0, 20)); // NOI18N
        jLabel1.setForeground(new Color(255, 255, 255));
        jLabel1.setText("Update Employee Details");

        jLabel2.setForeground(new Color(255, 255, 255));
        jLabel2.setText("Employee ID");

        jLabel3.setForeground(new Color(255, 255, 255));
        jLabel3.setText("Update Name");

        jLabel4.setForeground(new Color(255, 255, 255));
        jLabel4.setText("Update Salary");

        btnUpdateEmp.setText("Update ");
        btnUpdateEmp.addActionListener(new ActionListener() {
        	 private boolean validateInput()
        	    {
        	        if(txtEmpNo.getText().isEmpty())
        	        {
        	            return false;
        	        }
        	        else
        	        {
        	            return true;
        	        }

        	    }
			@Override
			public void actionPerformed(ActionEvent evt) {
				// TODO Auto-generated method stub
				if(validateInput()==false)
		        {
		            JOptionPane.showMessageDialog(null,"Please enter Employee ID to update details","Input not entered",JOptionPane.ERROR_MESSAGE);
		            return;
		        }
		        else
		        {
		            try
		            {
		                Employee e=new Employee();
		                int empNo=Integer.parseInt(txtEmpNo.getText());
		                String eName=txtEmpName.getText();
		                double sal=Double.parseDouble(txtSal.getText());
		                
		                e.setId(empNo);
		                e.setName(eName);
		                e.setSalary(sal);
		                
		                if(EmpDao.updateEmployee(e))
		                {
		                    JOptionPane.showMessageDialog(null, "Record updated Successfully","Success!",JOptionPane.INFORMATION_MESSAGE);
		                }
		                else
		                {
		                    JOptionPane.showMessageDialog(null,"Please enter correct values","Input incorrect",JOptionPane.ERROR_MESSAGE);
		                }
		            }
		            catch(SQLException e)
		            {
		                JOptionPane.showMessageDialog(null,"SQL Exception here"+e.getMessage(),"Exception",JOptionPane.ERROR_MESSAGE);
		            }
		            catch(NumberFormatException e)
		            {
		                JOptionPane.showMessageDialog(null,"Number Format Exception ","Exception",JOptionPane.ERROR_MESSAGE);
		            } catch (HeadlessException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
		                
		        }				
			}
        });

        jButton2.setText("Back");
        jButton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
            	 OptionFrame option=new OptionFrame();
                 option.setVisible(true);
                 dispose();
            }
        });

        txtEmpNo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {

            }
        });

      GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(75, 75, 75))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnUpdateEmp)
                        .addGap(35, 35, 35)
                        .addComponent(jButton2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addGap(31, 31, 31)
                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtEmpNo, GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
                            .addComponent(txtSal)
                            .addComponent(txtEmpName))))
                .addContainerGap(86, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jLabel1)
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtEmpNo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtEmpName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtSal,GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(btnUpdateEmp)
                    .addComponent(jButton2))
                .addContainerGap(43, Short.MAX_VALUE))
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1,GroupLayout.DEFAULT_SIZE,GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE,GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
      Logger.getLogger(UpdateEmployee.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
          Logger.getLogger(UpdateEmployee.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(UpdateEmployee.class.getName()).log(Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
           Logger.getLogger(UpdateEmployee.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UpdateEmployee().setVisible(true);
            }
        });
    }
}