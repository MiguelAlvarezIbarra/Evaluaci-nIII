package mx.utng.MAAI.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.validation.Valid;
import mx.utng.MAAI.model.entity.Evento;
import mx.utng.MAAI.model.service.IEventoService;

@Controller
@SessionAttributes("evento")
public class EventoController {
    @Autowired
    private IEventoService service;

    @GetMapping({"/evento", "/evento/", "/evento/list"})
    public String list(Model model){
        model.addAttribute("title", "Listado de Eventos");
        model.addAttribute("eventos", service.list());
        return "evento-list";
    }

    @GetMapping("/evento/form")
    public String create(Model model){
        model.addAttribute("title", "Formulario de Eventos");
        model.addAttribute("evento", new Evento());
        return "evento-form";
    }

    @PostMapping("/evento/form")
    public String save(@Valid Evento evento, BindingResult br, Model model){
        if(br.hasErrors()){
            model.addAttribute("title", "Formulario de Eventos");
            return "evento-form";
        }
        service.save(evento);
        return "redirect:/evento/list";
    }

    @GetMapping("/evento/form/{id}")
    public String update(@PathVariable Long id, Model model){
        Evento evento = null;
        if(id>0){
            evento = service.getById(id);
        }else{
            return "redirect:/evento/list";
        }
        model.addAttribute("title", "Editar Evento");
        model.addAttribute("evento", evento);
        return "evento-form";
    }

    @GetMapping("/evento/delete/{id}")
    public String delete(@PathVariable Long id, Model model){
        if(id > 0){
            service.delete(id);
        }
        return "redirect:/evento/list";
    }

}
