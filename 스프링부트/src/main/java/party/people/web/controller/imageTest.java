package party.people.web.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import party.people.domain.Place;
import party.people.repository.place.PlaceInterface;

import java.util.List;

@Controller
@RequiredArgsConstructor
@Slf4j
public class imageTest {

    private final PlaceInterface placeInterface;


    @GetMapping("/test")
    public String imageTest(){
        return "home";
    }

    @PostMapping("/test")
    public String imageTestyo(Model model){
        List<Place>all =  placeInterface.findAll();
        model.addAttribute("searchResult",all);
        return "home";
    }
}
