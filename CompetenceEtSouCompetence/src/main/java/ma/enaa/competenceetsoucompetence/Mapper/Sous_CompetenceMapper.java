package ma.enaa.competenceetsoucompetence.Mapper;

import ma.enaa.competenceetsoucompetence.DTO.SousCompetenceDto;
import ma.enaa.competenceetsoucompetence.Models.SousCompetence;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedSourcePolicy = ReportingPolicy.IGNORE)

public interface Sous_CompetenceMapper {

SousCompetenceDto souscompeteneToDto(SousCompetence sousCompetence);
SousCompetence dtoToSousCompetence(SousCompetenceDto sousCompetenceDto);
}
