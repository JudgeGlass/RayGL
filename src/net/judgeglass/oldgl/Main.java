<<<<<<< HEAD
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
=======
package net.judgeglass.oldgl;

public class Main {
	public static void main(String args[]) {
		Screen screen = new Screen(800, 480);
		screen.init();
		Renderer renderer = new Renderer();
		renderer.startLoop();
	}
}
>>>>>>> 16ca59f7bbf70e13553fff9a8b009dd52f5d1595
