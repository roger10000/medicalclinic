package med.voll.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.paciente.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("pacientes")
public class PacienteController {

    @Autowired
    PacienteRepository repository;

    @PostMapping()
    public void cadastrar(@RequestBody @Valid PacienteDTO pacienteDTO) {
        repository.save(new Paciente(pacienteDTO));
    }

    @GetMapping()
    public Page<DadosListagemPacienteDTO> listar(@PageableDefault(size = 500000000,sort = {"nome"}) Pageable pageble){
        return repository.findAll(pageble).map(DadosListagemPacienteDTO::new);
    }

    @PutMapping()
    @Transactional
    public void atualizar(@RequestBody @Valid DadosPacienteDTO dadosPacienteDTO){
        Paciente paciente = repository.getReferenceById(dadosPacienteDTO.id());
        paciente.atualizarInformacoes(dadosPacienteDTO);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void delete(@PathVariable Long id){
        repository.deleteById(id);
    }

    @DeleteMapping("/exclusaologica/{id}")
    @Transactional
    public void exclusaoLogica(@PathVariable Long id){

        Paciente paciente = repository.getReferenceById(id);
        paciente.setAtivo(false);
    }


}
