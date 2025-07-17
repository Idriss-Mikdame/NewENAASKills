package ma.enaa.competenceetsoucompetence.DTO;

import java.io.Serializable;
import java.util.List;


public class CompetenceDto implements Serializable {
    Long id;
    String nom;
    String description;
    boolean etatValidation;
    List<SousCompetenceDto> sousCompetences;
}