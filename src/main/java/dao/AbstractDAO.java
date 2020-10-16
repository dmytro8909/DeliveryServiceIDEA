package dao;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public interface AbstractDAO<T> {
	List<T> getAll();
	T get(int id);
	T update(T t);
	T delete(T t);
}
