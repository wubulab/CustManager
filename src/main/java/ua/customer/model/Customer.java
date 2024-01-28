package ua.customer.model;

import jakarta.validation.constraints.Pattern;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.time.Instant;
@Component
@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "created", nullable = false)
    private Instant created;

    @Column(name = "updated", nullable = false)
    private Instant updated;

    @Column(name = "full_name", nullable = false, length = 50)
    @Pattern(regexp = "\\d{2,14}")
    private String full_name;

    @Column(name = "email", nullable = false, unique = true, length = 100)
    @Pattern(regexp = "[^@\\s]+@[^@\\s]+\\d{2,100}", message = "Email should be valid with exactly one '@'")
    private String email;

    @Column(name = "phone", length = 14)
    @Pattern(regexp = "\\+\\d{6,14}", message = "Phone should start with '+' and contain only digits")
    private String phone;

    @Column(name = "is_active", nullable = false)
    private boolean is_active;

    public Long getId() {
        return id;
    }

    public Instant getCreated() {
        return created;
    }

    public void setCreated(Instant created) {
        this.created = created;
    }

    public Instant getUpdated() {
        return updated;
    }

    public void setUpdated(Instant updated) {
        this.updated = updated;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean isIs_active() {
        return is_active;
    }

    public void setIs_active(boolean is_active) {
        this.is_active = is_active;
    }

    public Customer() {
        this.is_active = true;
        this.created = Instant.now();
        this.updated = Instant.now();

    }public Customer(String fullName, String email, String phone) {
        this.full_name = full_name;
        this.email = email;
        this.phone = phone;

    }

    @PrePersist
    protected void onCreate() {
        created = updated = Instant.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updated = Instant.now();

    }

}
