package br.com.study.proposal.repository;

import java.util.Optional;

import br.com.study.proposal.entity.Proposal;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ProposalRepository implements PanacheRepository<Proposal> {

    public Optional<Proposal> findByCustomer(String customer) {
        return Optional.of(find("customer", customer).firstResult());
    }
}
