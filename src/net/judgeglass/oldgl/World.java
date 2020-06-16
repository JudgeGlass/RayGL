package net.judgeglass.oldgl;

import static org.lwjgl.opengl.GL11.*;

public class World extends Entity{
	
	private Player player;
	private float step = 0.0174533f;
	
	public byte world_array[] = {
			1, 1, 1, 1, 1, 1, 1, 1,
			1, 0, 0, 1, 0, 0, 0, 1,
			1, 0, 0, 1, 0, 0, 0, 1,
			1, 0, 0, 0, 0, 0, 0, 1,
			1, 0, 0, 0, 0, 0, 0, 1,
			1, 0, 0, 1, 0, 0, 0, 1,
			1, 0, 0, 0, 0, 0, 0, 1,
			1, 1, 1, 1, 1, 1, 1, 1,
	};
	
	public World(final Player player) {
		this.player = player;
	}

	@Override
	public void render() {
		glColor3f(1f, 1f, 1f);
		for(int y = 0; y < 8; y++) {
			for(int x = 0; x < 8; x++) {
				if(world_array[x + y * 8] == 1) {
					glBegin(GL_QUADS);
						glVertex3f((x * 64), (y * 64), 0.0f);
						glVertex3f((x * 64) + 63, (y * 64), 0.0f);
						glVertex3f((x * 64) + 63, (y * 64) + 63, 0.0f);
						glVertex3f((x * 64), (y * 64) + 63, 0.0f);
					glEnd();
				}
			}
		}
		
		drawRays();
	}
	
	private float distance(float ax, float ay, float bx, float by) {
		return (float)Math.sqrt((bx-ax) * (bx-ax) + (by-ay) * (by-ay));
	}
	
	private void drawRays() {
		int r;
		int mx;
		int my;
		int mp;
		int dof;
		float px = player.x;
		float py = player.y;
		float pa = player.pa;
		float rx = 0;
		float ry = 0;
		float ra;
		float xo = 0;
		float yo = 0;
		float disT = 0;
		
		ra = pa-step * 30;
		if(ra < 0) ra += 2 * (float)Math.PI;
		if(ra > 2 * (float)Math.PI) ra -= 2 * (float)Math.PI;
		for(r = 0; r < 60; r++) {
			dof = 0;
			float disH = Float.MAX_VALUE;
			float hx=px, hy=py;
			float aTan = -1 / (float)Math.tan(ra);
			if(ra > Math.PI) {
				ry = (((int)py >> 6) << 6) - 0.0001f;
				rx = (py - ry) * aTan + px;
				yo = -64;
				xo = -yo * aTan;
			}
			if(ra < Math.PI) {
				ry = (((int)py >> 6) << 6) + 64;
				rx = (py - ry) * aTan + px;
				yo = 64;
				xo = -yo * aTan;
			}
			if(ra == 0 || ra == Math.PI) {
				rx = px;
				ry = py;
				dof = 8;
			}
			
			while(dof < 8) {
				mx = (int) (rx) >> 6;
				my = (int) (ry) >> 6;
				
				if(mx + my * 8 < 64 && mx + my * 8 > 0 && world_array[mx + my * 8] == 1) {
					hx = rx;
					hy = ry;
					disH = distance(px, py, hx, hy);
					dof = 8;
				}else {
					rx += xo;
					ry += yo;
					dof += 1;
				}
			}
			
			//VERTICAL
			float disV = Float.MAX_VALUE;
			float vx=px, vy=py;
			double P2 = Math.PI / 2;
			double P3 = 3 * Math.PI / 2;
			dof = 0;
			float nTan = -(float)Math.tan(ra);
			if(ra > P2 && ra < P3) {
				rx = (((int)px >> 6) << 6) - 0.0001f;
				ry = (px - rx) * nTan + py;
				xo = -64;
				yo = -xo * nTan;
			}
			if(ra < P2 || ra > P3) {
				rx = (((int)px >> 6) << 6) + 64;
				ry = (px - rx) * nTan + py;
				xo = 64;
				yo = -xo * nTan;
			}
			if(ra == 0 || ra == Math.PI) {
				rx = px;
				ry = py;
				dof = 8;
			}
			
			while(dof < 8) {
				mx = (int) (rx) >> 6;
				my = (int) (ry) >> 6;
				
				if(mx + my * 8 < 64 && mx + my * 8 > 0 && world_array[mx + my * 8] == 1) {
					vx = rx;
					vy = ry;
					disV = distance(px, py, vx, vy);
					dof = 8;
				}else {
					rx += xo;
					ry += yo;
					dof += 1;
				}
			}
			if(disV<disH) {
				rx=vx;
				ry=vy;
				disT = disV;
				glColor3f(0.9f, 0f, 0f);
			}
			if(disH<disV) {
				rx=hx;
				ry=hy;
				disT = disH;
				glColor3f(0.7f, 0f, 0f);
			}
			glBegin(GL_LINES);
				glVertex2f(px, py);
				glVertex2f(rx, ry);
			glEnd();
			
			//3D
			float ca = pa - ra;
			if(ca < 0) ca += 2 * (float)Math.PI;
			if(ca > 2 * Math.PI) ca -= 2 * (float)Math.PI;
			disT = disT * (float)Math.cos(ca);
			int lineH = (int) ((8 * 320) / disT);
			int lineO = 260-lineH/2;
			if(lineH > 320) lineH=320;
			glLineWidth(8);
			glBegin(GL_LINES);
				glVertex2i(r * 8 + 530, lineO);
				glVertex2i(r * 8 + 530, lineH + lineO);
			glEnd();
			
			
			ra += step;
			if(ra < 0) ra += 2 * (float)Math.PI;
			if(ra > 2 * (float)Math.PI) ra -= 2 * (float)Math.PI;
		}
	}

	@Override
	public void tick() {
		
	}

}
