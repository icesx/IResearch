/**
 * Program  : FileUtil.java<br/>
 * Author   : i<br/>
 * Create   : 2015年10月13日 下午12:33:02<br/>
 *
 * Copyright 1997-2015 by XJGZ ltd.,
 * All rights reserved.
 */
package cn.i.lucene.utils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.PosixFilePermission;
import java.util.HashSet;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;

public class FileUtil {
	private static Logger logger = Logger.getLogger(FileUtil.class);

	private static File toNamedTempSh(String name, String code) throws IOException {
		File tempFile = createNamedTempFile(name, code);
		Set<PosixFilePermission> perms = new HashSet<>();
		perms.add(PosixFilePermission.OWNER_EXECUTE);
		perms.add(PosixFilePermission.OWNER_READ);
		perms.add(PosixFilePermission.OWNER_WRITE);
		perms.add(PosixFilePermission.OTHERS_READ);
		perms.add(PosixFilePermission.OTHERS_EXECUTE);
		perms.add(PosixFilePermission.GROUP_READ);
		perms.add(PosixFilePermission.GROUP_EXECUTE);
		Files.setPosixFilePermissions(tempFile.toPath(), perms);
		FileUtils.write(tempFile, code);
		logger.info("create temp file " + tempFile);
		return tempFile;
	}

	public static File createNamedTempFile(String name, String code) throws IOException {
		File file = tempNamedPath(name);
		logger.info("createNamedTempFile is " + file);
		FileUtils.write(file, code);
		return file;
	}

	public static File tempNamedPath(String name) {
		String tmpdir = System.getProperty("java.io.tmpdir");
		File file = new File(tmpdir + File.separator + name);
		return file;
	}

	public static File classPathToTempFile(String name, String script) throws IOException {
		InputStream inputStream = FileUtil.class.getClassLoader().getResource(script).openStream();
		String code = IOUtils.toString(inputStream);
		File shellTemp = FileUtil.toNamedTempSh(name, code);
		return shellTemp;
	}

	public static File createRadomTempFile(String name, String suffix) throws IOException {
		File tempFile = File.createTempFile(name, suffix);
		return tempFile;
	}

	public static boolean isTempExists(String fileName) {
		File file = tempNamedPath(fileName);
		return file.exists() ? true : false;
	}

	public static Path createTempDir(String name) throws IOException {
		String tmpdir = System.getProperty("java.io.tmpdir");
		File file = new File(tmpdir + File.separator + name);
		file.createNewFile();
		return file.toPath();
	}
}
