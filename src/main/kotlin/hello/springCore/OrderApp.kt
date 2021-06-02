package hello.springCore

import hello.springCore.member.Grade
import hello.springCore.member.Member

class OrderApp

fun main(args: Array<String>) {
  val appConfig = AppConfig()
  val orderService = appConfig.orderService()
  val memberService = appConfig.memberService()
  val member = Member(1L, "memberA", Grade.VIP)
  memberService.join(member)

  val createOrder = orderService.createOrder(1L, "itemA", 10000)
  println("createOrder = $createOrder")
}