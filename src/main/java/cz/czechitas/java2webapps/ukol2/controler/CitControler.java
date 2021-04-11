package cz.czechitas.java2webapps.ukol2.controler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.Random;
import java.util.List;


@Controller
public class CitControler {

    private final Random random;

    public CitControler(){
        random = new Random();
    }
    @GetMapping("/")
    public ModelAndView vyberCit() {
        int nahodneCislo = random.nextInt(6)+1;
        List<String> seznamTextu= Arrays.asList("Debugging /de·bugh·ing/ (verb): The Classic Mystery Game where you are the detective, the victim, and the murderer."
                ,"A user interface is like a joke. If you have to explain it, it's not that good.",
                "To replace programmers with robots, clients will have to accurately describe what they want. We're safe.",
                "I have a joke on programming but it only works on my computer.",
                "Programmer (noun.): A machine that turns coffee into code.",
                "Real programmers count from 0.");
        ModelAndView result = new ModelAndView("t");
        String nahodnyCitat = seznamTextu.get(nahodneCislo-1);
        result.addObject("citat",nahodnyCitat);
        result.addObject("obrazek",String.format("/images/obr-%d.jpg", nahodneCislo));
        String cesta = String.format("/images/obr-%d.jpg", nahodneCislo);
        String mujBodyStyle = "background-image: url("+cesta+");";
        result.addObject("bodyStyle",mujBodyStyle);

        return result;

    }

}
