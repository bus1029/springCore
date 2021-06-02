package hello.springCore

import hello.springCore.member.Grade
import hello.springCore.member.Member

class MemberApp

fun main(args: Array<String>) {
  val appConfig = AppConfig()
  val memberService = appConfig.memberService()
  val member = Member(1L, "memberA", Grade.VIP)
  memberService.join(member)

  val findMember = memberService.findMember(1L)
  println("findMember = ${findMember?.name}")
}