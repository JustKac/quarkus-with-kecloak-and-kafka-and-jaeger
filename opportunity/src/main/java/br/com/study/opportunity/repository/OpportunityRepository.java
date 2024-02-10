package br.com.study.repository;

import br.com.study.entity.Opportunity;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class OpportunityRepository implements PanacheRepository<Opportunity> {
}
