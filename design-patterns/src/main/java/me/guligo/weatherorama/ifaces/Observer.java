package me.guligo.weatherorama.ifaces;

/**
 * @see "Head First Design Patterns" by Eric Freeman and Elisabeth Robson
 */
public interface Observer<T extends Event> {

	public void update(T event);

}
