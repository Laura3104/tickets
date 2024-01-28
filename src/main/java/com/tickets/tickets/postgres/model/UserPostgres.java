package com.tickets.tickets.postgres.model;

import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * The type User.
 */
@Entity
@Table(name = "users")
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class UserPostgres {

    /**
     * The Id.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * The Name.
     */
    @Column(name = "name", nullable = false)
    private String name;

    /**
     * The Email.
     */
    @Column(name = "email", nullable = false)
    private String email;

    /**
     * The list of user tickets.
     */
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private final List<TicketPostgres> tickets = new ArrayList<>();

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private UserAccountPostgres userAccount;

    /**
     * Instantiates a new User.
     */
    public UserPostgres() {}

    /**
     * Instantiates a new User.
     *
     * @param id    the id
     * @param name  the name
     * @param email the email
     */
    public UserPostgres(Long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    /**
     * Instantiates a new User.
     *
     * @param name  the name
     * @param email the email
     */
    public UserPostgres(String name, String email) {
        this.name = name;
        this.email = email;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets email.
     *
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets email.
     *
     * @param email the email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets user tickets.
     * @return tickets
     */
    public List<TicketPostgres> getTickets() {
        return tickets;
    }

    /**
     * Gets user account.
     * @return userAccount
     */
    public UserAccountPostgres getUserAccount() {
        return userAccount;
    }

    /**
     * Sets user account.
     * @param userAccount the user account
     */
    public void setUserAccount(UserAccountPostgres userAccount) {
        this.userAccount = userAccount;
    }

    /**
     * Equals boolean.
     *
     * @param o the o
     * @return the boolean
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserPostgres user = (UserPostgres) o;
        return Objects.equals(id, user.id) && Objects.equals(name, user.name) && Objects.equals(email, user.email);
    }

    /**
     * Hash code int.
     *
     * @return the int
     */
    @Override
    public int hashCode() {
        return Objects.hash(id, name, email);
    }

    /**
     * To string string.
     *
     * @return the string
     */
    @Override
    public String toString() {
        return "{" +
                "'id' : " + id +
                ", 'name' : '" + name + '\'' +
                ", 'email' : '" + email + '\'' +
                '}';
    }
}

