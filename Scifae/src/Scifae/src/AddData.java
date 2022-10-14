package Scifae.src;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JTabbedPane;
import javax.swing.table.DefaultTableModel;
import java.awt.ScrollPane;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import javax.swing.border.CompoundBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class AddData extends JPanel {
	
	private JTextField txtSelectedFile;
	private JTable table;

	/**
	 * Create the panel.
	 */
	public AddData() {
	    setBounds(0, 0, 802, 521);
		setVisible(true);
		setLayout(null);
		
		JButton btnUploadFile = new JButton("Upload File");
		btnUploadFile.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnUploadFile.setBackground(new Color(46, 139, 87));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnUploadFile.setBackground(new Color(90, 219, 181));
			}
		});
		btnUploadFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//public void importExcelToJtableJava() {
                    DefaultTableModel defaultTableModel = (DefaultTableModel) table.getModel();
			        File excelFile;
			        FileInputStream excelFIS = null;
			        BufferedInputStream excelBIS = null;
//			        XSSFWorkbook excelImportToJTable = null;
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
							
			                // add the excel file selected to the text field !!
			                txtSelectedFile.setText("" + excelFileChooser.getSelectedFile());
			                
			                /*
			                 * 
			                 */
			               // File targetFile = new File(s);
							//obtaining input bytes from a file  
							FileInputStream fis;
							
								fis = new FileInputStream(excelFileChooser.getSelectedFile());
							
							BufferedInputStream	excelBis = new BufferedInputStream(fis);
							//creating workbook instance that refers to .xls file  
							
							Workbook workbook = new HSSFWorkbook(excelBis);
							// System.out.println("ici");
							Sheet firstSheet = workbook.getSheetAt(0); 
							//evaluating cell type   
							FormulaEvaluator formulaEvaluator=workbook.getCreationHelper().createFormulaEvaluator();  
							
							for(int i = 13; i< firstSheet.getLastRowNum(); i++)     //iteration over row using for each loop  
							{
						    Row row = firstSheet.getRow(i);
							Cell tdt = row.getCell(0);
							Cell pv = row.getCell(1);
							Cell edf = row.getCell(2);
							if(tdt == null) {
								break;
							}
							defaultTableModel.addRow(new Object[] {tdt,pv,edf});
							
							
							    }
							
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
			                /*
			                 * 
			                 */
			            }          
			        
			}}
		);
		btnUploadFile.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnUploadFile.setBackground(new Color(90, 219, 181));
		btnUploadFile.setBounds(304, 49, 173, 30);
		
		add(btnUploadFile);
		
		txtSelectedFile = new JTextField();
		txtSelectedFile.setBounds(109, 90, 215, 20);
		add(txtSelectedFile);
		txtSelectedFile.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(23, 115, 769, 264);
		add(scrollPane);
		
		table = new JTable();
		table.setBorder(new CompoundBorder());
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new Object[] {
				"Date", "EDF", "PV"
			}
		) {
			Class[] columnTypes = new Class[] {
					Object.class, Object.class, Object.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.getColumnModel().getColumn(1).setPreferredWidth(100);
		table.getColumnModel().getColumn(1).setMinWidth(50);
		table.getColumnModel().getColumn(2).setPreferredWidth(100);
		table.getColumnModel().getColumn(2).setMinWidth(50);
		
		JLabel lblNewLabel = new JLabel("Selected File:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(23, 88, 94, 20);
		add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Add to DataBase");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					//Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/scifae?allowPublicKeyRetrieval=true&useSSL=false","root","Sql4561");
					
					String s = txtSelectedFile.getText();
					if(s != "") {
						FileInputStream fis = new FileInputStream(s);
						
						BufferedInputStream	excelBis = new BufferedInputStream(fis);
						//creating workbook instance that refers to .xls file  
						
						Workbook workbook = new HSSFWorkbook(excelBis);
						// System.out.println("ici");
						Sheet firstSheet = workbook.getSheetAt(0); 
						//evaluating cell type   
						FormulaEvaluator formulaEvaluator=workbook.getCreationHelper().createFormulaEvaluator();  
						
						for(int i = 13; i< 100; i++)     //iteration over row using for each loop  
						{
						    Row row = firstSheet.getRow(i);
							Cell tdt = row.getCell(0);
							Cell pv = row.getCell(1);
							Cell edf = row.getCell(2);
							
							String query="insert into ConsommationAnnuelle values(?,?,?)";
			                
			                PreparedStatement ps = con.prepareStatement(query);
			                 
			                ps.setString(1, tdt.toString());
			                ps.setString(2, pv.toString());
			                ps.setString(3, edf.toString());
			              
			                int v = ps.executeUpdate();		                
		                    ps.close();
						}
						
					}
					JOptionPane.showMessageDialog(btnNewButton,  "import successfully!");
	                con.close();
					
				}catch(Exception x) {
					System.out.println(x.getMessage());
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(585, 439, 207, 38);
		add(btnNewButton);

	}
}
