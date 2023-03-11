package model.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.sql.Date;

@Entity
@Table(name = "Internship", schema = "advanced_programming_project", catalog = "")
public class InternshipEntity {
    @Id
    @Column(name = "id_internship", nullable = false)
    private int idInternship;

    @Basic
    @Column(name = "specifications", nullable = false)
    private boolean specifications;

    @Basic
    @Column(name = "visit_sheet", nullable = false)
    private boolean visitSheet;

    @Basic
    @Column(name = "company_eval_sheet", nullable = false)
    private boolean companyEvalSheet;

    @Basic
    @Column(name = "web_survey", nullable = false)
    private boolean webSurvey;

    @Basic
    @Column(name = "report_delivered", nullable = false)
    private boolean reportDelivered;

    @Basic
    @Column(name = "presentation", nullable = false)
    private boolean presentation;

    @Basic
    @Column(name = "planned", nullable = false)
    private boolean planned;

    @Basic
    @Column(name = "done", nullable = false)
    private boolean done;

    @Basic
    @Column(name = "start_date", nullable = false)
    private Date startDate;

    @Basic
    @Column(name = "end_date", nullable = false)
    private Date endDate;

    @Basic
    @Column(name = "supervisor", nullable = false, length = 50)
    private String supervisor;

    @Basic
    @Column(name = "technical_note", nullable = true, precision = 2)
    private BigDecimal technicalNote;

    @Basic
    @Column(name = "communication_note", nullable = true, precision = 2)
    private BigDecimal communicationNote;

    @ManyToOne
    //@JoinColumn(name="id_student")
    private StudentEntity student;

    @ManyToOne
    //@JoinColumn(name="id_company")
    private CompanyEntity company;

    public InternshipEntity() {}

    public int getIdInternship() {
        return idInternship;
    }

    public void setIdInternship(int idInternship) {
        this.idInternship = idInternship;
    }

    public boolean isSpecifications() {
        return specifications;
    }

    public void setSpecifications(boolean specifications) {
        this.specifications = specifications;
    }

    public boolean isVisitSheet() {
        return visitSheet;
    }

    public void setVisitSheet(boolean visitSheet) {
        this.visitSheet = visitSheet;
    }

    public boolean isCompanyEvalSheet() {
        return companyEvalSheet;
    }

    public void setCompanyEvalSheet(boolean companyEvalSheet) {
        this.companyEvalSheet = companyEvalSheet;
    }

    public boolean isWebSurvey() {
        return webSurvey;
    }

    public void setWebSurvey(boolean webSurvey) {
        this.webSurvey = webSurvey;
    }

    public boolean isReportDelivered() {
        return reportDelivered;
    }

    public void setReportDelivered(boolean reportDelivered) {
        this.reportDelivered = reportDelivered;
    }

    public boolean isPresentation() {
        return presentation;
    }

    public void setPresentation(boolean presentation) {
        this.presentation = presentation;
    }

    public boolean isPlanned() {
        return planned;
    }

    public void setPlanned(boolean planned) {
        this.planned = planned;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(String supervisor) {
        this.supervisor = supervisor;
    }

    public BigDecimal getTechnicalNote() {
        return technicalNote;
    }

    public void setTechnicalNote(BigDecimal technicalNote) {
        this.technicalNote = technicalNote;
    }

    public BigDecimal getCommunicationNote() {
        return communicationNote;
    }

    public void setCommunicationNote(BigDecimal communicationNote) {
        this.communicationNote = communicationNote;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        InternshipEntity that = (InternshipEntity) o;

        if (idInternship != that.idInternship) return false;
        if (specifications != that.specifications) return false;
        if (visitSheet != that.visitSheet) return false;
        if (companyEvalSheet != that.companyEvalSheet) return false;
        if (webSurvey != that.webSurvey) return false;
        if (reportDelivered != that.reportDelivered) return false;
        if (presentation != that.presentation) return false;
        if (planned != that.planned) return false;
        if (done != that.done) return false;
        if (startDate != null ? !startDate.equals(that.startDate) : that.startDate != null) return false;
        if (endDate != null ? !endDate.equals(that.endDate) : that.endDate != null) return false;
        if (supervisor != null ? !supervisor.equals(that.supervisor) : that.supervisor != null) return false;
        if (technicalNote != null ? !technicalNote.equals(that.technicalNote) : that.technicalNote != null)
            return false;
        if (communicationNote != null ? !communicationNote.equals(that.communicationNote) : that.communicationNote != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idInternship;
        result = 31 * result + (specifications ? 1 : 0);
        result = 31 * result + (visitSheet ? 1 : 0);
        result = 31 * result + (companyEvalSheet ? 1 : 0);
        result = 31 * result + (webSurvey ? 1 : 0);
        result = 31 * result + (reportDelivered ? 1 : 0);
        result = 31 * result + (presentation ? 1 : 0);
        result = 31 * result + (planned ? 1 : 0);
        result = 31 * result + (done ? 1 : 0);
        result = 31 * result + (startDate != null ? startDate.hashCode() : 0);
        result = 31 * result + (endDate != null ? endDate.hashCode() : 0);
        result = 31 * result + (supervisor != null ? supervisor.hashCode() : 0);
        result = 31 * result + (technicalNote != null ? technicalNote.hashCode() : 0);
        result = 31 * result + (communicationNote != null ? communicationNote.hashCode() : 0);
        return result;
    }

    public StudentEntity getStudent() {
        return student;
    }

    public void setStudent(StudentEntity student) {
        this.student = student;
    }

    public CompanyEntity getCompany() {
        return company;
    }

    public void setCompany(CompanyEntity company) {
        this.company = company;
    }
}
