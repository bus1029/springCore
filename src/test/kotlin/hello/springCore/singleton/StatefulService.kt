package hello.springCore.singleton

class StatefulService {
  // 상태를 유지하는 필드
  private var price = 0

  fun order(name: String, price: Int) {
    println("name = $name price = $price")
    // 여기가 문제
    this.price = price
  }

  fun getPrice(): Int {
    return price
  }
}