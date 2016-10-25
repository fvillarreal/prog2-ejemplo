package ar.edu.um.programacion2.demo1.web;
import ar.edu.um.programacion2.demo1.domain.Role;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/roles")
@Controller
@RooWebScaffold(path = "roles", formBackingObject = Role.class)
public class RoleController {
}
