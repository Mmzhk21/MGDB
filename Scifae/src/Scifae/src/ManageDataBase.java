package Scifae.src;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.Panel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ManageDataBase extends JPanel {

	/**
	 * Create the panel.
	 */
	private AddData addData;
	private HomeManageData homeManageData;
	private VisualizeData visualizeData;
	private ExportFile exportFile;
	
	public ManageDataBase() {
		setBounds(0, 0, 802, 674);		
		setVisible(true);
		setLayout(null);
		Panel panelButtons = new Panel();
		panelButtons.setBounds(0, 0, 802, 48);
		add(panelButtons);
		panelButtons.setLayout(null);
		
		JButton btnDelData = new JButton("Visualise Data");
		btnDelData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menuClicked(visualizeData);
			}
		});
		btnDelData.setBounds(300, 11, 147, 30);
		panelButtons.add(btnDelData);
		btnDelData.setBackground(new Color(64, 224, 208));
		btnDelData.setFont(new Font("Tahoma", Font.PLAIN, 18));
		// customize the button with your own look
		btnDelData.setUI(new StyledButtonUI());
		
		JButton btnAddFile = new JButton("Upload Data");
		btnAddFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menuClicked(addData);
			}
		});
		btnAddFile.setBounds(151, 11, 139, 30);
		panelButtons.add(btnAddFile);
		btnAddFile.setBackground(new Color(64, 224, 208));
		btnAddFile.setFont(new Font("Tahoma", Font.PLAIN, 18));
		// customize the button with your own look
		btnAddFile.setUI(new StyledButtonUI());
		
		JButton btnExportData = new JButton("Export Data");
		btnExportData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menuClicked(exportFile);
			}
		});
		btnExportData.setBounds(457, 11, 147, 30);
		panelButtons.add(btnExportData);
		btnExportData.setBackground(new Color(64, 224, 208));
		btnExportData.setFont(new Font("Tahoma", Font.PLAIN, 18));
		// customize the button with your own look
		btnExportData.setUI(new StyledButtonUI());
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
	    addData = new AddData();
	    homeManageData = new HomeManageData();
	    visualizeData = new VisualizeData();
	    exportFile = new ExportFile();
	    exportFile.setBounds(0, 0, 802, 521);
	    visualizeData.setBounds(0, 0, 802, 521);
	    homeManageData.setBounds(0, 0, 802, 521);
		addData.setBounds(0, 0, 802, 521);
		panel.add(addData);
		panel.add(homeManageData);
		panel.add(visualizeData);
		panel.add(exportFile);
		panel.setBounds(0, 46, 802, 521);
		panel.setVisible(true);
		add(panel);
		menuClicked(homeManageData);
	}
	public void menuClicked(JPanel panel) {
		addData.setVisible(false);
		homeManageData.setVisible(false);
		visualizeData.setVisible(false);
		exportFile.setVisible(false);
		panel.setVisible(true);
	}
}
