package Scifae.src;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;

public class RegisterPanel extends JPanel {
	private JTextField firstName;
	private JTextField lastName;
	private JTextField userName;
	private JPasswordField password;

	/**
	 * Create the panel.
	 */
	public RegisterPanel() {
		setVisible(true);
		 this.setBounds(0, 0, 800, 400);
	    setLayout(null);
		JLabel lblNewLabel = new JLabel("Create Account");
		lblNewLabel.setForeground(new Color(51, 204, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 33));
		lblNewLabel.setBounds(264, 56, 288, 40);
		add(lblNewLabel);
		
		JLabel jLabelfirstName = new JLabel("First Name:");
		jLabelfirstName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		jLabelfirstName.setBounds(253, 120, 77, 28);
		add(jLabelfirstName);
		
		JLabel lblLastName = new JLabel("Last Name:");
		lblLastName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblLastName.setBounds(253, 166, 89, 28);
		add(lblLastName);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblUsername.setBounds(253, 219, 89, 25);
		add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPassword.setBounds(253, 265, 77, 31);
		add(lblPassword);
		
		firstName = new JTextField();
		firstName.setForeground(Color.BLACK);
		firstName.setColumns(10);
		firstName.setBounds(353, 122, 275, 28);
		add(firstName);
		
		lastName = new JTextField();
		lastName.setColumns(10);
		lastName.setBounds(352, 168, 276, 28);
		add(lastName);
		
		userName = new JTextField();
		userName.setColumns(10);
		userName.setBounds(352, 219, 276, 28);
		add(userName);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.setForeground(Color.BLACK);
		btnRegister.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnRegister.setBackground(Color.GREEN);
		btnRegister.setBounds(318, 328, 219, 34);
		// customize the button with your own look
		btnRegister.setUI(new StyledButtonUI());
		
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					//Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/scifae?allowPublicKeyRetrieval=true&useSSL=false","root","Sql4561");
					String query="insert into Register values(?,?,?,?)";
	                
	                PreparedStatement ps = con.prepareStatement(query);
	                if(!(firstName.getText()=="" && lastName.getText()=="" && userName.getText() =="" && password.getText() =="")) {
	                ps.setString(1, firstName.getText());
	                ps.setString(2, lastName.getText());
	                ps.setString(3, userName.getText());
	                ps.setString(4, password.getText());
	                
	                int i = ps.executeUpdate();
	                JOptionPane.showMessageDialog(btnRegister,  "account created successfully!");
	                ps.close();
	                con.close();
	                MainHome homeP = new MainHome();
	                homeP.show();
					//dispose();
	                }else {
	                	 JOptionPane.showMessageDialog(btnRegister,  "remplissez tous les champs!");
	                }
				}catch(Exception x) {
					System.out.println(x.getMessage());
				}
			}
		});
		add(btnRegister);
		
		password = new JPasswordField();
		password.setBounds(353, 267, 275, 31);
		add(password);

	}

}
