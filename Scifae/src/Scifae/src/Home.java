package Scifae.src;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import java.awt.Toolkit;
import java.awt.Dialog.ModalExclusionType;
import java.awt.Insets;
import java.awt.Panel;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Label;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.UIManager;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Home {

	private JFrame frmScifae;
	
	private HomePanel homePanel;
	private RegisterPanel registerPanel;
	private LoginPanel loginPanel;
	private Panel panlMainContent;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home window = new Home();
					window.frmScifae.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Home() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmScifae = new JFrame();
		frmScifae.setForeground(new Color(0, 0, 0));
		frmScifae.setTitle("SCIFAE");
		frmScifae.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\HAMID\\Desktop\\ELECTRISE-ECO-SMART-ENERGY-LOGO-300x87.png"));
		frmScifae.setBounds(100, 100, 906, 553);
		frmScifae.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmScifae.getContentPane().setLayout(null);
		
		Panel panel = new Panel();
		panel.setBackground(new Color(30, 144, 255));
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setVgap(10);
		flowLayout.setHgap(100);
		panel.setBounds(0, 0, 890, 51);
		frmScifae.getContentPane().add(panel);
		
		JMenuItem home = new JMenuItem("Home");
		home.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				homePanel.setVisible(true);
				registerPanel.setVisible(false);
				loginPanel.setVisible(false);
				panlMainContent.add(homePanel);
				panlMainContent.setVisible(true);
				
			}
		});
		home.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				homePanel.setVisible(true);
				registerPanel.setVisible(false);
				loginPanel.setVisible(false);
				panlMainContent.add(homePanel);
				panlMainContent.setVisible(true);
			}
		});
		home.setForeground(new Color(0, 0, 0));
		home.setBackground(new Color(30, 144, 255));
		home.setFont(new Font("Segoe UI", Font.BOLD, 17));
		home.setHorizontalAlignment(SwingConstants.LEFT);
		panel.add(home);
		
		JMenuItem signIn = new JMenuItem("Sign In");
		signIn.setForeground(new Color(0, 0, 0));
		signIn.setBackground(new Color(30, 144, 255));
		signIn.setFont(new Font("Segoe UI", Font.BOLD, 17));
		panel.add(signIn);
		
		JMenuItem signUp = new JMenuItem("Get Started");
		signUp.setForeground(new Color(0, 0, 0));
		signUp.setBackground(new Color(30, 144, 255));
		signUp.setFont(new Font("Segoe UI", Font.BOLD, 17));
		signUp.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(signUp);
		
		panlMainContent = new Panel();
		homePanel = new HomePanel();
		registerPanel = new RegisterPanel();
		loginPanel = new LoginPanel();
		panlMainContent.add(homePanel);
		panlMainContent.add(registerPanel);
		panlMainContent.add(loginPanel);
		
		panlMainContent.setBounds(0, 53, 890, 461);
		frmScifae.getContentPane().add(panlMainContent);
	}
}
