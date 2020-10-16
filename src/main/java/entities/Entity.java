package entities;

import java.io.Serializable;

public abstract class Entity implements Serializable {

	private static final long serialVersionUID = -3783372990506096355L;

	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
