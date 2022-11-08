package MVC.Model;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
public class Formateur {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_formateur", nullable = false)
    private int idFormateur;
    @Basic
    @Column(name = "nom", nullable = false, length = 255)
    private String nom;
    @Basic
    @Column(name = "prenom", nullable = false, length = 255)
    private String prenom;
    @Basic
    @Column(name = "username", nullable = false, length = 255)
    private String username;
    @Basic
    @Column(name = "password", nullable = false, length = 255)
    private String password;
    @OneToMany(mappedBy = "formateurByIdFormateur")
    private Collection<Classroom> classroomsByIdFormateur;

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

    public Collection<Classroom> getClassroomsByIdFormateur() {
        return classroomsByIdFormateur;
    }

    public void setClassroomsByIdFormateur(Collection<Classroom> classroomsByIdFormateur) {
        this.classroomsByIdFormateur = classroomsByIdFormateur;
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

    public Formateur() {
    }
}
