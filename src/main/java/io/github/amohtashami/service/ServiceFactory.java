package io.github.amohtashami.service;

import io.github.amohtashami.enums.EnumServiceName;

/**
 * This class is a factory for selecting an implementation of ITraverseService based on user request
 * @Author alieh on 9/19/22
 */
public class ServiceFactory {
	/**
	 * factory method to initialize an implementation for ITraverseService
	 * @param input let users choose their required implementation more easily with fewer errors
	 * @param <T> generic parameter to have more abstraction on service
	 * @return an object from various implementation of ITraverseService
	 */
	public static <T> ITraverseService<T> getTraverseService(EnumServiceName input) {
		switch (input) {
			case SPIRAL:
			default:
				return new SpiralTraverse<>();
		}
	}

	/**
	 * a private constructor so no object can be instantiated from this class
	 */
	private ServiceFactory()
	{

	}
}
