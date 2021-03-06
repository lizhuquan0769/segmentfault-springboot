package com.segmentfault.springboot.lession8.jpa.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "jpa_stores")
public class Store {

    @Id
    @GeneratedValue
    private Long id;

    @Column(length = 128)
    private String name;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "jpa_relate_store_guest",
            joinColumns = @JoinColumn(name = "relate_store_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "relate_guest_id", referencedColumnName = "id")
    )
    private List<Guest> guests;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Guest> getGuests() {
        return guests;
    }

    public void setGuests(List<Guest> guests) {
        this.guests = guests;
    }
}
