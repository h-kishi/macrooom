# Macrooom
Macrooom is an object-object mapper library. 

Developers need sometimes similar but different classes depending a purpose. Macrooom makes it easy to convert one object to another. It generates the code with Scala macro.


#### Current features:  

 * Mapping between Scala classes
 * Mapping between Java and Scala classes.


#### Not Supported:  

 * Nested classes



## Usage

```scala
case class SourceClass(id: Int, name: String) 
```

```java
class TargetClass {
  private String name;
  

  public void setName(String name) { this.name = name; }
  public String getName() { return name; }
}
```


```scala
import macrooom

// Convert from Scala object to Java object
def convert(src: SourceClass) = ObjectMapper.convertTo[SourceClass, TargetClass](src)

val source = SourceClass(1, "ScalaToJava")
val target = convert(source)
```



## Generated code

### Scala to Scala

**Scala class is instantiated based on the primary constructor.**

Here is an example source class:
 
```scala
class SourceClass(val id: Int, val name: String)
```

Here is an example target case class:

```scala
case class TargetClass(id: Int, name: String)
```

Here is generated by the macro:

```scala
// def convert(source: SourceClass) = ObjectMapper.convertTo[SourceClass, TargetClass](source)
def convert(source: SourceClass): TargetClass = new TargetClass(
  id = source.id
  name = source.name
)

```

### Scala to Java

**Java class is instantiated with default constructor and initialized using the accessors.**

Here is an example source class:
 
```scala
case class SourceClass(val id: Int, val name: String)
```

Here is an example target case class:

```java
class TargetClass {
  private int id;
  private String name;
  
  public void setId(int id) { id = id; }
  public int getName() { return id; }
  public void setName(String name) { this.name = name; }
  public String getName() { return name; }
}
```

Here is generated by the macro:

```
// def convert(source: SourceClass) = ObjectMapper.convertTo[SourceClass, TargetClass](source)
def convert(source: SourceClass): TargetClass = new TargetClass {
  setId(source.id)
  setName(source.name)
}

```

