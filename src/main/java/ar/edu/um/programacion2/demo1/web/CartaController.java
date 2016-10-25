package ar.edu.um.programacion2.demo1.web;
import ar.edu.um.programacion2.demo1.entidades.Carta;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.roo.addon.web.mvc.controller.json.RooWebJson;
import org.springframework.roo.addon.web.mvc.controller.finder.RooWebFinder;

@RequestMapping("/cartas")
@Controller
@RooWebScaffold(path = "cartas", formBackingObject = Carta.class)
@RooWebJson(jsonObject = Carta.class)
@RooWebFinder
public class CartaController {
}
