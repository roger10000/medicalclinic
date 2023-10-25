package med.voll.api.paciente;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.endereco.Endereco;

@Table(name = "pacientes")
@Entity(name = "Paciente")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Paciente {

    @Embedded
    Endereco endereco;
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private String cpf;
    private Boolean ativo;

    public Paciente(PacienteDTO pacienteDTO) {
        this.nome = pacienteDTO.nome();
        this.email = pacienteDTO.email();
        this.cpf = pacienteDTO.cpf();
        this.telefone = pacienteDTO.telefone();
        this.endereco = new Endereco(pacienteDTO.endereco());
    }

    public void atualizarInformacoes(DadosPacienteDTO dadosPacienteDTO) {
        if(dadosPacienteDTO.nome()!=null && !dadosPacienteDTO.nome().isBlank()){
            this.nome = dadosPacienteDTO.nome();
        }
        if(dadosPacienteDTO.telefone()!=null && !dadosPacienteDTO.telefone().isBlank()){
           this.telefone = dadosPacienteDTO.telefone();
        }
        if(dadosPacienteDTO.endereco()!=null){
           this.endereco = new Endereco(dadosPacienteDTO.endereco());
        }
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

}
