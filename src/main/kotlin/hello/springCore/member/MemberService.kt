package hello.springCore.member

interface MemberService {
  fun join(member: Member)
  fun findMember(memberId: Long): Member?
}