package theanh.topjob.bus.converter;

public interface IConvertFormToEntity<E, F> {
	void convertFormToEntity(Class<E> entity, Class<F> form);
}
