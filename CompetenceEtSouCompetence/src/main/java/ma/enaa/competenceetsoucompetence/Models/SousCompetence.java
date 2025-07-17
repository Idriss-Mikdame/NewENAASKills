package ma.enaa.competenceetsoucompetence.Models;

import jakarta.persistence.*;

@Entity
public class SousCompetence {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Génération auto de l'ID
    private Long id;
    private String nom;
    private String description;
    private  boolean etatValidation;

    @ManyToOne
    @JoinColumn(name = "competence_id")
    private Competence competence;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isEtatValidation() {
        return etatValidation;
    }

    public void setEtatValidation(boolean etatValidation) {
        this.etatValidation = etatValidation;
    }

    public Competence getCompetence() {
        return competence;
    }

    public void setCompetence(Competence competence) {
        this.competence = competence;
    }
}
