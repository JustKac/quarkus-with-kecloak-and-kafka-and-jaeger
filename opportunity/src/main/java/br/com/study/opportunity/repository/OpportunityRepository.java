package br.com.study.opportunity.repository;

import br.com.study.opportunity.entity.Opportunity;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class OpportunityRepository implements PanacheRepository<Opportunity> {
}
