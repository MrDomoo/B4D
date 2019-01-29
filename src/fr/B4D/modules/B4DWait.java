package fr.B4D.modules;

import java.awt.Color;
import java.awt.Point;
import java.awt.Rectangle;

import fr.B4D.bot.B4D;
import fr.B4D.threads.ColorThread;
import fr.B4D.threads.KeyboardThread;
import fr.B4D.threads.OCRThread;
import fr.B4D.threads.PixelThread;
import fr.B4D.utils.PointF;

public final class B4DWait {
	
	  /********************/
	 /** ATTENTE SIMPLE **/
	/********************/
	
	public static void wait(int timeOut) {
		try {
			Thread.sleep(timeOut);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	  /*********************/
	 /** ATTENTE SUR OCR **/
	/*********************/
	
	public static String waitForOCR(Rectangle rectangle, String text, int timeOut) {
		OCRThread ocrThread = new OCRThread(rectangle, text);
		ocrThread.start();
		try {
			ocrThread.join(timeOut);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		if(ocrThread.isAlive())
			ocrThread.interrupt();
		return ocrThread.getResult();
	}
	public static String waitForOCR(Point P1, Point P2, String text, int timeOut) {
		return waitForOCR(new Rectangle(P1.x,  P1.y, P2.x - P1.x, P2.y - P1.y), text, timeOut);
	}
	public static String waitForOCR(PointF P1, PointF P2, String text, int timeOut) {
		return waitForOCR(B4D.converter.pointFToPoint(P1), B4D.converter.pointFToPoint(P2), text, timeOut);
	}
	
	  /************************/
	 /** ATTENTE SUR TOUCHE **/
	/************************/
	
	public static boolean waitForKeyboard(int timeOut) {
		Thread keyboardThread = new KeyboardThread();
		keyboardThread.start();
		try {
			keyboardThread.join(timeOut);
		} catch (InterruptedException e) {
			e.printStackTrace();
			return false;
		}
		
		if(keyboardThread.isAlive()) {
			keyboardThread.interrupt();
			return false;
		}else 
			return true;
	}
	
	  /*************************************/
	 /** ATTENTE SUR CHANGEMENT DE PIXEL **/
	/*************************************/
	
	public static boolean waitForChangingPixel(Point point, int timeOut) {
		Thread pixelThread = new PixelThread(point);
		pixelThread.start();
		try {
			pixelThread.join(timeOut);
		} catch (InterruptedException e) {
			e.printStackTrace();
			return false;
		}
		
		if(pixelThread.isAlive()) {
			pixelThread.interrupt();
			return true;
		}else
			return false;
	}
	public static boolean waitForChangingPixel(PointF point, int timeOut) {
		return waitForChangingPixel(B4D.converter.pointFToPoint(point), timeOut);
	}
	
	  /**********************************/
	 /** ATTENTE SUR COULEUR DE PIXEL **/
	/**********************************/
	
	public static boolean waitForColor(Point point, Color min, Color max, int timeOut) {
		Thread colorThread = new ColorThread(point, min, max);
		colorThread.start();
		try {
			colorThread.join(timeOut);
		} catch (InterruptedException e) {
			e.printStackTrace();
			return false;
		}
		
		if(colorThread.isAlive()) {
			colorThread.interrupt();
			return true;
		}else
			return false;
	}
	public static boolean waitForColor(PointF point, Color min, Color max, int timeOut) {
		return waitForColor(B4D.converter.pointFToPoint(point), min, max, timeOut);
	}
}
