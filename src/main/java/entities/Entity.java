package entities;

import java.io.Serializable;

/**
 * Class for definitions of minimum methods
 * necessary for creating of project entities.
 */
public abstract class Entity implements Serializable {

	private static final long serialVersionUID = -3783372990506096355L;

	private int id;

	/**
	 * Method for getting id.
	 * @return id.
	 */
	public int getId() {
		return id;
	}

	/**
	 * Method for setting id.
	 * @param id - id.
	 */
	public void setId(int id) {
		this.id = id;
	}
}
