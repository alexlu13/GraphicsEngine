package myGUIEngine;

import static org.lwjgl.opengl.GL11.GL_QUADS;
import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glVertex2f;

public class GridGUI extends AbstractGUI{

	@Override
	protected void render() {
		glBegin(GL_QUADS);
			glVertex2f(0, 0);
			glVertex2f(200, 0);
			glVertex2f(200, 200);
			glVertex2f(0, 200);
		glEnd();
	}
	
}
