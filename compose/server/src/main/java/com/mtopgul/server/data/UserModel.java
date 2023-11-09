package com.mtopgul.server.data;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author muhammed-topgul
 * @since 09/11/2023 11:22
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
public class UserModel {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(unique = true)
    private String username;

    @Column(unique = true)
    private String email;

    public UserModel(String username, String email) {
        this.username = username;
        this.email = email;
    }

    @Override
    public String toString() {
        return "User={" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
