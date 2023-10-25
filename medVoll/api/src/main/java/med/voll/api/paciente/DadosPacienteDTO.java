package med.voll.api.paciente;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import med.voll.api.endereco.EnderecoDTO;

public record DadosPacienteDTO(@NotNull Long id,
                               @NotBlank String nome,
                               @NotBlank String telefone,
                               @Valid EnderecoDTO endereco) {
}
