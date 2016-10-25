package ar.edu.um.programacion2.demo1.entidades;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.json.RooJson;
import org.springframework.roo.addon.tostring.RooToString;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.validation.constraints.NotNull;

@RooJavaBean
@RooToString
@RooJpaActiveRecord(finders = { "findCartasByPaloLike", "findCartasByNumeroIsNull" })
@RooJson
public class Carta {
    /**
     */
    @NotNull
    private String palo;

    /**
     */
    @NotNull
    private String numero;

    /**
     */
    @NotNull
    private String fondo;

    /**
     */
    private Long valor2;
    
    private int cod2() {
    	return 0;
    }
}
