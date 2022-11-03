package hello.hellospring4.repository;

import hello.hellospring4.AppConfig;
import hello.hellospring4.domain.Member;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

class JdbcMemberRepositoryTest {

    @Test
    void saveTest() {
        // 스프링컨테이너가 아니여서 테스트할 수 없음
//        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
//        MemberRepository memberRepository = ac.getBean(MemberRepository.class);
//        Member member = new Member();
//        member.setId(1L);
//        member.setName("jiheon");
//        memberRepository.save(member);
    }
}