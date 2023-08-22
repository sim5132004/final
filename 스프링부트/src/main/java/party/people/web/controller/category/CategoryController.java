package party.people.web.controller.category;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CategoryController {

    @GetMapping("place")
    public String goPlace(){
        return "place/place_CK";
    }


}
