package me.guligo.matchmaking.service;

import java.lang.reflect.Proxy;

/**
 * @see "Head First Design Patterns" by Eric Freeman and Elisabeth Robson
 */
public class PersonBeanFactory {

	public PersonBean createPersonBean(boolean owner, String name) {
		PersonBean personBean = new PersonBeanImpl(name);
		if (owner) {
			return (PersonBean) Proxy.newProxyInstance(personBean.getClass().getClassLoader(), personBean.getClass().getInterfaces(),
					new OwnerInvocationHandler(personBean));
		} else {
			return (PersonBean) Proxy.newProxyInstance(personBean.getClass().getClassLoader(), personBean.getClass().getInterfaces(),
					new NonOwnerInvocationHandler(personBean));
		}
	}

}
