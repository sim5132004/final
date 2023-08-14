package party.people.repository.client;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import party.people.domain.Client;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
@Slf4j
public class ClientRepository implements ClientInterface{

    /* DB에서 가져오기 위해 Mapper 이용 */
    private final ClientMapper clientMapper;

    /* 이하 인터페이스에서 가져온 기능을 Mapper에 위임 */

    @Override
    public void save(Client client) {
        clientMapper.save(client);
    }

    @Override
    public List<Client> findAll() {
        return clientMapper.findAll();
    }

    @Override
    public Optional<Client> findBySequenceId(Long sequenceId) {
        return clientMapper.findBySequenceId(sequenceId);
    }

    @Override
    public Optional<Client> findByClientId(String clientId) {
        log.info("findByClientId] "+clientId);
        return clientMapper.findByClientId(clientId);
    }

    @Override
    public Optional<Client> findByClientEmail(String clientEmail) {
        return Optional.empty();
    }

    @Override
    public Optional<Client> findPassword(String clientId, String clientEmail) {
        return clientMapper.findPassword(clientId, clientEmail);
    }

    @Override
    public void update(String clientId, ClientUpdateDto clientUpdateParam) {
        clientMapper.update(clientId, clientUpdateParam);
    }
}
