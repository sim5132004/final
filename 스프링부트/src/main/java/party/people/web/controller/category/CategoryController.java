package party.people.web.controller.category;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import party.people.domain.Client;
import party.people.domain.Place;
import party.people.domain.SearchResult;
import party.people.repository.place.PlaceInterface;
import party.people.repository.search.SearchInputInterface;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Controller
@RequiredArgsConstructor
@Slf4j
public class CategoryController {

    private final PlaceInterface placeInterface;
    private final SearchInputInterface searchInputInterface;

    @GetMapping("place")
    public String goPlace(HttpServletRequest request, Model model){
        /* side lnb 출력용 */
        model.addAttribute("category","place");
        /* 로그인 유무 체크 */
        /* 함수 정보는 함수 이름 컨트롤 클릭 */
        loginCheck(request, model);

        List<SearchResult>allResult = searchInputInterface.loadAll();
        Random random = new Random();
        int randomValue = random.nextInt(allResult.size());

        SearchResult start = allResult.get(randomValue);

        /* 출력 형식이 이중 리스트로 [[PLACE, PLACE, PLACE], [PLACE, PLACE, PLACE], ... ] */
        /* 리스트에 PLACE 3개의 객체가 하나의 리스트로 들어가 있는 형식이어야 함  */
        /* 그래서 DB inputResult 테이블도 내부 3개는 ,로 리스트와 리스트사이는 / 로 구분지어둠 */
        List<List<Place>> finalForm = new ArrayList<>();
        /* 첫 리스트 쪼개기 /로 3개로 구성되어있는 리스트로 만들기 */
        /* ['가,나,다','1,2,3',...,'A,B,C'] */
        if (start.getResult()!=null) {
            List<String> three = Arrays.stream(start.getResult().split("/")).toList();
            /* 위의 리스트를 또 ,단위로 쪼개야 한다 */
            /* 여기서 Strong one의 첫번째 값은 위의 예시 '가,나,다'를 예시로 */

            for (String one : three) {
                /* ,로 스플릿해 나누면 해당 finalList의 값은 ['가','나','다']가 된다 */
                List<String> finalList = Arrays.stream(one.split(",")).toList();
                /* 이 가,나,다 의 정보를 DB에서 찾아 PLACE객체를 담을 예정이므로 새 Place제네릭을 가진 리스트를 생성 */
                List<Place> midForm = new ArrayList<>();

                /* 위의 ['가','나','다']를 하나씩 불러온다 */
                /* 가,나,다로 설명했지만 각각은 돈비어천가, 부평시장 등 상호, 장소명이다. */
                for (String finalOne : finalList) {
                    /* findByTitle은 이름으로 List<Place>를 호출하기때문에 get(0)으로 첫번째 값을 리턴 */
                    Place placeOne = placeInterface.findByTitle(finalOne).get(0);
                    /* '가'로 리턴된 Place객체를 midForm에 담는다 이를 3번 반복 */
                    midForm.add(placeOne);
                }
                /* place객체가 담긴 midForm리스트를 finalForm리스트에 추가한다 */

                finalForm.add(midForm);
            }
            log.info("searchPlace] " + finalForm);

            /* 해당 리스트를 타임리프단에 전달 */
            model.addAttribute("searchResult", finalForm);

        }

        // place페이지 오른쪽 카드세트 번호에 글자 색 리스트
        String[] colors = {
                "#ff0000", "#ff8c00", "#008000", "#0000ff", "#4b0082", "#8b00ff"
        };
        model.addAttribute("colors", colors);


        return "place/place_thymeleaf";
    }

    @GetMapping("main")
    public String goCategory(Model model){
        /* side lnb 출력용 */
       // model.addAttribute("category","place");
        return "main/main";
    }

    @GetMapping("analysis")
    public String goAnalysis(HttpServletRequest request, Model model){

        /* side lnb 출력용 */
        model.addAttribute("category","analysis");

        /* 로그인 유무 체크 */
        /* 함수 정보는 함수 이름 컨트롤 클릭 */
        loginCheck(request, model);

        return "analysis/analysis";
    }



//    @GetMapping("invite")
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
        model.addAttribute("category","invite");

//        if(request != null){
//            model.addAttribute("category2",request);
//
//        }else{
//
//            model.addAttribute("category2",placeList);
//
//        }

        return "invite/invite_A";
    }

//    @GetMapping("category")
//    public String goCategory(Model model){
//
//        return "category/category";
//    }

    public static void loginCheck(HttpServletRequest request, Model model) {
        /* 세션 정보 가져오기 */
        /* create:false => 세션 정보가 있으면 기존 세션정보 로딩, 없으면 null 반환 */
        /* 세션 생성은 LoginController 참조 */
        HttpSession loginInfo = request.getSession(false);
        log.info("세션정보 " + loginInfo);

        /* 세션 정보가 없으면 client 객체에 null값 반환 */
        if (loginInfo==null) {
            model.addAttribute("client", null);
        } else {
            /* 세션 정보가 있으면 "로그인"이라는 키로 로그인 회원의 정보 가져오기 */
            Client loginClient = (Client) loginInfo.getAttribute("로그인");
            /* 해당 정보가 없으면 client 객체에 null값 반환 */
            if (loginClient==null) {
                model.addAttribute("client", null);
                /* 로그인 회원에 대한 정보를 client 객체에 담아 반환 */
            } else model.addAttribute("client", loginClient);
        }
    }

}
