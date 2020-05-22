package in.codeblog.tdms.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

/**
 * @author Yash Nahar
 *
 */
@Entity
@Table(name = "groupss")
public class Group {
	/**
	 * group id ,pk
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	/**
	 * name of group
	 */
	@Column(name = "name", nullable = false, unique = true)
	@Size(min = 5, max = 15, message = "name must be 5 to 15 character")
	private String name;
	/**
	 * status of group 1:Activate 2:Deactivate
	 */
	@Column(name = "status")

	private int status = 1;
	/**
	 * User class reference for foreign key
	 * Many to one relationship
	 * many group belongs to one user
	 */
	@ManyToOne(targetEntity = User.class)
	@JoinColumn(name = "user_id", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private User user;

	public Group() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
