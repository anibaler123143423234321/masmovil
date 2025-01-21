package api.codesoft.com.masmovil.service;

import api.codesoft.com.masmovil.model.Lead;
import api.codesoft.com.masmovil.repository.LeadRepository;
import org.springframework.stereotype.Service;

@Service
public class LeadService {

    private final LeadRepository leadRepository;

    public LeadService(LeadRepository leadRepository) {
        this.leadRepository = leadRepository;
    }

    public Lead saveLead(Lead lead) {
        return leadRepository.save(lead);
    }
}
