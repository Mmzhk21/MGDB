package Scifae.src;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.UIManager;
import javax.swing.SwingConstants;
import javax.swing.DropMode;
import javax.swing.JFormattedTextField;
import java.awt.Canvas;

public class Register extends JFrame {

	private JPanel contentPane;
	private JTextField firstName;
	private JTextField lastName;
	private JTextField userName;
	private JPasswordField password;
	//private Border border;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Register frame = new Register();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Register() {
		//border = new Border();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 680, 470);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Create Account");
		lblNewLabel.setForeground(new Color(51, 204, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 33));
		lblNewLabel.setBounds(260, 24, 288, 40);
		contentPane.add(lblNewLabel);
		
		JLabel jLabelfirstName = new JLabel("First Name:");
		jLabelfirstName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		jLabelfirstName.setBounds(260, 75, 77, 28);
		contentPane.add(jLabelfirstName);
		
		JLabel lblLastName = new JLabel("Last Name:");
		lblLastName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblLastName.setBounds(260, 143, 89, 28);
		contentPane.add(lblLastName);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblUsername.setBounds(260, 207, 89, 25);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPassword.setBounds(260, 260, 77, 31);
		contentPane.add(lblPassword);
		
		
		firstName = new JTextField();
		//firstName.setBorder(new Border(10));
		firstName.setForeground(new Color(0, 0, 0));
		firstName.setBounds(260, 104, 251, 28);
		contentPane.add(firstName);
		firstName.setColumns(10);
		
		lastName = new JTextField();
		lastName.setColumns(10);
		lastName.setBounds(260, 168, 251, 28);
		contentPane.add(lastName);
		
		userName = new JTextField();
		userName.setColumns(10);
		userName.setBounds(260, 232, 251, 27);
		contentPane.add(userName);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnRegister.setBackground(Color.GREEN);
		btnRegister.setForeground(Color.BLACK);
		
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
	                InterfaceSisai saisi = new InterfaceSisai();
	                saisi.show();
					dispose();
	                }else {
	                	 JOptionPane.showMessageDialog(btnRegister,  "remplissez tous les champs!");
	                }
				}catch(Exception x) {
					System.out.println(x.getMessage());
				}
			}
		});
		btnRegister.setBounds(260, 344, 151, 34);
		contentPane.add(btnRegister);
		
		JLabel lblNewLabel_1 = new JLabel("You already have an account");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(new Color(0, 0, 153));
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Login lg = new Login();
				/*rg.setVisible(true);
				rg.pack();
				rg.setLocationRelativeTo(null);
				rg.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				*/
				lg.show();
				dispose();
			}
		});
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(233, 389, 263, 20);
		contentPane.add(lblNewLabel_1);
		
		password = new JPasswordField();
		password.setBounds(261, 292, 250, 31);
		contentPane.add(password);
	}
}
