package marma.contactos.repositorio;

import marma.contactos.modelo.contacto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactoRepositorio extends JpaRepository<contacto, Integer> {
}
