package com.kunal.spring.security.oauth2.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "NOTIFICATIONS",uniqueConstraints = {@UniqueConstraint(columnNames = {"ID"})})
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor
public class Notification implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", updatable = false, nullable = false)
    private Long id = null;

    @Column(name = "MESSAGE", nullable = true)
    private String message;

    @Column(name = "EMAIL", nullable = false)
    private String email;

    @Column(name = "COST", nullable = false)
    private Long cost;


}
