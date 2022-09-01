package emp.gui;

import emp.dao.EmpDao;
import emp.pojo.Employee;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.logging.*;
import javax.swing.*;
import javax.swing.UIManager.LookAndFeelInfo;

@SuppressWarnings("serial")
public class ShowAll extends JFrame {

    public ShowAll() {

        JPanel jPanel1 = new JPanel();
        JLabel jLabel1 = new JLabel();
        JScrollPane jScrollPane1 = new JScrollPane();
        JTextArea txtAllEmp = new JTextArea();
        JButton btnShowAllEmp = new JButton();
        JButton btnBack = new JButton();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new Color(0, 51, 102));
        jPanel1.setForeground(new Color(0, 51, 102));

        jLabel1.setFont(new Font("Courier New", 0, 20)); // NOI18N
        jLabel1.setForeground(new Color(255, 255, 255));
        jLabel1.setText("Details of Employees");

        txtAllEmp.setColumns(20);
        txtAllEmp.setRows(5);
        jScrollPane1.setViewportView(txtAllEmp);

        btnShowAllEmp.setText("show all records");
        btnShowAllEmp.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                try {
    
                    ArrayList<Employee> empList=EmpDao.getAllEmployee();
                    
                    if(empList.isEmpty())
                        {
                            JOptionPane.showMessageDialog(null,"This table has no records","Empty Table",JOptionPane.INFORMATION_MESSAGE);
                        }
                        else
                        {
                            String str=new String();
                            txtAllEmp.setText("");
                            str="Employee ID \t Name \t Salary\n\n";
                            for(Employee e:empList)
                            {
                                str=str+e.getId()+"\t"+e.getName()+"\t"+e.getSalary()+"\n";
                            }
                            txtAllEmp.setText(str);
                        }
            }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,"SQLException here","Exception",JOptionPane.ERROR_MESSAGE);
        }
     }
        });

        btnBack.setText("Back");
        btnBack.addActionListener(new ActionListener() {
     

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
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
                        .addGap(60, 60, 60)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 287,GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(89, 89, 89)
                        .addComponent(btnShowAllEmp)
                        .addGap(39, 39, 39)
                        .addComponent(btnBack)))
                .addContainerGap(64, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(btnShowAllEmp)
                    .addComponent(btnBack))
                .addGap(29, 29, 29))
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1,GroupLayout.DEFAULT_SIZE,GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1,GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    	this.setLocationRelativeTo(this);
    }


    public static void main(String args[]) {
       
        try {
            for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
           Logger.getLogger(ShowAll.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(ShowAll.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
           Logger.getLogger(ShowAll.class.getName()).log(Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            Logger.getLogger(ShowAll.class.getName()).log(Level.SEVERE, null, ex);
        }
      
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ShowAll().setVisible(true);
            }
        });
    }
}