package br.com.cadpessoa.api.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "pessoa")
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idpessoa;

    @NotBlank(message = "O campo nome é de preenchimento obrigatório")
    @Size(max = 80)
    private String nome;

    @Enumerated(EnumType.STRING)
    private SexoEnum sexo;

    @Email(message = "O endereço de email informado é inválido")
    @Size(max = 80)
    private String email;

    @NotNull(message = "O campo data de nascimento é de preenchimento obrigatório")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dtnascimento;

    @Size(max = 40)
    private String naturalidade;

    @Size(max = 40)
    private String nacionalidade;

    @CPF(message = "CPF informado é inválido!")
    private String cpf;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime dtcadastro;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime dtatualizacao;

    @PrePersist
    private void prePersist(){
        setDtcadastro(LocalDateTime.now());
    }

    @PreUpdate
    private void preUpdate(){
        setDtatualizacao(LocalDateTime.now());
    }
}
