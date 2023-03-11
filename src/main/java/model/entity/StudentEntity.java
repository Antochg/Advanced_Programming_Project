package model.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "student", schema = "advanced_programming_project", catalog = "")
public class StudentEntity {
    private int idStudent;
    private String name;
    private String lastname;
    private String level;

    @ManyToOne
    @JoinColumn(name="idTutor", nullable=false)
    private TutorEntity tutorEntity;

    @OneToOne(cascade = CascadeType.ALL)
    private InternshipEntity internshipEntity;

    @Id
    @Column(name = "id_student", nullable = false)
    public int getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(int idStudent) {
        this.idStudent = idStudent;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 50)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "lastname", nullable = false, length = 50)
    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @Basic
    @Column(name = "level", nullable = false, length = 50)
    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StudentEntity that = (StudentEntity) o;

        if (idStudent != that.idStudent) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (lastname != null ? !lastname.equals(that.lastname) : that.lastname != null) return false;
        if (level != null ? !level.equals(that.level) : that.level != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idStudent;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
        result = 31 * result + (level != null ? level.hashCode() : 0);
        return result;
    }

    public TutorEntity getTutorEntity() {
        return tutorEntity;
    }

    public void setTutorEntity(TutorEntity tutorEntity) {
        this.tutorEntity = tutorEntity;
    }

    public InternshipEntity getInternshipEntity() {
        return internshipEntity;
    }

    public void setInternshipEntity(InternshipEntity internshipEntity) {
        this.internshipEntity = internshipEntity;
    }
}
