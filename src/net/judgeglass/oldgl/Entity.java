package net.judgeglass.oldgl;

public abstract class Entity {
	protected float x;
	protected float y;
	
	public abstract void render();
	public abstract void tick();
}
