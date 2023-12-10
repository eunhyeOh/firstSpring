package grace.firstspring.repository;

import grace.firstspring.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.*;

//구현체
public class MemoryMemberRepository implements MemberRepository {

    //데이터 저장
    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;

    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }


    //optional 널 포함되어 반환
    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream().filter(member -> member.getName().equals(name))
                .findAny();
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }


    //테스트후 클리어하기 위해 생성
    public void clearStore(){
        store.clear();
    }
}
