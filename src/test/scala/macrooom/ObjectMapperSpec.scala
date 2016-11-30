package macrooom

import org.specs2.mutable.Specification

class ObjectMapperSpec extends Specification {

  case class ScalaCaseClass(id: Int, name: String)

  case class ScalaCaseClass2(name: String)

  class ScalaClass(val id: Int, val name: String)

  def convertBetweenScalaCaseClasses(src: ScalaCaseClass) = ObjectMapper.convertTo[ScalaCaseClass, ScalaCaseClass2](src)

  def convertScalaCaseClassToScalaClass(src: ScalaCaseClass) = ObjectMapper.convertTo[ScalaCaseClass, ScalaClass](src)

  def convertScalaCaseClassToJavaClass(src: ScalaCaseClass) = ObjectMapper.convertTo[ScalaCaseClass, JavaClass](src)

  def convertJavaClassToScalaCaseClass(src: JavaClass) =  ObjectMapper.convertTo[JavaClass, ScalaCaseClass](src)

  "ObjectMapper" should {
    "convert from case class to another case class with smaller parameters of constructor" in {
      val source = ScalaCaseClass(1, "Test")
      val target = convertBetweenScalaCaseClasses(source)
      target.isInstanceOf[ScalaCaseClass2] === true
      target.name === source.name
    }
    "convert from case class to scala class" in {
      val source = ScalaCaseClass(1, "Test")
      val target = convertScalaCaseClassToScalaClass(source)
      target.isInstanceOf[ScalaClass] === true
      target.id === source.id
      target.name === source.name
    }
    "convert from case class to java class" in {
      val source = ScalaCaseClass(1, "Test")
      val target = convertScalaCaseClassToJavaClass(source)
      target.isInstanceOf[JavaClass] === true
      target.getId === source.id
      target.getName === source.name
    }
    "convert from java class to case class" in {
      val source = new JavaClass(1, "Test")
      val target = convertJavaClassToScalaCaseClass(source)
      target.isInstanceOf[ScalaCaseClass] === true
      target.id === source.getId
      target.name === source.getName
    }
  }
}
