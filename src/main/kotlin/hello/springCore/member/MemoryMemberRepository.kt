package hello.springCore.member

import org.springframework.stereotype.Component

@Component
class MemoryMemberRepository : MemberRepository {
  companion object {
    val store: MutableMap<Long, Member> = HashMap()
  }

  override fun save(member: Member) {
    store[member.id] = member
  }

  override fun findById(memberId: Long): Member? {
    return store[memberId]
  }
}