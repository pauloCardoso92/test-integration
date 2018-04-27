package br.teste.app.servico;

import java.util.Arrays;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.teste.app.model.Carro;

@Path("carro")
@Produces(MediaType.APPLICATION_JSON)
public class CarroServico {

    @GET
    @Path("/{id}")
    public Carro getCarroPor(@PathParam("id") Long id) {
        System.out.println("Carrooo");
        return new Carro(id, "KIA Cadenza");
    }
    
    @GET
    public List<Carro> getsCarro() {
        return Arrays.asList(new Carro(1L, "KIA Cadenza"), new Carro(2L, "Honda city"));
    }
    
    @GET
    @Path("/teste")
    public void getsCarroaa() {
        Arrays.asList(new Carro(1L, "KIA Cadenza"), new Carro(2L, "Honda city"));
    }

}
