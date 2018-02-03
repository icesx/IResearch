package cn.i.learn.scala.clazz

import scala.beans.BeanProperty
import scala.annotation.meta.getter

object Pojo {
    case class Site(id: String, name: String)
    class Site2(id: String, name: String)
    class Site3 {
        var id: String = _
        var name: String = _
        override def toString(): String = id + ":" + name
    }
    class Site4 {
        private[this] var id: String = _
        private[this] var name: String = _
        def id_(id: String) = {
            this.id = id
            this
        }
        def name_(name:String)={
            this.name=name
            this
        }
        override def toString(): String = id + ":" + name
    }
    def main(args: Array[String]): Unit = {
        var site: Site = Site("id", "name")
        println(site)
        println(new Site2("id", "name"))
        val site3 = new Site3()
        site3.id = "id"
        println(site3)
        println(new Site4().id_("id").id_("id2").name_("name"))
    }
}