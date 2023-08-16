package party.people.web.controller.place;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import party.people.domain.Place;
import party.people.repository.place.PlaceInterface;

import java.util.List;

@Controller
@RequiredArgsConstructor
@Slf4j
public class PlaceController {
    private final PlaceInterface placeInterface;

    @GetMapping("place")
    public String placeForm(Model model){
        List<Place> findAll = placeInterface.findAll();
        List<Place> findCategory = placeInterface.findByCategory("레저");
        List<Place> findTitle = placeInterface.findByTitle("강화도");
        log.info("placeForm] "+findTitle);


        return "place/placeTest";
    }

}
