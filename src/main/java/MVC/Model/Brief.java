package MVC.Model;

import jakarta.persistence.*;

@Entity
public class Brief {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_brief", nullable = false)
    private int idBrief;
    @Basic
    @Column(name = "title_brief", nullable = false, length = 255)
    private String titleBrief;
    @Basic
    @Column(name = "description_brief", nullable = false, length = -1)
    private String descriptionBrief;
    @Basic
    @Column(name = "deadline_brief", nullable = false)
    private int deadlineBrief;

    @ManyToOne
    @JoinColumn(name = "id_classroom", referencedColumnName = "id_classroom", nullable = false ,insertable = false, updatable = false)
    private Classroom classroomByIdClassroom;


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

    public Classroom getClassroomByIdClassroom() {
        return classroomByIdClassroom;
    }

    public void setClassroomByIdClassroom(Classroom classroomByIdClassroom) {
        this.classroomByIdClassroom = classroomByIdClassroom;
    }

    public Brief(int idBrief, String titleBrief, String descriptionBrief, int deadlineBrief, Classroom classroomByIdClassroom) {
        this.idBrief = idBrief;
        this.titleBrief = titleBrief;
        this.descriptionBrief = descriptionBrief;
        this.deadlineBrief = deadlineBrief;
        this.classroomByIdClassroom = classroomByIdClassroom;
    }

    public Brief(String titleBrief, String descriptionBrief, int deadlineBrief, Classroom classroomByIdClassroom) {
        this.titleBrief = titleBrief;
        this.descriptionBrief = descriptionBrief;
        this.deadlineBrief = deadlineBrief;
        this.classroomByIdClassroom = classroomByIdClassroom;
    }

    public Brief() {
    }
}
