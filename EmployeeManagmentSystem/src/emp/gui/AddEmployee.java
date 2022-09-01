package emp.gui;

import emp.dao.EmpDao;
import emp.pojo.Employee;
import java.awt.*;
import java.awt.event.*;
import java.util.logging.*;
import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.UIManager.LookAndFeelInfo;

@SuppressWarnings("serial")
public class AddEmployee extends JFrame {

	public AddEmployee() {

		JPanel jPanel1 = new JPanel();
		JLabel jLabel1 = new JLabel();
		JLabel jLabel2 = new JLabel();
		JLabel jLabel3 = new JLabel();
		JLabel jLabel4 = new JLabel();
		JTextField txtEmpNo = new JTextField();
		JTextField txtEmpName = new JTextField();
		JTextField txtSal = new JTextField();
		JButton AddEmp = new JButton();
		JButton jButton2 = new JButton();

		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		jPanel1.setBackground(new Color(0, 0, 60));

		jLabel1.setFont(new Font("Courier New", 0, 25)); 
		jLabel1.setForeground(new Color(240, 240, 240));
		jLabel1.setText("Add Employee");

		jLabel2.setForeground(new Color(240, 240, 240));
		jLabel2.setText("Employee Id");

		jLabel3.setForeground(new Color(240, 240, 240));
		jLabel3.setText("Name");

		jLabel4.setForeground(new Color(240, 240, 240));
		jLabel4.setText("Salary");

		AddEmp.setText("Enter");
		AddEmp.addActionListener(new ActionListener() {
			public boolean validateInput() {
				if (txtEmpNo.getText().isEmpty() || txtEmpName.getText().isEmpty() || txtSal.getText().isEmpty())  
				{
					return false;
				} 
				else 
				{
					return true;
				}

			}
			public void actionPerformed(ActionEvent evt) {
				if (validateInput() == false) 
				{
					JOptionPane.showMessageDialog(null, "Please enter all details", "Input not entered",JOptionPane.ERROR_MESSAGE);
					
					return;
				} 
				else 
				{
					try 
					{
						Employee e = new Employee();
						int empNo = Integer.parseInt(txtEmpNo.getText());
						String eName = txtEmpName.getText();
						double sal = Double.parseDouble(txtSal.getText());
						e.setId(empNo);
						e.setName(eName);
						e.setSalary(sal);

						if (EmpDao.addEmployee(e))// a method that returns true if all correct values inserted
						{
							JOptionPane.showMessageDialog(null, "Record inserted Successfully", "Success!",
									JOptionPane.INFORMATION_MESSAGE);
						} else {
							JOptionPane.showMessageDialog(null, "Please enter correct values", "Input incorrect",
									JOptionPane.ERROR_MESSAGE);
						}

					} catch (Exception e) {
						JOptionPane.showMessageDialog(null, "SQL Exception ", "Exception", JOptionPane.ERROR_MESSAGE);
					}
				}

			}
		});

		jButton2.setText("Back");
		jButton2.addActionListener(new ActionListener() {
		
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			OptionFrame option = new OptionFrame();
				option.setVisible(true);
				dispose();	
			}
		});

		GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup()
						.addGroup(jPanel1Layout
						.createParallelGroup(Alignment.LEADING)
						.addGroup(jPanel1Layout.createSequentialGroup()
								.addGap(98, 98, 98)
								.addComponent(jLabel4))
						.addGroup(jPanel1Layout.createSequentialGroup()
								.addGap(145, 145, 145)
								.addComponent(AddEmp)
								.addGap(30, 30, 30)
								.addComponent(jButton2))
						.addGroup(jPanel1Layout.createSequentialGroup()
								.addGap(64, 64, 64)
								.addGroup(jPanel1Layout.createParallelGroup(Alignment.TRAILING)
										.addComponent(jLabel3)
										.addComponent(jLabel2))
								.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
										.addGroup(jPanel1Layout.createSequentialGroup()
												.addGap(18, 18, 18)
												.addComponent(jLabel1))
										.addGroup(jPanel1Layout.createSequentialGroup()
												.addGap(18, 18, 18)
												.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING,false)
														.addComponent(txtEmpName, GroupLayout.DEFAULT_SIZE,143, Short.MAX_VALUE)
														.addComponent(txtEmpNo).addComponent(txtSal))))))
						.addContainerGap(95, Short.MAX_VALUE)));
		
		
		jPanel1Layout.setVerticalGroup(
				jPanel1Layout.createParallelGroup(Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup()
						.addGap(46, 46, 46)
						.addComponent(jLabel1)
						.addGap(30, 30, 30)
						.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel2)
								.addComponent(txtEmpNo,GroupLayout.PREFERRED_SIZE,GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE))
						.addGap(18, 18, 18)
						.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
								.addComponent(jLabel3)
								.addComponent(txtEmpName, GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(18, 18, 18)
						.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
								.addComponent(jLabel4).addComponent(txtSal, GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(38, 38, 38)
						.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(AddEmp).addComponent(jButton2))
						.addContainerGap(47, Short.MAX_VALUE)));

		GroupLayout layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(Alignment.LEADING)
				.addComponent(jPanel1, GroupLayout.DEFAULT_SIZE,GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
		layout.setVerticalGroup(layout.createParallelGroup(Alignment.LEADING)
				.addComponent(jPanel1,GroupLayout.DEFAULT_SIZE,GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

		pack();

		this.setLocationRelativeTo(this);
		// DBConnection.getConnection();
	}

	public static void main(String args[]) {
		
		try {
			for (LookAndFeelInfo info :UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} 
		catch (ClassNotFoundException ex) {
			
			Logger.getLogger(AddEmployee.class.getName()).log(Level.SEVERE,null, ex);
		}
		catch (InstantiationException ex) {
			Logger.getLogger(AddEmployee.class.getName()).log(Level.SEVERE,null, ex);
		} 
		catch (IllegalAccessException ex) {
			Logger.getLogger(AddEmployee.class.getName()).log(Level.SEVERE,null, ex);
		}
		catch (UnsupportedLookAndFeelException ex) {
			Logger.getLogger(AddEmployee.class.getName()).log(Level.SEVERE,null, ex);
		}
	
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				new AddEmployee().setVisible(true);
			}
		});
	}


}