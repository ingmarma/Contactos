package marma.contactos.servicio;

import marma.contactos.modelo.contacto;

import java.util.List;

public interface IContactoServicio {
    public List<contacto> listarContactos();

    public contacto buscarContactoPorid(Integer idContato);

    public void guardarcontcto(contacto contacto);

    void guardarContacto(contacto contacto);

    public void eliminarContacto(contacto contacto);
}
