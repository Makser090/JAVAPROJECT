package edu.pro.springdemo.form;

public class RoutesForm {
    private String id;
    private String name;
    private String distance;
    private String daysinway;
    private String payment;
    private String createdAt;
    private String updatedAt;

    public RoutesForm() {
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

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "RoutesForm{" +
                ", name='" + name + '\'' +
                ", distance='" + distance + '\'' +
                ", daysinway='" + daysinway + '\'' +
                ", payment='" + payment + '\'' +
                '}';
    }
}
