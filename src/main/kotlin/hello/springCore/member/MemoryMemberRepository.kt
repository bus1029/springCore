package hello.springCore.member

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