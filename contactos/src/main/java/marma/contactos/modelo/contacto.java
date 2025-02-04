package marma.contactos.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class contacto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer idContacto;

    public String nombre;

    public String telefono;

    public String email;

    public void setIdContacto(int idContacto) {
        this.idContacto = idContacto;
    }
    public Integer getIdContacto() {
        return this.idContacto;
    }
    public String getnombre() {
        return this.nombre;
    }
    public String gettelefono() {
        return this.telefono;
    }
    public String getemail() {
        return this.email;
    }
}
