package cn.i.xportal.jdp.composite.filesystem;

import java.util.ArrayList;
import java.util.List;

public class FolderNode extends FileSystemNode {
	private List<FileNode> files = new ArrayList<>();

	public FolderNode() {
	}

	public void addNode(FileNode file) {
		files.add(file);
	}

	public int getSize() {
		int size = 0;
		for (FileNode fileNode : files) {
			size += fileNode.getSize();
		}
		return size;
	}
}
