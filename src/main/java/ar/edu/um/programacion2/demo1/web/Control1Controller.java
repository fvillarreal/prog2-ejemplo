package ar.edu.um.programacion2.demo1.web;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.TypedQuery;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import ar.edu.um.programacion2.demo1.entidades.Carta;
import ar.edu.um.programacion2.demo1.entidades.Mazo;
import ar.edu.um.programacion2.demo1.service.Venta;
import ar.edu.um.programacion2.demo1.service.VentaService;

@RequestMapping("/control1")
@Controller
public class Control1Controller {

	@Autowired
	Venta ventasService;
	
    @RequestMapping(method = RequestMethod.POST, value = "{id}")
    public void post(@PathVariable Long id, ModelMap modelMap, HttpServletRequest request, HttpServletResponse response) {
    }

    @RequestMapping(value="/")
    public String index() {
        return "control1/index";
    }
    
    @RequestMapping(value="/mazo/{mazoId}",method = RequestMethod.GET)
    public String mazos(@PathVariable Long mazoId) {
        Mazo mazo = Mazo.findMazo(mazoId);
        Carta carta1 = Carta.findCarta(7L);
    	return "control1/index";
    }
    
    
    @RequestMapping(value="/pepe",method = RequestMethod.GET)
    public String pepeHonguito(Model uiModel) {
    	
    	TypedQuery<Carta> tq = Carta.findCartasByPaloLike("pepe");
    	List<Carta> todas = tq.getResultList();
    	
    	Carta c = new Carta();
    	c.setFondo("algo");
    	c.setNumero("3");
    	c.setPalo("copa");
    	uiModel.addAttribute("lacarta", c);
    	uiModel.addAttribute("texto", "este es el texto inyectado");
    	if(c.getNumero().equals("4")) {
    		return "control1/pepe2";
    	}
    	else {
    		return "control1/pepe";
    	}
    }
    
    @RequestMapping(value="/form",method = RequestMethod.GET)
    public String armameElFormulario() {
    	return "control1/form";
    }
    
    @RequestMapping(value="/agregarCarta",method = RequestMethod.POST)
    public String agregamosUnaCarta(@RequestParam("fondo") String elFondo, @RequestParam("numero") String elNumero,@RequestParam("palo") String elPalo, HttpServletRequest request, HttpServletResponse response, Model uiModel) {
    	Carta c = new Carta();
    	c.setFondo(elFondo);
    	c.setNumero(elNumero);
    	c.setPalo(elPalo);
    	c.persist();
    	return "redirect:../cartas?page=1&size=10";

    }
    
    @RequestMapping(value="/agregarCarta2",method = RequestMethod.POST)
    public String agregamosUnaCarta2(@Valid Carta carta, BindingResult bindingResult, HttpServletRequest request, HttpServletResponse response, Model uiModel) {

    	String resultado = ventasService.vende();
    	

    	return "redirect:../cartas?page=1&size=10";
    }
    @RequestMapping(value="/mostrar",method = RequestMethod.GET) 
    public String mostrar(Model uiModel) {
    	List<String> csss= new ArrayList<>();
    	List<String> javascripts= new ArrayList<>();
    	csss.add("estilo1.css");
    	javascripts.add("ejemplo1.js");
    	javascripts.add("ejemplo2.js");
    	
    	uiModel.addAttribute("CSSs", csss);
    	uiModel.addAttribute("JSs", javascripts);

    	
    	return "control1/form";
    }
 
    private void mostrar() {
    	
    }
    
    private void cod1() {
    	
    }
    
}
