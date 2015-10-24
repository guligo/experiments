package me.guligo.restaurant;

/**
 * Represents leaf.
 * 
 * @author guligo
 */
public class MenuItem extends MenuComponent {

	private Double price;

	public MenuItem(String name, Double price) {
		super(name);
		this.price = price;
	}

	@Override
	public void addChild(MenuComponent component) {
		throw new UnsupportedOperationException();
	}

	@Override
	public double getPrice() {
		return price;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("{ name: ");
		sb.append(getName());
		sb.append(", ");
		sb.append("price: ");
		sb.append(getPrice());
		sb.append(" }");
		return sb.toString();
	}

}
