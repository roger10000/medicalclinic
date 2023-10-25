package med.voll.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.medico.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository repository;

    @PostMapping()
    @Transactional
    public void cadastrar(@RequestBody @Valid MedicoDTO medicoDTO) {

        repository.save(new Medico(medicoDTO));
        System.out.println(medicoDTO);
    }

    @GetMapping()
    public Page<DadosListagemMedicoDTO> listar(@PageableDefault(size=5000000, sort = {"nome"}) Pageable pageble) {
        //return repository.findAll(pageble).map(DadosListagemMedicoDTO::new);
        return repository.findAllByAtivoTrue(pageble).map(DadosListagemMedicoDTO::new);
    }

    @PutMapping()
    @Transactional
    public void atualizar(@RequestBody @Valid DadosMedicoDTO dadosMedicoDTO) {
        Medico medico = repository.getReferenceById(dadosMedicoDTO.id());
        medico.atualizarInformacoes(dadosMedicoDTO);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }

    @DeleteMapping("/exclusaologica/{id}")
    @Transactional
    public void exclusaoLogica(@PathVariable Long id) {
        Medico medico = repository.getReferenceById(id);
        medico.setAtivo(false);
    }

}
