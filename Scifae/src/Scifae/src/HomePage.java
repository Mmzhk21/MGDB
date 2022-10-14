package Scifae.src;


import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Panel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Button;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class HomePage extends JFrame {

	private JPanel contentPane;
	
	
	private HomePanel homePanel;
	private RegisterPanel registerPanel;
	private LoginPanel loginPanel;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomePage frame = new HomePage();
					frame.setVisible(true);
					//interfaceSisai is = new interfaceSisai();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public HomePage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 903, 538);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(30, 144, 255));
		panel.setBounds(0, 0, 914, 54);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panH = new JPanel();
		/*panH.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(homePanel);
				
			}
		});*/
		panH.setBackground(new Color(30, 144, 255));
		panH.setBounds(82, 10, 183, 34);
		panel.add(panH);
		panH.setLayout(null);
		
		JButton homeBtn = new JButton("Home");
		homeBtn.setBackground(new Color(30, 144, 255));
		homeBtn.setBorder(null);
		homeBtn.setContentAreaFilled(false);
		homeBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				homeBtn.setBackground(new Color(90, 219, 181));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(homePanel);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				homeBtn.setBackground(new Color(30, 144, 255));
			}
		});
		homeBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menuClicked(homePanel);
			}
			
		});
		homeBtn.setFont(new Font("Tahoma", Font.PLAIN, 20));
		homeBtn.setBounds(10, 0, 173, 34);
		panH.add(homeBtn);
		
		JPanel panS = new JPanel();
		/*panS.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(loginPanel);
			}
		});*/
		panS.setBackground(new Color(30, 144, 255));
		panS.setBounds(438, 10, 183, 34);
		panel.add(panS);
		panS.setLayout(null);
		
		JButton signIn = new JButton("Sign In");
		signIn.setBackground(new Color(30, 144, 255));
		signIn.setBackground(new Color(30, 144, 255));
		signIn.setBorder(null);
		signIn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(loginPanel);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				
				signIn.setBackground(new Color(90, 219, 181));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				signIn.setBackground(new Color(30, 144, 255));
			}
		});
		signIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menuClicked(loginPanel);
			}
			
		});
		signIn.setFont(new Font("Tahoma", Font.PLAIN, 20));
		signIn.setBounds(0, 0, 183, 34);
		panS.add(signIn);
		
		JPanel panG = new JPanel();
		/*panG.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});*/
		panG.setBackground(new Color(30, 144, 255));
		panG.setBounds(659, 10, 183, 34);
		panel.add(panG);
		panG.setLayout(null);
		
		JButton getStartedBtn = new JButton("Get Started");
		getStartedBtn.setBackground(new Color(30, 144, 255));
		getStartedBtn.setBackground(new Color(30, 144, 255));
		getStartedBtn.setBorder(null);
		getStartedBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(registerPanel);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				
				getStartedBtn.setBackground(new Color(90, 219, 181));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				getStartedBtn.setBackground(new Color(30, 144, 255));
			}
		});
		getStartedBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menuClicked(registerPanel);
			}
		});
		getStartedBtn.setFont(new Font("Tahoma", Font.PLAIN, 20));
		getStartedBtn.setBounds(10, 0, 163, 34);
		panG.add(getStartedBtn);
		
		JPanel panelMainContent = new JPanel();
		panelMainContent.setBounds(0, 54, 897, 445);
		contentPane.add(panelMainContent);
		homePanel = new HomePanel();
		homePanel.setBounds(0, 0, 887, 445);
		
		registerPanel = new RegisterPanel();
		registerPanel.setBounds(0, 0, 887, 445);
		
		loginPanel = new LoginPanel();
		loginPanel.setBounds(0, 0, 887, 445);
		
		panelMainContent.setLayout(null);
		
		panelMainContent.add(homePanel);
		panelMainContent.add(registerPanel);
		panelMainContent.add(loginPanel);
		panelMainContent.setVisible(true);
		menuClicked(homePanel);
		
	}
	public void menuClicked(JPanel panel) {
		homePanel.setVisible(false);
		registerPanel.setVisible(false);
		loginPanel.setVisible(false);
		panel.setVisible(true);
	}
}
