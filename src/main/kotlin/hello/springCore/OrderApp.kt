package hello.springCore

import hello.springCore.member.Grade
import hello.springCore.member.Member
import hello.springCore.member.MemberService
import hello.springCore.order.OrderService
import org.springframework.context.annotation.AnnotationConfigApplicationContext

class OrderApp

fun main(args: Array<String>) {
  val applicationContext = AnnotationConfigApplicationContext(AppConfig::class.java)
  val orderService = applicationContext.getBean("orderService", OrderService::class.java)
  val memberService = applicationContext.getBean("memberService", MemberService::class.java)
  val member = Member(1L, "memberA", Grade.VIP)
  memberService.join(member)

  val createOrder = orderService.createOrder(1L, "itemA", 10000)
  println("createOrder = $createOrder")
}