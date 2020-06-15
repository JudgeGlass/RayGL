<<<<<<< HEAD
package net.judgeglass.oldgl;

import static org.lwjgl.opengl.GL11.GL_COLOR_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.GL_DEPTH_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.glClear;
import static org.lwjgl.opengl.GL11.glClearColor;

import java.util.ArrayList;
import java.util.List;

import org.lwjgl.opengl.Display;

public class Renderer {
	private int fps;
	
	public static List<Entity> entities = new ArrayList<>();
	
	public Renderer() {
		
	}
	
	public void startLoop() {
		long lastTime = System.nanoTime();
        double unprocessed = 0;
        double nsPerTick = 1000000000.0 / 60;
        int frames = 0;
        int ticks = 0;
        long lastTimer1 = System.currentTimeMillis();

        while (!Display.isCloseRequested()) {
            long now = System.nanoTime();
            unprocessed += (now - lastTime) / nsPerTick;
            lastTime = now;
            boolean shouldRender = true;
            while (unprocessed >= 1) {
                ticks++;
                tick();
                unprocessed -= 1;
                shouldRender = true;
            }

            if (shouldRender) {
                frames++;
                render();
                Display.update();
            }

            if (System.currentTimeMillis() - lastTimer1 > 1000) {
                lastTimer1 += 1000;
                System.out.println(ticks + " ticks, " + frames + " fps\t\tMem: " + ((Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / 1024) / 1024 + " MB");
                //screen.setTitle(" FPS: " + frames);
                fps = frames;
                frames = 0;
                ticks = 0;
            }
        }
        stop();
	}
	
	private void render() {
		glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
		glClearColor(0.5f, 0.5f, 0.5f, 1.0f);
		
		for(Entity e: entities) {
			e.render();
		}
	}
	
	private void tick() {
		for(Entity e: entities) {
			e.tick();
		}
	}
	
	private void stop() {
		Display.destroy();
	}
}
=======
package net.judgeglass.oldgl;

import static org.lwjgl.opengl.GL11.*;
import org.lwjgl.opengl.Display;

public class Renderer {
	private int fps;
	
	public Renderer() {
		
	}
	
	public void startLoop() {
		long lastTime = System.nanoTime();
        double unprocessed = 0;
        double nsPerTick = 1000000000.0 / 60;
        int frames = 0;
        int ticks = 0;
        long lastTimer1 = System.currentTimeMillis();

        while (!Display.isCloseRequested()) {
            long now = System.nanoTime();
            unprocessed += (now - lastTime) / nsPerTick;
            lastTime = now;
            boolean shouldRender = true;
            while (unprocessed >= 1) {
                ticks++;
                tick();
                unprocessed -= 1;
                shouldRender = true;
            }

            if (shouldRender) {
                frames++;
                render();
                Display.update();
            }

            if (System.currentTimeMillis() - lastTimer1 > 1000) {
                lastTimer1 += 1000;
                System.out.println(ticks + " ticks, " + frames + " fps\t\tMem: " + ((Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / 1024) / 1024 + " MB");
                //screen.setTitle(" FPS: " + frames);
                fps = frames;
                frames = 0;
                ticks = 0;
            }
        }
        stop();
	}
	
	private void render() {
		glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
		glClearColor(0.5f, 0.5f, 0.5f, 1.0f);
		
		glBegin(GL_QUADS);
		
		glVertex2f(100, 100);
		glVertex2f(200, 100);
		glVertex2f(200, 200);
		glVertex2f(100, 200);
		
		glEnd();
	}
	
	private void tick() {
		
	}
	
	private void stop() {
		Display.destroy();
	}
}
>>>>>>> 16ca59f7bbf70e13553fff9a8b009dd52f5d1595
