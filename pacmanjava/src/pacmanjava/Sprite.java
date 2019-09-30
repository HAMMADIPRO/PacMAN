/**
	pacmanjava
    @autor Yassine HAMMADI 
	Created on 11 Sep 2019 at 22:31:59
 */
package pacmanjava;


import java.awt.image.BufferedImage;
import java.util.List;

import javax.swing.JPanel;


 public  class   Sprite extends JPanel {
	 
	protected int size ; 
	protected int posX; 
	protected int posY;
	protected  List<BufferedImage>  images ;
	//private BufferedImage originalImgage ;

	

	public Sprite() {
		// TODO Auto-generated constructor stub
	}
	

	public Sprite(int size, int posX, int posY, List<BufferedImage> images) {
		super();
		this.size = size;
		this.posX = posX;
		this.posY = posY;
		this.images = images;
	//	this.originalImgage = originalImgage;
	}

	/**
	 * @return the size
	 */
	

	/**
	 * @param size the size to set
	 */
	public void setSize(int size) {
		this.size = size;
	}

	/**
	 * @return the posX
	 */
	public int getPosX() {
		return posX;
	}

	/**
	 * @param posX the posX to set
	 */
	public void setPosX(int posX) {
		this.posX = posX;
	}

	/**
	 * @return the posY
	 */
	public int getPosY() {
		return posY;
	}

	/**
	 * @param posY the posY to set
	 */
	public void setPosY(int posY) {
		this.posY = posY;
	}

	/**
	 * @return the images
	 */
	public List<BufferedImage> getImages() {
		return images;
	}

	/**
	 * @param images the images to set
	 */
	public void setImages(List<BufferedImage> images) {
		this.images = images;
	}

	





}
