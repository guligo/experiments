package me.guligo.matchmaking.service;

/**
 * @see "Head First Design Patterns" by Eric Freeman and Elisabeth Robson
 */
public interface PersonBean {

	public String getName();

	public void setName(String name);

	public int getHotOrNotRating();

	public void setHotOrNotRating(int rating);

}
