package hello.springCore.order

import hello.springCore.AppConfig
import hello.springCore.member.Grade
import hello.springCore.member.Member
import hello.springCore.member.MemberService
import hello.springCore.member.MemberServiceImpl
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach

class OrderServiceImplTest {
  private lateinit var memberService: MemberService
  private lateinit var orderService: OrderService

  @BeforeEach
  fun init() {
    val appConfig = AppConfig()
    memberService = appConfig.memberService()
    orderService = appConfig.orderService()
  }

  @Test
  fun createOrder() {
    val memberId = 1L
    val member = Member(memberId, "memberA", Grade.VIP)
    memberService.join(member)

    val order = orderService.createOrder(memberId, "ItemA", 12345)
    Assertions.assertThat(order?.discountPrice).isEqualTo(1234)
  }
}