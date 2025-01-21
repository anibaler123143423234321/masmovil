package api.codesoft.com.masmovil.repository;

import api.codesoft.com.masmovil.model.Lead;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeadRepository extends JpaRepository<Lead, Long> {
}
