package me.guligo.weatherorama.ifaces;

/**
 * @see "Head First Design Patterns" by Eric Freeman and Elisabeth Robson
 */
public interface Subject<T extends Event> {

	public void registerObserver(Observer<T> observer);

	public void removeObserver(Observer<T> observer);

	public void notifyObservers();

}
