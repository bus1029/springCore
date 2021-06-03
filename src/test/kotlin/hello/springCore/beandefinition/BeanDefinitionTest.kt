package hello.springCore.beandefinition

import hello.springCore.AppConfig
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.config.BeanDefinition
import org.springframework.context.annotation.AnnotationConfigApplicationContext
import org.springframework.context.support.GenericXmlApplicationContext

class BeanDefinitionTest {
  // 자바 코드로 등록하는 방식은 팩토리 메소드로 Bean을 등록하는 방식
  val ac = AnnotationConfigApplicationContext(AppConfig::class.java)
  // XML로 등록하는 방식은 직접 Bean을 등록하는 방식
  val xmlAc = GenericXmlApplicationContext("appConfig.xml")

  @Test
  @DisplayName("자바코드로 등록한 빈 설정 메타정보 확인")
  fun findApplicationBeanThroughCode() {
    val beanDefinitionNames = ac.beanDefinitionNames
    for (beanDefinitionName in beanDefinitionNames) {
      val beanDefinition = ac.getBeanDefinition(beanDefinitionName)

      if (beanDefinition.role == BeanDefinition.ROLE_APPLICATION) {
        println("code beanDefinitionName = $beanDefinitionName beanDefinition = $beanDefinition")
      }
    }
  }

  @Test
  @DisplayName("XML로 등록한 빈 설정 메타정보 확인")
  fun findApplicationBeanThroughXml() {
    val beanDefinitionNames = xmlAc.beanDefinitionNames
    for (beanDefinitionName in beanDefinitionNames) {
      val beanDefinition = xmlAc.getBeanDefinition(beanDefinitionName)

      if (beanDefinition.role == BeanDefinition.ROLE_APPLICATION) {
        println("xml beanDefinitionName = $beanDefinitionName beanDefinition = $beanDefinition")
      }
    }
  }
}