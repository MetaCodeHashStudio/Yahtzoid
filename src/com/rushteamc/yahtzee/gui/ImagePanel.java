package com.rushteamc.yahtzee.gui;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import com.rushteamc.yahtzee.utils.FileHandling;

//@SuppressWarnings("serial")
public class ImagePanel extends JPanel {

	private static final long serialVersionUID = -1132795389431147872L;
	private BufferedImage image;
	
	public ImagePanel(String filePath) {
		
		
		try {
			URL inputURL = new URL(FileHandling.getWorkingPaths() + filePath);
			InputStream input = new URL(inputURL.toString()).openStream();
			this.image = ImageIO.read(input);
			GridBagLayout gbl_imagePanel = new GridBagLayout();
			gbl_imagePanel.columnWidths = new int[]{image.getWidth()};
			gbl_imagePanel.rowHeights = new int[]{image.getHeight()};
			
			this.setLayout(gbl_imagePanel);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(this.image, 0, 0, null);
    }
}
