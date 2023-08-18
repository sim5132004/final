package party.people.web.controller.place;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import party.people.domain.Page;
import party.people.domain.Place;
import party.people.repository.place.PlaceInterface;

import static party.people.service.keyword.keywordToMapLogic.*;

import java.util.*;
import java.util.stream.Collectors;

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
    public String searchPlace(Page page, @RequestParam("searchForm") String searchForm, Model model){
        /* 검색 결과를 출력하는 로직 */
        log.info("검색내용 "+ searchForm);
        List<String>splitSearch = Arrays.stream(searchForm.split(" ")).toList();
        List<Place>mergedResult = new ArrayList<>();
        for (String one : splitSearch){
            mergedResult.addAll(placeInterface.findByKeyword(one));
//            log.info("포문으로 개수 확인 " +mergedResult.size());
        }
        log.info("검색 결과 개수 "+mergedResult.size());
        Set<Place> uniqueResult = new HashSet<>(mergedResult);
        /* or조건 */
        List<Place> resultWithoutDuplicates = new ArrayList<>(uniqueResult);
        /* and조건 */
        log.info("중복결과 제거 확인 " + resultWithoutDuplicates.size());
//        model.addAttribute("searchResult", mergedResult);
        model.addAttribute("searchResult", resultWithoutDuplicates);

        /* 검색한 내용을 키워드에 추가하는 로직 */
//        for (Place one : resultWithoutDuplicates){
//            String keyword = one.getKeyword();
//            Map<String, Integer> map = new HashMap<>();
//            map = keywordToMap(map, keyword);
//            if(splitSearch!=null){
//                for (String split : splitSearch){
//                    if (placeInterface.findByKeyword(split)!=null) {
//                        addNewKeyword(map, split);
//                    }
//                }
//            }
//            String updated = mapToSortedString(map);
//            placeInterface.updateKeyword(one.getTitle(), updated);
//        }
        return "home";
    }

}
