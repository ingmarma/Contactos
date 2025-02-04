package marma.contactos.servicio;


import marma.contactos.modelo.contacto;
import marma.contactos.repositorio.ContactoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Contactoservicio implements IContactoServicio {

    @Autowired
   private ContactoRepositorio contactoRepositorio;


    @Override
    public List<contacto> listarContactos() {
        return contactoRepositorio.findAll();
    }

    @Override
    public contacto buscarContactoPorid(Integer idContacto) {
        contacto contacto = contactoRepositorio.findById(idContacto).orElse(null);
        return contacto;
    }

    @Override
    public void guardarcontcto(contacto contacto) {

    }

    @Override
    public void guardarContacto(contacto contacto) {
        contactoRepositorio.save(contacto);
    }

    @Override
    public void eliminarContacto(contacto contacto) {
        contactoRepositorio.delete(contacto);
    }
}
