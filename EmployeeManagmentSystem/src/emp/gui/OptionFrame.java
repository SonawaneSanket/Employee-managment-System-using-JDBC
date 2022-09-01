package emp.gui;

import java.awt.*;
import java.awt.event.*;
import java.util.logging.*;
import javax.swing.*;
import javax.swing.UIManager.*;
import javax.swing.GroupLayout.Alignment;


@SuppressWarnings("serial")
public class OptionFrame extends JFrame {

    public OptionFrame() {
    	JButton jButton1 = new JButton();
        ButtonGroup buttonGroup1 = new ButtonGroup();
        JPanel jPanel1 = new JPanel();
        JRadioButton jrbAddEmp = new JRadioButton();
        JRadioButton jrbSearchEmp = new JRadioButton();
        JRadioButton jrbShowAllEmp = new JRadioButton();
        JRadioButton jrbDeleteEmp = new JRadioButton();
        JRadioButton jrbQuit = new JRadioButton();
        JLabel jLabel1 = new JLabel();
        JButton dotask = new JButton();
        JRadioButton jrbUpdateEmp = new JRadioButton();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new Color(0, 0, 80));

        jrbAddEmp.setBackground(new Color(0, 0, 0));
        buttonGroup1.add(jrbAddEmp);
        jrbAddEmp.setForeground(new Color(240, 240, 240));
        jrbAddEmp.setText("Add Employee ");
        jrbAddEmp.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                                
            }
        });

        jrbSearchEmp.setBackground(new Color(0, 0, 0));
        buttonGroup1.add(jrbSearchEmp);
        jrbSearchEmp.setForeground(new Color(240, 240, 240));
        jrbSearchEmp.setText("Search Employee");

        jrbShowAllEmp.setBackground(new Color(0, 0, 0));
        buttonGroup1.add(jrbShowAllEmp);
        jrbShowAllEmp.setForeground(new Color(240, 240, 240));
        jrbShowAllEmp.setText("View All Employees");

        jrbDeleteEmp.setBackground(new Color(0, 0, 0));
        buttonGroup1.add(jrbDeleteEmp);
        jrbDeleteEmp.setForeground(new Color(240, 240, 240));
        jrbDeleteEmp.setText("Remove Employee");

        jrbUpdateEmp.setBackground(new Color(0, 0, 0));
        buttonGroup1.add(jrbUpdateEmp);
        jrbUpdateEmp.setForeground(new Color(240, 240, 240));
        jrbUpdateEmp.setText("Update Employee Details");
        
        jrbQuit.setBackground(new Color(0, 0, 0));
        buttonGroup1.add(jrbQuit);
        jrbQuit.setForeground(new Color(240, 240, 240));
        jrbQuit.setText("Exit");

        jLabel1.setFont(new Font("Courier New", 0, 22));
        jLabel1.setForeground(new Color(240, 240, 240));
        jLabel1.setText("Welcome to the Project of Employee Managment System");

        dotask.setText("Enter");
        dotask.addActionListener(new ActionListener() {
        
			@Override
			public void actionPerformed(ActionEvent evt) {
				// TODO Auto-generated method stub
				  if(jrbAddEmp.isSelected())
                  {
                      AddEmployee add=new AddEmployee();
                      add.setVisible(true);
                      dispose();
                  }
                  else if (jrbSearchEmp.isSelected())
                  {
                      SearchFrame search=new SearchFrame ();
                      search.setVisible(true);
                      dispose();
                  }
                  else if(jrbShowAllEmp.isSelected())
                  {
                      ShowAll show=new ShowAll();
                      show.setVisible(true);
                     dispose();
                  }
                  else if(jrbUpdateEmp.isSelected())
                  {
                      UpdateEmployee update=new UpdateEmployee();
                      update.setVisible(true);
                     dispose();
                  }
                  else if(jrbDeleteEmp.isSelected())
                  {
                      DeleteEmployee delete=new DeleteEmployee();
                      delete.setVisible(true);
                   dispose();
                  }
                  else if(jrbQuit.isSelected())
                  {
                      int ans=0;
                      ans=JOptionPane.showConfirmDialog(null, "Are you sure?", "Quitting", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
                      if(ans==JOptionPane.YES_OPTION)
                      {
                          System.exit(0);
                      }    
                      
                  }
                  else
                  {
                      JOptionPane.showMessageDialog(null,"Please select an option","Error",JOptionPane.ERROR_MESSAGE);
                  }	
			}
        });

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(70,70,70)
                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(jrbSearchEmp)
                            .addComponent(jrbAddEmp)
                            .addComponent(jrbShowAllEmp)
                            .addComponent(jrbDeleteEmp)
                            .addComponent(jrbUpdateEmp)
                            .addComponent(jrbQuit)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(70, 70,70)
                        .addComponent(dotask)))
                .addContainerGap(95, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jLabel1)
                .addGap(26, 26, 26)
                .addComponent(jrbAddEmp)
                .addGap(18, 18, 18)
                .addComponent(jrbSearchEmp)
                .addGap(18, 18, 18)
                .addComponent(jrbShowAllEmp)
                .addGap(18, 18, 18)
                .addComponent(jrbUpdateEmp)
                .addGap(18, 18, 18)
                .addComponent(jrbDeleteEmp)
                .addGap(18, 18, 18)
                .addComponent(jrbQuit)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(dotask)
                .addGap(32, 32, 32))
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1,GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1,GroupLayout.DEFAULT_SIZE,GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
            Logger.getLogger(OptionFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
           Logger.getLogger(OptionFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
           Logger.getLogger(OptionFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
         Logger.getLogger(OptionFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new OptionFrame().setVisible(true);
            }
        });
    }

}