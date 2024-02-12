package br.com.study.proposal.service;

import br.com.study.proposal.dto.ProposalDetailsDTO;

public interface ProposalService {

    ProposalDetailsDTO findFullProposal(long id);

    void createNewProposal(ProposalDetailsDTO proposalDetailsDTO);

    void removeProposal(long id);
}
