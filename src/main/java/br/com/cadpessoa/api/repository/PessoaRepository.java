package br.com.cadpessoa.api.repository;

import br.com.cadpessoa.api.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

    public Pessoa findByCpf(String cpf);

    public List<Pessoa> findAllByOrderByDtcadastro();
}
