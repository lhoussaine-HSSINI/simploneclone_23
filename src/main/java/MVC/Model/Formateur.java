package MVC.Model;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
public class Formateur {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_formateur")
    private int idFormateur;
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
    @OneToMany(mappedBy = "formateurByIdFormateur")
    private Collection<Classroom> classroomsByIdFormateur;
    public Formateur(){

    }

    public Formateur(int idFormateur, String nom, String prenom, String username, String password) {
        this.idFormateur = idFormateur;
        this.nom = nom;
        this.prenom = prenom;
        this.username = username;
        this.password = password;
    }

    public Formateur(String nom, String prenom, String username, String password) {
        this.nom = nom;
        this.prenom = prenom;
        this.username = username;
        this.password = password;
    }

    public int getIdFormateur() {
        return idFormateur;
    }

    public void setIdFormateur(int idFormateur) {
        this.idFormateur = idFormateur;
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

        Formateur formateur = (Formateur) o;

        if (idFormateur != formateur.idFormateur) return false;
        if (nom != null ? !nom.equals(formateur.nom) : formateur.nom != null) return false;
        if (prenom != null ? !prenom.equals(formateur.prenom) : formateur.prenom != null) return false;
        if (username != null ? !username.equals(formateur.username) : formateur.username != null) return false;
        if (password != null ? !password.equals(formateur.password) : formateur.password != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idFormateur;
        result = 31 * result + (nom != null ? nom.hashCode() : 0);
        result = 31 * result + (prenom != null ? prenom.hashCode() : 0);
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }

    public Collection<Classroom> getClassroomsByIdFormateur() {
        return classroomsByIdFormateur;
    }

    public void setClassroomsByIdFormateur(Collection<Classroom> classroomsByIdFormateur) {
        this.classroomsByIdFormateur = classroomsByIdFormateur;
    }
}
