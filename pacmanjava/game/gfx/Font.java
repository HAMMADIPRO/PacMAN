/**
	pacmanjava
    @autor Yassine HAMMADI 
	Created on 12 Sep 2019 at 15:36:44
 */
package gfx;

import java.awt.Graphics;

import pacmanjava.Shape;

/**
 * @author yassine
 *
 */
public class Font {

	public static final String text ="0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ:";

	
	public final static int fontSize =15;

	private Font() {

	}

	public  static int getStringWidth(String text) {
		return text.length()*12;

	}

	public static void draw(Graphics g , String msg , int x, int y) {
		msg=msg.toUpperCase();
		int length=msg.length();

		for (int i = 0; i < length; i++) {

			int  c= text.indexOf(msg.charAt(i));
			//System.out.println(c);
			if(c<0) {x+=fontSize; continue ;}

					g.drawImage(Shape.images.get(28+c),x,y,fontSize,fontSize+5,null);
					x+=fontSize;			



		}


	}



}
