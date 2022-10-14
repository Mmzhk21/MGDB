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


public class VisualizeData extends JPanel {
	private JTable table;
	private JTextField txtDateDeDbut;
	private JTextField txtDateFin;

	/**
	 * Create the panel.
	 */
	public VisualizeData() {
	    setBounds(0, 0, 802, 521);
		setVisible(true);
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(23, 90, 769, 371);
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
		
		JButton btnVisualiser = new JButton("Visualiser");
		btnVisualiser.setBackground(new Color(90, 219, 181));
		btnVisualiser.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnVisualiser.setBounds(227, 28, 167, 33);
		add(btnVisualiser);
		
		JButton btnEnregistrer = new JButton("Enregistrer");
		btnEnregistrer.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnEnregistrer.setBackground(new Color(90, 219, 181));
		btnEnregistrer.setBounds(536, 477, 256, 33);
		add(btnEnregistrer);
		
		txtDateDeDbut = new JTextField();
		txtDateDeDbut.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtDateDeDbut.setText("date d\u00E9but");
		txtDateDeDbut.setBounds(23, 11, 167, 31);
		add(txtDateDeDbut);
		txtDateDeDbut.setColumns(10);
		
		
		
		txtDateFin = new JTextField();
		txtDateFin.setText("date fin");
		txtDateFin.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtDateFin.setColumns(10);
		txtDateFin.setBounds(23, 48, 167, 31);
		add(txtDateFin);
		
		JButton btnVisualiserTout = new JButton("Visualiser Tout");
		btnVisualiserTout.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnVisualiserTout.setBackground(new Color(90, 219, 181));
		btnVisualiserTout.setBounds(541, 28, 167, 33);
		add(btnVisualiserTout);
		table.getColumnModel().getColumn(1).setPreferredWidth(100);
		table.getColumnModel().getColumn(1).setMinWidth(50);
		table.getColumnModel().getColumn(2).setPreferredWidth(100);
		table.getColumnModel().getColumn(2).setMinWidth(50);

	}
}
