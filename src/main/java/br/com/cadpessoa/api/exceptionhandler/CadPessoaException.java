package br.com.cadpessoa.api.exceptionhandler;

import java.util.List;

public class CadPessoaException extends RuntimeException{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ValidaErro validaErro;

    public CadPessoaException(ValidaErro validaErro) {
        this.validaErro = validaErro;
    }

    public List<Erro> getValidaErro() {
        return validaErro.getErros();
    }

    public void limparErros(){
        validaErro.limparErros();
    }
}
