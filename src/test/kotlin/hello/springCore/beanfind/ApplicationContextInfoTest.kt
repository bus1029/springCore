package hello.springCore.beanfind

import hello.springCore.AppConfig
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.config.BeanDefinition
import org.springframework.context.annotation.AnnotationConfigApplicationContext

class ApplicationContextInfoTest {
  private val ac = AnnotationConfigApplicationContext(AppConfig::class.java)

  @Test
  @DisplayName("모든 빈 출력하기")
  fun findAllBean() {
    val beanDefinitionNames = ac.beanDefinitionNames
    for (beanDefinitionName in beanDefinitionNames) {
      val bean = ac.getBean(beanDefinitionName)
      println("beanDefinitionName = $beanDefinitionName object = $bean")
    }
  }

  @Test
  @DisplayName("애플리케이션 빈 출력하기")
  fun findApplicationBean() {
    val beanDefinitionNames = ac.beanDefinitionNames
    beanDefinitionNames.forEach { beanDefinitionName ->
      val beanDefinition = ac.getBeanDefinition(beanDefinitionName)
      // ROLE_INFRASTRUCTURE: 스프링 내부에서 사용하는 빈
      if (beanDefinition.role == BeanDefinition.ROLE_APPLICATION) {
        val bean = ac.getBean(beanDefinitionName)
        println("beanDefinitionName = $beanDefinitionName object = $bean")
      }
    }
  }
}