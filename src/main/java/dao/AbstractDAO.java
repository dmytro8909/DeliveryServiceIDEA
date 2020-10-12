package dao;

import java.util.List;

public interface AbstractDAO<T> {
	List<T> getAll();
	T get(Long id);
	T update(T t);
	T delete(T t);
}
