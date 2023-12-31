package med.voll.api.medico;

import med.voll.api.enumeration.Especialidade;

public record DadosListagemMedicoDTO(Long id, String nome, String email, String crm, Especialidade especialidade, Boolean ativo) {

    public DadosListagemMedicoDTO(Medico medico){
        this(medico.getId(), medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getEspecialidade(), medico.getAtivo());
    }
}
