package party.people.repository.keywords;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import party.people.domain.Keywords;

import java.util.List;

@Repository
@RequiredArgsConstructor
@Slf4j
public class KeywordsRepository implements KeywordsInterface {

    private final KeywordsMapper keywordsMapper;

    @Override
    public List<Keywords> findAll() {
        return keywordsMapper.findAll();
    }

    @Override
    public void save(Keywords keywords) {
        keywordsMapper.save(keywords);
    }

    @Override
    public void update(Keywords keywords) {
        keywordsMapper.update(keywords);
    }
}
