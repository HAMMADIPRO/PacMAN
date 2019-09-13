/**
	pacmanjava
    @autor Yassine HAMMADI 
	Created on 12 Sep 2019 at 01:31:44
 */
package gfx;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

public class Screen extends Bitmap {


	public static BufferedImage image ;
	
	
	public Screen(int w, int h) {
		super(w, h);
		image = new BufferedImage(w, h,BufferedImage.TYPE_INT_ARGB);

		pixels=((DataBufferInt)image.getRaster().getDataBuffer()).getData();
		
	}
	
	
	
	

	
	
}
