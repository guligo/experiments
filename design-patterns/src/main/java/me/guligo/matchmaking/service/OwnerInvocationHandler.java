package me.guligo.matchmaking.service;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @see "Head First Design Patterns" by Eric Freeman and Elisabeth Robson
 */
class OwnerInvocationHandler implements InvocationHandler {

	private PersonBean person;

	public OwnerInvocationHandler(PersonBean person) {
		this.person = person;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		if (method.getName().startsWith("setHotOrNotRating")) {
			throw new IllegalAccessError();
		}
		return method.invoke(person, args);
	}

}
