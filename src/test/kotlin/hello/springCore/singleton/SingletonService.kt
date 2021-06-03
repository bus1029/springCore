package hello.springCore.singleton

class SingletonService private constructor() {
  // Holder 방식의 Singleton 패턴
  // Kotlin은 Object 클래스로 Singleton 클래스를 바로 생성할 수 있음
  private class InnerSingletonService {
    companion object {
      val instance = SingletonService()
    }
  }

  companion object {
    fun getInstance(): SingletonService {
      return InnerSingletonService.instance
    }
  }

  fun logic() {
    println("싱글톤 객체 로직 호출")
  }
}