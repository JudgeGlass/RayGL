package net.judgeglass.oldgl;

public class Main {
	public static void main(String args[]) {
		Screen screen = new Screen(1024, 512);
		screen.init();
				
		Renderer renderer = new Renderer();
		
		Player player = new Player();
		World world = new World(player);
		
		Renderer.entities.add(world);
		Renderer.entities.add(player);
		
		
		
		
		
		renderer.startLoop();
	}
}
