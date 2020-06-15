package net.judgeglass.oldgl;

import static org.lwjgl.opengl.GL11.*;

public class World extends Entity{
	
	private Player player;
	
	public byte world_array[][] = {
			{1, 1, 1, 1, 1, 1, 1, 1, 1},
			{1, 0, 1, 0, 0, 0, 0, 0, 1},
			{1, 0, 0, 0, 0, 0, 0, 0, 1},
			{1, 0, 0, 0, 0, 0, 0, 0, 1},
			{1, 0, 0, 0, 0, 0, 0, 0, 1},
			{1, 0, 0, 0, 0, 0, 0, 0, 1},
			{1, 0, 0, 0, 0, 0, 0, 1, 1},
			{1, 1, 1, 1, 1, 1, 1, 1, 1}
	};
	
	public World(final Player player) {
		this.player = player;
	}

	@Override
	public void render() {
		glColor3f(1f, 1f, 1f);
		for(int y = 0; y < 8; y++) {
			for(int x = 0; x < 9; x++) {
				if(world_array[y][x] == 1) {
					glBegin(GL_QUADS);
						glVertex3f((x * 64), (y * 64), 0.0f);
						glVertex3f((x * 64) + 63, (y * 64), 0.0f);
						glVertex3f((x * 64) + 63, (y * 64) + 63, 0.0f);
						glVertex3f((x * 64), (y * 64) + 63, 0.0f);
					glEnd();
				}
			}
		}
	}

	@Override
	public void tick() {
		
	}

}
