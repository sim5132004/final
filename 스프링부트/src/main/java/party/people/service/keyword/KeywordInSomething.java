package party.people.service.keyword;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import party.people.domain.Place;
import party.people.repository.place.PlaceInterface;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static party.people.service.keyword.keywordToMapLogic.*;

@Service
@RequiredArgsConstructor
public class KeywordInSomething {
    private final PlaceInterface placeInterface;

    /* 이 서비스는 최초 실행 한 번만 되어야 함 */
    /* 안 그러면 DB 오염 됨 */
    public void addToKeyword(){
        List<Place> allList = placeInterface.findAll();
        for(int i=0; i<allList.size(); i++){
            Map<String, Integer> map = new HashMap<>();
            String title = allList.get(i).getTitle();
            String category = allList.get(i).getCategory();
            String smallCategory = allList.get(i).getSmallCategory();
            String address = allList.get(i).getAddress();
            List<String>splitAdd = regexAddress(address);
            String keyword = allList.get(i).getKeyword();
            if (keyword!=null) {
                map = keywordToMap(map, keyword);
            }
            addNewKeyword(map,title);
            addNewKeyword(map,category);
            addNewKeyword(map,smallCategory);
            for (String one : splitAdd){
                addNewKeyword(map,one);
            }
            String mergedKeyword= mapToString(map);
            System.out.println(mergedKeyword);
            placeInterface.updateKeyword(title,mergedKeyword);
        }

    }


    public static List<String> regexAddress(String input) {
        List<String>regexAddress = new ArrayList<>();
        while(true) {
            System.out.println("추출대상: "+ input);
            String regex = "([가-힣]+)(?:구|동|군|읍|면)\\s";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(input);
            boolean extract = matcher.find();
            if (extract){
                String one = matcher.group();
                regexAddress.add(one);
                System.out.println("추출결과: "+one);
                input = input.replace(one, "");
            } else {
                System.out.println("더 이상 없음");
                break;
            }
        }
        return regexAddress;
    }
}

