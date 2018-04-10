package com.global;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import net.proteanit.sql.DbUtils;

public class AdminFrame
  extends JFrame
{
  private static final long serialVersionUID = 1L;
  public int sum_exp = 0;
  public int sum_sal = 0;
  public int sum_total = 0;
  private JPasswordField passwordField;
  private JPasswordField passwordField_1;
  private JPasswordField passwordField_2;
  private JTextField cem;
  private JTextField fly;
  private JTextField che;
  private JTextField cem1;
  private JTextField fly1;
  private JTextField che1;
  private JTextField description;
  private JTextField amount;
  private JTextField date;
  private JTextField start_date;
  private JTextField end_date;
  private JTable table;
  private JTextField no;
  private JTextField quantity;
  private JTextField price;
  private JTextField customer;
  private JTextField date1;
  private JTextField start_date1;
  private JTextField end_date1;
  private JTable table_1;
  private JTextField s4;
  private JTextField s6;
  private JTextField s8;
  private JTextField s41;
  private JTextField s61;
  private JTextField s81;
  private JTextField invno;
  private JTextField cusme;
  private JTextField sie;
  private JTextField quaty;
  private JTextField amont;
  private JTextField date2;
  private JTextField s_invoice;
  private JTable table_2;
  private JTextField username;
  private JTextField password;
  private JTextField database;
  private JTextField path;
  
  public static void main(String[] args)
  {
    EventQueue.invokeLater(new Runnable()
    {
      public void run()
      {
        try
        {
          AdminFrame frame = new AdminFrame();
          frame.setVisible(true);
        }
        catch (Exception e)
        {
          e.printStackTrace();
        }
      }
    });
  }
  
  public AdminFrame()
  {
    setTitle("Industry Management - Zielyx");
    setResizable(false);
    setIconImage(
      new ImageIcon(getClass().getResource("icon.png")).getImage());
    setDefaultCloseOperation(3);
    setBounds(100, 100, 730, 489);
    
    JMenuBar menuBar = new JMenuBar();
    menuBar.setBackground(new Color(0, 128, 128));
    setJMenuBar(menuBar);
    
    JMenu mnNavigation = new JMenu("Navigation");
    mnNavigation.setForeground(Color.WHITE);
    mnNavigation.setFont(new Font("Segoe UI", 0, 13));
    menuBar.add(mnNavigation);
    
    JMenuItem mntmMainpage = new JMenuItem("Mainpage");
    mntmMainpage.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        ((CardLayout)AdminFrame.this.getContentPane().getLayout()).show(AdminFrame.this.getContentPane(), "name_215852242440400");
      }
    });
    mntmMainpage.setForeground(new Color(0, 0, 0));
    mntmMainpage.setFont(new Font("Segoe UI", 0, 12));
    mnNavigation.add(mntmMainpage);
    
    JMenuItem mntmExit = new JMenuItem("Exit");
    mntmExit.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        System.exit(0);
      }
    });
    mnNavigation.add(mntmExit);
    
    JMenu mnInventory = new JMenu("Inventory");
    mnInventory.setFont(new Font("Segoe UI", 0, 13));
    mnInventory.setForeground(Color.WHITE);
    menuBar.add(mnInventory);
    
    JMenu mnCheckData = new JMenu("Check data");
    mnInventory.add(mnCheckData);
    
    JMenuItem mntmCement = new JMenuItem("cement");
    mntmCement.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        Connection con = null;
        Statement st = null;
        
        String url = "jdbc:mysql://localhost:3306/clc_database";
        String user = "root";
        String password = "root";
        try
        {
          Class.forName("com.mysql.jdbc.Driver");
          con = DriverManager.getConnection(url, user, password);
          st = con.createStatement();
          
          String sql = "SELECT cement FROM inventory ";
          ResultSet rs = st.executeQuery(sql);
          if (rs.next())
          {
            float status = rs.getFloat("cement");
            UIManager.put("OptionPane.minimumSize", new Dimension(300, 200));
            JOptionPane.showMessageDialog(null, " The Cement bags present are   " + status + " ");
          }
          else
          {
            JOptionPane.showMessageDialog(null, "Cannot provide something wrong");
          }
          rs.close();
          st.close();
          con.close();
        }
        catch (SQLException se)
        {
          se.printStackTrace();
        }
        catch (Exception e1)
        {
          e1.printStackTrace();
        }
      }
    });
    mnCheckData.add(mntmCement);
    
    JMenuItem mntmFlyash = new JMenuItem("flyash");
    mntmFlyash.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        Connection con = null;
        Statement st = null;
        
        String url = "jdbc:mysql://localhost:3306/clc_database";
        String user = "root";
        String password = "root";
        try
        {
          Class.forName("com.mysql.jdbc.Driver");
          con = DriverManager.getConnection(url, user, password);
          st = con.createStatement();
          
          String sql = "SELECT flyash FROM inventory ";
          ResultSet rs = st.executeQuery(sql);
          if (rs.next())
          {
            float status = rs.getFloat("flyash");
            UIManager.put("OptionPane.minimumSize", new Dimension(300, 200));
            JOptionPane.showMessageDialog(null, " The flyash left is    " + status + " kgs");
          }
          else
          {
            JOptionPane.showMessageDialog(null, "Cannot provide something wrong");
          }
          rs.close();
          st.close();
          con.close();
        }
        catch (SQLException se)
        {
          se.printStackTrace();
        }
        catch (Exception e1)
        {
          e1.printStackTrace();
        }
      }
    });
    mnCheckData.add(mntmFlyash);
    
    JMenuItem mntmChemical = new JMenuItem("chemical");
    mntmChemical.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        Connection con = null;
        Statement st = null;
        
        String url = "jdbc:mysql://localhost:3306/clc_database";
        String user = "root";
        String password = "root"
        String password = "root";
        try
        {
          Class.forName("com.mysql.jdbc.Driver");
          con = DriverManager.getConnection(url, user, password);
          st = con.createStatement();
          
          String sql = "SELECT chemical FROM inventory ";
          ResultSet rs = st.executeQuery(sql);
          if (rs.next())
          {
            float status = rs.getFloat("chemical");
            UIManager.put("OptionPane.minimumSize", new Dimension(300, 200));
            JOptionPane.showMessageDialog(null, " The chemical of   " + status + " L is present");
          }
          else
          {
            JOptionPane.showMessageDialog(null, "Cannot provide something wrong");
          }
          rs.close();
          st.close();
          con.close();
        }
        catch (SQLException se)
        {
          se.printStackTrace();
        }
        catch (Exception e1)
        {
          e1.printStackTrace();
        }
      }
    });
    mnCheckData.add(mntmChemical);
    
    JMenuItem mntmModifyData = new JMenuItem("Modify data");
    mntmModifyData.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        ((CardLayout)AdminFrame.this.getContentPane().getLayout()).show(AdminFrame.this.getContentPane(), "name_215857342136887");
      }
    });
    mnInventory.add(mntmModifyData);
    
    JMenu mnExpenditures = new JMenu("Expenditures");
    mnExpenditures.setForeground(Color.WHITE);
    mnExpenditures.setFont(new Font("Segoe UI", 0, 13));
    menuBar.add(mnExpenditures);
    
    JMenuItem mntmAddData = new JMenuItem("Add data");
    mntmAddData.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        ((CardLayout)AdminFrame.this.getContentPane().getLayout()).show(AdminFrame.this.getContentPane(), "name_215860324740175");
      }
    });
    mnExpenditures.add(mntmAddData);
    
    JMenuItem mntmViewData = new JMenuItem("View data");
    mntmViewData.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent arg0)
      {
        ((CardLayout)AdminFrame.this.getContentPane().getLayout()).show(AdminFrame.this.getContentPane(), "name_282876144061811");
      }
    });
    mnExpenditures.add(mntmViewData);
    
    JMenu mnSales = new JMenu("Sales");
    mnSales.setFont(new Font("Segoe UI", 0, 13));
    mnSales.setForeground(Color.WHITE);
    menuBar.add(mnSales);
    
    JMenuItem mntmAddData_1 = new JMenuItem("Add data");
    mntmAddData_1.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent arg0)
      {
        ((CardLayout)AdminFrame.this.getContentPane().getLayout()).show(AdminFrame.this.getContentPane(), "name_355357971405125");
      }
    });
    mnSales.add(mntmAddData_1);
    
    JMenuItem mntmViewData_1 = new JMenuItem("View data");
    mntmViewData_1.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        ((CardLayout)AdminFrame.this.getContentPane().getLayout()).show(AdminFrame.this.getContentPane(), "name_367200178823045");
      }
    });
    mnSales.add(mntmViewData_1);
    
    JMenu mnStock = new JMenu("Stock");
    mnStock.setForeground(Color.WHITE);
    mnStock.setFont(new Font("Segoe UI", 0, 13));
    menuBar.add(mnStock);
    
    JMenu mnCheckStock = new JMenu("Check stock");
    mnStock.add(mnCheckStock);
    
    JMenuItem mntmS = new JMenuItem("s4");
    mntmS.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        Connection con = null;
        Statement st = null;
        
        String url = "jdbc:mysql://localhost:3306/clc_database";
        String user = "root";
        String password = "root";
        try
        {
          Class.forName("com.mysql.jdbc.Driver");
          con = DriverManager.getConnection(url, user, password);
          st = con.createStatement();
          
          String sql = "SELECT s4 FROM stock ";
          ResultSet rs = st.executeQuery(sql);
          if (rs.next())
          {
            Integer status = Integer.valueOf(rs.getInt("s4"));
            UIManager.put("OptionPane.minimumSize", new Dimension(300, 200));
            JOptionPane.showMessageDialog(null, " There are   " + status + " bricks present");
          }
          else
          {
            JOptionPane.showMessageDialog(null, "Cannot provide something wrong");
          }
          rs.close();
          st.close();
          con.close();
        }
        catch (SQLException se)
        {
          se.printStackTrace();
        }
        catch (Exception e1)
        {
          e1.printStackTrace();
        }
      }
    });
    mnCheckStock.add(mntmS);
    
    JMenuItem mntmS_1 = new JMenuItem("s6");
    mntmS_1.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        Connection con = null;
        Statement st = null;
        
        String url = "jdbc:mysql://localhost:3306/clc_database";
        String user = "root";
        String password = "root";
        try
        {
          Class.forName("com.mysql.jdbc.Driver");
          con = DriverManager.getConnection(url, user, password);
          st = con.createStatement();
          
          String sql = "SELECT s6 FROM stock ";
          ResultSet rs = st.executeQuery(sql);
          if (rs.next())
          {
            Integer status = Integer.valueOf(rs.getInt("s6"));
            UIManager.put("OptionPane.minimumSize", new Dimension(300, 200));
            JOptionPane.showMessageDialog(null, " There are   " + status + " bricks present");
          }
          else
          {
            JOptionPane.showMessageDialog(null, "Cannot provide something wrong");
          }
          rs.close();
          st.close();
          con.close();
        }
        catch (SQLException se)
        {
          se.printStackTrace();
        }
        catch (Exception e1)
        {
          e1.printStackTrace();
        }
      }
    });
    mnCheckStock.add(mntmS_1);
    
    JMenuItem mntmS_2 = new JMenuItem("s8");
    mntmS_2.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        Connection con = null;
        Statement st = null;
        
        String url = "jdbc:mysql://localhost:3306/clc_database";
        String user = "root";
        String password = "root";
        try
        {
          Class.forName("com.mysql.jdbc.Driver");
          con = DriverManager.getConnection(url, user, password);
          st = con.createStatement();
          
          String sql = "SELECT s8 FROM stock ";
          ResultSet rs = st.executeQuery(sql);
          if (rs.next())
          {
            Integer status = Integer.valueOf(rs.getInt("s8"));
            UIManager.put("OptionPane.minimumSize", new Dimension(300, 200));
            JOptionPane.showMessageDialog(null, " There are   " + status + " bricks present");
          }
          else
          {
            JOptionPane.showMessageDialog(null, "Cannot provide something wrong");
          }
          rs.close();
          st.close();
          con.close();
        }
        catch (SQLException se)
        {
          se.printStackTrace();
        }
        catch (Exception e1)
        {
          e1.printStackTrace();
        }
      }
    });
    mnCheckStock.add(mntmS_2);
    
    JMenuItem mntmModifyStock = new JMenuItem("Modify stock");
    mntmModifyStock.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        ((CardLayout)AdminFrame.this.getContentPane().getLayout()).show(AdminFrame.this.getContentPane(), "name_371201353987700");
      }
    });
    mnStock.add(mntmModifyStock);
    
    JMenu mnInvoice = new JMenu("Invoice");
    mnInvoice.setFont(new Font("Segoe UI", 0, 12));
    mnInvoice.setForeground(Color.WHITE);
    menuBar.add(mnInvoice);
    
    JMenuItem mntmCheckInvoice = new JMenuItem("check invoice");
    mntmCheckInvoice.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        ((CardLayout)AdminFrame.this.getContentPane().getLayout()).show(AdminFrame.this.getContentPane(), "name_374629456389026");
      }
    });
    mnInvoice.add(mntmCheckInvoice);
    
    JMenuItem mntmAddInvoice = new JMenuItem("Add invoice");
    mntmAddInvoice.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        ((CardLayout)AdminFrame.this.getContentPane().getLayout()).show(AdminFrame.this.getContentPane(), "name_372626033218944");
      }
    });
    mnInvoice.add(mntmAddInvoice);
    
    JMenu mnOthers = new JMenu("Others");
    mnOthers.setForeground(Color.WHITE);
    mnOthers.setFont(new Font("Segoe UI", 0, 12));
    menuBar.add(mnOthers);
    
    JMenuItem mntmDatabackup = new JMenuItem("Databackup");
    mntmDatabackup.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        ((CardLayout)AdminFrame.this.getContentPane().getLayout()).show(AdminFrame.this.getContentPane(), "name_379200884010569");
      }
    });
    mnOthers.add(mntmDatabackup);
    
    JMenu mnHelp = new JMenu("Help");
    mnHelp.setFont(new Font("Segoe UI", 0, 12));
    mnHelp.setForeground(new Color(255, 255, 255));
    menuBar.add(mnHelp);
    
    JMenuItem mntmAbout = new JMenuItem("About");
    mntmAbout.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        JOptionPane.showMessageDialog(null, "                       v 1.0", "Software Version", 1);
      }
    });
    mnHelp.add(mntmAbout);
    getContentPane().setLayout(new CardLayout(0, 0));
    
    JPanel Mainpage = new JPanel();
    getContentPane().add(Mainpage, "name_215852242440400");
    Mainpage.setLayout(null);
    
    JLabel lblChangePassword = new JLabel("Change Password :");
    lblChangePassword.setFont(new Font("Tahoma", 1, 12));
    lblChangePassword.setBounds(511, 86, 135, 14);
    Mainpage.add(lblChangePassword);
    
    JLabel lblOldPassword = new JLabel("Old Password");
    lblOldPassword.setBounds(440, 149, 84, 14);
    Mainpage.add(lblOldPassword);
    
    JLabel lblNewPassword = new JLabel("New Password");
    lblNewPassword.setBounds(440, 196, 96, 14);
    Mainpage.add(lblNewPassword);
    
    JLabel lblRetypePassword = new JLabel("Re-type Password");
    lblRetypePassword.setBounds(440, 243, 107, 14);
    Mainpage.add(lblRetypePassword);
    
    this.passwordField = new JPasswordField();
    this.passwordField.setBounds(583, 146, 96, 20);
    Mainpage.add(this.passwordField);
    
    this.passwordField_1 = new JPasswordField();
    this.passwordField_1.setBounds(583, 193, 96, 20);
    Mainpage.add(this.passwordField_1);
    
    this.passwordField_2 = new JPasswordField();
    this.passwordField_2.addKeyListener(new KeyAdapter()
    {
      public void keyPressed(KeyEvent evt)
      {
        if (evt.getKeyCode() == 10)
        {
          String opass = String.valueOf(AdminFrame.this.passwordField.getPassword());
          String npass1 = String.valueOf(AdminFrame.this.passwordField_1.getPassword());
          String npass2 = String.valueOf(AdminFrame.this.passwordField_2.getPassword());
          
          Connection con = null;
          Statement st = null;
          Statement st1 = null;
          String url = "jdbc:mysql://localhost:3306/clc_database";
          String user = "root";
          String password = "root";
          try
          {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, user, password);
            st = con.createStatement();
            
            String sql = "SELECT password FROM admin_table WHERE username = 'admin' AND password = '" + opass + "' ";
            ResultSet rs = st.executeQuery(sql);
            if (rs.next())
            {
              if (npass1.equals(npass2))
              {
                st1 = con.createStatement();
                
                String sql1 = "UPDATE admin_table SET password='" + npass1 + "' WHERE username='admin' ";
                int rs1 = st1.executeUpdate(sql1);
                if (rs1 == 1) {
                  JOptionPane.showMessageDialog(null, "Password change successful");
                } else {
                  JOptionPane.showMessageDialog(null, "Something wrong");
                }
                st1.close();
              }
              else
              {
                JOptionPane.showMessageDialog(null, "Passwords are not same");
              }
            }
            else if (!rs.next()) {
              JOptionPane.showMessageDialog(null, "Sorry Wrong old password");
            }
            rs.close();
            st.close();
            con.close();
          }
          catch (SQLException se)
          {
            se.printStackTrace();
          }
          catch (Exception e)
          {
            e.printStackTrace();
          }
        }
      }
    });
    this.passwordField_2.setBounds(583, 240, 96, 20);
    Mainpage.add(this.passwordField_2);
    
    JButton btnChange = new JButton("Change");
    btnChange.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent arg0)
      {
        String opass = String.valueOf(AdminFrame.this.passwordField.getPassword());
        String npass1 = String.valueOf(AdminFrame.this.passwordField_1.getPassword());
        String npass2 = String.valueOf(AdminFrame.this.passwordField_2.getPassword());
        
        Connection con = null;
        Statement st = null;
        Statement st1 = null;
        String url = "jdbc:mysql://localhost:3306/clc_database";
        String user = "root";
        String password = "root";
        try
        {
          Class.forName("com.mysql.jdbc.Driver");
          con = DriverManager.getConnection(url, user, password);
          st = con.createStatement();
          
          String sql = "SELECT password FROM admin_table WHERE username = 'admin' AND password = '" + opass + "' ";
          ResultSet rs = st.executeQuery(sql);
          if (rs.next())
          {
            if (npass1.equals(npass2))
            {
              st1 = con.createStatement();
              
              String sql1 = "UPDATE admin_table SET password='" + npass1 + "' WHERE username='admin' ";
              int rs1 = st1.executeUpdate(sql1);
              if (rs1 == 1)
              {
                AdminFrame.this.passwordField.setText("");
                AdminFrame.this.passwordField_1.setText("");
                AdminFrame.this.passwordField_2.setText("");
                JOptionPane.showMessageDialog(null, "Password change successful");
              }
              else
              {
                JOptionPane.showMessageDialog(null, "Something wrong");
              }
              st1.close();
            }
            else
            {
              JOptionPane.showMessageDialog(null, "Passwords are not same");
            }
          }
          else if (!rs.next()) {
            JOptionPane.showMessageDialog(null, "Sorry Wrong old password");
          }
          rs.close();
          st.close();
          con.close();
        }
        catch (SQLException se)
        {
          se.printStackTrace();
        }
        catch (Exception e1)
        {
          e1.printStackTrace();
        }
      }
    });
    btnChange.setBounds(595, 296, 84, 23);
    Mainpage.add(btnChange);
    
    JButton btnNewButton = new JButton("Reset");
    btnNewButton.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        AdminFrame.this.passwordField.setText("");
        AdminFrame.this.passwordField_1.setText("");
        AdminFrame.this.passwordField_2.setText("");
      }
    });
    btnNewButton.setBounds(447, 296, 77, 23);
    Mainpage.add(btnNewButton);
    
    JLabel lblYourNetProfit = new JLabel("Your net Profit is");
    lblYourNetProfit.setForeground(new Color(0, 100, 0));
    lblYourNetProfit.setFont(new Font("Tahoma", 1, 18));
    lblYourNetProfit.setBounds(120, 112, 190, 51);
    Mainpage.add(lblYourNetProfit);
    
    JLabel label = new JLabel(" ");
    label.setBounds(166, 196, 65, 14);
    Mainpage.add(label);
    
    JButton btnKnowMe = new JButton("know me");
    btnKnowMe.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent arg0)
      {
        int sum_exp = 0;
        int sum_sal = 0;
        int sum_total = 0;
        
        Connection con = null;
        Statement st = null;
        String url = "jdbc:mysql://localhost:3306/clc_database";
        String user = "root";
        String password = "root";
        try
        {
          Class.forName("com.mysql.jdbc.Driver");
          con = DriverManager.getConnection(url, user, password);
          st = con.createStatement();
          
          String sql = "SELECT SUM(amount) FROM expenditures ";
          ResultSet rs = st.executeQuery(sql);
          while (rs.next())
          {
            int c = rs.getInt(1);
            sum_exp += c;
          }
          rs.close();
          st.close();
          con.close();
        }
        catch (SQLException se)
        {
          se.printStackTrace();
        }
        catch (Exception e1)
        {
          e1.printStackTrace();
        }
        Connection con1 = null;
        Statement st1 = null;
        String url1 = "jdbc:mysql://localhost:3306/clc_database";
        String user1 = "root";
        String password1 = "root";
        try
        {
          Class.forName("com.mysql.jdbc.Driver");
          con1 = DriverManager.getConnection(url1, user1, password1);
          st1 = con1.createStatement();
          
          String sql1 = "SELECT SUM(amount) FROM sales ";
          ResultSet rs = st1.executeQuery(sql1);
          while (rs.next())
          {
            int c = rs.getInt(1);
            sum_sal += c;
          }
          rs.close();
          st.close();
          con.close();
        }
        catch (SQLException se)
        {
          se.printStackTrace();
        }
        catch (Exception e1)
        {
          e1.printStackTrace();
        }
        sum_total = sum_sal - sum_exp;
        JOptionPane.showMessageDialog(null, "Your net Profit is " + sum_total + " ");
      }
    });
    btnKnowMe.setBounds(144, 192, 89, 23);
    Mainpage.add(btnKnowMe);
    
    JLabel lblPoweredBy = new JLabel("Powered by ");
    lblPoweredBy.setFont(new Font("Tahoma", 1, 15));
    lblPoweredBy.setBounds(43, 345, 107, 19);
    Mainpage.add(lblPoweredBy);
    
    JLabel lblSeizant = new JLabel("Zielyx");
    lblSeizant.setForeground(Color.BLUE);
    lblSeizant.setFont(new Font("Tahoma", 1, 15));
    lblSeizant.setBounds(144, 347, 96, 14);
    Mainpage.add(lblSeizant);
    
    JPanel inventory_mod = new JPanel();
    getContentPane().add(inventory_mod, "name_215857342136887");
    inventory_mod.setLayout(null);
    
    JLabel lblAddData = new JLabel("Add data");
    lblAddData.setFont(new Font("Tahoma", 1, 12));
    lblAddData.setBounds(92, 83, 86, 14);
    inventory_mod.add(lblAddData);
    
    JLabel lblCement = new JLabel("Cement");
    lblCement.setBounds(39, 148, 46, 14);
    inventory_mod.add(lblCement);
    
    this.cem = new JTextField();
    this.cem.setBounds(112, 145, 86, 20);
    inventory_mod.add(this.cem);
    this.cem.setColumns(10);
    
    JLabel lblFlyash = new JLabel("Flyash");
    lblFlyash.setBounds(39, 193, 46, 14);
    inventory_mod.add(lblFlyash);
    
    this.fly = new JTextField();
    this.fly.setBounds(112, 190, 86, 20);
    inventory_mod.add(this.fly);
    this.fly.setColumns(10);
    
    JLabel lblChemical = new JLabel("Chemical");
    lblChemical.setBounds(39, 241, 62, 14);
    inventory_mod.add(lblChemical);
    
    this.che = new JTextField();
    this.che.setBounds(112, 238, 86, 20);
    inventory_mod.add(this.che);
    this.che.setColumns(10);
    
    JButton btnAddData = new JButton("Add data");
    btnAddData.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        float cement = Integer.parseInt(AdminFrame.this.cem.getText());
        float flyash = Integer.parseInt(AdminFrame.this.fly.getText());
        float chemical = Integer.parseInt(AdminFrame.this.che.getText());
        
        Connection con = null;
        Statement st = null;
        Statement st1 = null;
        String url = "jdbc:mysql://localhost:3306/clc_database";
        String user = "root";
        String password = "root";
        try
        {
          Class.forName("com.mysql.jdbc.Driver");
          con = DriverManager.getConnection(url, user, password);
          st = con.createStatement();
          
          String sql = "SELECT *from inventory ";
          ResultSet rs = st.executeQuery(sql);
          if (rs.next())
          {
            float dcement = rs.getFloat("cement");
            float dflyash = rs.getFloat("flyash");
            float dchemical = rs.getFloat("chemical");
            
            float fcement = cement + dcement;
            float fflyash = flyash + dflyash;
            float fchemical = chemical + dchemical;
            
            st1 = con.createStatement();
            
            String sql1 = "UPDATE inventory SET cement='" + fcement + "',flyash='" + fflyash + "',chemical='" + fchemical + "'  ";
            int rs1 = st1.executeUpdate(sql1);
            if (rs1 == 1)
            {
              AdminFrame.this.cem.setText("");
              AdminFrame.this.fly.setText("");
              AdminFrame.this.che.setText("");
              JOptionPane.showMessageDialog(null, "Data Added successfully");
            }
            else
            {
              JOptionPane.showMessageDialog(null, "something went wrong");
            }
            st1.close();
          }
          else
          {
            JOptionPane.showMessageDialog(null, "Cannot provide,something wrong");
          }
          rs.close();
          st.close();
          con.close();
        }
        catch (SQLException se)
        {
          se.printStackTrace();
        }
        catch (Exception e1)
        {
          e1.printStackTrace();
        }
      }
    });
    btnAddData.setBounds(61, 291, 89, 23);
    inventory_mod.add(btnAddData);
    
    JLabel lblCheckData = new JLabel("Reduce data");
    lblCheckData.setFont(new Font("Tahoma", 1, 12));
    lblCheckData.setBounds(551, 83, 95, 14);
    inventory_mod.add(lblCheckData);
    
    JLabel lblCement_1 = new JLabel("Cement");
    lblCement_1.setBounds(487, 148, 46, 14);
    inventory_mod.add(lblCement_1);
    
    this.cem1 = new JTextField();
    this.cem1.setBounds(589, 145, 86, 20);
    inventory_mod.add(this.cem1);
    this.cem1.setColumns(10);
    
    JLabel lblFlyash_1 = new JLabel("Flyash");
    lblFlyash_1.setBounds(487, 193, 46, 14);
    inventory_mod.add(lblFlyash_1);
    
    this.fly1 = new JTextField();
    this.fly1.setBounds(589, 190, 86, 20);
    inventory_mod.add(this.fly1);
    this.fly1.setColumns(10);
    
    JLabel lblChemical_1 = new JLabel("Chemical");
    lblChemical_1.setBounds(487, 244, 86, 14);
    inventory_mod.add(lblChemical_1);
    
    this.che1 = new JTextField();
    this.che1.setBounds(589, 238, 86, 20);
    inventory_mod.add(this.che1);
    this.che1.setColumns(10);
    
    JButton btnReduce = new JButton("Reduce");
    btnReduce.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        float cement = Integer.parseInt(AdminFrame.this.cem1.getText());
        float flyash = Integer.parseInt(AdminFrame.this.fly1.getText());
        float chemical = Integer.parseInt(AdminFrame.this.che1.getText());
        
        Connection con = null;
        Statement st = null;
        Statement st1 = null;
        String url = "jdbc:mysql://localhost:3306/clc_database";
        String user = "root";
        String password = "root";
        try
        {
          Class.forName("com.mysql.jdbc.Driver");
          con = DriverManager.getConnection(url, user, password);
          st = con.createStatement();
          
          String sql = "SELECT *from inventory ";
          ResultSet rs = st.executeQuery(sql);
          if (rs.next())
          {
            float dcement = rs.getFloat("cement");
            float dflyash = rs.getFloat("flyash");
            float dchemical = rs.getFloat("chemical");
            
            float fcement = dcement - cement;
            float fflyash = dflyash - flyash;
            float fchemical = dchemical - chemical;
            
            st1 = con.createStatement();
            
            String sql1 = "UPDATE inventory SET cement='" + fcement + "',flyash='" + fflyash + "',chemical='" + fchemical + "'  ";
            int rs1 = st1.executeUpdate(sql1);
            if (rs1 == 1)
            {
              AdminFrame.this.cem1.setText("");
              AdminFrame.this.fly1.setText("");
              AdminFrame.this.che1.setText("");
              JOptionPane.showMessageDialog(null, "Data Reduced successfully");
            }
            else
            {
              JOptionPane.showMessageDialog(null, "something went wrong");
            }
            st1.close();
          }
          else
          {
            JOptionPane.showMessageDialog(null, "Cannot provide,something wrong");
          }
          rs.close();
          st.close();
          con.close();
        }
        catch (SQLException se)
        {
          se.printStackTrace();
        }
        catch (Exception e1)
        {
          e1.printStackTrace();
        }
      }
    });
    btnReduce.setBounds(531, 291, 89, 23);
    inventory_mod.add(btnReduce);
    
    JPanel Expend_add = new JPanel();
    getContentPane().add(Expend_add, "name_215860324740175");
    Expend_add.setLayout(null);
    
    JLabel lblAddExpenditureData = new JLabel("Add Expenditures data");
    lblAddExpenditureData.setFont(new Font("Tahoma", 1, 14));
    lblAddExpenditureData.setBounds(279, 90, 192, 20);
    Expend_add.add(lblAddExpenditureData);
    
    JLabel lblDescription = new JLabel("Description");
    lblDescription.setBounds(219, 174, 76, 14);
    Expend_add.add(lblDescription);
    
    this.description = new JTextField();
    this.description.setBounds(353, 171, 159, 20);
    Expend_add.add(this.description);
    this.description.setColumns(10);
    
    JLabel lblAmount = new JLabel("Amount");
    lblAmount.setBounds(219, 228, 46, 14);
    Expend_add.add(lblAmount);
    
    this.amount = new JTextField();
    this.amount.setBounds(353, 225, 159, 20);
    Expend_add.add(this.amount);
    this.amount.setColumns(10);
    
    JLabel lblDate = new JLabel("Date");
    lblDate.setBounds(219, 282, 46, 14);
    Expend_add.add(lblDate);
    
    this.date = new JTextField();
    this.date.setBounds(353, 279, 159, 20);
    Expend_add.add(this.date);
    this.date.setColumns(10);
    
    JLabel lblDdmmyyyy = new JLabel("( dd/mm/yyyy)");
    lblDdmmyyyy.setBounds(550, 282, 120, 14);
    Expend_add.add(lblDdmmyyyy);
    
    JButton btnAdd = new JButton("Add");
    btnAdd.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        String desc = AdminFrame.this.description.getText();
        Float amou = Float.valueOf(Integer.parseInt(AdminFrame.this.amount.getText()));
        String dat = AdminFrame.this.date.getText();
        
        Connection con = null;
        Statement st = null;
        String url = "jdbc:mysql://localhost:3306/clc_database";
        String user = "root";
        String password = "root";
        try
        {
          Class.forName("com.mysql.jdbc.Driver");
          con = DriverManager.getConnection(url, user, password);
          st = con.createStatement();
          
          String sql = " INSERT INTO expenditures (description,amount,date) VALUES ('" + 
            desc + "','" + amou + "','" + dat + "')";
          int rs = st.executeUpdate(sql);
          if (rs == 1)
          {
            AdminFrame.this.description.setText("");
            AdminFrame.this.amount.setText("");
            AdminFrame.this.date.setText("");
            JOptionPane.showMessageDialog(null, "Added successfully");
          }
          else
          {
            JOptionPane.showMessageDialog(null, "Something wrong");
          }
          st.close();
          con.close();
        }
        catch (SQLException se)
        {
          se.printStackTrace();
        }
        catch (Exception e1)
        {
          e1.printStackTrace();
        }
      }
    });
    btnAdd.setBounds(298, 337, 89, 23);
    Expend_add.add(btnAdd);
    
    JPanel Expend_view = new JPanel();
    getContentPane().add(Expend_view, "name_282876144061811");
    Expend_view.setLayout(null);
    
    JLabel lblStartDate = new JLabel("Start date");
    lblStartDate.setBounds(43, 145, 82, 22);
    Expend_view.add(lblStartDate);
    
    this.start_date = new JTextField();
    this.start_date.setBounds(135, 146, 86, 20);
    Expend_view.add(this.start_date);
    this.start_date.setColumns(10);
    
    JLabel lblEndDate = new JLabel("End date");
    lblEndDate.setBounds(43, 206, 82, 22);
    Expend_view.add(lblEndDate);
    
    this.end_date = new JTextField();
    this.end_date.setBounds(135, 207, 86, 20);
    Expend_view.add(this.end_date);
    this.end_date.setColumns(10);
    
    JButton btnCheck = new JButton("Check");
    btnCheck.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        String s_date = AdminFrame.this.start_date.getText();
        String e_date = AdminFrame.this.end_date.getText();
        
        Connection con = null;
        Statement st = null;
        String url = "jdbc:mysql://localhost:3306/clc_database";
        String user = "root";
        String password = "root";
        try
        {
          Class.forName("com.mysql.jdbc.Driver");
          con = DriverManager.getConnection(url, user, password);
          st = con.createStatement();
          
          String sql = " select * from expenditures  where date between   '" + s_date + "'  and '" + e_date + "'";
          ResultSet rs = st.executeQuery(sql);
          AdminFrame.this.table.setModel(DbUtils.resultSetToTableModel(rs));
          
          AdminFrame.this.start_date.setText("");
          AdminFrame.this.end_date.setText("");
          st.close();
          con.close();
        }
        catch (SQLException se)
        {
          se.printStackTrace();
        }
        catch (Exception e1)
        {
          e1.printStackTrace();
        }
      }
    });
    btnCheck.setBounds(102, 266, 82, 22);
    Expend_view.add(btnCheck);
    
    JLabel lblNewLabel = new JLabel("(dd/mm/yyyy)");
    lblNewLabel.setBounds(251, 149, 82, 14);
    Expend_view.add(lblNewLabel);
    
    JLabel lblddmmyyyy = new JLabel("(dd/mm/yyyy)");
    lblddmmyyyy.setBounds(251, 210, 94, 14);
    Expend_view.add(lblddmmyyyy);
    
    JScrollPane scrollPane = new JScrollPane();
    scrollPane.setBounds(349, 121, 365, 242);
    Expend_view.add(scrollPane);
    
    this.table = new JTable();
    scrollPane.setViewportView(this.table);
    
    JPanel sales_add = new JPanel();
    getContentPane().add(sales_add, "name_355357971405125");
    sales_add.setLayout(null);
    
    JLabel lblSize = new JLabel("Size");
    lblSize.setBounds(219, 68, 46, 14);
    sales_add.add(lblSize);
    
    this.no = new JTextField();
    this.no.setBounds(314, 65, 86, 20);
    sales_add.add(this.no);
    this.no.setColumns(10);
    
    JLabel lblAmount_1 = new JLabel("Quantity");
    lblAmount_1.setBounds(219, 130, 79, 14);
    sales_add.add(lblAmount_1);
    
    this.quantity = new JTextField();
    this.quantity.setBounds(314, 127, 86, 20);
    sales_add.add(this.quantity);
    this.quantity.setColumns(10);
    
    JLabel lblAmount_2 = new JLabel("Amount");
    lblAmount_2.setBounds(219, 184, 46, 14);
    sales_add.add(lblAmount_2);
    
    this.price = new JTextField();
    this.price.setBounds(314, 181, 86, 20);
    sales_add.add(this.price);
    this.price.setColumns(10);
    
    JLabel lblCustomer = new JLabel("Customer ");
    lblCustomer.setBounds(219, 240, 79, 14);
    sales_add.add(lblCustomer);
    
    this.customer = new JTextField();
    this.customer.setBounds(314, 237, 86, 20);
    sales_add.add(this.customer);
    this.customer.setColumns(10);
    
    JLabel lblDate_1 = new JLabel("Date");
    lblDate_1.setBounds(219, 291, 46, 14);
    sales_add.add(lblDate_1);
    
    this.date1 = new JTextField();
    this.date1.setBounds(314, 288, 86, 20);
    sales_add.add(this.date1);
    this.date1.setColumns(10);
    
    JButton btnNewButton_1 = new JButton("Add");
    btnNewButton_1.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        String size1 = AdminFrame.this.no.getText();
        Integer quan = Integer.valueOf(Integer.parseInt(AdminFrame.this.quantity.getText()));
        Integer amo = Integer.valueOf(Integer.parseInt(AdminFrame.this.price.getText()));
        String custo = AdminFrame.this.customer.getText();
        String da1 = AdminFrame.this.date1.getText();
        
        Connection con = null;
        Statement st = null;
        String url = "jdbc:mysql://localhost:3306/clc_database";
        String user = "root";
        String password = "root";
        try
        {
          Class.forName("com.mysql.jdbc.Driver");
          con = DriverManager.getConnection(url, user, password);
          st = con.createStatement();
          
          String sql = " INSERT INTO sales (size,quantity,amount,customer,date) VALUES ('" + 
            size1 + "','" + quan + "','" + amo + "','" + custo + "','" + da1 + "')";
          int rs = st.executeUpdate(sql);
          if (rs == 1)
          {
            AdminFrame.this.no.setText("");
            AdminFrame.this.quantity.setText("");
            AdminFrame.this.price.setText("");
            AdminFrame.this.customer.setText("");
            AdminFrame.this.date1.setText("");
            JOptionPane.showMessageDialog(null, "Added successfully");
          }
          else
          {
            JOptionPane.showMessageDialog(null, "Something wrong");
          }
          st.close();
          con.close();
        }
        catch (SQLException se)
        {
          se.printStackTrace();
        }
        catch (Exception e1)
        {
          e1.printStackTrace();
        }
      }
    });
    btnNewButton_1.setBounds(256, 339, 89, 23);
    sales_add.add(btnNewButton_1);
    
    JLabel lblRs = new JLabel("Rs");
    lblRs.setBounds(410, 184, 46, 14);
    sales_add.add(lblRs);
    
    JLabel lblddmmyyyy_1 = new JLabel("(dd/mm/yyyy)");
    lblddmmyyyy_1.setBounds(427, 291, 86, 14);
    sales_add.add(lblddmmyyyy_1);
    
    JPanel sales_view = new JPanel();
    getContentPane().add(sales_view, "name_367200178823045");
    sales_view.setLayout(null);
    
    JLabel lblStartDate_1 = new JLabel("Start date ");
    lblStartDate_1.setBounds(25, 113, 63, 14);
    sales_view.add(lblStartDate_1);
    
    this.start_date1 = new JTextField();
    this.start_date1.setBounds(98, 110, 86, 20);
    sales_view.add(this.start_date1);
    this.start_date1.setColumns(10);
    
    JLabel lblEndDate_1 = new JLabel("End date");
    lblEndDate_1.setBounds(25, 171, 58, 14);
    sales_view.add(lblEndDate_1);
    
    this.end_date1 = new JTextField();
    this.end_date1.setBounds(98, 168, 86, 20);
    sales_view.add(this.end_date1);
    this.end_date1.setColumns(10);
    
    JButton btnNewButton_2 = new JButton("Search");
    btnNewButton_2.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        String s_date1 = AdminFrame.this.start_date1.getText();
        String e_date1 = AdminFrame.this.end_date1.getText();
        
        Connection con = null;
        Statement st = null;
        String url = "jdbc:mysql://localhost:3306/clc_database";
        String user = "root";
        String password = "root";
        try
        {
          Class.forName("com.mysql.jdbc.Driver");
          con = DriverManager.getConnection(url, user, password);
          st = con.createStatement();
          
          String sql = " select * from sales  where date between   '" + s_date1 + "'  and '" + e_date1 + "'";
          ResultSet rs = st.executeQuery(sql);
          AdminFrame.this.table_1.setModel(DbUtils.resultSetToTableModel(rs));
          
          AdminFrame.this.start_date.setText("");
          AdminFrame.this.end_date.setText("");
          st.close();
          con.close();
        }
        catch (SQLException se)
        {
          se.printStackTrace();
        }
        catch (Exception e1)
        {
          e1.printStackTrace();
        }
      }
    });
    btnNewButton_2.setBounds(40, 217, 75, 23);
    sales_view.add(btnNewButton_2);
    
    JScrollPane scrollPane_1 = new JScrollPane();
    scrollPane_1.setBounds(212, 57, 502, 371);
    sales_view.add(scrollPane_1);
    
    this.table_1 = new JTable();
    scrollPane_1.setViewportView(this.table_1);
    
    JLabel lblEnterDates = new JLabel("Enter dates");
    lblEnterDates.setFont(new Font("Tahoma", 0, 14));
    lblEnterDates.setBounds(25, 58, 90, 14);
    sales_view.add(lblEnterDates);
    
    JLabel lblddmmyyyy_2 = new JLabel("(dd/mm/yyyy)");
    lblddmmyyyy_2.setBounds(106, 58, 78, 14);
    sales_view.add(lblddmmyyyy_2);
    
    JPanel stock_modify = new JPanel();
    getContentPane().add(stock_modify, "name_371201353987700");
    stock_modify.setLayout(null);
    
    JLabel lblAddStock = new JLabel("Add stock");
    lblAddStock.setFont(new Font("Tahoma", 1, 14));
    lblAddStock.setBounds(84, 106, 89, 14);
    stock_modify.add(lblAddStock);
    
    JLabel lblNewLabel_1 = new JLabel("s4");
    lblNewLabel_1.setBounds(33, 164, 46, 14);
    stock_modify.add(lblNewLabel_1);
    
    this.s4 = new JTextField();
    this.s4.setBounds(84, 161, 86, 20);
    stock_modify.add(this.s4);
    this.s4.setColumns(10);
    
    JLabel lblS = new JLabel("s6");
    lblS.setBounds(33, 195, 46, 14);
    stock_modify.add(lblS);
    
    this.s6 = new JTextField();
    this.s6.setBounds(84, 192, 86, 20);
    stock_modify.add(this.s6);
    this.s6.setColumns(10);
    
    JLabel lblS_1 = new JLabel("s8");
    lblS_1.setBounds(33, 226, 46, 14);
    stock_modify.add(lblS_1);
    
    this.s8 = new JTextField();
    this.s8.setBounds(84, 223, 86, 20);
    stock_modify.add(this.s8);
    this.s8.setColumns(10);
    
    JButton btnAdd_1 = new JButton("Add");
    btnAdd_1.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        Integer s41v = Integer.valueOf(Integer.parseInt(AdminFrame.this.s4.getText()));
        Integer s61v = Integer.valueOf(Integer.parseInt(AdminFrame.this.s6.getText()));
        Integer s81v = Integer.valueOf(Integer.parseInt(AdminFrame.this.s8.getText()));
        
        Connection con = null;
        Statement st = null;
        Statement st1 = null;
        String url = "jdbc:mysql://localhost:3306/clc_database";
        String user = "root";
        String password = "root";
        try
        {
          Class.forName("com.mysql.jdbc.Driver");
          con = DriverManager.getConnection(url, user, password);
          st = con.createStatement();
          
          String sql = "SELECT *from stock ";
          ResultSet rs = st.executeQuery(sql);
          if (rs.next())
          {
            Integer s41d = Integer.valueOf(rs.getInt("s4"));
            Integer s61d = Integer.valueOf(rs.getInt("s6"));
            Integer s81d = Integer.valueOf(rs.getInt("s8"));
            
            Integer s41e = Integer.valueOf(s41d.intValue() + s41v.intValue());
            Integer s61e = Integer.valueOf(s61d.intValue() + s61v.intValue());
            Integer s81e = Integer.valueOf(s81d.intValue() + s81v.intValue());
            
            st1 = con.createStatement();
            
            String sql1 = "UPDATE stock SET s4='" + s41e + "',s6='" + s61e + "',s8='" + s81e + "'  ";
            int rs1 = st1.executeUpdate(sql1);
            if (rs1 == 1)
            {
              AdminFrame.this.s41.setText("");
              AdminFrame.this.s61.setText("");
              AdminFrame.this.s81.setText("");
              JOptionPane.showMessageDialog(null, "Data Added successfully");
            }
            else
            {
              JOptionPane.showMessageDialog(null, "something went wrong");
            }
            st1.close();
          }
          else
          {
            JOptionPane.showMessageDialog(null, "Cannot provide,something wrong");
          }
          rs.close();
          st.close();
          con.close();
        }
        catch (SQLException se)
        {
          se.printStackTrace();
        }
        catch (Exception e1)
        {
          e1.printStackTrace();
        }
      }
    });
    btnAdd_1.setBounds(47, 270, 74, 23);
    stock_modify.add(btnAdd_1);
    
    JLabel lblReduceStock = new JLabel("Reduce stock");
    lblReduceStock.setFont(new Font("Tahoma", 1, 14));
    lblReduceStock.setBounds(520, 103, 104, 20);
    stock_modify.add(lblReduceStock);
    
    JLabel lblS_2 = new JLabel("s4");
    lblS_2.setBounds(485, 164, 46, 14);
    stock_modify.add(lblS_2);
    
    JLabel lblS_3 = new JLabel("s6");
    lblS_3.setBounds(485, 195, 46, 14);
    stock_modify.add(lblS_3);
    
    JLabel lblS_4 = new JLabel("s8");
    lblS_4.setBounds(485, 226, 46, 14);
    stock_modify.add(lblS_4);
    
    this.s41 = new JTextField();
    this.s41.setBounds(520, 161, 86, 20);
    stock_modify.add(this.s41);
    this.s41.setColumns(10);
    
    this.s61 = new JTextField();
    this.s61.setBounds(520, 192, 86, 20);
    stock_modify.add(this.s61);
    this.s61.setColumns(10);
    
    this.s81 = new JTextField();
    this.s81.setBounds(520, 223, 86, 20);
    stock_modify.add(this.s81);
    this.s81.setColumns(10);
    
    JButton btnNewButton_3 = new JButton("Reduce");
    btnNewButton_3.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        Integer s41v = Integer.valueOf(Integer.parseInt(AdminFrame.this.s41.getText()));
        Integer s61v = Integer.valueOf(Integer.parseInt(AdminFrame.this.s61.getText()));
        Integer s81v = Integer.valueOf(Integer.parseInt(AdminFrame.this.s81.getText()));
        
        Connection con = null;
        Statement st = null;
        Statement st1 = null;
        String url = "jdbc:mysql://localhost:3306/clc_database";
        String user = "root";
        String password = "root";
        try
        {
          Class.forName("com.mysql.jdbc.Driver");
          con = DriverManager.getConnection(url, user, password);
          st = con.createStatement();
          
          String sql = "SELECT *from stock ";
          ResultSet rs = st.executeQuery(sql);
          if (rs.next())
          {
            Integer s41d = Integer.valueOf(rs.getInt("s4"));
            Integer s61d = Integer.valueOf(rs.getInt("s6"));
            Integer s81d = Integer.valueOf(rs.getInt("s8"));
            
            Integer s41e = Integer.valueOf(s41d.intValue() - s41v.intValue());
            Integer s61e = Integer.valueOf(s61d.intValue() - s61v.intValue());
            Integer s81e = Integer.valueOf(s81d.intValue() - s81v.intValue());
            
            st1 = con.createStatement();
            
            String sql1 = "UPDATE stock SET s4='" + s41e + "',s6='" + s61e + "',s8='" + s81e + "'  ";
            int rs1 = st1.executeUpdate(sql1);
            if (rs1 == 1)
            {
              AdminFrame.this.s41.setText("");
              AdminFrame.this.s61.setText("");
              AdminFrame.this.s81.setText("");
              JOptionPane.showMessageDialog(null, "Data Reduced successfully");
            }
            else
            {
              JOptionPane.showMessageDialog(null, "something went wrong");
            }
            st1.close();
          }
          else
          {
            JOptionPane.showMessageDialog(null, "Cannot provide,something wrong");
          }
          rs.close();
          st.close();
          con.close();
        }
        catch (SQLException se)
        {
          se.printStackTrace();
        }
        catch (Exception e1)
        {
          e1.printStackTrace();
        }
      }
    });
    btnNewButton_3.setBounds(500, 270, 79, 23);
    stock_modify.add(btnNewButton_3);
    
    JPanel invoice_add = new JPanel();
    getContentPane().add(invoice_add, "name_372626033218944");
    invoice_add.setLayout(null);
    
    JLabel lblAddInvoiceDetails = new JLabel("Add Invoice details");
    lblAddInvoiceDetails.setFont(new Font("Tahoma", 1, 12));
    lblAddInvoiceDetails.setBounds(254, 49, 134, 14);
    invoice_add.add(lblAddInvoiceDetails);
    
    JLabel lblInvoiceNo = new JLabel("Invoice no");
    lblInvoiceNo.setBounds(118, 133, 71, 14);
    invoice_add.add(lblInvoiceNo);
    
    this.invno = new JTextField();
    this.invno.setBounds(232, 130, 86, 20);
    invoice_add.add(this.invno);
    this.invno.setColumns(10);
    
    JLabel lblCustomerName = new JLabel("Customer name");
    lblCustomerName.setBounds(118, 179, 104, 14);
    invoice_add.add(lblCustomerName);
    
    this.cusme = new JTextField();
    this.cusme.setBounds(232, 176, 86, 20);
    invoice_add.add(this.cusme);
    this.cusme.setColumns(10);
    
    JLabel lblNewLabel_2 = new JLabel("Size");
    lblNewLabel_2.setBounds(118, 221, 46, 14);
    invoice_add.add(lblNewLabel_2);
    
    this.sie = new JTextField();
    this.sie.setBounds(232, 218, 86, 20);
    invoice_add.add(this.sie);
    this.sie.setColumns(10);
    
    JLabel lblQuantity = new JLabel("Quantity");
    lblQuantity.setBounds(392, 133, 71, 14);
    invoice_add.add(lblQuantity);
    
    this.quaty = new JTextField();
    this.quaty.setBounds(461, 130, 86, 20);
    invoice_add.add(this.quaty);
    this.quaty.setColumns(10);
    
    JLabel lblAmount_3 = new JLabel("Amount");
    lblAmount_3.setBounds(392, 179, 71, 14);
    invoice_add.add(lblAmount_3);
    
    this.amont = new JTextField();
    this.amont.setBounds(461, 176, 86, 20);
    invoice_add.add(this.amont);
    this.amont.setColumns(10);
    
    JLabel lblDate_2 = new JLabel("Date");
    lblDate_2.setBounds(392, 221, 46, 14);
    invoice_add.add(lblDate_2);
    
    this.date2 = new JTextField();
    this.date2.setBounds(461, 218, 86, 20);
    invoice_add.add(this.date2);
    this.date2.setColumns(10);
    
    JButton btnAddDetails = new JButton("Add details");
    btnAddDetails.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        Integer invoice_no = Integer.valueOf(Integer.parseInt(AdminFrame.this.invno.getText()));
        String customer_name = AdminFrame.this.cusme.getText();
        String size_stone = AdminFrame.this.sie.getText();
        Integer quantity_stone = Integer.valueOf(Integer.parseInt(AdminFrame.this.quaty.getText()));
        Integer amount_stone = Integer.valueOf(Integer.parseInt(AdminFrame.this.amont.getText()));
        String date_stone = AdminFrame.this.date2.getText();
        
        Connection con = null;
        Statement st = null;
        String url = "jdbc:mysql://localhost:3306/clc_database";
        String user = "root";
        String password = "root";
        try
        {
          Class.forName("com.mysql.jdbc.Driver");
          con = DriverManager.getConnection(url, user, password);
          st = con.createStatement();
          
          String sql = " INSERT INTO invoice (invoice_no,customer,size,quantity,amount,date) VALUES ('" + 
            invoice_no + "','" + customer_name + "','" + size_stone + "','" + quantity_stone + "','" + amount_stone + "','" + date_stone + "')";
          int rs = st.executeUpdate(sql);
          if (rs == 1)
          {
            AdminFrame.this.invno.setText("");
            AdminFrame.this.quaty.setText("");
            AdminFrame.this.date2.setText("");
            AdminFrame.this.amont.setText("");
            AdminFrame.this.sie.setText("");
            AdminFrame.this.cusme.setText("");
            JOptionPane.showMessageDialog(null, "Added successfully");
          }
          else
          {
            JOptionPane.showMessageDialog(null, "Something wrong");
          }
          st.close();
          con.close();
        }
        catch (SQLException se)
        {
          se.printStackTrace();
        }
        catch (Exception e1)
        {
          e1.printStackTrace();
        }
      }
    });
    btnAddDetails.setBounds(325, 280, 113, 23);
    invoice_add.add(btnAddDetails);
    
    JPanel invoice_view = new JPanel();
    getContentPane().add(invoice_view, "name_374629456389026");
    invoice_view.setLayout(null);
    
    JLabel lblEnterInvoiceNumber = new JLabel("Enter Invoice number");
    lblEnterInvoiceNumber.setBounds(172, 66, 132, 14);
    invoice_view.add(lblEnterInvoiceNumber);
    
    this.s_invoice = new JTextField();
    this.s_invoice.setBounds(331, 63, 86, 20);
    invoice_view.add(this.s_invoice);
    this.s_invoice.setColumns(10);
    
    JButton btnSearch = new JButton("Search");
    btnSearch.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        String search_invoice = AdminFrame.this.s_invoice.getText();
        
        Connection con = null;
        Statement st = null;
        String url = "jdbc:mysql://localhost:3306/clc_database";
        String user = "root";
        String password = "root";
        try
        {
          Class.forName("com.mysql.jdbc.Driver");
          con = DriverManager.getConnection(url, user, password);
          st = con.createStatement();
          
          String sql = " select * from invoice  where invoice_no='" + search_invoice + "'";
          ResultSet rs = st.executeQuery(sql);
          AdminFrame.this.table_2.setModel(DbUtils.resultSetToTableModel(rs));
          AdminFrame.this.s_invoice.setText("");
          st.close();
          con.close();
        }
        catch (SQLException se)
        {
          se.printStackTrace();
        }
        catch (Exception e1)
        {
          e1.printStackTrace();
        }
      }
    });
    btnSearch.setBounds(465, 62, 76, 23);
    invoice_view.add(btnSearch);
    
    JScrollPane scrollPane_2 = new JScrollPane();
    scrollPane_2.setBounds(10, 129, 704, 276);
    invoice_view.add(scrollPane_2);
    
    this.table_2 = new JTable();
    scrollPane_2.setViewportView(this.table_2);
    
    JPanel backup = new JPanel();
    getContentPane().add(backup, "name_379200884010569");
    backup.setLayout(null);
    
    JLabel lblUsername = new JLabel("Username");
    lblUsername.setBounds(196, 122, 65, 14);
    backup.add(lblUsername);
    
    JLabel lblPassword = new JLabel("Password");
    lblPassword.setBounds(196, 169, 65, 14);
    backup.add(lblPassword);
    
    JLabel lblDatabase = new JLabel("Database");
    lblDatabase.setBounds(196, 211, 65, 14);
    backup.add(lblDatabase);
    
    JLabel lblBackupto = new JLabel("Backupto ");
    lblBackupto.setBounds(196, 261, 65, 14);
    backup.add(lblBackupto);
    
    this.username = new JTextField();
    this.username.setBounds(314, 119, 171, 20);
    backup.add(this.username);
    this.username.setColumns(10);
    
    this.password = new JTextField();
    this.password.setBounds(314, 166, 171, 20);
    backup.add(this.password);
    this.password.setColumns(10);
    
    this.database = new JTextField();
    this.database.setBounds(314, 208, 171, 20);
    backup.add(this.database);
    this.database.setColumns(10);
    
    this.path = new JTextField();
    this.path.setBounds(314, 258, 171, 20);
    backup.add(this.path);
    this.path.setColumns(10);
    
    JButton btnBackup = new JButton("Backup");
    btnBackup.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        String username_get = AdminFrame.this.username.getText();
        String password_get = AdminFrame.this.password.getText();
        String database_get = AdminFrame.this.database.getText();
        String path_get = AdminFrame.this.path.getText();
        String manual_database = "backup.sql";
        String final_path = " " + path_get + manual_database;
        try
        {
          Process runtimeProcess = Runtime.getRuntime().exec("C:\\xampp\\mysql\\bin\\mysqldump -u  " + username_get + " " + password_get + " " + database_get + " -r " + final_path);
          
          int processComplete = runtimeProcess.waitFor();
          if (processComplete == 1)
          {
            JOptionPane.showMessageDialog(null, "Backup Failed");
          }
          else if (processComplete == 0)
          {
            AdminFrame.this.username.setText("");
            AdminFrame.this.password.setText("");
            AdminFrame.this.database.setText("");
            AdminFrame.this.path.setText("");
            JOptionPane.showMessageDialog(null, "\n Backup created Successfully..");
          }
        }
        catch (Exception e1)
        {
          JOptionPane.showMessageDialog(null, e1);
        }
      }
    });
    btnBackup.setBounds(277, 334, 89, 23);
    backup.add(btnBackup);
    
    JLabel lblpathD = new JLabel("( Example :  D:\\example\\subfolder   )");
    lblpathD.setBounds(495, 261, 219, 14);
    backup.add(lblpathD);
  }
}
