package ma.enaa.competenceetsoucompetence.Mapper;

import ma.enaa.competenceetsoucompetence.DTO.CompetenceDto;
import ma.enaa.competenceetsoucompetence.Models.Competence;
import org.mapstruct.Mapper;
import org.springframework.boot.CommandLineRunner;

@Mapper(componentModel = "spring")
public interface CompetenceMapper {
    Competence toEntity(CompetenceDto competenceDto);
    CompetenceDto toDto(Competence competence);
}
