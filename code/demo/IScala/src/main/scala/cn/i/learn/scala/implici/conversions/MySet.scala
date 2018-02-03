package cn.i.learn.scala.implici.conversions

import java.util.Set

class MySet(set: Set[String]) {
    val mySet = set
    def foreach(f: (String) => Unit) = {
        val it = mySet.iterator()
        while (it.hasNext()) {
            f(it.next())
        }
    }
}