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
//import party.people.domain.TestOne;
import party.people.repository.place.PlaceInterface;

import static party.people.service.keyword.keywordToMapLogic.*;

import java.util.*;
import java.util.stream.Collectors;

@Controller
@RequiredArgsConstructor
@Slf4j
public class PlaceController {
    private final PlaceInterface placeInterface;

//    @GetMapping("place")
    public String placeForm(Model model){
        List<Place> findAll = placeInterface.findAll();
        List<Place> findCategory = placeInterface.findByCategory("레저");
        List<Place> findTitle = placeInterface.findByTitle("강화도");
        log.info("placeForm] "+findTitle);

        return "place/placeTest";
    }

//    @PostMapping("go_invite")
//    public String goInvite(@RequestParam("go_invite") TestOne testOne, Model model){
//
//
//        return "testpage/test_shim_in";
//    }
//

//    @GetMapping("test_main")
//    public String testMain(Model model){
//        TestOne one = new TestOne();
//        System.out.println("셋터 시작");
//        one.setOne(1);
//        one.setTwo(2);
//        one.setThree(3);
//
//        model.addAttribute("testOne", one);
//        System.out.println("리턴 시작");
//        return "testpage/test_shim_pl";
//    }

//
////    @PostMapping("test_main")
//    public String postMain(@ModelAttribute("test_ii") TestOne testOne, Model model){
//        TestOne testOne1= new TestOne();
//        model.addAttribute("c1", testOne1);
//        return "";
//    }
//
//    @PostMapping("test_i")
//    public String testIn(@ModelAttribute("test_ii") TestOne testOne, Model model){
////        Integer s=testOne.getOne();
////        System.out.println(s);
//        return "testpage/test_shim_in";
//    }
//



    @PostMapping("searchPlace")
    public String searchPlace(Page page, @RequestParam("searchForm") String searchForm, Model model){
        /* 검색 결과를 출력하는 로직 */
        log.info("검색내용 "+ searchForm);
        List<String>splitSearch = Arrays.stream(searchForm.split(" ")).toList();
        List<Place>searchResult = placeInterface.findByKeyword(splitSearch);

        model.addAttribute("searchResult", searchResult);


        /* 검색한 내용을 키워드에 추가하는 로직 => 해당 로직은 완성 됐지만 반복시 데이터가 오염되므로 실 서비스시 주석 해제*/
//        for (Place one : searchResult){
//            String keyword = one.getKeyword();
//            Map<String, Integer> map = new HashMap<>();
//            map = keywordToMap(map, keyword);
//            log.info("오류발생 지점 확인용 ");
//            if(splitSearch!=null){
//                log.info("searchPlace] "+splitSearch);
//                for (String split : splitSearch){
//                    log.info("split] "+split);
//                    if (placeInterface.findByKeyword(splitSearch)!=null) {
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
