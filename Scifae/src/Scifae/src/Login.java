package Scifae.src;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField userName;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setFont(new Font("Dialog", Font.PLAIN, 18));
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\HAMID\\Desktop\\ELECTRISE-ECO-SMART-ENERGY-LOGO-300x87.png"));
		setTitle("SCIFAE");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 680, 470);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Login");
		lblNewLabel.setForeground(Color.GREEN);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblNewLabel.setBounds(247, 48, 340, 80);
		contentPane.add(lblNewLabel);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblUsername.setBounds(163, 172, 89, 32);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPassword.setBounds(163, 220, 100, 32);
		contentPane.add(lblPassword);
		
		userName = new JTextField();
		//userName.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
		userName.setColumns(10);
		userName.setBounds(260, 172, 219, 32);
		contentPane.add(userName);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setToolTipText("");
		btnLogin.setBackground(Color.GREEN);
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnLogin.setForeground(new Color(255, 0, 0));
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
		                InterfaceSisai saisi = new InterfaceSisai();
		                saisi.show();
						dispose();
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
		btnLogin.setBounds(250, 285, 105, 35);
		
		 // customize the button with your own look
		btnLogin.setUI(new StyledButtonUI());
		
		contentPane.add(btnLogin);
		
		JLabel lblNewLabel_1 = new JLabel("Click here to create a new account");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(new Color(0, 0, 153));
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Register rg = new Register();
			//	rg.setVisible(true);
				//rg.pack();
				rg.show();
			//	rg.setLocationRelativeTo(null);
				//rg.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				dispose();
				
			}
		});
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(195, 352, 263, 20);
		contentPane.add(lblNewLabel_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(260, 220, 219, 32);
		
		contentPane.add(passwordField);
	}
}

