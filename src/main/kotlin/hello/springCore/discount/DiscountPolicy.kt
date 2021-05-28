package hello.springCore.discount

import hello.springCore.member.Member

interface DiscountPolicy {

  /**
   * @return 할인 대상 금액
   */
  fun discount(member: Member, price: Int): Int
}