package hello.hellospring4;

import hello.hellospring4.repository.JdbcTemplateMemberRepositry;
import hello.hellospring4.repository.JpaMemberRepository;
import hello.hellospring4.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

@Configuration
public class AppConfig {
    private final DataSource dataSource;
    private final EntityManager em;
    @Autowired
    public AppConfig(DataSource dataSource, EntityManager em) {
        this.dataSource = dataSource;
        this.em = em;
    }

    @Bean
    public MemberRepository memberRepository() {
//        return new MemoryMemberRepository();
//        return new JdbcMemberRepository(dataSource);
//        return new JdbcTemplateMemberRepositry(dataSource);
        return new JpaMemberRepository(em);
    }
}
