package ma.enaa.competenceetsoucompetence.Controller;

import ma.enaa.competenceetsoucompetence.DTO.CompetenceDto;
import ma.enaa.competenceetsoucompetence.Models.Competence;
import ma.enaa.competenceetsoucompetence.Services.CompetenceServices;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Competence")
@CrossOrigin(origins = "*")
public class CompetenceController {
    private final CompetenceServices competenceServices;

    public CompetenceController(CompetenceServices competenceServices) {
        this.competenceServices = competenceServices;
    }
    @PostMapping
    public CompetenceDto AddCompetence(@RequestBody CompetenceDto competenceDto){
        return competenceServices.Ajouter(competenceDto);
    }

    @GetMapping
    public List<Competence> AfficherCompetence(){
        return competenceServices.ListCompetence();
    }

    @GetMapping("{id}")
    public CompetenceDto AfficherParid(@PathVariable Long id){
        return competenceServices.AfficherParId(id);
    }

    @PutMapping("{id}")
    public CompetenceDto ModifierCompetence(@PathVariable Long id , @RequestBody CompetenceDto competenceDto){
        return competenceServices.Modifier(id,competenceDto);
    }

    @DeleteMapping("{id}")
    public  void SupprimerCompetence(@PathVariable Long id){
        competenceServices.Supprimer(id);
    }
}
