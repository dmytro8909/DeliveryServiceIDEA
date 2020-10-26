package dao;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Interface for implementing DAO-pattern.
 * @param <T> - generic parameter.
 */
public interface AbstractDAO<T> {
	List<T> getAll();
	T get(int id);
	void delete(int id);
}
