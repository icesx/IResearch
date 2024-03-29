状态模式(State Pattern) 
===========

允许一个对象在其内部状态改变时改变它的行为，对象看起来似乎修改了它的类。其别名为状态对象(Objects for States)，状态模式是一种对象行为型模式。

策略模式与状态模式在实现上有共同之处，都是把不同的情形抽象为统一的接口来实现，就放在一起进行记录。2个模式的UML建模图基本相似，区别在于状态模式需要在子类实现与context相关的一个状态行为

### 状态模式和策略模式的比较

1. 两个模式的实现类图虽然一致，但是实现目的不一样！

2. 首先知道，策略模式是一个接口的应用案例，一个很重要的设计模式，简单易用，策略模式一般用于单个算法的替换，客户端事先必须知道所有的可替换策略，由客户端去指定环境类需要哪个策略，注意通常都只有一个最恰当的策略（算法）被选择。其他策略是同级的，可互相动态的在运行中替换原有策略。

3. 而状态模式的每个状态子类中需要包含环境类（Context）中的所有方法的具体实现——条件语句。通过把行为和行为对应的逻辑包装到状态类里，在环境类里消除大量的逻辑判断，而不同状态的切换由继承（实现）State的状态子类去实现，当发现修改的当前对象的状态不是自己这个状态所对应的参数，则各个状态子类自己给Context类切换状态（有职责链模式思想）！且客户端不直接和状态类交互，客户端不需要了解状态！（和策略不一样），策略模式是直接依赖注入到Context类的参数进行选择策略，不存在切换状态的操作，客户端需要了解策略！

4. 联系：状态模式和策略模式都是为具有多种可能情形设计的模式，把不同的处理情形抽象为一个相同的接口（抽象类），符合对开闭原则，且策略模式更具有一般性，在实践中，可以用策略模式来封装几乎任何类型的规则，只要在分析过程中听到需要在不同实践应用不同的业务规则，就可以考虑使用策略模式处理，在这点上策略模式是包含状态模式的功能的。