/**
	pacmanjava
    @autor Yassine HAMMADI 
	Created on 11 Sep 2019 at 22:31:59
 */
package pacmanjava;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.imageio.ImageIO;

 public  class   Shape {
	 
	 
	 private int size ; 

	
	private int posX; 
	private int posY;
	public static  List<BufferedImage>  images ;

	BufferedImage originalImgage ;

	public  Shape() {
		images = new ArrayList<BufferedImage>();


		try {
			BufferedImage originalImgage = ImageIO.read(new File("pacmanTiles.png"));

			System.out.println("Original Image Dimension: "+originalImgage.getWidth()+"x"+originalImgage.getHeight());

			
			for (int i = 0; i < 22; i++) {
				for (int j = 0; j <16; j++) {
					BufferedImage SubImgage = originalImgage.getSubimage(48*j,i*48 , 48, 48);
					images.add(SubImgage);
				}
				
			}	
			
		
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void setPosition(int x, int y ) {
		this.posX=x;
		this.posY=y;
	}

	/**
	 * 
	 */
	public void init() {
		// TODO Auto-generated method stub
		
	}




}
