package model.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Company", schema = "advanced_programming_project", catalog = "")
public class CompanyEntity {

    @Id
    @Column(name = "id_company", nullable = false)
    private int idCompany;

    @Basic
    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Basic
    @Column(name = "address", nullable = false, length = 255)
    private String address;

    @OneToMany
    @JoinColumn(name="id_company")
    private List<InternshipEntity> internships;

    public CompanyEntity() {}

    public int getIdCompany() {
        return idCompany;
    }

    public void setIdCompany(int idCompany) {
        this.idCompany = idCompany;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<InternshipEntity> getInternships() { return internships; }

    public void setInternships( List<InternshipEntity> internships ) { this.internships = internships; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CompanyEntity that = (CompanyEntity) o;

        if (idCompany != that.idCompany) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (address != null ? !address.equals(that.address) : that.address != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idCompany;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        return result;
    }

}
