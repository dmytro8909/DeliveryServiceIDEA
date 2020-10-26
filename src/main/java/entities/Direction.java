package entities;

import java.util.Objects;

/**
 * Class Java Bean represents of direction entity.
 */
public class Direction extends Entity {

	private static final long serialVersionUID = -7063184170999721077L;
	private int id;
	private String direction;
	private int distance;

	/**
	 * Default constructor.
	 */
	public Direction() {};

	/**
	 * Method for getting id
	 * @return the id
	 */
	@Override
	public int getId() {
		return id;
	}

	/**
	 * Method for setting id.
	 * @param id the id to set
	 */
	@Override
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Method for getting direction
	 * @return the direction
	 */
	public String getDirection() {
		return direction;
	}

	/**
	 * Method for setting direction
	 * @param direction the direction to set
	 */
	public void setDirection(String direction) {
		this.direction = direction;
	}

	/**
	 * Method for getting distance
	 * @return distance
	 */
	public int getDistance() {
		return distance;
	}

	/**
	 * Method for setting distance.
	 * @param distance the distance to set
	 */
	public void setDistance(int distance) {
		this.distance = distance;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Direction)) return false;
		Direction direction1 = (Direction) o;
		return id == direction1.id &&
				distance == direction1.distance &&
				Objects.equals(direction, direction1.direction);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, direction, distance);
	}

	@Override
	public String toString() {
		return "Direction{" +
				"id=" + id +
				", direction='" + direction + '\'' +
				", distance=" + distance +
				'}';
	}

}
