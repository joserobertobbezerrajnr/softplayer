package br.com.cadpessoa.api.service;

import br.com.cadpessoa.api.model.Pessoa;
import br.com.cadpessoa.api.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.Objects.isNull;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    public List<Pessoa> findAll(){
        return pessoaRepository.findAllByOrderByDtcadastro();
    }

    public Pessoa findOne(Long idpessoa){
        return pessoaRepository.findOne(idpessoa);
    }

    public Pessoa save(Pessoa pessoa){
        return pessoaRepository.save(pessoa);
    }

    public void delete(Long idpessoa){
        pessoaRepository.delete(idpessoa);
    }

    public boolean cpfExists(Pessoa pessoa) {
        if (isNull(pessoa.getIdpessoa())){
            if (isNull(pessoaRepository.findByCpf(pessoa.getCpf()))){
                return false;
            }
        } else {
            Pessoa pessoaCadastro = pessoaRepository.findByCpf(pessoa.getCpf());
            if (isNull(pessoaCadastro)){
                return false;
            } else {
                if (pessoaCadastro.getIdpessoa() == pessoa.getIdpessoa()){
                    return false;
                }
            }
        }

        return true;
    }
}
