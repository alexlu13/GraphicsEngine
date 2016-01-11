package myGUIEngine;

import static org.lwjgl.opengl.GL11.*;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.input.Keyboard;

public class GUI {
	
	// Variables for resolutions
	private int xResolution;
	private int yResolution;
	AbstractGUI[] gui;
	private final int MAX_FPS = 60;

	// Boolean for pressing escape to exit
	private boolean escToExit;
	
	// Constructor
	GUI(int xResolution, int yResolution, boolean escToExit){
		this.xResolution = xResolution;
		this.yResolution = yResolution;
		this.escToExit = escToExit;
		gui = new AbstractGUI[1];
		gui[0] = new GridGUI();
		startRender();
	}
	
	private void startRender(){
		try {
			Display.setDisplayMode(new DisplayMode(xResolution, yResolution));
			Display.create();
			render();
		} catch (LWJGLException e) {
			e.printStackTrace();
			System.exit(0);
		}
	}
	
	private void render(){
		
		glMatrixMode(GL_PROJECTION);
	    glLoadIdentity();
	    glMatrixMode(GL_MODELVIEW);
	    glEnable(GL_BLEND);
	    glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
	    glOrtho(0, xResolution, 0, 600, 1, -1);
	    glEnable(GL_TEXTURE_2D);
		
		while(!Display.isCloseRequested() && !Keyboard.isKeyDown(Keyboard.KEY_ESCAPE)){
			Display.update();
			Display.sync(MAX_FPS);
			
		}
		Display.destroy();
	}
}
