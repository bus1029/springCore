package hello.springCore.member

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class MemberServiceTest {
  private val memberService = MemberServiceImpl()

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