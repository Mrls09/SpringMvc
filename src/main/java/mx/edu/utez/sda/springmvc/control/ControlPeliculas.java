package mx.edu.utez.sda.springmvc.control;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/peliculas")
public class ControlPeliculas {
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    @Secured("ROLE_RECE")
    public String index(){
        return "peliculas";
    }
    @RequestMapping(value = "/adulto", method = RequestMethod.GET)
    @Secured("ROLE_ADUL")
    public String indexAdulto(){
        return "peliculas";
    }
    @RequestMapping(value = "/niño", method = RequestMethod.GET)
    @Secured({"ROLE_NI","ROLE_ADUL"})
    public String indexNiñp(){
        return "peliculasNiños";
    }
    @RequestMapping(value = "/terror", method = RequestMethod.GET)
    @Secured("ROLE_ADUL")
    public String indexTerror(){
        return "terror";
    }
    @RequestMapping(value = "/caricaturas", method = RequestMethod.GET)
    @Secured({"ROLE_ADUL","ROLE_NI"})
    public String indexCaticaturas(){
        return "caricaturas";
    }
    @RequestMapping(value = "/nickelodeo", method = RequestMethod.GET)
    @Secured({"ROLE_ADUL","ROLE_NI"})
    public String indexNickelodeo(){
        return "nickelodeo";
    }
    @RequestMapping(value = "/accion", method = RequestMethod.GET)
    @Secured("ROLE_ADUL")
    public String indexAccion(){
        return "accion";
    }

}
