package net.judgeglass.oldgl;

import static org.lwjgl.opengl.GL11.*;

public class Player extends Entity{
	
	public float pa;
	
	public Player() {
		x = 100;
		y = 100;
	}

	@Override
	public void render() {
		glColor3f(1.0f, 1.0f, 0.0f);
		glPointSize(8);
		glBegin(GL_POINTS);
			glVertex2f(x, y);
		glEnd();
	}

	@Override
	public void tick() {
		
	}

}
