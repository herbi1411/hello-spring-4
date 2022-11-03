package hello.hellospring4.repository;

import hello.hellospring4.domain.Member;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
@Repository
public interface MemberRepository {
    Member save(Member member) throws SQLException;
    Optional<Member> findById(Long id) throws SQLException;
    Optional<Member> findByName(String name) throws SQLException;
    List<Member> findAll() throws SQLException;
}
