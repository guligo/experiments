package me.guligo.restaurant;

/**
 * Represents composite.
 * 
 * @author guligo
 */
public class Menu extends MenuComponent {

	public Menu(String name) {
		super(name);
	}

	@Override
	public double getPrice() {
		throw new UnsupportedOperationException();
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("{ menu: ");
		sb.append(getName());
		sb.append(", items: [ ");
		for (MenuComponent menuComponent : getChildren()) {
			sb.append(menuComponent.toString());
			sb.append(" ");
		}
		sb.append("] }");
		return sb.toString();
	}

}
