package br.com.study.quarkusmineradora.client;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import br.com.study.quarkusmineradora.dto.CurrencyPriceDTO;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

@Path(value = "/last")
@RegisterRestClient
@ApplicationScoped
public interface CurrencyPriceClient {

    @GET
    @Path("/{pair}")
    CurrencyPriceDTO getPriceByPair(@PathParam("pair") String pair);
}
