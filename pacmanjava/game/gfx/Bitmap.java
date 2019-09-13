/**
	pacmanjava
    @autor Yassine HAMMADI 
	Created on 12 Sep 2019 at 00:58:34
 */
package gfx;

import java.util.Arrays;


public class Bitmap {
	
	public int w, h;
	public int []pixels;
	
	
	public Bitmap(int w, int h) {
		this.w=w;
		this.h=h;
		pixels=new int[w * h];
		
	}
	
	
	public void clear(int color) {
		Arrays.fill(pixels, color);
	}
	
	
	public void render(Bitmap bitmap,int x, int y) {		
		int x0=x;
		int x1=x+bitmap.w;
		int y0=y;
		int y1=y+bitmap.h;	
		if(x0<0) x0=0;
		if(x1>w) x1=w;
		if(y0<0) y0=0;
		if(y1>h) y1=h;	
		int ww=x1-x0;
		
		for (int i = y0; i < y1; i++) {
			int tp=i*w+x0;
			int sp=(i-y)*bitmap.w+(x0-x);
			tp-=sp;
			for (int j = sp; j < sp+ww; j++) {
				int col=bitmap.pixels[j];
				if(col<0)pixels[tp+j]=col;
				
			}
			
		}
		
	}
	
	

}
