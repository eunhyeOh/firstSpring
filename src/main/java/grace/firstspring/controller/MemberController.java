package grace.firstspring.controller;

import grace.firstspring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController {

    /*
    * 다른 여러 컨트롤러에서도 사용한다면 여러개 생성할 필요가 없음
    * */
//    private final MemberService memberService = new MemberService();

    private final MemberService memberService;

    //의존관계주입(DI)
    @Autowired
    public MemberController(MemberService memberService){
        this.memberService = memberService;
    }
}
