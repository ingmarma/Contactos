package marma.contactos.controlador;

import marma.contactos.ContactosApplication;
import marma.contactos.modelo.contacto;
import marma.contactos.servicio.Contactoservicio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ContactoControlador {

    private static final Logger logger =
            LoggerFactory.getLogger(ContactoControlador.class);

    @Autowired
    Contactoservicio contactoservicio;

    @GetMapping("/")
    public String iniciar(ModelMap modelo){
        List<contacto> contactos = contactoservicio.listarContactos();
        contactos.forEach((contacto) ->logger.info(contacto.toString()));
        modelo.put("contactos", contactos);
        return"index"; //index.html
    }

    @GetMapping("/agregar")
    public String mostrarAgregar(){
        return "agregar";//agregar.html
    }

    @PostMapping("/agregar")
    public String agregar(@ModelAttribute("contactoForma") contacto contacto){
        logger.info("Contacto a agregar: " + contacto);
        contactoservicio.guardarContacto(contacto);
        return "redirect:/"; //redirigimos al controlador path "/"
    }

    @GetMapping("/editar/{id}")
    public String mostrarEditar(@PathVariable(value="id") int idContacto, ModelMap modelo){
        contacto contacto = contactoservicio.buscarContactoPorid(idContacto);
        logger.info("Contacto a editar (mostrar): " + contacto);
        modelo.put("contacto", contacto);
        return "editar"; //editar.html
    }

    @PostMapping("/editar")
    public String editar(@ModelAttribute("contacto")contacto contacto){
      logger.info("Contacto a guardar (editar): " + contacto);
      contactoservicio.guardarContacto(contacto);
      return "redirect:/"; //redirigimos al controlador path "/"
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable(value= "id") int idContacto){
        contacto contacto = new contacto();
        contacto.setIdContacto(idContacto);
        contactoservicio.eliminarContacto(contacto);
        return "redirect:/"; //redirigimos al path de inicio "/"

    }
}
