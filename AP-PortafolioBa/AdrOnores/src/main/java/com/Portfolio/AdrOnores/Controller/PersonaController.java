package com.Portfolio.AdrOnores.Controller;

import com.Portfolio.AdrOnores.Entity.Persona;
import com.Portfolio.AdrOnores.Interface.IPersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin(origins = {"https://portafolio-nicolasonores.web.app/","http://localhost:4200"})
public class PersonaController {
    @Autowired IPersonaService iPersonaService;
    
    
    @GetMapping("personas/traer")
    public List<Persona> getPersona(){
        return iPersonaService.getPersona();
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("personas/crear")
    public String createPersona(@RequestBody Persona persona){
        iPersonaService.savePersona(persona);
        return "Persona creada con exito";
    }
   
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("personas/borrar/{id}")
    public String deletePersona(@PathVariable long id){
        iPersonaService.deletePersona(id);
        return "Borrado exitoso";
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("personas/editar/{id}")
    public Persona editarPersona(@PathVariable long id,
            @RequestParam("nombre") String nuevoNombre,
            @RequestParam("apellido") String nuevoApellido,
            @RequestParam("img") String nuevoImg){
        Persona persona = iPersonaService.findPersona(id);
        persona.setNombre(nuevoNombre);
        persona.setApellido(nuevoApellido);
        persona.setImg(nuevoImg);
        iPersonaService.savePersona(persona);
        return persona;
    }
    
    @GetMapping("personas/traer/perfil")
    public Persona findPersona(){
        return iPersonaService.findPersona((long)1);
    }
}
