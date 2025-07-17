package ma.enaa.competenceetsoucompetence.Services;

import ma.enaa.competenceetsoucompetence.DTO.SousCompetenceDto;
import ma.enaa.competenceetsoucompetence.Mapper.Sous_CompetenceMapper;
import ma.enaa.competenceetsoucompetence.Models.Competence;
import ma.enaa.competenceetsoucompetence.Models.SousCompetence;
import ma.enaa.competenceetsoucompetence.Repository.CompetenceRepository;
import ma.enaa.competenceetsoucompetence.Repository.Sous_CompetenceRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class Sous_CompetenceService {
    private final Sous_CompetenceRepo sousCompetenceRepo;
    private Sous_CompetenceMapper sousCompetenceMapper;
    private CompetenceRepository competenceRepo;
    private CompetenceServices competenceService;


    public Sous_CompetenceService(Sous_CompetenceRepo sousCompetenceRepo, Sous_CompetenceMapper sousCompetenceMapper, CompetenceRepository competenceRepo, CompetenceServices competenceService) {
        this.sousCompetenceRepo = sousCompetenceRepo;
        this.sousCompetenceMapper = sousCompetenceMapper;
        this.competenceRepo = competenceRepo;
        this.competenceService = competenceService;
    }

    public SousCompetenceDto AjouterSousCompetence(SousCompetenceDto sousCompetenceDto) {
        SousCompetence sousCompetence = sousCompetenceMapper.dtoToSousCompetence(sousCompetenceDto);
        if (sousCompetenceDto.getCompetenceId()!=null){
            Competence competence=competenceRepo.findById(sousCompetenceDto.getCompetenceId())
                    .orElse(null);
            sousCompetence.setCompetence(competence);
        }
        return sousCompetenceMapper.souscompeteneToDto(sousCompetenceRepo.save(sousCompetence));
    }
    public List<SousCompetenceDto> ListSousCompetence(){
        return sousCompetenceRepo.findAll().stream()
                .map(sousCompetenceMapper::souscompeteneToDto)
                .collect(Collectors.toList());
    }
    public SousCompetenceDto modifier(Long id , SousCompetenceDto sous_competenceDto){
        SousCompetence sousCompetence= sousCompetenceRepo.findById(id)
                .orElse(null);
        if (sous_competenceDto==null){
            throw new RuntimeException("Aucune sous_competence");
        }
        sousCompetence.setNom(sous_competenceDto.getNom());
        sousCompetence.setDescription(sous_competenceDto.getDescription());
        return sousCompetenceMapper.souscompeteneToDto(sousCompetence);

    }

    public void supprimerSousCompetence (Long id ){
        sousCompetenceRepo.deleteById(id);
    }

    public SousCompetenceDto updateEtatValidation(Long id, boolean etatValidation) {
        SousCompetence sousCompetence = sousCompetenceRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Sous-compétence non trouvée avec id: " + id));
        sousCompetence.setEtatValidation(etatValidation);
        SousCompetence updated = sousCompetenceRepo.save(sousCompetence);
        return sousCompetenceMapper.souscompeteneToDto(updated);
    }
}
