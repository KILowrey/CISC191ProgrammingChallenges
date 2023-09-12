/**
 * This class is the logic for the Module 2 Middle Developer Code for
 * CISC 191 at San Diego Mesa College in Fall 2023
 * 
 * This programming assignment is an extension of Barbara Ericson's Picture Lab.
 * @author KILowrey
 */

import java.awt.Color;

public class Logic {

	/**
	 * Alters the picture so that each pixel's blue channel has been zeroed out. 
	 * All other channels remain the same
	 * 
	 * @param picture the image to be altered
	 */
	public static void zeroBlue(DigitalPicture picture) 
	{
		// create our 2D pixel array and go though it
		Pixel[][] pixel2D = picture.getPixels2D();
		
		for (int r = 0; r < pixel2D.length; r++) 
		{
			for (int c = 0; c < pixel2D[r].length; c++) 
			{
				// set our blue value at our current location to 0
				pixel2D[r][c].setBlue(0);
			}
		}
	}

	/**
	 * Alters the picture so that it is black and white by setting each pixels color
	 * value to be the average of the pixels red, green, and blue channel.
	 * 
	 * @param picture, the image to be altered
	 */
	public static void blackAndWhite(DigitalPicture picture) 
	{
		// create averageVal variable
		int averageVal = 0;
		Color averageColor;
		
		// create our 2D pixel array and go though it
		Pixel[][] pixel2D = picture.getPixels2D();
		
		for (int r = 0; r < pixel2D.length; r++) 
		{
			for (int c = 0; c < pixel2D[r].length; c++)
			{
				// utilize the getAverage method in Pixel.java line 361
				averageVal = (int) pixel2D[r][c].getAverage();
				
				// for some reason I can't "setColor" w/ the values directly so we have to include this line :angry:
				averageColor = new Color(averageVal, averageVal, averageVal);
				
				// set our color
				pixel2D[r][c].setColor(averageColor);
			}
		}
	}
	
	/**
	 * Alters the picture so that the color values are the negative of themselves
	 * 
	 * @param picture, the image to be altered
	 */
	public static void negative(DigitalPicture picture) 
	{
		// create our 2D pixel array and go though it
		Pixel[][] pixel2D = picture.getPixels2D();
		for (int r = 0; r < pixel2D.length; r++) 
		{
			for (int c = 0; c < pixel2D[r].length; c++) 
			{
				// negate all our color values by subtracting the original value from 255.
				pixel2D[r][c].setRed(255 - pixel2D[r][c].getRed());
				pixel2D[r][c].setBlue(255 - pixel2D[r][c].getBlue());
				pixel2D[r][c].setGreen(255 - pixel2D[r][c].getGreen());
			}
		}
	}
	
	/**
	 * Alters the picture so that it looks like it was taken at sunset
	 * 
	 * @param picture, the image to be altered
	 * @param redIntensity, the amount we are multiplying the red value by
	 * @param greenBlueReduction, the amount we are multiplying the green and blue value by
	 */
	public static void makeSunset(DigitalPicture picture, double redIntensity, double greenBlueReduction) 
	{
		// create our 2D pixel array and go though it
		Pixel[][] pixel2D = picture.getPixels2D();
		
		for (int r = 0; r < pixel2D.length; r++) 
		{
			for (int c = 0; c < pixel2D[r].length; c++) 
			{
				// multiply red by the parsed value
				pixel2D[r][c].setRed((int) (pixel2D[r][c].getRed() * redIntensity));
				
				// multiply green and blue by the parsed value
				pixel2D[r][c].setGreen((int) (pixel2D[r][c].getGreen() * greenBlueReduction));
				pixel2D[r][c].setBlue((int) (pixel2D[r][c].getBlue() * greenBlueReduction));
			}
		}
	}
	
	/**
	 * Alters the picture so that it is mirrored horizontally
	 * 
	 * @param picture, the image to be altered
	 */
	public static void mirrorHorizontal(DigitalPicture picture) 
	{
		// create our storage color and our pixel reference
		Color tempColor = new Color(0,0,0);
		Pixel tempPixel;
		
		// create our 2D array
		Pixel[][] pixel2D = picture.getPixels2D();
		for (int r = 0; r < pixel2D.length; r++) 
		{
			// divide the length of "c" by 2 for mirroring
			for (int c = 0; c < (pixel2D[r].length / 2); c++) 
			{
				// store current color in our storing variable
				tempColor = pixel2D[r][c].getColor();
				
				// define the mirror pixel just to keep things readable
				tempPixel = pixel2D[r][pixel2D[r].length-1-c];
				
				// color our original pixel w/ the mirror pixel's color
				pixel2D[r][c].setColor(tempPixel.getColor());
				// color the mirror pixel w/ our stored color
				tempPixel.setColor(tempColor);
			}
		}
	}
	
	/**
	 * Alters the picture so that it is mirrored vertically
	 * 
	 * @param picture, the image to be altered
	 */
	public static void mirrorVertical(DigitalPicture picture) 
	{
		// create our storage color and our pixel reference
		Color tempColor = new Color(0,0,0);
		Pixel tempPixel;
		
		// create our 2D array
		Pixel[][] pixel2D = picture.getPixels2D();
		// divide the length of "r" by 2 for mirroring
		for (int r = 0; r < (pixel2D.length / 2); r++) 
		{
			for (int c = 0; c < pixel2D[r].length; c++) 
			{
				// store current color in our storing variable
				tempColor = pixel2D[r][c].getColor();
				
				// define the mirror pixel just to keep things readable
				tempPixel = pixel2D[pixel2D.length-1-r][c];
				
				// color our original pixel w/ the mirror pixel's color
				pixel2D[r][c].setColor(tempPixel.getColor());
				// color the mirror pixel w/ our stored color
				tempPixel.setColor(tempColor);
			}
		}
	}
	
	/**
	 * Alters the picture by bluring the color averages of groups of 4 pixels
	 * 
	 * @param picture, the image to be altered
	 */
	public static void blur(DigitalPicture picture) 
	{
		// create our temp variables for our values and color
		int blurRed = 0;
		int blurGreen = 0; 
		int blurBlue = 0;
		Color blurColor;
		
		// create our 2D arrays
		Pixel[][] pixel2D = picture.getPixels2D();
		
		for (int r = 0; r < pixel2D.length-1; r++) 
		{
			for (int c = 0; c < pixel2D[r].length-1; c++) 
			{
				// average out our color values from the 4 pixels
				// yes this could be prettier but this is what I like
				blurRed = (int) ((pixel2D[r][c].getRed() + pixel2D[r+1][c].getRed() + pixel2D[r][c+1].getRed() + pixel2D[r+1][c+1].getRed()) / 4.0);
				blurGreen = (int) ((pixel2D[r][c].getGreen() + pixel2D[r+1][c].getGreen() + pixel2D[r][c+1].getGreen() + pixel2D[r+1][c+1].getGreen()) / 4.0);
				blurBlue = (int) ((pixel2D[r][c].getBlue() + pixel2D[r+1][c].getBlue() + pixel2D[r][c+1].getBlue() + pixel2D[r+1][c+1].getBlue()) / 4.0);
				
				// create our new color (still mad I can't just setColor w/ the values)
				blurColor = new Color(blurRed, blurGreen, blurBlue);
				
				// set the color
				pixel2D[r][c].setColor(blurColor);
			}
		}
	}

}
