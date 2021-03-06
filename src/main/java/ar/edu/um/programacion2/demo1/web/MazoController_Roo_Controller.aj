// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package ar.edu.um.programacion2.demo1.web;

import ar.edu.um.programacion2.demo1.entidades.Carta;
import ar.edu.um.programacion2.demo1.entidades.Mazo;
import ar.edu.um.programacion2.demo1.web.MazoController;
import java.io.UnsupportedEncodingException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.UriUtils;
import org.springframework.web.util.WebUtils;

privileged aspect MazoController_Roo_Controller {
    
    @RequestMapping(method = RequestMethod.POST, produces = "text/html")
    public String MazoController.create(@Valid Mazo mazo, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            populateEditForm(uiModel, mazo);
            return "mazoes/create";
        }
        uiModel.asMap().clear();
        mazo.persist();
        return "redirect:/mazoes/" + encodeUrlPathSegment(mazo.getId().toString(), httpServletRequest);
    }
    
    @RequestMapping(params = "form", produces = "text/html")
    public String MazoController.createForm(Model uiModel) {
        populateEditForm(uiModel, new Mazo());
        return "mazoes/create";
    }
    
    @RequestMapping(value = "/{id}", produces = "text/html")
    public String MazoController.show(@PathVariable("id") Long id, Model uiModel) {
        uiModel.addAttribute("mazo", Mazo.findMazo(id));
        uiModel.addAttribute("itemId", id);
        return "mazoes/show";
    }
    
    @RequestMapping(produces = "text/html")
    public String MazoController.list(@RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, Model uiModel) {
        if (page != null || size != null) {
            int sizeNo = size == null ? 10 : size.intValue();
            final int firstResult = page == null ? 0 : (page.intValue() - 1) * sizeNo;
            uiModel.addAttribute("mazoes", Mazo.findMazoEntries(firstResult, sizeNo));
            float nrOfPages = (float) Mazo.countMazoes() / sizeNo;
            uiModel.addAttribute("maxPages", (int) ((nrOfPages > (int) nrOfPages || nrOfPages == 0.0) ? nrOfPages + 1 : nrOfPages));
        } else {
            uiModel.addAttribute("mazoes", Mazo.findAllMazoes());
        }
        return "mazoes/list";
    }
    
    @RequestMapping(method = RequestMethod.PUT, produces = "text/html")
    public String MazoController.update(@Valid Mazo mazo, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            populateEditForm(uiModel, mazo);
            return "mazoes/update";
        }
        uiModel.asMap().clear();
        mazo.merge();
        return "redirect:/mazoes/" + encodeUrlPathSegment(mazo.getId().toString(), httpServletRequest);
    }
    
    @RequestMapping(value = "/{id}", params = "form", produces = "text/html")
    public String MazoController.updateForm(@PathVariable("id") Long id, Model uiModel) {
        populateEditForm(uiModel, Mazo.findMazo(id));
        return "mazoes/update";
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "text/html")
    public String MazoController.delete(@PathVariable("id") Long id, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, Model uiModel) {
        Mazo mazo = Mazo.findMazo(id);
        mazo.remove();
        uiModel.asMap().clear();
        uiModel.addAttribute("page", (page == null) ? "1" : page.toString());
        uiModel.addAttribute("size", (size == null) ? "10" : size.toString());
        return "redirect:/mazoes";
    }
    
    void MazoController.populateEditForm(Model uiModel, Mazo mazo) {
        uiModel.addAttribute("mazo", mazo);
        uiModel.addAttribute("cartas", Carta.findAllCartas());
    }
    
    String MazoController.encodeUrlPathSegment(String pathSegment, HttpServletRequest httpServletRequest) {
        String enc = httpServletRequest.getCharacterEncoding();
        if (enc == null) {
            enc = WebUtils.DEFAULT_CHARACTER_ENCODING;
        }
        try {
            pathSegment = UriUtils.encodePathSegment(pathSegment, enc);
        } catch (UnsupportedEncodingException uee) {}
        return pathSegment;
    }
    
}
