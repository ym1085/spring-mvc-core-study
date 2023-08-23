package hello.servlet.domain.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.*;

import java.util.List;

class MemberRepositoryTest {

    MemberRepository memberRepository = MemberRepository.getInstance();

    // 클래스 초기화 전에 딱 한번만 수행이 된다, 기본적으로 static으로 선언해야함
    @BeforeAll
    static void beforeAll() {
        System.out.println("----beforeAll----");
    }

    // 각 테스트 메서드 실행 전에 한 번씩 실행됨
    @BeforeEach
    void beforeEach() {
        System.out.println("----beforeEach----");
    }

    // 모든 테스트 메서드 수행 후 마지막에 딱 한번만 수행 됨
    @AfterAll
    static void afterAll() {
        System.out.println("----afterAll----");
    }

    // 각 테스트 메서드 수행 후 한 번씩 수행 됨
    @AfterEach
    void afterEach() {
        System.out.println("----afterEach----");
        memberRepository.clearStore();
    }

    @Test
    public void testSaveMember() {
        System.out.println("testSaveMember");

        //given
        Member member = new Member("hello", 20);

        //when
        Member savedMember = memberRepository.save(member);

        //then
        Member findMember = memberRepository.findById(savedMember.getId());
        Assertions.assertThat(findMember).isEqualTo(savedMember);
    }

    @Test
    public void testFindAll() {
        System.out.println("testFindAll");

        //given
        Member member1 = new Member("member1", 20);// name, age
        Member member2 = new Member("member2", 30);// name, age

        memberRepository.save(member1);
        memberRepository.save(member2);

        //when
        List<Member> result = memberRepository.findAll();

        //then
        Assertions.assertThat(result.size()).isEqualTo(2);
    }
}