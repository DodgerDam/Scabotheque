package fr.scabois.scabotheque.bean.security;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "user_roles")
public class UserRole {

    @Id
    @Column(name = "user_role_id")
    private String id;

    @Column(name = "role")
    private String role;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "username")
    private User user;

    public String getId() {
	return id;
    }

    public User getUser() {
	return user;
    }

    public String isLibelle() {
	return role;
    }

    public void setId(String id) {
	this.id = id;
    }

    public void setLibelle(String role) {
	this.role = role;
    }

    public void setUser(User user) {
	this.user = user;
    }

}
