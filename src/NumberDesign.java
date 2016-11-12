import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 * NumberDesign.java
 * for GunnHacks 3.0
 * @author andrewshieh
 *
 */
public class NumberDesign extends JPanel{
	//0 = bomb, 2 = 2, etc.
	int item = 0;
	BufferedImage tempPic = null;
	boolean voltorb = false;
	
	public NumberDesign(int item) {
		this.item = item;
		
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
		
		setBackground(new Color (188, 143, 143));
		
		//voltorb icon initialization
		
		try {
			tempPic = ImageIO.read(this.getClass().getResource("voltorb_larger.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ImageIcon pic = new ImageIcon(tempPic);
		
		
		JLabel voltorbIcon = new JLabel(pic);
		
		JLabel label = new JLabel(Integer.toString(item));
		Font labelFont = label.getFont();
		label.setFont(new Font(labelFont.getName(), Font.PLAIN, 35));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setVerticalAlignment(SwingConstants.CENTER);
		label.setForeground(Color.BLACK);
		if(item != 0) {
			add (label, c);
		}
		
		else {
			voltorb = true;
			
		}		
	}
	
	@Override
	  protected void paintComponent(Graphics gr) {

	    super.paintComponent(gr);
	    
	    if (voltorb)
	    	gr.drawImage(tempPic, 0, 0, getWidth(), getHeight(), this);
	}
	
}
