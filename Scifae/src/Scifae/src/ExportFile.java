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


public class ExportFile extends JPanel {
	private JTextField txtDateDbut;
	private JTextField textField_1;

	/**
	 * Create the panel.
	 */
	public ExportFile() {
	    setBounds(0, 0, 802, 521);
		setVisible(true);
		setLayout(null);
		
		JButton btnNewButton = new JButton("export");
		btnNewButton.setBackground(new Color(175, 238, 238));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton.setBounds(77, 236, 220, 43);
		add(btnNewButton);
		
		txtDateDbut = new JTextField();
		txtDateDbut.setText("date d\u00E9but");
		txtDateDbut.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtDateDbut.setColumns(10);
		txtDateDbut.setBounds(77, 148, 167, 31);
		add(txtDateDbut);
		
		textField_1 = new JTextField();
		textField_1.setText("date fin");
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_1.setColumns(10);
		textField_1.setBounds(313, 148, 167, 31);
		add(textField_1);
		
		JButton btnExportTout = new JButton("export tout");
		btnExportTout.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnExportTout.setBackground(new Color(175, 238, 238));
		btnExportTout.setBounds(418, 236, 220, 43);
		add(btnExportTout);

	}
}