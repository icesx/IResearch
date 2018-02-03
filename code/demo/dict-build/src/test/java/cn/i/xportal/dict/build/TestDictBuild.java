/**
 * Program  : TestDictBuild.java<br/>
 * Author   : i<br/>
 * Create   : Jul 27, 2017 8:21:46 AM<br/>
 *
 * Copyright 1997-2013 by 0dog.cn ltd.,
 * All rights reserved.
 */
package cn.i.xportal.dict.build;

import org.junit.Test;

import dict.build.Main;

public class TestDictBuild {
	@Test
	public void buildDict() {
		Main.main(new String[] {"/ICESX/workSpaceI/IResearch/code/demo/dict-build/data/raw.TXT"});
	}
}
