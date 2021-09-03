/**
 * Program  : ImgeviewerTest.java<br/>
 * Author   : i<br/>
 * Create   : Mar 28, 2017 3:04:52 PM<br/>
 *
 * Copyright 1997-2013 by III.cn ltd.,
 * All rights reserved.
 */
package cn.i.xportal.jdp.bridge;

import cn.i.xportal.jdp.bridge.imageviewer.BmpImageAbstraction;
import cn.i.xportal.jdp.bridge.imageviewer.ImageImpl;
import cn.i.xportal.jdp.bridge.imageviewer.JpgImageAbstraction;
import cn.i.xportal.jdp.bridge.imageviewer.LinuxImageImpl;
import cn.i.xportal.jdp.bridge.imageviewer.WindowImageImpl;

public class ImgeviewerTest {
	public static void main(String[] args) {
		ImageImpl linux = new LinuxImageImpl();
		ImageImpl windows = new WindowImageImpl();
		new BmpImageAbstraction(linux).show();
		new JpgImageAbstraction(linux).show();
		new JpgImageAbstraction(windows).show();
	}
}
