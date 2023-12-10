package grace.firstspring.controller;

import grace.firstspring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController {

    /**필드 주입
    @Autowired private MemberService;
    /*

    /**세터 주입
    private MemberService memberService;
    @Autowired
    public void SetMemberService(MemberService memberService){
        this.memberService = memberService;
    }
    */

    //생성자주입
    private MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService){
        this.memberService = memberService;
    }
}
