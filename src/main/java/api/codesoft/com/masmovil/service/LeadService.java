package api.codesoft.com.masmovil.service;

import api.codesoft.com.masmovil.model.Lead;
import api.codesoft.com.masmovil.repository.LeadRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class LeadService {


    private final LeadRepository leadRepository;

    public LeadService(LeadRepository leadRepository) {
        this.leadRepository = leadRepository;
    }

    public Lead saveLead(Lead lead) {
        lead.setFechaCreacion(LocalDateTime.now());
        return leadRepository.save(lead);
    }

    public List<Lead> findAllLeads() {
        return leadRepository.findAll();
    }


}
