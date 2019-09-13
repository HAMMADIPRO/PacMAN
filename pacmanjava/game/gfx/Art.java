/**
	pacmanjava
    @autor Yassine HAMMADI 
	Created on 12 Sep 2019 at 01:46:28
 */
package gfx;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

public class Art {
	public static  List<BufferedImage>  images ;

	
	public Art() {
		
		
		
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
	

}
