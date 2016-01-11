package myGUIEngine;

import static org.lwjgl.opengl.GL11.*;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

public abstract class AbstractGUI {
	
	protected int[] textures;
	
	// Abstract methods
	abstract protected void render();
}
