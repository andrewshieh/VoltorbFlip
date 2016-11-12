import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 * InfoMarker.java
 * for GunnHacks 3.0
 * @author andrewshieh
 *
 */
public class InfoMarker extends JPanel{
	int sum = 0;
	int bombNum = 0;
	JPanel sumBox = new JPanel();
	JPanel bombBox = new JPanel();
	
	public InfoMarker(int sum, int bombNum, Color color) {	
		this.sum  = sum;
		this.bombNum = bombNum;
		init(color);
	}
	
	/**
	 * resets InfoMarkers
	 * @param sum sum of tiles
	 * @param bombNum number of bombs
	 * @param color color of InfoMarker
	 */
	public void reset(int sum, int bombNum, Color color) {
		removeAll();
		sumBox.removeAll();
		bombBox.removeAll();
	
		this.sum  = sum;
		this.bombNum = bombNum;
		init(color);
	}
	
	/**
	 * initializes InfoMarker
	 * @param color color of InfoMarker
	 */
	private void init(Color color) {
		//voltorb icon initialization
		BufferedImage tempPic = null;
		try {
			tempPic = ImageIO.read(this.getClass().getResource("voltorb.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ImageIcon pic = new ImageIcon(tempPic);
		JLabel voltorbIcon = new JLabel(pic);
		
		//GridBagLayout
		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		//top of marker (sum of tile values)
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 0;
		c.gridy = 0;
		c.anchor = GridBagConstraints.LINE_END;
		c.weightx = 1;
		c.weighty= 0.5;
		JLabel sumLabel = new JLabel(""+sum);
		sumBox.add(sumLabel);
		sumBox.setBorder(BorderFactory.createLineBorder(Color.black));
		sumBox.setBackground(color);
		add(sumBox, c);
		
		//bottom of marker (number of bombs)
		bombBox.setBorder(BorderFactory.createLineBorder(Color.black));
		bombBox.setBackground(color);
		bombBox.setLayout(new GridBagLayout());
		c.gridx = 0;
		c.gridy = 0;
		c.weightx = 0.6;
		bombBox.add(voltorbIcon, c);
		c.gridx = 1;
		c.weightx = 0.4;
		bombBox.add(new JLabel(Integer.toString(bombNum)),c);
		c.gridx = 0;
		c.weightx = 1;
		c.gridy = 1;
		c.weighty= 1;
		add(bombBox, c);
	}

	

}
