package com.roshan.realtor.model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "broker")
public class Broker {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(length = 255, nullable = false)
    private String name;

    @OneToMany(mappedBy = "broker", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<House> houses;
}
