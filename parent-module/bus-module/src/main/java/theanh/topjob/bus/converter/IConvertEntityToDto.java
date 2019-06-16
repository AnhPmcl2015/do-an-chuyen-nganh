package theanh.topjob.bus.converter;

public interface IConvertEntityToDto<D , E> {
	
	void convertEntityToDto(Class<D> dto, @SuppressWarnings("unchecked") Class<? extends E> ... entities);
}
