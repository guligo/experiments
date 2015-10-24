package me.guligo.restaurant;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Represents component.
 * 
 * @author guligo
 */
public abstract class MenuComponent {

	private String name;
	private Collection<MenuComponent> children;

	public MenuComponent(String name) {
		this.name = name;
		this.children = new ArrayList<>();
	}

	public void addChild(MenuComponent component) {
		this.children.add(component);
	}

	public double getPrice() {
		throw new UnsupportedOperationException();
	}

	public Collection<MenuComponent> getChildren() {
		return children;
	}

	public String getName() {
		return name;
	}

}
