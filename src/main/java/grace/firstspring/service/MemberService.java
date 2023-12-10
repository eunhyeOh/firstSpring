package grace.firstspring.service;

import grace.firstspring.domain.Member;
import grace.firstspring.repository.MemberRepository;
import grace.firstspring.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public class MemberService {

    //의존성 주입
    private final MemberRepository memberRepository;

    @Autowired
    public MemberService(MemberRepository memberRepository){
        this.memberRepository = memberRepository;
    }


    /**
     * 회원 가입
     * */
    public Long Join(Member member){
        
        //같은 이름이 있는 중복 회원X
//        Optional<Member> result = memberRepository.findByName(member.getName());
        validateDuplicateMember(member); //중복회원 검증

        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                        .ifPresent(m -> {
                            //null이 아닌 어떤 값이 있으면 동작하는 Optional의 메세드
                            throw new IllegalStateException("이미 존재하는 회원입니다.");
                        });
    }

    /**
    * 전체 회원 조회
     * */
    public List<Member> findMembers(){
       return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId){
        return memberRepository.findById(memberId);
    }
}
