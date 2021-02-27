package dio.tutorials.springwebmvc.controller;

import dio.tutorials.springwebmvc.model.Jedi;
import dio.tutorials.springwebmvc.repository.JediRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller // diz ao spring que essa classe faz parte do sistema MVC e atua como 'controller'
public class JediController {

    @Autowired //dependece injection(cria uma instancia de JediRepository e injeta essa instancia na classe JediController)
    private JediRepository repository;

    @GetMapping("/jedi")// executa o metodo a seguir sempre que o usuario faz uma requisição em 'jedi'
    public ModelAndView jedi(){

        final ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("jedi");

        modelAndView.addObject("allJedi", repository.getAllJedi());
        return modelAndView;
    }

    @GetMapping("/new-jedi")
    public ModelAndView newJedi(){
        final ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("new-jedi");

        modelAndView.addObject("jedi", new Jedi());
        return modelAndView;
    }

    @PostMapping("/jedi")
    public String createJedi(@Valid @ModelAttribute Jedi jedi, BindingResult result, RedirectAttributes redirectAttributes){
        if(result.hasErrors()){
            return "new-jedi";
        }

        System.out.println(result);
        repository.add(jedi);

        redirectAttributes.addFlashAttribute("message", "Jedi cadastrado com sucesso");

        return "redirect:jedi";
    }

}
