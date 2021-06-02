package hello.springCore.member

import hello.springCore.AppConfig
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class MemberServiceTest {
  private lateinit var memberService: MemberService

  @BeforeEach
  fun init() {
    val appConfig = AppConfig()
    memberService = appConfig.memberService()
  }

  @Test
  fun join() {
    // given
    val member = Member(1L, "memberA", Grade.VIP)

    // when
    memberService.join(member)
    val findMember = memberService.findMember(1L)

    // then
    assertThat(member).isEqualTo(findMember)
  }
}