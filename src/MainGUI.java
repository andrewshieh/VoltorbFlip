import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

/**
 * MainGUI.java
 * for GunnHacks 3.0
 * @author andrewshieh
 *
 */
public class MainGUI extends JFrame{

	private static final Insets inset = new Insets(5,5,5,5); 
	private boolean[][] clickArray = new boolean[5][5];
	private GridBagConstraints c = new GridBagConstraints();
	private JButton[][] buttonArray = new JButton[5][5];
	private InfoMarker[] infoMarkerArray = new InfoMarker[10];
	

	
	public MainGUI() {
		//sets GUI layout
		setLayout(new GridBagLayout());

		getContentPane().setBackground(new Color (49, 176, 104));

		//gbl constraints

		c.fill = GridBagConstraints.BOTH;
		c.weightx = 1;
		c.weighty = 1;
		c.anchor = GridBagConstraints.CENTER;
		c.insets=inset;
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 6;

		Gameboard board = new Gameboard();
		board.fillGameboard();

		//initialize and add the title bar
		TitleMarker title = new TitleMarker();
		add(title, c);

		//right side infomarkers
		for (int i = 0; i < 5; i++) {
			c.fill = GridBagConstraints.BOTH;
			c.weightx = 0.24;
			c.weighty = 0.5;
			c.anchor = GridBagConstraints.CENTER;
			c.insets= inset;
			c.gridx = 5;
			c.gridy = i+1;
			c.gridwidth = 1;
			Color color = Color.black;
			switch (i) {
			case 0:
				color = new Color (224, 112, 80);
				break;
			case 1:
				color = new Color (64, 168, 64);
				break;
			case 2:
				color = new Color (232, 160, 56);
				break;
			case 3:
				color = new Color (48, 144, 248);
				break;
			case 4:
				color = new Color (192, 96, 224);
				break;
			}
			infoMarkerArray[i] = new InfoMarker(board.sumArrayRow(i),board.bombsArrayRow(i), color);
			add(infoMarkerArray[i], c);
		}

		//bottom infomarkers
		for (int i = 5; i < 10; i++) {
			c.fill = GridBagConstraints.BOTH;
			c.weightx = 0.3;
			c.weighty = 0.2;
			c.anchor = GridBagConstraints.CENTER;
			c.insets= inset;
			c.gridx = i-5;
			c.gridy = 6;
			c.gridwidth = 1;
			Color color = Color.black;
			switch (i) {
			case 5:
				color = new Color (224, 112, 80);
				break;
			case 6:
				color = new Color (64, 168, 64);
				break;
			case 7:
				color = new Color (232, 160, 56);
				break;
			case 8:
				color = new Color (48, 144, 248);
				break;
			case 9:
				color = new Color (192, 96, 224);
				break;
			}
			infoMarkerArray[i] = new InfoMarker(board.sumArrayColumn(i-5),board.bombsArrayColumn(i-5), color);
			add(infoMarkerArray[i], c);
			
		}

		//creates the 25 tiles
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				buttonArray[i][j] = new JButton("");
			}
		}

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				c.fill = GridBagConstraints.BOTH;
				c.weightx = 0.5;
				c.weighty = 0.5;
				c.anchor = GridBagConstraints.CENTER;
				c.insets=inset;
				c.gridx = j;
				c.gridy = i+1;
				c.gridwidth = 1;
				buttonArray[i][j].setFocusPainted(false);
				buttonArray[i][j].setMargin(new Insets(0, 0, 0, 0));
				buttonArray[i][j].setContentAreaFilled(false);
				buttonArray[i][j].setLayout(new BorderLayout());
				buttonArray[i][j].setBorder(BorderFactory.createLineBorder(Color.black,2));
				TileDesign checkerLook = new TileDesign();
				buttonArray[i][j].add(checkerLook, BorderLayout.CENTER);
				add(buttonArray[i][j] , c);
				int x = i;
				int y = j;
				//every time a button is clicked:
				buttonArray[i][j].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						
						//check if button has been clicked before
						if(!clickArray[x][y]) {
							updateEverything();
							clickArray[x][y]=true;
							buttonArray[x][y].removeAll();
							buttonArray[x][y].add(new NumberDesign(board.getBoxValue(x, y)), BorderLayout.CENTER);
							board.flip(x, y);
							title.click(board.getScore());

							//game over
							if (board.isOver()) {
								updateEverything();
								for (int p = 0; p < 5; p++) {
									
									for (int z = 0; z < 5; z++) {
										
										if(!clickArray[p][z]) {
											clickArray[p][z]=true;
											buttonArray[p][z].removeAll();
											buttonArray[p][z].add(new NumberDesign(board.getBoxValue(p, z)), BorderLayout.CENTER);
											updateEverything();
										}
										updateEverything();
									}
									updateEverything();
								}
								updateEverything();
								if (board.isWon()) {
									title.win();
									updateEverything();
								}
								
								else {
									title.lose();
									updateEverything();
								}
								updateEverything();
							}


							updateEverything();

						}
						updateEverything();

					}
					
				});

				

			}
			
		}
		updateEverything();

		//info button
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.001;
		c.weighty = 0.5;
		c.anchor = GridBagConstraints.LAST_LINE_END;
		c.insets=inset;
		c.gridx = 0;
		c.gridy = 1;
		c.gridwidth = 1;

		JPanel exitPanel = new JPanel();
		exitPanel.setLayout(new GridBagLayout());
		exitPanel.setBackground(new Color(102,205,170));
		JButton exit = new JButton("Info");
		exit.setBorder(null);
		exit.setBorder(BorderFactory.createLineBorder(Color.black));
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				//creates info popup
				JScrollPane scrollpane = new JScrollPane(); 
			       String categories[] = { "This is a replica of the classic Pokemon minigame 'Voltorb Flip'", 
			    		   "Made by Andrew Shieh (andrewshieh) for GunnHacks 3.0", 
			    		   " ", "How to Play", 
			    		   "1. Click on the green tiles to flip them",
			    		   "2. Each tile will either be a 1, 2, 3, or bomb tile",
			    		   "3. Your score will be multiplied by the tile you flipped. If you flipped a bomb, you lose!",
			    		   "4. The numbers on the right and bottom indicate how the sum of all the tiles and the number of bombs in that row or column"};
			       JList list = new JList(categories);

			       scrollpane = new JScrollPane(list);

			       JPanel panel = new JPanel(); 
			       panel.add(scrollpane);

			       scrollpane.getViewport().add(list);
			       JOptionPane.showMessageDialog(null, scrollpane, "Voltorb Flip Info", JOptionPane.PLAIN_MESSAGE);
			}
		});
		Font labelFont = exit.getFont();
		exit.setFont(new Font(labelFont.getName(), Font.PLAIN, 14));
		exit.setHorizontalAlignment(SwingConstants.CENTER);
		exit.setVerticalAlignment(SwingConstants.CENTER);
		exit.setBackground(Color.WHITE);
		exit.setOpaque(true);
		exitPanel.add(exit,c);

		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.001;
		c.weighty = 1;
		c.anchor = GridBagConstraints.LAST_LINE_END;
		c.insets=inset;
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 1;

		JButton reset = new JButton("Reset");
		reset.setBackground(Color.WHITE);
		reset.setOpaque(true);
		reset.setBorder(null);
		reset.setBorder(BorderFactory.createLineBorder(Color.black));

		//called every time reset button is hit
		reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				title.setMessage();
				board.resetGame();
				for (int i = 0; i < 5; i++) {
					
					for (int j = 0; j < 5; j++) {
						updateEverything();
						clickArray[i][j]=false;
						buttonArray[i][j].removeAll();
						
						TileDesign checkerLook = new TileDesign();
						buttonArray[i][j].add(checkerLook, BorderLayout.CENTER);
						
						
						//Right Side
						for (int i1 = 0; i1 < 5; i1++) {
							c.fill = GridBagConstraints.BOTH;
							c.weightx = 0.24;
							c.weighty = 0.5;
							c.anchor = GridBagConstraints.CENTER;
							c.insets= inset;
							c.gridx = 5;
							c.gridy = i1+1;
							c.gridwidth = 1;
							Color color = Color.black;
							switch (i1) {
							case 0:
								color = new Color (224, 112, 80);
								break;
							case 1:
								color = new Color (64, 168, 64);
								break;
							case 2:
								color = new Color (232, 160, 56);
								break;
							case 3:
								color = new Color (48, 144, 248);
								break;
							case 4:
								color = new Color (192, 96, 224);
								break;
							}
							infoMarkerArray[i1].reset(board.sumArrayRow(i1),board.bombsArrayRow(i1), color);
						}
						updateEverything();

						//Bottom
						for (int i1 = 5; i1 < 10; i1++) {
							
							c.fill = GridBagConstraints.BOTH;
							c.weightx = 0.3;
							c.weighty = 0.2;
							c.anchor = GridBagConstraints.CENTER;
							c.insets= inset;
							c.gridx = i1-5;
							c.gridy = 6;
							c.gridwidth = 1;
							Color color = Color.black;
							switch (i1) {
							case 5:
								color = new Color (224, 112, 80);
								break;
							case 6:
								color = new Color (64, 168, 64);
								break;
							case 7:
								color = new Color (232, 160, 56);
								break;
							case 8:
								color = new Color (48, 144, 248);
								break;
							case 9:
								color = new Color (192, 96, 224);
								break;
							}
							infoMarkerArray[i1].reset(board.sumArrayColumn(i1-5),board.bombsArrayColumn(i1-5), color);
							updateEverything();
						}
						updateEverything();
						
					}
					updateEverything();
				}
				updateEverything();
			}
		});
		
		Font resetFont = reset.getFont();
		reset.setFont(new Font(resetFont.getName(), Font.PLAIN, 14));
		reset.setHorizontalAlignment(SwingConstants.CENTER);
		reset.setVerticalAlignment(SwingConstants.CENTER);
		exitPanel.add(reset,c);

		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.2;
		c.weighty = 0.2;
		c.anchor = GridBagConstraints.LAST_LINE_END;
		c.insets=new Insets(15,15,5,5);
		c.gridx = 5;
		c.gridy = 6;
		c.gridwidth = 1;
		add(exitPanel,c);

	}
	
	
	public void updateEverything() {
		revalidate();
		repaint();
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 5; j++) {
				buttonArray[i][j].invalidate();
				buttonArray[i][j].validate();
				
				int u = i;
				int r = j;
				EventQueue.invokeLater(new Runnable()
			    {
			        public void run()
			        {
			        	buttonArray[u][r].repaint();
			        }
			    });
				
			}
		}
		
		for(int i = 0; i < 10; i++) {
			infoMarkerArray[i].invalidate();
			infoMarkerArray[i].validate();
			int u = i;
			EventQueue.invokeLater(new Runnable()
		    {
		        public void run()
		        {
		        	infoMarkerArray[u].repaint();
		        }
		    });
			
			
		}
	}
}
