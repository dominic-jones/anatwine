package com.anatwine.stock.entity;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "stock_level")
@SequenceGenerator(name = "STOCKLEVEL_SEQ", sequenceName = "stock_level_seq_id", initialValue = 1, allocationSize = 1)
public class StockLevel {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "STOCKLEVEL_SEQ")
    @Column(name = "id")
    private Long id;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "brand_id")
    private Long brandId;

    @Column(name = "brand_sku")
    private String brandSku;

    @ElementCollection
    @CollectionTable(name = "stock_levels_channels", joinColumns = {@JoinColumn(name = "stock_level_id")})
    @Column(name = "channel_id")
    private Set<Long> channels = new HashSet<>();

    @Column
    private String status;

    @Column(name = "updated_at")
    private Timestamp updatedAt;

    public Set<Long> getChannels() {
        return ImmutableSet.copyOf(channels);
    }

    public void setChannels(Set<Long> channels) {
        this.channels = Sets.newHashSet(channels);
    }

    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getBrandSku() {
        return brandSku;
    }

    public void setBrandSku(String brandSku) {
        this.brandSku = brandSku;
    }
}
