package MVC.Model;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
public class Apprenante {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_apprenante")
    private int idApprenante;
    @Basic
    @Column(name = "nom")
    private String nom;
    @Basic
    @Column(name = "prenom")
    private String prenom;
    @Basic
    @Column(name = "username")
    private String username;
    @Basic
    @Column(name = "password")
    private String password;
    @OneToMany(mappedBy = "apprenanteByIdApprenante")
    private Collection<Classroom> classroomsByIdApprenante;
    public Apprenante(){

    }

    public Apprenante(String nom, String prenom, String username, String password) {
        this.nom = nom;
        this.prenom = prenom;
        this.username = username;
        this.password = password;
    }

    public Apprenante(int idApprenante, String nom, String prenom, String username, String password) {
        this.idApprenante = idApprenante;
        this.nom = nom;
        this.prenom = prenom;
        this.username = username;
        this.password = password;
    }


    public int getIdApprenante() {
        return idApprenante;
    }

    public void setIdApprenante(int idApprenante) {
        this.idApprenante = idApprenante;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

        Apprenante that = (Apprenante) o;

        if (idApprenante != that.idApprenante) return false;
        if (nom != null ? !nom.equals(that.nom) : that.nom != null) return false;
        if (prenom != null ? !prenom.equals(that.prenom) : that.prenom != null) return false;
        if (username != null ? !username.equals(that.username) : that.username != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idApprenante;
        result = 31 * result + (nom != null ? nom.hashCode() : 0);
        result = 31 * result + (prenom != null ? prenom.hashCode() : 0);
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }

    public Collection<Classroom> getClassroomsByIdApprenante() {
        return classroomsByIdApprenante;
    }

    public void setClassroomsByIdApprenante(Collection<Classroom> classroomsByIdApprenante) {
        this.classroomsByIdApprenante = classroomsByIdApprenante;
    }
}
