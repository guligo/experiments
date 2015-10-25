package me.guligo.matchmaking;

import me.guligo.matchmaking.service.PersonBean;
import me.guligo.matchmaking.service.PersonBeanFactory;

/**
 * Following is an example of proxy pattern in action. The "proxy pattern"
 * provides a surrogate or placeholder for another object to control access to
 * it.
 * 
 * @see "Head First Design Patterns" by Eric Freeman and Elisabeth Robson
 */
public class TestMatchMakingService {

	public static void main(String[] args) {
		PersonBeanFactory personBeanFactory = new PersonBeanFactory();

		PersonBean personBean = personBeanFactory.createPersonBean(false, "foo");
		personBean.getHotOrNotRating();
		// throws an exception
		// personBean.setName("bar");

		personBean = personBeanFactory.createPersonBean(true, "bar");
		personBean.setName("foo");
		// throws an exception
		// personBean.setHotOrNotRating(10);
	}

}
