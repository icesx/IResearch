package cn.i.xportal.jdp.bridge.imageviewer;

public class BmpImageAbstraction extends ImageAbstraction {
	public BmpImageAbstraction(ImageImpl image) {
		super(image);
	}

	public void load() {
		System.out.println(this.getClass() + " load "+imp);
	}

	public void show() {
		System.out.println(this.getClass() + " show "+imp);
	}
}
