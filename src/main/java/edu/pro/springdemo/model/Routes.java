package edu.pro.springdemo.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.geo.Distance;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Objects;

@ApiModel
@Document

public class Routes {
    @Id
    @ApiModelProperty(value = " UUID is given by BD", required = true, dataType = "UUID to string", example = "12345")
    private String id;
    private String name;
    private String distance;
    private String daysinway;
    private String payment;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Routes() {
    }

    public Routes(String name, String distance, String daysinway, String payment) {
        this.name = name;
        this.distance = distance;
        this.daysinway = daysinway;
        this.payment = payment;
    }

    public Routes(String id, String name, String distance, String daysinway, String payment, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.name = name;
        this.distance = distance;
        this.daysinway = daysinway;
        this.payment = payment;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String getDaysinway() {
        return daysinway;
    }

    public void setDaysinway(String daysinway) {
        this.daysinway = daysinway;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Routes routes = (Routes) o;
        return getId().equals(routes.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}

