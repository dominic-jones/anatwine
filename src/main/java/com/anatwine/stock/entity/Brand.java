package com.anatwine.stock.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "brand")
public class Brand {

    @Id
    private Long id;

    @Column(name = "brand_name")
    private String brandName;

    @Column
    @OneToMany
    @JoinTable(name = "brands_channels", joinColumns = { @JoinColumn(name="brand_id", referencedColumnName = "id")},
    inverseJoinColumns = {@JoinColumn(name="channel_id", referencedColumnName = "id")})
    private List<Channel> channels;

    public List<Channel> getChannels() {
        return channels;
    }

    public void setChannels(List<Channel> channels) {
        this.channels = channels;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
