package ma.enaa.competenceetsoucompetence.Controller;

import ma.enaa.competenceetsoucompetence.DTO.SousCompetenceDto;
import ma.enaa.competenceetsoucompetence.Services.Sous_CompetenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/soucompetence")
public class Sous_CompetenceController {

    @Autowired
    private final Sous_CompetenceService sousCompetenceService;

    public Sous_CompetenceController(Sous_CompetenceService sousCompetenceService) {
        this.sousCompetenceService = sousCompetenceService;
    }

    @PostMapping("/add")
    public SousCompetenceDto AddSousCompetence(@RequestBody SousCompetenceDto sous_competenceDto) {
        return sousCompetenceService.AjouterSousCompetence(sous_competenceDto);
    }

    @GetMapping("/list")
    public List<SousCompetenceDto> getAll(){
        return sousCompetenceService.ListSousCompetence();
    }

    @PutMapping("/updat/{id}")
    public SousCompetenceDto updatSousCompetence(@PathVariable Long id , @RequestBody SousCompetenceDto sousCompetenceDto){
        return sousCompetenceService.modifier(id,sousCompetenceDto);
    }

    @DeleteMapping("/{id}")
    public void delet(@PathVariable Long id){
        sousCompetenceService.supprimerSousCompetence(id);
    }

    @PatchMapping("/{id}/{etatValidation}")
    public ResponseEntity<SousCompetenceDto> updateEtatValidation(
            @PathVariable Long id,
            @PathVariable boolean etatValidation) {
        SousCompetenceDto updatedDto = sousCompetenceService.updateEtatValidation(id, etatValidation);
        return ResponseEntity.ok(updatedDto);
    }
}
