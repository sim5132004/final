package party.people.web.controller.category;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import party.people.domain.Place;
import party.people.repository.place.PlaceInterface;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
@Slf4j
public class CategoryController {

    private final PlaceInterface placeInterface;

    @GetMapping("place")
    public String goPlace(Model model){
        /* side lnb 출력용 */
        model.addAttribute("category","place");

        return "place/place_thymeleaf";
    }

    @GetMapping("category")
    public String goCategory(Model model){
        /* side lnb 출력용 */
       // model.addAttribute("category","place");
        return "category/category";
    }

    @GetMapping("analysis")
    public String goAnalysis(Model model){
        /* side lnb 출력용 */
        // model.addAttribute("category","place");
        return "analysis/analysis";
    }

    @GetMapping("invite")
    public String goInvite(Model model){

        Place place1 = placeInterface.idSearch(1L);
        Place place2 = placeInterface.idSearch(2L);
        Place place3 = placeInterface.idSearch(3L);
        List<Place> placeList = new ArrayList<>();
        placeList.add(place1);
        placeList.add(place2);
        placeList.add(place3);
//        placeList=placeInterface.findAll();



        log.info("goInvite] "+placeList);

        /* side lnb 출력용 */
        model.addAttribute("category","invite_A");
        model.addAttribute("category2",placeList);
        return "invite/invite_A";
    }

//    @GetMapping("category")
//    public String goCategory(Model model){
//
//        return "category/category";
//    }

}
