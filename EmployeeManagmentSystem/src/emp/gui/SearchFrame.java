
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
public class SearchFrame extends JFrame {

    public SearchFrame() {
        
        JFormattedTextField jFormattedTextField1 = new JFormattedTextField();
        JPanel jPanel1 = new JPanel();
        JLabel jLabel1 = new JLabel();
        JTextField txtEmpNumber = new JTextField();
        JLabel jLabel2 = new JLabel();
        JLabel jLabel3 = new JLabel();
        JLabel jLabel4 = new JLabel();
        JTextField txtEmpName = new JTextField();
        JTextField txtSalary = new JTextField();
        JButton jButton1 = new JButton();
        JButton jButton2 = new JButton();

        jFormattedTextField1.setText("jFormattedTextField1");

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new Color(60, 0, 0));

        jLabel1.setFont(new Font("Courier New", 0, 20)); 
        jLabel1.setForeground(new Color(240, 240, 240));
        jLabel1.setText("Search Employee Details");

        txtEmpNumber.addActionListener(new ActionListener() {
            
			@Override
			public void actionPerformed(ActionEvent evt) {
				// TODO Auto-generated method stub
				
			}
        });

        jLabel2.setForeground(new Color(255, 255, 255));
        jLabel2.setText("Employee ID");

        jLabel3.setForeground(new Color(255, 255, 255));
        jLabel3.setText("Employee Name");

        jLabel4.setForeground(new Color(255, 255, 255));
        jLabel4.setText("Total Salary");

        jButton1.setText("Search Here");
        jButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
            	if(txtEmpNumber.getText().isEmpty())
                {
                    JOptionPane.showMessageDialog(null,"Please Enter Name of Employee ","Something went wrong",JOptionPane.ERROR_MESSAGE);
                }
                else
                {
                    try 
                    {
                        
                        int e=Integer.parseInt(txtEmpNumber.getText());
                        Employee emp=EmpDao.searchEmployee(e);
                        if(emp==null)
                        {
                            JOptionPane.showMessageDialog(null,"No Record Found","No record",JOptionPane.INFORMATION_MESSAGE);
                        }
                        else
                        {
                        txtEmpName.setText(emp.getName());
                        txtSalary.setText(Double.toString(emp.getSalary()));
                        }
                    } 
                    catch (SQLException ex) 
                    {
                        JOptionPane.showMessageDialog(null,"SQL Exception here","Exception",JOptionPane.ERROR_MESSAGE);
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

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(96, 96, 96)
                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(jButton1))
                        .addGap(36, 36, 36)
                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtEmpNumber, GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE)
                                .addComponent(txtEmpName)
                                .addComponent(txtSalary))
                            .addComponent(jButton2))))
                .addContainerGap(100, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jLabel1)
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtEmpNumber,GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtEmpName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtSalary,GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(47, Short.MAX_VALUE))
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1,GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
            Logger.getLogger(SearchFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(SearchFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(SearchFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            Logger.getLogger(SearchFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        	EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SearchFrame().setVisible(true);
            }
        });
    }

}