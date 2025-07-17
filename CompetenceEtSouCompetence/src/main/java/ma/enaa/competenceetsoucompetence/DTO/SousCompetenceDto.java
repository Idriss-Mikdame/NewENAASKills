package ma.enaa.competenceetsoucompetence.DTO;

import lombok.Value;
import ma.enaa.competenceetsoucompetence.Models.SousCompetence;

import java.io.Serializable;


public class SousCompetenceDto  {
    Long id;
    String nom;
    String description;
    boolean etatValidation;

}