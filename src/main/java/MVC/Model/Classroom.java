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
    @Basic
    @Column(name = "id_promo", nullable = false)
    private int idPromo;
    @Basic
    @Column(name = "id_formateur", nullable = false)
    private int idFormateur;
    @Basic
    @Column(name = "id_apprenante", nullable = false)
    private int idApprenante;
    @OneToMany(mappedBy = "classroomByIdClassroom")
    private Collection<Brief> briefsByIdClassroom;
    @ManyToOne
    @JoinColumn(name = "id_promo", referencedColumnName = "id_promo", nullable = false ,insertable = false, updatable = false)
    private Promotion promotionByIdPromo;
    @ManyToOne
    @JoinColumn(name = "id_formateur", referencedColumnName = "id_formateur", nullable = false ,insertable = false, updatable = false)
    private Formateur formateurByIdFormateur;
    @ManyToOne
    @JoinColumn(name = "id_apprenante", referencedColumnName = "id_apprenante", nullable = false ,insertable = false, updatable = false)
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

    public int getIdPromo() {
        return idPromo;
    }

    public void setIdPromo(int idPromo) {
        this.idPromo = idPromo;
    }

    public int getIdFormateur() {
        return idFormateur;
    }

    public void setIdFormateur(int idFormateur) {
        this.idFormateur = idFormateur;
    }

    public int getIdApprenante() {
        return idApprenante;
    }

    public void setIdApprenante(int idApprenante) {
        this.idApprenante = idApprenante;
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

    public Formateur getFormateurByIdFormateur() {
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

    public Classroom(int idClassroom, String nomClassroom, Promotion promotionByIdPromo, Formateur formateurByIdFormateur, Apprenante apprenanteByIdApprenante) {
        this.idClassroom = idClassroom;
        this.nomClassroom = nomClassroom;
        this.promotionByIdPromo = promotionByIdPromo;
        this.formateurByIdFormateur = formateurByIdFormateur;
        this.apprenanteByIdApprenante = apprenanteByIdApprenante;
    }

    public Classroom(String nomClassroom, Promotion promotionByIdPromo, Formateur formateurByIdFormateur, Apprenante apprenanteByIdApprenante) {
        this.nomClassroom = nomClassroom;
        this.promotionByIdPromo = promotionByIdPromo;
        this.formateurByIdFormateur = formateurByIdFormateur;
        this.apprenanteByIdApprenante = apprenanteByIdApprenante;
    }

    public Classroom() {
    }
}
