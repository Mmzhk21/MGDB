package Scifae.src;
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





public class InterfaceSisai extends JFrame {
	/*
	 * Interface graphique pour creer la vue login 
	 */
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfaceSisai frame = new InterfaceSisai();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	

	private JFrame frame;
	private JTextField textField;


	
	/**
	 * @wbp.parser.entryPoint
	 */
	public InterfaceSisai() {
		//DefaultTableModel ImportDataFromExcelModel = (DefaultTableModel) jTable1.getModel();
		JFileChooser excelFileChooser;
		frame = new JFrame("Select File");
		frame.getContentPane().setBackground(new Color(224, 255, 255));
		frame.setBounds(10, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		// button add to sql database
		JButton btnAdd = new JButton("Add To BDD");
		//btnNewButton.setIcon(new ImageIcon("/home/saitfask/icons8-sql-30.png"));
		btnAdd.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));

		btnAdd.setFont(new Font("Dialog", Font.BOLD, 17));
		btnAdd.setBackground(Color.CYAN);
		btnAdd.setBounds(259, 221, 177, 40);
		frame.getContentPane().add(btnAdd);
		frame.setVisible(true);
		
		
		
		
		final File excelFile = null;
		final FileInputStream excelFIS = null;
		JButton btnImport = new JButton("Importer");
		btnImport.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
		//btnImport.setIcon(new ImageIcon("/home/saitfask/icons8-ms-excel-35.png"));
		btnImport.setFont(new Font("Dialog", Font.BOLD, 17));
		btnImport.setBackground(Color.CYAN);
		btnImport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//public void importExcelToJtableJava() {

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
							} catch (FileNotFoundException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
			                // add the excel file selected to the text field !!
			                textField.setText("" + excelFileChooser.getSelectedFile());
			            }          
			        }
			}
		);
		
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// action listener for the ADD TO SQL Button ...
				
				try {
					//Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/scifae?allowPublicKeyRetrieval=true&useSSL=false","root","Sql4561");
					
					String s = textField.getText();
					if(s != "") {
					File targetFile = new File(s);
					//obtaining input bytes from a file  
					FileInputStream fis=new FileInputStream(targetFile);
					//creating workbook instance that refers to .xls file  
					
					Workbook workbook = new HSSFWorkbook(fis);
					// System.out.println("ici");
		            Sheet firstSheet = workbook.getSheetAt(0); 
					//evaluating cell type   
					FormulaEvaluator formulaEvaluator=workbook.getCreationHelper().createFormulaEvaluator();  
					int b= 0;
					double dt;
					double pv;
					double edf;
					for(Row row: firstSheet)     //iteration over row using for each loop  
					{  b++;
					    if(b>=13) {						
						ArrayList<String> arr = new ArrayList<String>();
						int j= 0;
						/*
					for(Cell cell: row)    //iteration over cell using for each loop  
					{  
						if(j>0 && j<=3) {
						switch(formulaEvaluator.evaluateInCell(cell).getCellType())  
						{  
						case NUMERIC:   //field that represents numeric cell type  
						//getting the value of the cell as a number  
						System.out.print(cell.getNumericCellValue()+ "\t\t");   
						break;  
						case STRING:    //field that represents string cell type  
						//getting the value of the cell as a string  
						System.out.print(cell.getStringCellValue()+ "\t\t");
						//user = cell.getStringCellValue();
						arr.add(cell.getStringCellValue());
						break;  
						} 
						j++;
						}
						*/
					  
					System.out.println();  
					 
					dt = row.getCell(1).getNumericCellValue();
					pv = row.getCell(2).getNumericCellValue();
					edf = row.getCell(3).getNumericCellValue();
					    
					
					String query="insert into ConsommationAnnuelle values(?,?,?)";
	                
	                PreparedStatement ps = con.prepareStatement(query);
	                 
	                ps.setString(1, Double.toString(dt));
	                ps.setString(2, Double.toString(pv));
	                ps.setString(3, Double.toString(edf));
	                int i = ps.executeUpdate();
	                
	                ps.close();
					}
					} 
					}
					JOptionPane.showMessageDialog(btnAdd,  "import successfully!");
	                con.close();
					
				}catch(Exception x) {
					System.out.println(x.getMessage());
				}
				
				
				
			}
			}
		);
		
		btnImport.setBounds(12, 220, 163, 40);
		frame.getContentPane().add(btnImport);
		
		textField = new JTextField();
		textField.setBounds(41, 99, 347, 40);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblFileChosed = new JLabel("File Chosed :");
		lblFileChosed.setFont(new Font("Dialog", Font.BOLD, 18));
		lblFileChosed.setBounds(168, 68, 163, 15);
		frame.getContentPane().add(lblFileChosed);
		
		
		
		
	}
}
