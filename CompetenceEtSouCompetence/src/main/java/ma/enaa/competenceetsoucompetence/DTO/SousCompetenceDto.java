package ma.enaa.competenceetsoucompetence.DTO;

import lombok.Value;
import ma.enaa.competenceetsoucompetence.Models.SousCompetence;

import java.io.Serializable;


public class SousCompetenceDto  {
    Long id;
    String nom;
    String description;
    boolean etatValidation;
    Long CompetenceId;

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

    public Long getCompetenceId() {
        return CompetenceId;
    }

    public void setCompetenceId(Long competenceId) {
        CompetenceId = competenceId;
    }
}