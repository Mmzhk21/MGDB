package Scifae.src;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Panel;
import java.awt.Color;
import java.awt.Button;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainHome extends JFrame {

	private JPanel contentPane;
    private ManageDataBase mD;
	private ConsommationPV consPv;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainHome frame = new MainHome();
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
	public MainHome() {
		setBackground(new Color(176, 196, 222));
		setTitle("SCIFAE");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1035, 713);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Panel panel = new Panel();
		panel.setBackground(new Color(75, 75, 75));
		panel.setBounds(0, 0, 216, 674);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton databaseManger = new JButton("Manage DataBase");
		databaseManger.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menuClicked(mD);
			}
		});
		databaseManger.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				databaseManger.setForeground(Color.RED);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				databaseManger.setForeground(new Color(255, 255, 255));
			}
		});
		
		databaseManger.setForeground(new Color(255, 255, 255));
		databaseManger.setBackground(new Color(75, 75, 75));
		databaseManger.setFont(new Font("Dialog", Font.PLAIN, 20));
		databaseManger.setBounds(0, 101, 216, 42);
		databaseManger.setBorder(null);
		databaseManger.setContentAreaFilled(false);
		panel.add(databaseManger);
		
		JButton pVConsommation = new JButton("Consommation PV");
		pVConsommation.setForeground(new Color(255, 255, 255));
		pVConsommation.setBackground(new Color(75, 75, 75));
		pVConsommation.setBorder(null);
		pVConsommation.setContentAreaFilled(false);
		pVConsommation.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				pVConsommation.setForeground(Color.RED);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				pVConsommation.setForeground(new Color(255, 255, 255));
			}
		});
		pVConsommation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menuClicked(consPv);
			}
		});
		pVConsommation.setFont(new Font("Dialog", Font.PLAIN, 20));
		pVConsommation.setBounds(0, 164, 216, 42);
		panel.add(pVConsommation);
		
		JButton btnAutoCons = new JButton("Autoconsommation");
		btnAutoCons.setForeground(new Color(255, 255, 255));
		btnAutoCons.setBackground(new Color(75, 75, 75));
		btnAutoCons.setBorder(null);
		btnAutoCons.setContentAreaFilled(false);
		
		btnAutoCons.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnAutoCons.setForeground(Color.RED);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnAutoCons.setForeground(new Color(255, 255, 255));
			}
		});
		
		
		btnAutoCons.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAutoCons.setFont(new Font("Dialog", Font.PLAIN, 20));
		btnAutoCons.setBounds(0, 227, 216, 42);
		panel.add(btnAutoCons);
		
		JButton button_3 = new JButton("AAAA");
		button_3.setForeground(new Color(255, 255, 255));
		button_3.setBackground(new Color(75, 75, 75));
		button_3.setFont(new Font("Dialog", Font.PLAIN, 20));
		button_3.setBounds(0, 296, 216, 42);
		button_3.setBorder(null);
		button_3.setContentAreaFilled(false);
		
		button_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				button_3.setForeground(Color.RED);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				button_3.setForeground(new Color(255, 255, 255));
			}
		});
		
		
		panel.add(button_3);
		
		JButton button_4 = new JButton("BBBBB\r\n");
		button_4.setForeground(new Color(255, 255, 255));
		button_4.setBackground(new Color(75, 75, 75));
		button_4.setFont(new Font("Dialog", Font.PLAIN, 20));
		button_4.setBounds(0, 359, 216, 42);
		button_4.setBorder(null);
		button_4.setContentAreaFilled(false);
		
		button_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				button_4.setForeground(Color.RED);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				button_4.setForeground(new Color(255, 255, 255));
			}
		});
		
		
		panel.add(button_4);
		
		JPanel mainPanelContent = new JPanel();
		mainPanelContent.setLayout(null);
		mD = new ManageDataBase();
		consPv = new ConsommationPV();
		consPv.setBounds(0, 0, 802, 674);
		//mD.setVisible(true);
		mD.setBounds(0, 0, 802, 674);
		mainPanelContent.add(mD);
		mainPanelContent.add(consPv);
		mainPanelContent.setBounds(217, 0, 802, 674);
		mainPanelContent.setVisible(true);
		contentPane.add(mainPanelContent);
		menuClicked(consPv);
	}
	
	public void menuClicked(JPanel panel) {
		mD.setVisible(false);
		consPv.setVisible(false);
		//loginPanel.setVisible(false);
		panel.setVisible(true);
	}
}
