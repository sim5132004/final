package party.people.service.keyword;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class test2 {
    public static void main(String[] args) {
        String words = "낮잠/3,여름/4,부평구/2";

        /* DB에서 가져온 키워드를 Map으로 전환하는 메서드 사용 */
        Map<String, Integer> mapKeyword = keywordToMap(words);


        System.out.println("맵으로 쪼갠결과"+mapKeyword);
        System.out.println(mapKeyword.size());

        System.out.println("키값으로 내림차순 정렬결과");
        // Stream과 map.Entry를 이용하면 정렬도 된다!
        List<Map.Entry<String, Integer>> entries = mapKeyword.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toList());
        for (Map.Entry<String, Integer> entry : entries) {
            System.out.println("Key: " + entry.getKey() + ", "
                    + "Value: " + entry.getValue());
        }

        /* 새로운 키워드가 들어오면 어떻게 처리할까 */
        String newKeyword = "밤잠";
        System.out.println(mapKeyword.get(newKeyword));
        /* keyword가 null 없으면 맵에 키를 추가하고 카운트에 1 */
        if (mapKeyword.get(newKeyword)==null){
            mapKeyword.put(newKeyword,1);
        /* keyword가 존재한다면 해당 키워드 카운트에 +1 */
        } else {
            mapKeyword.put(newKeyword,mapKeyword.get(newKeyword)+1);
        }

        System.out.println(mapKeyword.get(newKeyword));

        System.out.println(mapKeyword.keySet().stream().toList().get(1));
        System.out.println(mapKeyword.keySet());
        System.out.println(mapKeyword.values().stream().toList().get(1));
        System.out.println(mapKeyword.values());

        /* 위의 프린트인에서 확인 결과 순서 이상 없음 */
        /* 해쉬맵을 다시 리스트화 */
        List<String>goToDBKeyword = new ArrayList<>();
        for (int i=0; i<mapKeyword.size(); i++){
            String key = mapKeyword.keySet().stream().toList().get(i);
            String num = mapKeyword.get(key).toString();

            /* 키워드에 넣기로 한 양식 적용 (KEYWORD/COUNT) */
            goToDBKeyword.add(key+"/"+num);
        }
        System.out.println(goToDBKeyword);

        /* DB에는 리스트를 넣을 수 없기 때문에 약속된 문자열로 투스트링! */
        String goToDB = goToDBKeyword.toString().replace("[","").replace("]","");
        System.out.println(goToDB);

    }

    public static Map<String, Integer> keywordToMap(String words) {
        // 리스트 형식으로 키워드 값을 가져올 시 어떻게 개수 체크를 할 것인가
        List<String>keyword = new ArrayList<>();
        // KEYWORD/개수 형식 체크
        keyword.add(words);

        // 첫번째 테스트 해시맵으로 해보자!
        Map<String, Integer>mapKeyword = new HashMap<>();

        System.out.println("전체 리스트 : "+keyword.get(0));
        /* ,로 keyword를 하나 하나 쪼개서 리스트 재 생성 */
        List splitKeyword = Arrays.stream(keyword.get(0).split(",")).toList();
        /* 쪼개진 키워드들을 이번엔 /의 인덱스를 이용해 해시맵에 키워드를 키로 개수를 밸류로 입력*/
        for (int index = 0; index < splitKeyword.size(); index++) {
            /* List에 <> 제네릭을 적용하지 않았기 때문에 get 호출시 Object 자료형으로 호출 */
            // 그래서 toString()으로 String으로 변환
            // , 하고 띄어쓰기를 했을 경우에 대비해 strip() 글자 시작과 끝에 띄어쓰기가 있으면 제거 함수 사용
            String Title = splitKeyword.get(index).toString().strip();
            System.out.println("쪼개진 리스트 : "+Title);
            // '/'의 인덱스를 찾아 divideCheckIndex에 저장
            int divideCheckIndex = Title.indexOf("/");
            // 시작부터 /의 인덱스 앞까지 substring으로 추출 -> substring(시작인덱스(포함),끝인덱스(미포함))
            String textResult = Title.substring(0,divideCheckIndex);
            // 체크인덱스의+1(/의 다음문자)부터 글자의 끝까지 substring으로 추출
            // ex) "23"과 같은 스트링 자료형이므로 Integer.parseInt이용해 int형으로 변경
            int numberResult = Integer.parseInt(Title.substring(divideCheckIndex+1, Title.length()));

//            /* mapKeyword에 키와, 밸류를 각각 저장 */
            mapKeyword.put(textResult, numberResult);
        }
        return mapKeyword;
    }
}
