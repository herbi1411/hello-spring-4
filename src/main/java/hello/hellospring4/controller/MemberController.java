package hello.hellospring4.controller;

import hello.hellospring4.domain.Member;
import hello.hellospring4.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @GetMapping(value="/members/update/{memberId}")
    public String updateView(Model model, @PathVariable("memberId") String memberId) {
        Optional<Member> member = memberService.findOne(Long.parseLong(memberId));
        if (member.isPresent()) {
            model.addAttribute("member", member.get());
            return "members/updateMemberForm";
        }
        else {
            return "redirect:/";
        }
    }
    @PostMapping(value="/members/update/{memberId}")
    public String updateOne(MemberForm form, @PathVariable("memberId") String memberId) {
        memberService.UpdateMember(Long.valueOf(memberId), form.getName());
        return "redirect:/members";
    }
}
