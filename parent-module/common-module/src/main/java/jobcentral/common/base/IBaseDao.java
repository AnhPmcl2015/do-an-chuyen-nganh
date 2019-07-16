package jobcentral.common.base;

public interface IBaseDao<T> {
	T findById(Object id);
	void insertOrUpdate(T t, boolean updateOnly);
	void delete (T t);
	long count();
	void deletePermanently(T t);
}
