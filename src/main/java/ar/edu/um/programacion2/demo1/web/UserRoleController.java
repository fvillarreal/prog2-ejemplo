package ar.edu.um.programacion2.demo1.web;
import ar.edu.um.programacion2.demo1.domain.UserRole;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.roo.addon.web.mvc.controller.finder.RooWebFinder;

@RequestMapping("/userroles")
@Controller
@RooWebScaffold(path = "userroles", formBackingObject = UserRole.class)
@RooWebFinder
public class UserRoleController {
}
