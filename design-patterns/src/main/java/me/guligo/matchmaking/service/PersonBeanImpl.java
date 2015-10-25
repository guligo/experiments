package me.guligo.matchmaking.service;

/**
 * @see "Head First Design Patterns" by Eric Freeman and Elisabeth Robson
 */
class PersonBeanImpl implements PersonBean {

	private String name;
	private int rating;

	public PersonBeanImpl(String name) {
		this.name = name;
		this.rating = 0;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int getHotOrNotRating() {
		return rating;
	}

	@Override
	public void setHotOrNotRating(int rating) {
		this.rating += rating;
	}

}
