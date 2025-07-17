package ma.enaa.competenceetsoucompetence.DTO;

import lombok.Value;
import ma.enaa.competenceetsoucompetence.Models.SousCompetence;

import java.io.Serializable;

/**
 * DTO for {@link SousCompetence}
 */
@Value
public class SousCompetenceDto implements Serializable {
    Long id;
    String nom;
    String description;
    boolean etatValidation;
}