package hello.springCore.discount

import hello.springCore.member.Grade
import hello.springCore.member.Member
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName

internal class RateDiscountPolicyTest {
  val discountPolicy = RateDiscountPolicy()

  @Test
  @DisplayName("VIP는 할인이 적용되어야 함.")
  fun discount() {
    val member = Member(1L, "memberVIP", Grade.VIP)
    val discount = discountPolicy.discount(member, 10000)
    Assertions.assertThat(discount).isEqualTo(1000)
  }

  @Test
  @DisplayName("VIP가 아니면 할인이 적용되지 않아야 함")
  fun discountNotVip() {
    val member = Member(1L, "memberVIP", Grade.BASIC)
    val discount = discountPolicy.discount(member, 10000)
    Assertions.assertThat(discount).isEqualTo(0)
  }
}