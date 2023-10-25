package med.voll.api.medico;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.endereco.Endereco;
import med.voll.api.enumeration.Especialidade;

@Table(name = "medicos")
@Entity(name = "Medico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Medico {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String email;

    private String telefone;

    private String crm;

    private Boolean ativo;

    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;

    @Embedded
    private Endereco endereco;

    public Medico(MedicoDTO medicoDTO) {
        this.ativo = true;
        this.nome = medicoDTO.nome();
        this.email = medicoDTO.email();
        this.crm = medicoDTO.crm();
        this.especialidade = medicoDTO.especialidade();
        this.endereco = new Endereco(medicoDTO.endereco());
        this.telefone = medicoDTO.telefone();
    }

    public void atualizarInformacoes(DadosMedicoDTO dadosMedicoDTO) {

        if(dadosMedicoDTO.nome() != null && !dadosMedicoDTO.nome().isBlank()) {
            this.nome = dadosMedicoDTO.nome();
        }

        if(dadosMedicoDTO.telefone() != null && !dadosMedicoDTO.telefone().isBlank()) {
            this.telefone = dadosMedicoDTO.telefone();
        }

        if(dadosMedicoDTO.endereco() != null) {
            this.endereco.atualizaInformacoes(dadosMedicoDTO.endereco());
        }

    }

    public void setAtivo(Boolean ativo){
        this.ativo = ativo;
    }
}
