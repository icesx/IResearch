package cn.i.xportal.jdp.interpreter;

import cn.i.xportal.jdp.interpreter.And;
import cn.i.xportal.jdp.interpreter.Constant;
import cn.i.xportal.jdp.interpreter.Context;
import cn.i.xportal.jdp.interpreter.Expression;
import cn.i.xportal.jdp.interpreter.Not;
import cn.i.xportal.jdp.interpreter.Or;
import cn.i.xportal.jdp.interpreter.Variable;

public class Client {
	private static Context ctx;
	private static Expression exp;

	public static void main(String[] args) {
		ctx = new Context();

		Variable x = new Variable("x");
		Variable y = new Variable("y");
		Constant c = new Constant(true);

		ctx.assign(x, false);
		ctx.assign(y, true);

		exp = new Or(new And(c, x), new And(y, new Not(x)));
		System.out.println("x = " + x.interpret(ctx));
		System.out.println("y = " + y.interpret(ctx));
		System.out.println(exp.toString() + " = " + exp.interpret(ctx));
	}
}
