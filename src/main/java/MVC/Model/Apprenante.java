package MVC.Model;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
public class Apprenante {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_apprenante", nullable = false)
    private int idApprenante;
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
    @OneToMany(mappedBy = "apprenanteByIdApprenante")
    private Collection<Classroom> classroomsByIdApprenante;

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

    public Collection<Classroom> getClassroomsByIdApprenante() {
        return classroomsByIdApprenante;
    }

    public void setClassroomsByIdApprenante(Collection<Classroom> classroomsByIdApprenante) {
        this.classroomsByIdApprenante = classroomsByIdApprenante;
    }

    public Apprenante(int idApprenante, String nom, String prenom, String username, String password) {
        this.idApprenante = idApprenante;
        this.nom = nom;
        this.prenom = prenom;
        this.username = username;
        this.password = password;
    }

    public Apprenante(String nom, String prenom, String username, String password) {
        this.nom = nom;
        this.prenom = prenom;
        this.username = username;
        this.password = password;
        this.classroomsByIdApprenante = classroomsByIdApprenante;
    }

    public Apprenante() {
    }
}
