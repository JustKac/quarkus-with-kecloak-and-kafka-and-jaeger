package br.com.study.quotation.repository;

import br.com.study.quotation.entity.Quotation;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class QuotationRepository implements PanacheRepository<Quotation> {
}
