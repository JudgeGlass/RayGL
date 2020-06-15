<<<<<<< HEAD
package net.judgeglass.oldgl;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import static org.lwjgl.opengl.GL11.*;

public class Screen {
	public int width;
	public int height;
	
	public Screen(int sw, int sh) {
		width = sw;
		height = sh;
	}
	
	public void init() {
		try {
			Display.setDisplayMode(new DisplayMode(width, height));
			Display.create();
		}catch(LWJGLException e) {
			e.printStackTrace();
			System.exit(0);
		}
		
		glViewport(0, 0, width, height);
		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		glOrtho(0, width, 0, height, 1, -1);
		glMatrixMode(GL_MODELVIEW);
	}
}
=======
package net.judgeglass.oldgl;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import static org.lwjgl.opengl.GL11.*;

public class Screen {
	public int width;
	public int height;
	
	public Screen(int sw, int sh) {
		width = sw;
		height = sh;
	}
	
	public void init() {
		try {
			Display.setDisplayMode(new DisplayMode(width, height));
			Display.create();
		}catch(LWJGLException e) {
			e.printStackTrace();
			System.exit(0);
		}
		
		glViewport(0, 0, width, height);
		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		glOrtho(0, width, 0, height, 1, -1);
		glMatrixMode(GL_MODELVIEW);
	}
}
>>>>>>> 16ca59f7bbf70e13553fff9a8b009dd52f5d1595
