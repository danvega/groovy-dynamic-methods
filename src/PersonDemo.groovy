class Person {
    String first
    String last
    String email
}

ExpandoMetaClass.enableGlobally()

Person person = new Person()
Person.metaClass.sayHello = { -> println "Hello 👋"}
person.sayHello()