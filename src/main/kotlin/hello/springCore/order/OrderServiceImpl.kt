package hello.springCore.order

import hello.springCore.discount.DiscountPolicy
import hello.springCore.member.MemberRepository

class OrderServiceImpl(private val memberRepository: MemberRepository, private val discountPolicy: DiscountPolicy) : OrderService {
  override fun createOrder(memberId: Long, itemName: String, itemPrice: Int): Order? {
    val findMember = memberRepository.findById(memberId)
    findMember?.let {
      val discount = discountPolicy.discount(it, itemPrice)
      return Order(memberId, itemName, itemPrice, discount)
    }

    return null
  }

  fun getMemberRepository(): MemberRepository {
    return memberRepository
  }
}