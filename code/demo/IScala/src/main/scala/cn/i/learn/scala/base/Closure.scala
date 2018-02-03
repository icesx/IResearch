package cn.i.learn.scala.base
class FOO {
    def exec(f: (String) => Unit, name: String) {
        f(name)
    }
}
object ClosureExample extends App {
    var hello = "Hello"
    def sayHello(name: String) { println(s"$hello, $name") }
    // execute sayHello from the exec method foo
    val foo = new FOO
    foo.exec(sayHello, "Al")
    // change the local variable 'hello', then execute sayHello from
    // the exec method of foo, and see what happens
    hello = "Hola"
    foo.exec(sayHello, "Lorenzo")
}