package med.voll.api.paciente;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import med.voll.api.endereco.EnderecoDTO;

public record PacienteDTO(@NotBlank String nome, @NotBlank String email,
                          @NotBlank String telefone, @NotBlank String cpf,
                          @Valid EnderecoDTO endereco) {
}
