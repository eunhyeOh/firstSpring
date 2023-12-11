package grace.firstspring.controller;

import grace.firstspring.domain.Member;
import grace.firstspring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MemberController {

    //생성자주입
    private MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService){
        this.memberService = memberService;
    }

    /**
     * 회원가입
     * */
    @GetMapping("/member/new")
    public String createFrom(){
        return "members/createMemberForm";
    }

    /**
     * 회원가입 / 등록버튼
     * */
    @PostMapping("/members/new")
    public String create(MemberForm form){

        Member member = new Member();
        member.setName(form.getName());

        memberService.Join(member);

        //홈화면으로 보내기
        return "redirect:/";
    }

    @GetMapping("/members")
    public String list(Model model){
        List<Member> members = memberService.findMembers();
        model.addAttribute("members", members);

        return "members/memberList";
    }
}
