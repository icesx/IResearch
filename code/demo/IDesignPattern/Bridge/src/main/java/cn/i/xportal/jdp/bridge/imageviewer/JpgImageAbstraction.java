package cn.i.xportal.jdp.bridge.imageviewer;

public class JpgImageAbstraction extends ImageAbstraction {
	public JpgImageAbstraction(ImageImpl image) {
		super(image);
	}

	public void load() {
		System.out.println(this.getClass() + " load "+imp);
	}

	public void show() {
		System.out.println(this.getClass() + " show  "+imp);
	}
}
