package ar.edu.um.programacion2.demo1.web;
import ar.edu.um.programacion2.demo1.entidades.Mazo;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/mazoes")
@Controller
@RooWebScaffold(path = "mazoes", formBackingObject = Mazo.class)
public class MazoController {
}
