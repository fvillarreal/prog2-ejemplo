package ar.edu.um.programacion2.demo1.entidades;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.OneToMany;

@RooJavaBean
@RooToString
@RooJpaActiveRecord
public class Mazo {

    /**
     */
    @NotNull
    private String nombre;

    /**
     */
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "mazo")
    private Set<Carta> cartas = new HashSet<Carta>();
}
