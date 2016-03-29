package com.anatwine.stock.entity;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "stock_level")
@SequenceGenerator(name = "STOCKLEVEL_SEQ", sequenceName = "stock_level_seq_id", initialValue = 1, allocationSize = 1)
public class StockLevel {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "STOCKLEVEL_SEQ")
    private Long Id;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "brand_id")
    private Long brandId;

    @Column(name = "brand_sku")
    private String brandSku;


    @ElementCollection
    @CollectionTable(name = "stock_levels_channels", joinColumns = { @JoinColumn(name="stock_level_id")})
    @Column(name = "channel_id")
    private Set<Long> channels = new HashSet<>();

    /**
     * Status can be pending, approved, activated
     */
    @Column
    private String status;

    @Column(name = "updated_at")
    private Date UpdatedAt;

    public Set<Long> getChannels() {
        return channels;
    }

    public void setChannels(Set<Long> channels) {
        this.channels = channels;
    }

    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Date getUpdatedAt() {
        return UpdatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        UpdatedAt = updatedAt;
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
