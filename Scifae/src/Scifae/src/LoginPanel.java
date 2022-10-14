package Scifae.src;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class LoginPanel extends JPanel {
	private JTextField userName;
	private JPasswordField passwordField;

	/**
	 * Create the panel.
	 */
	public LoginPanel() {
		setVisible(true);
		 this.setBounds(0, 0, 800, 400);
      setLayout(null);
      
      JLabel lblNewLabel = new JLabel("Login");
      lblNewLabel.setForeground(Color.GREEN);
      lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 35));
      lblNewLabel.setBounds(359, 70, 340, 80);
      add(lblNewLabel);
      
      JLabel lblUsername = new JLabel("Username:");
      lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 16));
      lblUsername.setBounds(282, 173, 105, 43);
      add(lblUsername);
      
      userName = new JTextField();
      userName.setColumns(10);
      userName.setBounds(380, 175, 271, 43);
      add(userName);
      
      JLabel lblPassword = new JLabel("Password:");
      lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
      lblPassword.setBounds(282, 254, 100, 32);
      add(lblPassword);
      
      passwordField = new JPasswordField();
      passwordField.setBounds(380, 245, 271, 41);
      add(passwordField);
      
      JButton btnLogin = new JButton("Login");
      btnLogin.setToolTipText("");
      btnLogin.setForeground(Color.RED);
      btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 14));
      btnLogin.setBackground(Color.GREEN);
      
      btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				    
				try {
					//Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/scifae?allowPublicKeyRetrieval=true&useSSL=false","root","Sql4561");
					String user = userName.getText();
	                String password = passwordField.getText();
	                
	                Statement stm = con.createStatement();
	                String sql = "select * from Register where username='"+user+"' and password='"+password+"';";
	                
	                ResultSet rs = stm.executeQuery(sql);
	                
	                if(rs.next()) {	
		                JOptionPane.showMessageDialog(btnLogin, "Login Successful");
		                MainHome homeP = new MainHome();
		                homeP.show();
						//dispose();
	                } else {
	                    JOptionPane.showMessageDialog(btnLogin, "Invalid Username or Password");
	                    userName.setText("");
	                    passwordField.setText("");
	                }
	                con.close();
				}catch(Exception x) {
					System.out.println(x.getMessage());
				}
			}
		});
      btnLogin.setBounds(380, 325, 147, 43);
      // customize the button with your own look
		btnLogin.setUI(new StyledButtonUI());
      add(btnLogin);
	}

}
