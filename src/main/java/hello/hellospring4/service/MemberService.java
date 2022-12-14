package hello.hellospring4.service;

import hello.hellospring4.domain.Member;
import hello.hellospring4.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class MemberService {
    private final MemberRepository memberRepository;

    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public Long join(Member member){
        validDuplicateMember(member);
        memberRepository.save(member);
        return member.getId();
    }

    private void validDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    public List<Member> findMembers() { return memberRepository.findAll(); }

    public Optional<Member> findOne(Long memberId) { return memberRepository.findById(memberId); }

    public Member deleteMember(Long memberId) {
        Optional<Member> member = memberRepository.findById(memberId);
        return member.map(memberRepository::deleteOne).orElse(null);
    }

    public Member UpdateMember(Long memberId, String newName) {
        Optional<Member> member = memberRepository.findById(memberId);
        return member.map(value -> memberRepository.updateOne(value, newName)).orElse(null);
    }
}
