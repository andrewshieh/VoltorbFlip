import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * TileDesign.java
 * for GunnHacks 3.0
 * @author andrewshieh
 * 
 */
public class TileDesign extends JPanel{
	public TileDesign() {
		//create layout and constraints
		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.5;
		c.weighty = 0.5;
		c.anchor = GridBagConstraints.CENTER;
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 1;
		
		//add each colored square
		JLabel darkGreen1 = new JLabel();
		darkGreen1.setBackground(new Color(24,128,96));
		darkGreen1.setOpaque(true);
		add(darkGreen1, c);
		
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.5;
		c.weighty = 0.5;
		c.anchor = GridBagConstraints.CENTER;
		c.gridx = 1;
		c.gridy = 1;
		c.gridwidth = 1;
		JLabel darkGreen2 = new JLabel();
		darkGreen2.setBackground(new Color(24,128,96));
		darkGreen2.setOpaque(true);
		add(darkGreen2, c);
		
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.5;
		c.weighty = 0.5;
		c.anchor = GridBagConstraints.CENTER;
		c.gridx = 2;
		c.gridy = 2;
		c.gridwidth = 1;
		JLabel darkGreen3 = new JLabel();
		darkGreen3.setBackground(new Color(24,128,96));
		darkGreen3.setOpaque(true);
		add(darkGreen3, c);
		
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.5;
		c.weighty = 0.5;
		c.anchor = GridBagConstraints.CENTER;
		c.gridx = 0;
		c.gridy = 2;
		c.gridwidth = 1;
		JLabel darkGreen4 = new JLabel();
		darkGreen4.setBackground(new Color(24,128,96));
		darkGreen4.setOpaque(true);
		add(darkGreen4, c);
		
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.5;
		c.weighty = 0.5;
		c.anchor = GridBagConstraints.CENTER;
		c.gridx = 2;
		c.gridy = 0;
		c.gridwidth = 1;
		JLabel darkGreen5 = new JLabel();
		darkGreen5.setBackground(new Color(24,128,96));
		darkGreen5.setOpaque(true);
		add(darkGreen5, c);
		
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.5;
		c.weighty = 0.5;
		c.anchor = GridBagConstraints.CENTER;
		c.gridx = 1;
		c.gridy = 0;
		c.gridwidth = 1;
		JLabel lightGreen1 = new JLabel();
		lightGreen1.setBackground(new Color(39,159,103));
		lightGreen1.setOpaque(true);
		add(lightGreen1, c);
		
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.5;
		c.weighty = 0.5;
		c.anchor = GridBagConstraints.CENTER;
		c.gridx = 1;
		c.gridy = 2;
		c.gridwidth = 1;
		JLabel lightGreen2 = new JLabel();
		lightGreen2.setBackground(new Color(39,159,103));
		lightGreen2.setOpaque(true);
		add(lightGreen2, c);
		
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.5;
		c.weighty = 0.5;
		c.anchor = GridBagConstraints.CENTER;
		c.gridx = 0;
		c.gridy = 1;
		c.gridwidth = 1;
		JLabel lightGreen3 = new JLabel();
		lightGreen3.setBackground(new Color(39,159,103));
		lightGreen3.setOpaque(true);
		add(lightGreen3, c);
		
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.5;
		c.weighty = 0.5;
		c.anchor = GridBagConstraints.CENTER;
		c.gridx = 2;
		c.gridy = 1;
		c.gridwidth = 1;
		JLabel lightGreen4 = new JLabel();
		lightGreen4.setBackground(new Color(39,159,103));
		lightGreen4.setOpaque(true);
		add(lightGreen4, c);
		
	}
}
