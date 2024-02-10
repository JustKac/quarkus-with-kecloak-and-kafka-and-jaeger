package br.com.study.quarkusmineradora.repository;

import br.com.study.quarkusmineradora.entity.Quotation;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class QuotationRepository implements PanacheRepository<Quotation> {
}
