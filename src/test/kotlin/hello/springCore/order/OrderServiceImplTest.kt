package hello.springCore.order

import hello.springCore.member.Grade
import hello.springCore.member.Member
import hello.springCore.member.MemberServiceImpl
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class OrderServiceImplTest {
  private val memberService = MemberServiceImpl()
  private val orderService = OrderServiceImpl()

  @Test
  fun createOrder() {
    val memberId = 1L
    val member = Member(memberId, "memberA", Grade.VIP)
    memberService.join(member)

    val order = orderService.createOrder(memberId, "ItemA", 12345)
    Assertions.assertThat(order?.discountPrice).isEqualTo(1000)
    Assertions.assertThat(order?.calculatePrice()).isEqualTo(11345)
  }
}