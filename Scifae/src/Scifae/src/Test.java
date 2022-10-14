package Scifae.src;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Test extends JFrame {

	private JPanel contentPane;
	private JPanel addData;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Test frame = new Test();
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
	public Test() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 923, 630);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 10, 873, 560);
	    panel.setVisible(true);
		contentPane.add(panel);
		
		
		
		
		addData = new JPanel();
		JTextField txtSelectedFile;
		JTable table;
		
		addData.setBounds(0, 0, 802, 521);
		addData.setVisible(true);
		addData.setLayout(null);
			
		txtSelectedFile = new JTextField();
		txtSelectedFile.setBounds(109, 90, 215, 20);
		addData.add(txtSelectedFile);
		txtSelectedFile.setColumns(10);
		
			JButton btnUploadFile = new JButton("Upload File");
			btnUploadFile.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					//public void importExcelToJtableJava() {

				        File excelFile;
				        FileInputStream excelFIS = null;
				        BufferedInputStream excelBIS = null;
//				        XSSFWorkbook excelImportToJTable = null;
				        String defaultCurrentDirectoryPath = "C:\\Users\\Authentic\\Desktop";
				        JFileChooser excelFileChooser = new JFileChooser(defaultCurrentDirectoryPath);
				        excelFileChooser.setDialogTitle("Select Excel File");
				        FileNameExtensionFilter fnef = new FileNameExtensionFilter("EXCEL FILES", "xls", "xlsx", "xlsm");
				        excelFileChooser.setFileFilter(fnef);
				        int excelChooser = excelFileChooser.showOpenDialog(null);
				        if (excelChooser == JFileChooser.APPROVE_OPTION) {
				        		//System.out.println("22222222222222222");
				                excelFile = excelFileChooser.getSelectedFile();
				               // System.out.println("tttttttttttttttttt");	
				                //textField.setText(excelFIS.toString());
				                try {
									excelFIS = new FileInputStream(excelFile);
								} catch (FileNotFoundException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
				                // add the excel file selected to the text field !!
				                txtSelectedFile.setText("" + excelFileChooser.getSelectedFile());
				            }          
				        }
				}
			);
			btnUploadFile.setFont(new Font("Tahoma", Font.PLAIN, 18));
			btnUploadFile.setBackground(new Color(64, 224, 208));
			btnUploadFile.setBounds(285, 29, 173, 30);
			
			addData.add(btnUploadFile);
			
			
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(23, 114, 769, 155);
			addData.add(scrollPane);
			
			table = new JTable();
			scrollPane.setViewportView(table);
			table.setModel(new DefaultTableModel(
				new Object[][] {
					{null, null, null},
					{null, null, null},
					{null, null, null},
					{null, null, null},
					{null, null, null},
					{null, null, null},
					{null, null, null},
					{null, null, null},
				},
				new String[] {
					"Date", "EDF", "PV"
				}
			) {
				Class[] columnTypes = new Class[] {
					String.class, Object.class, Object.class
				};
				public Class getColumnClass(int columnIndex) {
					return columnTypes[columnIndex];
				}
			});
			
			JLabel lblNewLabel = new JLabel("Selected File:");
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblNewLabel.setBounds(23, 88, 94, 20);
			addData.add(lblNewLabel);
			table.getColumnModel().getColumn(1).setPreferredWidth(100);
			table.getColumnModel().getColumn(1).setMinWidth(50);
			table.getColumnModel().getColumn(2).setPreferredWidth(100);
			table.getColumnModel().getColumn(2).setMinWidth(50);

			
			JPanel pa = new JPanel();
			pa.setBounds(0, 0, 850, 540);
			addData.setVisible(true);
			pa.setLayout(null);
			pa.add(addData);
			pa.setVisible(true);
			add(pa);
			
			
	}
}
