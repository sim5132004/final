package party.people.service.client;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import party.people.domain.Client;
import party.people.repository.client.ClientInterface;

import static party.people.service.keyword.keywordToMapLogic.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
@Slf4j
public class ClientKeywords {
    private final ClientInterface clientInterface;

    public String keywords() {
        List<Client> all = clientInterface.findAll();
        Map<String, Integer> total = new HashMap<>();
        String keywords = "";
        for (int i = 0; i < all.size(); i++) {
            String one = all.get(i).getKeyword();
            log.info("keywords] "+one);
            if (one != null) {
                total = keywordToMap(total ,one);
                log.info("keywords] "+total);
            }
        }
        keywords = mapToString(total);
        return keywords;
    }

}

