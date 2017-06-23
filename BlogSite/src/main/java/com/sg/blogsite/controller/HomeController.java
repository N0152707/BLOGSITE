
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping({"/home"})
public class HomeController {

    public HomeController() {
    }

    @RequestMapping(value = {"/", "BlogSite"}, method = RequestMethod.GET)
    public String displayHome(Model model) {
        return "BlogSite";
    }

    @RequestMapping(value = "/author-admin.jsp", method = RequestMethod.GET)
    public String displayAuthorAdmin(Model model) {
        return "BlogSite";
    }

    @RequestMapping(value = "/aboutUs.jsp", method = RequestMethod.GET)
    public String displayStatic() {
        return "BlogSite";
    }
}
