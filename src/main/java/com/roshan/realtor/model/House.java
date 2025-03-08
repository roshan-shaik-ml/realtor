package com.roshan.realtor.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.List;
import java.util.UUID;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "house")
public class House {


    @Id @Generated
    @Column(name = "id")
    private UUID id;

    @Column(name = "zpid", length = 20, nullable = false)
    private String zpid;

    @Column(name = "price", nullable = false)
    private int price;

    @Column(name = "beds", columnDefinition = "int DEFAULT 0")
    private int beds;

    @Column(name = "baths", columnDefinition = "int DEFAULT 0")
    private int baths;

    @Column(name = "status", length = 50, nullable = false)
    private String status;

    @Column(name = "area")
    private Double area; // Living Area

    @Column(name = "type", length = 50, nullable = false)
    private String type;

    @Column(name = "url", columnDefinition = "TEXT")
    private String url; // detail url


    @OneToOne(mappedBy = "house", cascade = CascadeType.ALL, orphanRemoval = true)
    private Address address;

    @OneToMany(mappedBy = "house", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Images> images;

    @ManyToOne
    @JoinColumn(name = "broker_id", foreignKey = @ForeignKey(name = "houses_broker_id_fkey"))
    @OnDelete(action = OnDeleteAction.SET_NULL)
    private Broker broker;
}
