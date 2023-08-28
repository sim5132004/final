package party.people.web.controller.analysis;

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
public class analcontroller {

    @GetMapping("bup")
    public String analysis(Model model){

        return "analysis/bup";
    }
}