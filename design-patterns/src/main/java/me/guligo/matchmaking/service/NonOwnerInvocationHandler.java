package me.guligo.matchmaking.service;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @see "Head First Design Patterns" by Eric Freeman and Elisabeth Robson
 */
class NonOwnerInvocationHandler implements InvocationHandler {

	private PersonBean person;

	public NonOwnerInvocationHandler(PersonBean person) {
		this.person = person;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		if (method.getName().startsWith("setName")) {
			throw new IllegalAccessError();
		}
		return method.invoke(person, args);
	}

}
