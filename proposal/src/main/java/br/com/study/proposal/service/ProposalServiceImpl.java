package br.com.study.quarkusproposal.service;

import java.time.LocalDateTime;

import br.com.study.quarkusproposal.dto.ProposalDTO;
import br.com.study.quarkusproposal.dto.ProposalDetailsDTO;
import br.com.study.quarkusproposal.entity.Proposal;
import br.com.study.quarkusproposal.message.KafkaEvent;
import br.com.study.quarkusproposal.repository.ProposalRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Named("proposal")
public class ProposalServiceImpl implements ProposalService {

    @Inject
    ProposalRepository proposalRepository;

    @Inject
    KafkaEvent kafkaEvent;

    @Override
    public ProposalDetailsDTO findFullProposal(long id) {
        Proposal proposal = proposalRepository.findById(id);
        return new ProposalDetailsDTO()
                .setProposalId(proposal.getId())
                .setCountry(proposal.getCountry())
                .setCustomer(proposal.getCustomer())
                .setPriceTonne(proposal.getPriceTonne())
                .setTonnes(proposal.getTonnes())
                .setProposalValidityDays(proposal.getProposalValidityDays());
    }

    @Override
    @Transactional
    public void createNewProposal(ProposalDetailsDTO proposalDetailsDTO) {

        ProposalDTO proposalDTO = buildAndSaveNewProposal(proposalDetailsDTO);
        kafkaEvent.sendNewKafkaEvent(proposalDTO);
    }

    @Override
    @Transactional
    public void removeProposal(long id) {
        proposalRepository.deleteById(id);
    }

    private ProposalDTO buildAndSaveNewProposal(ProposalDetailsDTO proposalDetailsDTO) {
        try {
            proposalRepository.persist(new Proposal()
                    .setCustomer(proposalDetailsDTO.getCustomer())
                    .setCountry(proposalDetailsDTO.getCountry())
                    .setPriceTonne(proposalDetailsDTO.getPriceTonne())
                    .setTonnes(proposalDetailsDTO.getTonnes())
                    .setProposalValidityDays(proposalDetailsDTO.getProposalValidityDays())
                    .setCreatedAt(LocalDateTime.now()));

            return new ProposalDTO()
                    .setProposalId(proposalRepository.findByCustomer(proposalDetailsDTO.getCustomer()).get().getId())
                    .setCustomer(proposalDetailsDTO.getCustomer())
                    .setPriceTonne(proposalDetailsDTO.getPriceTonne());
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }
}
