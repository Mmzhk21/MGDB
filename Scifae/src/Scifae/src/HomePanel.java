package Scifae.src;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;

public class HomePanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public HomePanel() {
		  this.setBounds(0, 0, 800, 400);
	      setLayout(null);
	      setVisible(true);
	      
	      JLabel lblNewLabel = new JLabel("");
	      lblNewLabel.setIcon(new ImageIcon("C:\\Users\\HAMID\\Desktop\\ELECTRISE-ECO-SMART-ENERGY-LOGO-300x87.png"));
	      lblNewLabel.setBounds(291, 30, 613, 156);
	      add(lblNewLabel);
	      
	      JLabel lblNewLabel_1 = new JLabel("Welcome to home page !!");
	      lblNewLabel_1.setForeground(Color.CYAN);
	      lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
	      lblNewLabel_1.setBounds(291, 193, 462, 143);
	      add(lblNewLabel_1);
	}

}
