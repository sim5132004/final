package party.people.repository.client;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import party.people.domain.Client;
import party.people.web.controller.client.FindPwForm;

import java.util.List;
import java.util.Optional;

@Mapper
public interface ClientMapper {

    // 회원 가입
    void save(Client client);

    // 전체 조회
    List<Client> findAll();

    // 시퀀스 아이디로 찾기
    Optional<Client> findBySequenceId(Long sequenceId);

    // 고객 아이디로 찾기
    Optional<Client> findByClientId(String clientId);

    // Email로 찾기(이메일 중복 검사용)
    Optional<Client> findByClientEmail(String clientEmail);

    // 비밀 번호 찾기(고객 아이디, 이메일 이용)
    Optional<Client> findPassword(FindPwForm form);

    // 내 정보 수정
    void update(@Param("clientId") String clientId, @Param("clientUpdateParam") ClientUpdateDto clientUpdateParam);
}
