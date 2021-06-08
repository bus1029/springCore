package hello.springCore.discount

import hello.springCore.member.Grade
import hello.springCore.member.Member
import org.springframework.context.annotation.ComponentScan
import org.springframework.stereotype.Component

@Component
class FixDiscountPolicy : DiscountPolicy {
  private val discountFixAmount = 1000

  override fun discount(member: Member, price: Int): Int {
    return if (member.grade == Grade.VIP) {
      discountFixAmount
    } else {
      0
    }
  }
}