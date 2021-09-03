package cn.i.xportal.jdp.chainofresp.flowerpassing;

class JiaHuan extends Player {

	public JiaHuan(Player aSuccessor) {
		this.setSuccessor(aSuccessor);
	}

	public void handle(int i) {
		if (i == 5) {
			System.out.println("Jia Huan gotta drink!");
		} else {
			System.out.println("Jia huan passed!");
			next(i);
		}
	}

}
