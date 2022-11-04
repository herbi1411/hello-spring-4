package hello.hellospring4.controller;

import hello.hellospring4.domain.Member;
import hello.hellospring4.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class MemberController {

    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping(value="/members/new")
    public String createForm() {
        return "members/createMemberForm";
    }

    @PostMapping(value="/members/new")
    public String create(MemberForm form) {
        Member member = new Member();
        member.setName(form.getName());

        memberService.join(member);

        return "redirect:/";
    }

    @GetMapping(value="/members")
    public String list(Model model) {
        List<Member> members = memberService.findMembers();
        model.addAttribute("members", members);
        return "members/memberList";
    }

    @PostMapping(value="/members/delete/{memberId}")
    public String deleteOne(@PathVariable("memberId") String memberId) {
        memberService.deleteMember(Long.parseLong(memberId));
        return "redirect:/members";
    }
}
