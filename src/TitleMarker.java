import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;


/**
 * TitleMarker.java
 * for GunnHacks 3.0
 * @author andrewshieh
 *
 */
public class TitleMarker extends JPanel {
	
	private JLabel p = new JLabel();
	
	
	/**
	 * creates the title marker
	 */
	public TitleMarker() {
		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.5;
		c.weighty = 0.5;
		c.anchor = GridBagConstraints.CENTER;
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 1;
		
		this.setBorder(BorderFactory.createLineBorder(new Color(131,185,245), 5));
		setMessage();
		
		Font labelFont = p.getFont();
		p.setFont(new Font(labelFont.getName(), Font.BOLD, 16));
		p.setHorizontalAlignment(SwingConstants.CENTER);
		p.setVerticalAlignment(SwingConstants.CENTER);
		p.setForeground(Color.BLACK);
		
		add(p,c);
	}
	
	
	/** below are the different messages for the text/title box */
	
	public void setMessage() {
		p.setText("Flip the cards and collect coins!");
	}
	
	public void click(int score) {
		p.setText("Score: " + score);
	}
	
	public void lose() {
		p.setText("Oh no! You get 0 coins!");
	}
	
	public void win() {
		p.setText("You win!");
	}
	
	public void restart() {
		setMessage();
	}
}
