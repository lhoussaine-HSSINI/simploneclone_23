package MVC.Model;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
public class Classroom {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_classroom", nullable = false)
    private int idClassroom;
    @Basic
    @Column(name = "nom_classroom", nullable = false, length = 255)
    private String nomClassroom;
    @ManyToOne
    @JoinColumn(name = "id_promo", referencedColumnName = "id_promo", nullable = false ,insertable = false, updatable = false)
    private Promotion promotionByIdPromo;
    @ManyToOne
    @JoinColumn(name = "id_formateur", referencedColumnName = "id_formateur", nullable = false ,insertable = false, updatable = false)
    private Formateur formateurByIdFormateur;
    @ManyToOne
    @JoinColumn(name = "id_apprenante", referencedColumnName = "id_apprenante", nullable = false ,insertable = false, updatable = false)
    private Apprenante apprenanteByIdApprenante;

    @OneToMany(mappedBy = "classroomByIdClassroom")
    private Collection<Brief> briefsByIdClassroom;

    public Classroom(String nomClassroom, Promotion promotionByIdPromo, Formateur formateurByIdFormateur, Apprenante apprenanteByIdApprenante) {
        this.nomClassroom = nomClassroom;
        this.promotionByIdPromo = promotionByIdPromo;
        this.formateurByIdFormateur = formateurByIdFormateur;
        this.apprenanteByIdApprenante = apprenanteByIdApprenante;
    }

       public Classroom() {
    }

    public Classroom(int idClassroom, String nomClassroom, Promotion promotionByIdPromo, Formateur formateurByIdFormateur, Apprenante apprenanteByIdApprenante) {
        this.idClassroom = idClassroom;
        this.nomClassroom = nomClassroom;
        this.promotionByIdPromo = promotionByIdPromo;
        this.formateurByIdFormateur = formateurByIdFormateur;
        this.apprenanteByIdApprenante = apprenanteByIdApprenante;
    }

    public int getIdClassroom() {
        return idClassroom;
    }

    public void setIdClassroom(int idClassroom) {
        this.idClassroom = idClassroom;
    }

    public String getNomClassroom() {
        return nomClassroom;
    }

    public void setNomClassroom(String nomClassroom) {
        this.nomClassroom = nomClassroom;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Classroom classroom = (Classroom) o;

        if (idClassroom != classroom.idClassroom) return false;
//        if (idPromo != classroom.idPromo) return false;
//        if (idFormateur != classroom.idFormateur) return false;
//        if (idApprenante != classroom.idApprenante) return false;
        if (nomClassroom != null ? !nomClassroom.equals(classroom.nomClassroom) : classroom.nomClassroom != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idClassroom;
        result = 31 * result + (nomClassroom != null ? nomClassroom.hashCode() : 0);
//        result = 31 * result + idPromo;
//        result = 31 * result + idFormateur;
//        result = 31 * result + idApprenante;
        return result;
    }

    public Promotion getPromotionByIdPromo() {
        return promotionByIdPromo;
    }

    public void setPromotionByIdPromo(Promotion promotionByIdPromo) {
        this.promotionByIdPromo = promotionByIdPromo;
    }

    public Formateur getFormateurByIdFormateur(Formateur formateur) {
        return formateurByIdFormateur;
    }

    public void setFormateurByIdFormateur(Formateur formateurByIdFormateur) {
        this.formateurByIdFormateur = formateurByIdFormateur;
    }

    public Apprenante getApprenanteByIdApprenante() {
        return apprenanteByIdApprenante;
    }

    public void setApprenanteByIdApprenante(Apprenante apprenanteByIdApprenante) {
        this.apprenanteByIdApprenante = apprenanteByIdApprenante;
    }
    

    public Collection<Brief> getBriefsByIdClassroom() {
        return briefsByIdClassroom;
    }

    public void setBriefsByIdClassroom(Collection<Brief> briefsByIdClassroom) {
        this.briefsByIdClassroom = briefsByIdClassroom;
    }

    public Formateur getFormateurByIdFormateur() {
        return formateurByIdFormateur;
    }
}
