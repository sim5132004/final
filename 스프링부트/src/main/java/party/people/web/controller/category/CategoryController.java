package party.people.web.controller.category;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CategoryController {

    @GetMapping("place")
    public String goPlace(Model model){
        model.addAttribute("category","place");
        return "place/place_ck";
    }


    @GetMapping("invite")
    public String goInvite(Model model){
        model.addAttribute("category","invite");
        return "invite/invite_ck";
    }


}
