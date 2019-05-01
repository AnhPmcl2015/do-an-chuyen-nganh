package com.uit.bus.converter;

public interface IConvertDtoToEntity<E, D> {
	@SuppressWarnings("unchecked")
	void converDtoToEntity(Class<E> entity, Class<? extends D> ... dtos);
}
