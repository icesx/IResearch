/**
 * Program  : FileNodeTest.java<br/>
 * Author   : i<br/>
 * Create   : Mar 29, 2017 1:39:20 PM<br/>
 *
 * Copyright 1997-2013 by III.cn ltd.,
 * All rights reserved.
 */
package cn.i.xportal.jdp.composite;

import org.apache.log4j.Logger;

import cn.i.xportal.jdp.composite.filesystem.FileNode;
import cn.i.xportal.jdp.composite.filesystem.FolderNode;

public class FileNodeTest {
	private static Logger logger = Logger.getLogger(FileNodeTest.class);

	public static void main(String[] args) {
		FileNode fileNode = new FileNode();
		FolderNode folderNode = new FolderNode();
		folderNode.addNode(fileNode);
		folderNode.addNode(fileNode);
		folderNode.addNode(fileNode);
		logger.info(folderNode.getSize());
	}
}
