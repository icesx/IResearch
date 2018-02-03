/**
 * Program  : AbsBuilder.java<br/>
 * Author   : i<br/>
 * Create   : Jul 27, 2017 11:26:14 AM<br/>
 *
 * Copyright 1997-2013 by 0dog.cn ltd.,
 * All rights reserved.
 */
package dict.build;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.TreeMap;

import com.fasterxml.sort.SortConfig;
import com.fasterxml.sort.std.TextFileSorter;
import com.google.common.collect.Maps;

public class AbsBuilder {

	/**
	 * Let's limit maximum memory used for pre-sorting when invoked from
	 * command-line to be 256 megs
	 */
	public final static long MAX_HEAP_FOR_PRESORT = 2048L * 1024 * 1024;

	/**
	 * Also just in case our calculations are wrong, require 10 megs for
	 * pre-sort anyway (if invoked from CLI)
	 */
	public final static long MIN_HEAP_FOR_PRESORT = 10L * 1024 * 1024;
	public final static String stopwords = "的很了么呢是嘛个都也比还这于不与才上用就好在和对挺去后没说";

	/**
	 * 输入的字符是否是汉字
	 * 
	 * @param a
	 *            char
	 * @return boolean
	 */
	protected static boolean isChinese(char a) {
		int v = (int) a;
		return (v >= 19968 && v <= 171941);
	}

	protected static boolean allChs(String s) {
		if (null == s || "".equals(s.trim()))
			return false;
		for (int i = 0; i < s.length(); i++) {
			if (!isChinese(s.charAt(i)))
				return false;
		}
		return true;
	}

	protected TreeMap<String, double[]> loadPosprop() {

		TreeMap<String, double[]> prop = Maps.newTreeMap();
		try {
			System.out.println(FastBuilder.class.getResourceAsStream("/pos_prop.txt"));
			BufferedReader br = new BufferedReader(
					new InputStreamReader(this.getClass().getResourceAsStream("/pos_prop.txt")));
			String l = null;
			while (null != (l = br.readLine())) {
				String[] seg = l.split("\t");
				prop.put(seg[0], new double[] { Double.parseDouble(seg[1]), Double.parseDouble(seg[2]),
						Double.parseDouble(seg[3]) });
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
	}

	protected String reverse(String raw) {
		StringBuilder bui = new StringBuilder();
		for (int i = raw.length() - 1; i >= 0; --i)
			bui.append(raw.charAt(i));
		return bui.toString();
	}

	public void sortFile(File in, File out) {
		try {
			long availMem = Runtime.getRuntime().maxMemory() - (2048 * 1024 * 1024);
			long maxMem = (availMem >> 1);
			if (maxMem > MAX_HEAP_FOR_PRESORT) {
				maxMem = MAX_HEAP_FOR_PRESORT;
			} else if (maxMem < MIN_HEAP_FOR_PRESORT) {
				maxMem = MIN_HEAP_FOR_PRESORT;
			}
			final TextFileSorter sorter = new TextFileSorter(new SortConfig().withMaxMemoryUsage(maxMem));
			sorter.sort(new FileInputStream(in), new PrintStream(out));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
