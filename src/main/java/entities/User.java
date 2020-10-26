package entities;

import java.util.Objects;

/**
 * Class Java Bean represents of user entity.
 */
public class User extends Entity {

	private static final long serialVersionUID = 6176729694708676630L;

	private int id;
	private String name;
	private String lastName;
	private String login;
	private String password;
	private String role;
	private String local;

	/**
	 * Default constructor
	 */
	public User() {}
	
	/**
	 * Method for getting id
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Method for setting id
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Method for getting name
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Method for setting name
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Methdo for getting last name
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}
	
	/**
	 * Method for setting last name
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	/**
	 * Method for getting login
	 * @return the login
	 */
	public String getLogin() {
		return login;
	}
	
	/**
	 * Method for setting login
	 * @param login the login to set
	 */
	public void setLogin(String login) {
		this.login = login;
	}
	
	/**
	 * Method for getting password
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	
	/**
	 * Method for setting password
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	/**
	 * Method for getting role
	 * @return the role
	 */
	public String getRole() {
		return role;
	}
	
	/**
	 * Method for setting role
	 * @param role the role to set
	 */
	public void setRole(String role) {
		this.role = role;
	}
	
	/**
	 * Method for getting local
	 * @return the local
	 */
	public String getLocal() {
		return local;
	}
	
	/**
	 * Method for setting local
	 * @param local the local to set
	 */
	public void setLocal(String local) {
		this.local = local;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof User)) return false;
		User user = (User) o;
		return id == user.id &&
				Objects.equals(name, user.name) &&
				Objects.equals(lastName, user.lastName) &&
				Objects.equals(login, user.login) &&
				Objects.equals(password, user.password) &&
				Objects.equals(role, user.role) &&
				Objects.equals(local, user.local);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, lastName, login,
							password, role, local);
	}

	@Override
	public String toString() {
		return "User [id=" + id + 
			   ", name=" + name + 
			   ", lastName=" + lastName + 
			   ", login=" + login + 
			   ", password=" + password + 
			   ", role=" + role + 
			   ", local=" + local + "]";
	}
	
}
