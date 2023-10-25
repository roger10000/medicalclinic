package med.voll.api.medico;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import med.voll.api.endereco.EnderecoDTO;

public record DadosMedicoDTO(@NotNull Long id,
                             String nome,
                             String telefone,
                             @Valid EnderecoDTO endereco) {

}
