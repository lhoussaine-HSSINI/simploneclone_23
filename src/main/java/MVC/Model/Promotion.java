package MVC.Model;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
public class Promotion {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_promo", nullable = false)
    private int idPromo;
    @Basic
    @Column(name = "year", nullable = false, length = -1)
    private String year;
    @OneToMany(mappedBy = "promotionByIdPromo")
    private Collection<Classroom> classroomsByIdPromo;

    public int getIdPromo() {
        return idPromo;
    }

    public void setIdPromo(int idPromo) {
        this.idPromo = idPromo;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public Collection<Classroom> getClassroomsByIdPromo() {
        return classroomsByIdPromo;
    }

    public void setClassroomsByIdPromo(Collection<Classroom> classroomsByIdPromo) {
        this.classroomsByIdPromo = classroomsByIdPromo;
    }

    public Promotion() {
    }

    public Promotion(String year) {
        this.year = year;
    }
    public Promotion(int idPromo, String year) {
        this.idPromo = idPromo;
        this.year = year;
    }




}
