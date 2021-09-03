package cn.i.xportal.jdp.bridge.imageviewer;

public abstract class ImageAbstraction {
	protected ImageImpl imp;

	public ImageAbstraction(ImageImpl image) {
		imp=image;
	}

	public abstract void load();

	public abstract void show();
}
