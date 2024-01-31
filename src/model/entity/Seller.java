package model.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class Seller implements Serializable {

    private Integer id;
    private String name;
    private String email;
    private Date BirthDate;
    private Double baseSalary;

    public Seller() {
    }

    public Seller(String name, String email, Date birthDate, Double baseSalary) {
        this.name = name;
        this.email = email;
        BirthDate = birthDate;
        this.baseSalary = baseSalary;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public Date getBirthDate() {
        return BirthDate;
    }

    public Double getBaseSalary() {
        return baseSalary;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setBirthDate(Date birthDate) {
        BirthDate = birthDate;
    }

    public void setBaseSalary(Double baseSalary) {
        this.baseSalary = baseSalary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Seller seller = (Seller) o;
        return Objects.equals(id, seller.id) && Objects.equals(name, seller.name) && Objects.equals(email, seller.email) && Objects.equals(BirthDate, seller.BirthDate) && Objects.equals(baseSalary, seller.baseSalary);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, email, BirthDate, baseSalary);
    }

    @Override
    public String toString() {
        return "Seller{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", email='" + email + '\'' +
            ", BirthDate=" + BirthDate +
            ", baseSalary=" + baseSalary +
            '}';
    }
}
