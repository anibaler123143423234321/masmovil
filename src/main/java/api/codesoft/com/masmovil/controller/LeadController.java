package api.codesoft.com.masmovil.controller;

import api.codesoft.com.masmovil.model.Lead;
import api.codesoft.com.masmovil.service.LeadService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = {
        "https://fibramoviltotal.es",
        "https://fibramoviltotal.com",
        "http://localhost:4321"
})
@RequestMapping("/api/main/lead")
public class LeadController {

    private final LeadService leadService;
    private static final String STATIC_TOKEN = "Dagn3rChuman!K3y$ecureP@ssw0rd2025!";

    public LeadController(LeadService leadService) {
        this.leadService = leadService;
    }

    // Endpoint para crear un nuevo lead
    @PostMapping("/create")
    public ResponseEntity<Map<String, String>> createLead(@RequestBody Lead lead) {
        Map<String, String> response = new HashMap<>();
        try {
            // Guardar el lead (fechaCreacion se maneja en el servicio)
            Lead savedLead = leadService.saveLead(lead);

            // Crear una respuesta detallada
            response.put("status", "success");
            response.put("message", "Lead creado exitosamente");
            response.put("detail", "El lead fue guardado con ID: " + savedLead.getId());
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } catch (Exception e) {
            // Manejo de errores con un formato consistente
            response.put("status", "error");
            response.put("message", "Error al guardar el lead");
            response.put("detail", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    // Endpoint para obtener todos los leads
    @GetMapping("/all")
    public ResponseEntity<?> getAllLeads(@RequestParam(value = "Bearer", required = true) String token) {
        Map<String, Object> response = new HashMap<>();
        try {
            // Validar el token
            if (!STATIC_TOKEN.equals(token)) {
                response.put("status", "error");
                response.put("message", "Token de autenticación inválido");
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
            }

            // Obtener todos los leads
            List<Lead> leads = leadService.findAllLeads();
            response.put("status", "success");
            response.put("message", "Leads obtenidos exitosamente");
            response.put("data", leads);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            response.put("status", "error");
            response.put("message", "Error al obtener los leads");
            response.put("detail", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }
}
