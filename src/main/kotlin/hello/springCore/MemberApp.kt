package hello.springCore

import hello.springCore.member.Grade
import hello.springCore.member.Member
import hello.springCore.member.MemberService
import org.springframework.context.annotation.AnnotationConfigApplicationContext

class MemberApp

fun main(args: Array<String>) {
  val applicationContext = AnnotationConfigApplicationContext(AppConfig::class.java)
  val memberService = applicationContext.getBean("memberService", MemberService::class.java)
  val member = Member(1L, "memberA", Grade.VIP)
  memberService.join(member)

  val findMember = memberService.findMember(1L)
  println("findMember = ${findMember?.name}")
}