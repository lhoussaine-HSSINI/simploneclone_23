package MVC.Model;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
public class Classroom {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_classroom")
    private int idClassroom;
    @Basic
    @Column(name = "nom_classroom")
    private String nomClassroom;
//    @Basic
//    @Column(name = "id_promo")
//    private int idPromo;
//    @Basic
//    @Column(name = "id_formateur")
//    private int idFormateur;
//    @Basic
//    @Column(name = "id_apprenante")
//    private int idApprenante;
    @OneToMany(mappedBy = "classroomByIdClassroom")
    private Collection<Brief> briefsByIdClassroom;
    @ManyToOne
    @JoinColumn(name = "id_promo", referencedColumnName = "id_promo", nullable = false)
    private Promotion promotionByIdPromo;

    public Classroom(String nomClassroom, Promotion promotionByIdPromo, Formateur formateurByIdFormateur, Apprenante apprenanteByIdApprenante) {
        this.nomClassroom = nomClassroom;
        this.promotionByIdPromo = promotionByIdPromo;
        this.formateurByIdFormateur = formateurByIdFormateur;
        this.apprenanteByIdApprenante = apprenanteByIdApprenante;
    }
       public Classroom() {
    }

    @ManyToOne
    @JoinColumn(name = "id_formateur", referencedColumnName = "id_formateur", nullable = false)
    private Formateur formateurByIdFormateur;
    @ManyToOne
    @JoinColumn(name = "id_apprenante", referencedColumnName = "id_apprenante", nullable = false)
    private Apprenante apprenanteByIdApprenante;


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

//    public int getIdPromo() {
//        return idPromo;
//    }
//
//    public void setIdPromo(int idPromo) {
//        this.idPromo = idPromo;
//    }
//
//    public int getIdFormateur() {
//        return idFormateur;
//    }
//
//    public void setIdFormateur(int idFormateur) {
//        this.idFormateur = idFormateur;
//    }
//
//    public int getIdApprenante() {
//        return idApprenante;
//    }
//
//    public void setIdApprenante(int idApprenante) {
//        this.idApprenante = idApprenante;
//    }

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

    public Collection<Brief> getBriefsByIdClassroom() {
        return briefsByIdClassroom;
    }

    public void setBriefsByIdClassroom(Collection<Brief> briefsByIdClassroom) {
        this.briefsByIdClassroom = briefsByIdClassroom;
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

    public Apprenante getApprenanteByIdApprenante(Apprenante apprenante) {
        return apprenanteByIdApprenante;
    }

    public void setApprenanteByIdApprenante(Apprenante apprenanteByIdApprenante) {
        this.apprenanteByIdApprenante = apprenanteByIdApprenante;
    }
}
