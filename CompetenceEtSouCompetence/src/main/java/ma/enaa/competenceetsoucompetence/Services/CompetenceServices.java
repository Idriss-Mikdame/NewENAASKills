package ma.enaa.competenceetsoucompetence.Services;

import ma.enaa.competenceetsoucompetence.DTO.CompetenceDto;
import ma.enaa.competenceetsoucompetence.Mapper.CompetenceMapper;
import ma.enaa.competenceetsoucompetence.Models.Competence;
import ma.enaa.competenceetsoucompetence.Repository.CompetenceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompetenceServices {
    private final CompetenceRepository repositoryCompetence;
    private final CompetenceMapper competenceMapper;
//    private final RepositorySousCompetence repositorySousCompetence;

    public CompetenceServices(CompetenceRepository repositoryCompetence, CompetenceMapper competenceMapper) {
        this.repositoryCompetence = repositoryCompetence;
        this.competenceMapper = competenceMapper;
    }
    public CompetenceDto Ajouter(CompetenceDto competenceDto){
        Competence competence =  competenceMapper.toEntity(competenceDto);
        return competenceMapper.toDto(repositoryCompetence.save(competence));
    }

    public List<Competence> ListCompetence() {
        return repositoryCompetence.findAll();
    }
    public CompetenceDto AfficherParId(Long id){
        Competence competence =repositoryCompetence.findById(id).
                orElseThrow(()-> new RuntimeException("Competence non trouvé"));
        return competenceMapper.toDto(competence);
    }

    public CompetenceDto Modifier(Long id, CompetenceDto competenceDto){
        Competence competence = repositoryCompetence.findById(id).orElseThrow(()-> new RuntimeException("Competence non trouvé"));

        competence.setNom(competenceDto.getNom());
        competence.setEtatValidation(competenceDto.isEtatValidation());
        competence.setDescription(competenceDto.getDescription());
        return competenceMapper.toDto(repositoryCompetence.save(competence));

    }
    public void Supprimer(Long id){
        repositoryCompetence.deleteById(id);
    }
//    public boolean estCompetenceAcquise(Long competenceId) {
//        List<SousCompetence> sousCompetences = repositoryCompetence.findByCompetenceId(competenceId);
//
//        if (sousCompetences.isEmpty()) return false;
//
//        long valides = sousCompetences.stream().filter(SousCompetence::isEtatValidation).count();
//        return valides == sousCompetences.size(); // 100% validées
//    }
}
