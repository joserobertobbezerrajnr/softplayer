package br.com.cadpessoa.api.resource;

import br.com.cadpessoa.api.exceptionhandler.ValidaErro;
import br.com.cadpessoa.api.model.Pessoa;
import br.com.cadpessoa.api.service.PessoaService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static java.util.Objects.isNull;

@RestController
@RequestMapping("/pessoas")
public class PessoaResource {

    @Autowired
    private PessoaService pessoaService;

    @Autowired
    private ValidaErro validaErro;

    @GetMapping
    public ResponseEntity<?> listarPessoas(){
        List<Pessoa> pessoas = pessoaService.findAll();
        return pessoas.isEmpty() ? ResponseEntity.notFound().build() : ResponseEntity.ok(pessoas);
    }

    @PostMapping
    public ResponseEntity<Pessoa> savePessoa(@Valid @RequestBody Pessoa pessoa){
        validacoes(pessoa);

        Pessoa pessoaSalva = pessoaService.save(pessoa);

        return ResponseEntity.ok(pessoaSalva);
    }

    @GetMapping("/{idpessoa}")
    public ResponseEntity<Pessoa> findIdPessoa(@PathVariable Long idpessoa){
        Pessoa pessoaFind = pessoaService.findOne(idpessoa);

        return isNull(pessoaFind) ? ResponseEntity.notFound().build() : ResponseEntity.ok(pessoaFind);
    }

    @PutMapping("/{idpessoa}")
    public ResponseEntity<Pessoa> refreshPessoa(@PathVariable Long idpessoa, @Valid @RequestBody Pessoa pessoa){
        validacoes(pessoa);

        Pessoa pessoaSalva = pessoaService.findOne(idpessoa);
        BeanUtils.copyProperties(pessoa, pessoaSalva, "idpessoa");
        return ResponseEntity.ok(pessoaService.save(pessoaSalva));
    }

    @DeleteMapping("/{idpessoa}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePessoa(@PathVariable Long idpessoa){
        pessoaService.delete(idpessoa);
    }

    public void validacoes(Pessoa pessoa){
        if (pessoaService.cpfExists(pessoa)){
            validaErro.addErro("cpf.duplicado", "CPF já existe no banco de dados.");
        }

        validaErro.trataErros();
    }

}
