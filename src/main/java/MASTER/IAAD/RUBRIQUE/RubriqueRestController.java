package MASTER.IAAD.RUBRIQUE;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
class RubriqueRestController{
    @Autowired
    private RubriqueRepository rubriqueRepository;

    @GetMapping(path ="/rubriques")
    public List<Rubrique> list(){
        return rubriqueRepository.findAll();
    }
    @GetMapping(path = "/rubriques/{id}")
    public Rubrique getOne(@PathVariable Long id){
        return rubriqueRepository.findById(id).get();
    }
    @PostMapping(path="/rubriques")
    public Rubrique save(@RequestBody Rubrique rubrique){
        return rubriqueRepository.save(rubrique);
    }
    @PutMapping (path="/rubriques/{id}")
    public Rubrique update(@RequestBody Rubrique rubrique,@PathVariable Long id){
        rubrique.setId(id);
        return rubriqueRepository.save(rubrique);
    }
    @DeleteMapping(path="/rubriques/{id}")
    public void delete(@PathVariable Long id){
        rubriqueRepository.deleteById(id);
    }
}
