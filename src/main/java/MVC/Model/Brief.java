package MVC.Model;

import jakarta.persistence.*;

@Entity
public class Brief {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_brief")
    private int idBrief;
    @Basic
    @Column(name = "title_brief")
    private String titleBrief;
    @Basic
    @Column(name = "description_brief")
    private String descriptionBrief;
    @Basic
    @Column(name = "deadline_brief")
    private int deadlineBrief;
//    @Basic
//    @Column(name = "id_classroom")
//    private int idClassroom;
//    @Basic
//    @Column(name = "id_formateur")
//    private int idFormateur;
    @ManyToOne
    @JoinColumn(name = "id_classroom", referencedColumnName = "id_classroom", nullable = false)
    private Classroom classroomByIdClassroom;
    @ManyToOne
    @JoinColumn(name = "id_formateur", referencedColumnName = "id_formateur", nullable = false)
    private Formateur formateurByIdFormateur;

    public int getIdBrief() {
        return idBrief;
    }

    public void setIdBrief(int idBrief) {
        this.idBrief = idBrief;
    }

    public String getTitleBrief() {
        return titleBrief;
    }

    public void setTitleBrief(String titleBrief) {
        this.titleBrief = titleBrief;
    }

    public String getDescriptionBrief() {
        return descriptionBrief;
    }

    public void setDescriptionBrief(String descriptionBrief) {
        this.descriptionBrief = descriptionBrief;
    }

    public int getDeadlineBrief() {
        return deadlineBrief;
    }

    public void setDeadlineBrief(int deadlineBrief) {
        this.deadlineBrief = deadlineBrief;
    }

//    public int getIdClassroom() {
//        return idClassroom;
//    }
//
//    public void setIdClassroom(int idClassroom) {
//        this.idClassroom = idClassroom;
//    }
//
//    public int getIdFormateur() {
//        return idFormateur;
//    }
//
//    public void setIdFormateur(int idFormateur) {
//        this.idFormateur = idFormateur;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Brief brief = (Brief) o;

        if (idBrief != brief.idBrief) return false;
        if (deadlineBrief != brief.deadlineBrief) return false;
//        if (idClassroom != brief.idClassroom) return false;
//        if (idFormateur != brief.idFormateur) return false;
        if (titleBrief != null ? !titleBrief.equals(brief.titleBrief) : brief.titleBrief != null) return false;
        if (descriptionBrief != null ? !descriptionBrief.equals(brief.descriptionBrief) : brief.descriptionBrief != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idBrief;
        result = 31 * result + (titleBrief != null ? titleBrief.hashCode() : 0);
        result = 31 * result + (descriptionBrief != null ? descriptionBrief.hashCode() : 0);
        result = 31 * result + deadlineBrief;
//        result = 31 * result + idClassroom;
//        result = 31 * result + idFormateur;
        return result;
    }

    public Classroom getClassroomByIdClassroom() {
        return classroomByIdClassroom;
    }

    public void setClassroomByIdClassroom(Classroom classroomByIdClassroom) {
        this.classroomByIdClassroom = classroomByIdClassroom;
    }

    public Formateur getFormateurByIdFormateur() {
        return formateurByIdFormateur;
    }

    public void setFormateurByIdFormateur(Formateur formateurByIdFormateur) {
        this.formateurByIdFormateur = formateurByIdFormateur;
    }
}
