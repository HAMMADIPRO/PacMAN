/**
	pacmanjava
    @autor Yassine HAMMADI 
	Created on 12 Sep 2019 at 15:36:44
 */
package gfx;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import pacmanjava.Sprite;

/**
 * @author yassine
 *
 */
public class Font extends Sprite{


	
public static final String text ="0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ:";

	
	public final static  int  TILESIZE =48;


	public Font( ) {
		
	
		
	

	}


		public  void draw(Graphics g, String msg,int posX,int posY,List<BufferedImage> images ,int fontsize) {
			
			images = new ArrayList<BufferedImage>();


			try {
				BufferedImage originalImgage = ImageIO.read(new File("pacmanTiles.png"));
				for (int i = 0; i < originalImgage.getHeight()/TILESIZE; i++) {
					for (int j = 0; j <originalImgage.getWidth()/TILESIZE; j++) {
						BufferedImage SubImgage = originalImgage.getSubimage(TILESIZE*j,i*TILESIZE , TILESIZE, TILESIZE);
						images.add(SubImgage);
					}

				}	


			} catch (IOException e) {
				e.printStackTrace();
			}
			
			msg=msg.toUpperCase();
			int length=msg.length();

			for (int i = 0; i < length; i++) {

				int  c= text.indexOf(msg.charAt(i));
				//System.out.println(c);
				if(c<0) {posX+=fontsize; continue ;}

						g.drawImage(images.get(28+c),posX,posY,fontsize,fontsize+5,null);
						posX+=fontsize;			


			
		}
	
		

		


	}



}
