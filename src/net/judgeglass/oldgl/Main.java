package net.judgeglass.oldgl;

public class Main {
	public static void main(String args[]) {
		Screen screen = new Screen(800, 480);
		screen.init();
		Renderer renderer = new Renderer();
		renderer.startLoop();
	}
}
