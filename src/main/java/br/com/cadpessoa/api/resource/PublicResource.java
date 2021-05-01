package br.com.cadpessoa.api.resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/source")
public class PublicResource {

    @GetMapping
    public Map<String, String> getSource(){
        Map<String, String> resultado = new HashMap<>();
        resultado.put("API","https://github.com/diegocossa/cadpessoa-api.git");
        resultado.put("UI","https://github.com/diegocossa/cadpessoa-ui.git");

        return resultado;
    }
}
