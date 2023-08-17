package party.people.web.controller.place;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import party.people.domain.Place;
import party.people.repository.place.PlaceInterface;

import java.util.*;

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

    @PostMapping("searchPlace")
    public String searchPlace(@RequestParam("searchForm") String searchForm, Model model){
        log.info("검색내용 "+ searchForm);
        List<String>splitSearch = Arrays.stream(searchForm.split(" ")).toList();
        List<Place>mergedResult = new ArrayList<>();
        for (String one : splitSearch){
            mergedResult.addAll(placeInterface.findByKeyword(one));
            log.info("포문으로 개수 확인 " +mergedResult.size());
        }
        log.info("검색 결과 개수 "+mergedResult.size());
        Set<Place> uniqueResult = new HashSet<>(mergedResult);
        List<Place> resultWithoutDuplicates = new ArrayList<>(uniqueResult);
        log.info("중복결과 제거 확인 " + resultWithoutDuplicates.size());
        model.addAttribute("searchResult", resultWithoutDuplicates);

        return "home";
    }

}
