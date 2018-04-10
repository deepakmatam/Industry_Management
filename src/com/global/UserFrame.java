package com.global;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class UserFrame
  extends JFrame
{
  private static final long serialVersionUID = 1L;
  private JPanel contentPane;
  
  public static void main(String[] args)
  {
    EventQueue.invokeLater(new Runnable()
    {
      public void run()
      {
        try
        {
          UserFrame frame = new UserFrame();
          frame.setVisible(true);
        }
        catch (Exception e)
        {
          e.printStackTrace();
        }
      }
    });
  }
  
  public UserFrame()
  {
    setDefaultCloseOperation(3);
    setBounds(100, 100, 450, 300);
    this.contentPane = new JPanel();
    this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
    this.contentPane.setLayout(new BorderLayout(0, 0));
    setContentPane(this.contentPane);
  }
}
