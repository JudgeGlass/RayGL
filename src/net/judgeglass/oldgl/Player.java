package net.judgeglass.oldgl;

import static org.lwjgl.opengl.GL11.*;

import org.lwjgl.input.Keyboard;

public class Player extends Entity{
	
	public float pa;
	public float dy;
	public float dx;
	
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
		glBegin(GL_LINES);
			glVertex2f(x, y);
			glVertex2f(x + dx * 5, y + dy * 5);
		glEnd();
	}
	

	@Override
	public void tick() {
		if(Keyboard.isKeyDown(Keyboard.KEY_W)) {
			x += dx;
			y += dy;
		}else if(Keyboard.isKeyDown(Keyboard.KEY_S)){
			x -= dx;
			y -= dy;
		}else if(Keyboard.isKeyDown(Keyboard.KEY_A)){
			pa -= 0.1;
			if(pa < 0) {
				pa += 2 * Math.PI;
			}
			dx = (float)Math.cos(pa) * 5;
			dy = (float)Math.sin(pa) * 5;
		}else if(Keyboard.isKeyDown(Keyboard.KEY_D)){
			pa += 0.1;
			if(pa > 2*Math.PI) {
				pa = 0;
			}
			dx = (float)Math.cos(pa) * 5;
			dy = (float)Math.sin(pa) * 5;
		}
		
	}

}
