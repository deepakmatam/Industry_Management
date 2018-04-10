package com.global;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class LoginFrame
  extends JFrame
{
  private static final long serialVersionUID = 1L;
  private JPanel contentPane;
  private JTextField textField;
  private JPasswordField passwordField;
  
  public static void main(String[] args)
  {
    EventQueue.invokeLater(new Runnable()
    {
      public void run()
      {
        try
        {
          LoginFrame frame = new LoginFrame();
          frame.setIconImage(
            new ImageIcon(getClass().getResource("icon.png")).getImage());
          frame.setVisible(true);
        }
        catch (Exception e)
        {
          e.printStackTrace();
        }
      }
    });
  }
  
  public LoginFrame()
  {
    setTitle("Industry Management - Zielyx");
    setResizable(false);
    setDefaultCloseOperation(3);
    setBounds(100, 100, 414, 317);
    this.contentPane = new JPanel();
    this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
    setContentPane(this.contentPane);
    this.contentPane.setLayout(null);
    
    JLabel lblNewLabel = new JLabel("Welcome , Enter your login details");
    lblNewLabel.setForeground(SystemColor.textHighlight);
    lblNewLabel.setFont(new Font("Tahoma", 1, 12));
    lblNewLabel.setBounds(105, 43, 218, 14);
    this.contentPane.add(lblNewLabel);
    
    JLabel lblUsername = new JLabel("Username ");
    lblUsername.setBounds(116, 102, 71, 14);
    this.contentPane.add(lblUsername);
    
    JLabel lblPassword = new JLabel("Password");
    lblPassword.setBounds(116, 153, 58, 14);
    this.contentPane.add(lblPassword);
    
    JButton btnNewButton = new JButton("Login");
    btnNewButton.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent arg0)
      {
        String username = LoginFrame.this.textField.getText();
        String pass = String.valueOf(LoginFrame.this.passwordField.getPassword());
        if (username.equals("admin"))
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
            
            String sql = "SELECT username , password FROM admin_table WHERE username = '" + username + "' AND password = '" + pass + "' ";
            ResultSet rs = st.executeQuery(sql);
            if (rs.next())
            {
              new AdminFrame().setVisible(true);
              LoginFrame.this.dispose();
            }
            else if (!rs.next())
            {
              JOptionPane.showMessageDialog(null, "Sorry Wrong credentials");
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
        else
        {
          Connection con = null;
          Statement st = null;
          String url = "jdbc:mysql://localhost:3306/test";
          String user = "root";
          String password = "";
          try
          {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, user, password);
            st = con.createStatement();
            
            String sql = "SELECT username , password FROM user_table WHERE username = '" + username + "' AND password = '" + pass + "' ";
            ResultSet rs = st.executeQuery(sql);
            if (rs.next())
            {
              new UserFrame().setVisible(true);
              LoginFrame.this.dispose();
            }
            else if (!rs.next())
            {
              JOptionPane.showMessageDialog(null, "Sorry Wrong credentials");
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
    btnNewButton.setBounds(153, 194, 71, 23);
    this.contentPane.add(btnNewButton);
    
    JLabel lblLicensedTo = new JLabel("  Licensed to");
    lblLicensedTo.setBounds(0, 263, 84, 14);
    this.contentPane.add(lblLicensedTo);
    
    JLabel lblPoweredBy = new JLabel("Powered by");
    lblPoweredBy.setBounds(267, 263, 67, 14);
    this.contentPane.add(lblPoweredBy);
    
    JLabel lblSomeone = new JLabel(" Someone");
    lblSomeone.setForeground(SystemColor.textHighlight);
    lblSomeone.setFont(new Font("Tahoma", 1, 12));
    lblSomeone.setBounds(73, 263, 71, 14);
    this.contentPane.add(lblSomeone);
    
    JLabel lblSeizant = new JLabel("Zielyx");
    lblSeizant.setForeground(SystemColor.textHighlight);
    lblSeizant.setFont(new Font("Tahoma", 1, 12));
    lblSeizant.setBounds(344, 263, 46, 14);
    this.contentPane.add(lblSeizant);
    
    this.textField = new JTextField();
    this.textField.setBounds(197, 99, 86, 20);
    this.contentPane.add(this.textField);
    this.textField.setColumns(10);
    
    this.passwordField = new JPasswordField();
    this.passwordField.addKeyListener(new KeyAdapter()
    {
      public void keyPressed(KeyEvent evt)
      {
        if (evt.getKeyCode() == 10)
        {
          String username = LoginFrame.this.textField.getText();
          String pass = String.valueOf(LoginFrame.this.passwordField.getPassword());
          if (username.equals("admin"))
          {
            Connection con = null;
            Statement st = null;
            String url = "jdbc:mysql://localhost:3306/test";
            String user = "root";
            String password = "";
            try
            {
              Class.forName("com.mysql.jdbc.Driver");
              con = DriverManager.getConnection(url, user, password);
              st = con.createStatement();
              
              String sql = "SELECT username , password FROM admin_table WHERE username = '" + username + "' AND password = '" + pass + "' ";
              ResultSet rs = st.executeQuery(sql);
              if (rs.next())
              {
                new AdminFrame().setVisible(true);
                LoginFrame.this.dispose();
              }
              else if (!rs.next())
              {
                JOptionPane.showMessageDialog(null, "Sorry Wrong credentials");
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
          else
          {
            Connection con = null;
            Statement st = null;
            String url = "jdbc:mysql://localhost:3306/test";
            String user = "root";
            String password = "";
            try
            {
              Class.forName("com.mysql.jdbc.Driver");
              con = DriverManager.getConnection(url, user, password);
              st = con.createStatement();
              
              String sql = "SELECT username , password FROM user_table WHERE username = '" + username + "' AND password = '" + pass + "' ";
              ResultSet rs = st.executeQuery(sql);
              if (rs.next())
              {
                new UserFrame().setVisible(true);
                LoginFrame.this.dispose();
              }
              else if (!rs.next())
              {
                JOptionPane.showMessageDialog(null, "Sorry Wrong credentials");
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
      }
    });
    this.passwordField.setBounds(197, 150, 86, 20);
    this.contentPane.add(this.passwordField);
  }
}
