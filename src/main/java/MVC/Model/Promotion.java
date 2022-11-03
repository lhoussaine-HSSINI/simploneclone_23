package MVC.Model;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
public class Promotion {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_promo")
    private int idPromo;
    @Basic
    @Column(name = "year")
    private String year;
    @OneToMany(mappedBy = "promotionByIdPromo")
    private Collection<Classroom> classroomsByIdPromo;

    public Promotion(String year) {
        this.year = year;
    }

    public Promotion(int idPromo, String year) {
        this.idPromo = idPromo;
        this.year = year;
    }

    public Promotion() {
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Promotion promotion = (Promotion) o;

        if (idPromo != promotion.idPromo) return false;
        if (year != null ? !year.equals(promotion.year) : promotion.year != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idPromo;
        result = 31 * result + (year != null ? year.hashCode() : 0);
        return result;
    }

    public Collection<Classroom> getClassroomsByIdPromo() {
        return classroomsByIdPromo;
    }

    public void setClassroomsByIdPromo(Collection<Classroom> classroomsByIdPromo) {
        this.classroomsByIdPromo = classroomsByIdPromo;
    }
}
