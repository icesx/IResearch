package cn.i.xporal.jdp.iterator;

import java.util.Iterator;
import java.util.ListIterator;
import java.util.Vector;

import com.javapatterns.iterator.monkey.Desciple;
import com.javapatterns.iterator.monkey.Horse;
import com.javapatterns.iterator.monkey.Monkey;
import com.javapatterns.iterator.monkey.Pigsy;
import com.javapatterns.iterator.monkey.Sandy;
import com.javapatterns.iterator.monkey.Vecterator;

public class MonkTang {
	private static Vector desciples;

	public static void main(String[] args) {
		desciples = new Vector(3);

		Desciple monkey = new Monkey();
		Desciple pigsy = new Pigsy();
		Desciple sandy = new Sandy();

		desciples.add(monkey);
		desciples.add(pigsy);
		desciples.add(sandy);

		System.out.println("The following is from polymorphic iterator");
		listPolymorphic();

		System.out.println("The following is from concrete iterator");
		listConcrete();

		System.out.println("The above are also external iterators");
		System.out.println("The follwoing is from internal iterator");
		listInternal();

		System.out.println("The follwoing from robust iterator");
		listRobust();
	}

	private static void listPolymorphic() {
		Desciple desciple = null;

		Iterator it = desciples.iterator();

		while (it.hasNext()) {
			desciple = (Desciple) it.next();
			desciple.speak();
		}

	}

	private static void listConcrete() {
		Desciple desciple = null;

		Vecterator vect = new Vecterator(desciples);

		while (vect.hasNext()) {
			desciple = (Desciple) vect.next();
			desciple.speak();
		}

	}

	private static void listInternal() {
		Desciple desciple = null;

		for (int i = 0; i < desciples.size(); i++) {
			desciple = (Desciple) desciples.elementAt(i);
			desciple.speak();
		}
	}

	private static void listRobust() {
		Desciple desciple = null;

		ListIterator it = desciples.listIterator();

		while (it.hasNext()) {
			desciple = (Desciple) it.next();
			if (desciple instanceof Monkey) {
				it.remove();
				it.next();

				it.add(new Horse());
				it.previous();
			}
			desciple.speak();
		}

	}
}
