package model.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Tutor", schema = "advanced_programming_project", catalog = "")
public class TutorEntity {
    @Id
    @Column(name = "id_tutor", nullable = false)
    private int idTutor;

    @Basic
    @Column(name = "name", nullable = true, length = 50)
    private String name;

    @Basic
    @Column(name = "lastname", nullable = false, length = 50)
    private String lastname;

    @Basic
    @Column(name = "login", nullable = false, length = 50)
    private String login;

    @Basic
    @Column(name = "password", nullable = false, length = 50)
    private String password;

    public TutorEntity() {}

    public int getIdTutor() {
        return idTutor;
    }

    public void setIdTutor(int idTutor) {
        this.idTutor = idTutor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TutorEntity that = (TutorEntity) o;

        if (idTutor != that.idTutor) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (lastname != null ? !lastname.equals(that.lastname) : that.lastname != null) return false;
        if (login != null ? !login.equals(that.login) : that.login != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idTutor;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
        result = 31 * result + (login != null ? login.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }
}
