package com.uit.bus.converter;

public interface IConvertEntityToDto<D , E> {
	
	void convertEntityToDto(Class<D> dto, @SuppressWarnings("unchecked") Class<? extends E> ... entities);
}
