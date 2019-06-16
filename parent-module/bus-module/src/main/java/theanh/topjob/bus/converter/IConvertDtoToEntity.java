package theanh.topjob.bus.converter;

public interface IConvertDtoToEntity<E, D> {
	@SuppressWarnings("unchecked")
	void converDtoToEntity(Class<E> entity, Class<? extends D> ... dtos);
}
