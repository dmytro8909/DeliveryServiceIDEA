package entities;

import java.io.Serializable;

public abstract class Entity implements Serializable {

	private static final long serialVersionUID = -3783372990506096355L;

	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
