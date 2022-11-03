package hello.hellospring4.repository;

import hello.hellospring4.AppConfig;
import hello.hellospring4.domain.Member;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

class MemoryMemberRepositoryTest {
    @Test
    void join() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberRepository memberRepository = ac.getBean(MemberRepository.class);
        Member member = new Member();
        member.setName("jiheon");
        member.setId(1L);
        memberRepository.save(member);
    }
}