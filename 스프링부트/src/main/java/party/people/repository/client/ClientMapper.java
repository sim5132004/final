package party.people.repository.client;

import org.apache.ibatis.annotations.Mapper;
import party.people.domain.Client;

import java.util.List;
import java.util.Optional;

@Mapper
public interface ClientMapper {

    // 회원 가입
    Client save(Client client);

    // 전체 조회
    List<Client> findAll();

    // 시퀀스 아이디로 찾기
    Optional<Client> findBySequenceId(Long sequenceId);

    // 고객 아이디로 찾기
    Optional<Client> findByClientId(String clientId);

    // 비밀 번호 찾기(고객 아이디, 이메일 이용)
    Optional<Client> findPassword(String clientId, String clientEmail);

    // 내 정보 수정
    void update(String clientId, ClientUpdateDto clientUpdateParam);
}
