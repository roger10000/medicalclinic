package med.voll.api.endereco;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Endereco {

    private String logradouro;
    private String numero;
    private String complemento;
    private String bairro;
    private String cidade;
    private String uf;
    private String cep;

    public Endereco(EnderecoDTO endereco) {
        this.logradouro = endereco.logradouro();
        this.cep = endereco.cep();
        this.complemento = endereco.complemento();
        this.uf = endereco.uf();
        this.bairro = endereco.bairro();
        this.cidade = endereco.cidade();
        this.numero = endereco.numero();
    }

    public void atualizaInformacoes(EnderecoDTO endereco) {

        if(endereco.logradouro()!=null && !endereco.logradouro().isBlank()) {
            this.logradouro = endereco.logradouro();
        }
        if(endereco.cep()!=null && !endereco.cep().isBlank()) {
            this.cep = endereco.cep();
        }
        if(endereco.complemento()!=null && !endereco.complemento().isBlank()) {
            this.complemento = endereco.complemento();
        }
        if(endereco.uf()!=null && !endereco.uf().isBlank()) {
            this.uf = endereco.uf();
        }
        if(endereco.bairro()!=null && !endereco.bairro().isBlank()) {
            this.bairro = endereco.bairro();
        }
        if(endereco.cidade()!=null && !endereco.cidade().isBlank()) {
            this.cidade = endereco.cidade();
        }
        if(endereco.numero()!=null && !endereco.numero().isBlank()) {
            this.numero = endereco.numero();
        }
    }
}
