package cn.i.xportal.jdp.chainofresp.flowerpassing;

public class DrumBeater {
	private static Player player;

	public static void main(String[] args) {
		JiaMu jiaMu = new JiaMu(null);

		jiaMu.setSuccessor(new JiaShe(new JiaZheng(new JiaBaoYu(new JiaHuan(jiaMu)))));

		player = jiaMu;

		player.handle(4);
	}
}
