package cz.czechitas.java2webapps.ukol2.controler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Random;

@Controller
public class CitControler {

    private final Random random;

    public CitControler(){
        random = new Random();
    }
    @GetMapping("/")
    public ModelAndView vyberCit() {
        int nahodneCislo = random.nextInt(6)+1;
        ModelAndView result = new ModelAndView("t");
        result.addObject("cislo",nahodneCislo);
        result.addObject("obrazek",String.format("/images/obr-%d.jpg", nahodneCislo));
        return result;

    }
}
