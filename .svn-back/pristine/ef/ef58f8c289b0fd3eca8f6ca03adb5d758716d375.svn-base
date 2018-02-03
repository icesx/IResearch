package dict.build;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.TreeMap;

import com.google.common.base.Charsets;
import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import com.google.common.io.Files;

/**
 * 
 * @author Jennifer
 * 
 */
public class Builder extends AbsBuilder {

	public String genLeft(String rawTextFile, int maxLen, int memSize) {

		File rawFile = new File(rawTextFile);

		File dir = rawFile.getParentFile();

		File ngramFile = new File(dir, "ngram_left.data");
		File ngramSort = new File(dir, "sort_ngram_left.data");
		File ngramfreq = new File(dir, "freq_ngram_left.data");
		File ngramFreqSort = new File(dir, "freq_ngram_left_sort.data");

		try (BufferedReader breader = Files.newReader(rawFile, Charsets.UTF_8);
				BufferedWriter writer = Files.newWriter(ngramFile, Charsets.UTF_8);
				BufferedWriter freqWriter = Files.newWriter(ngramfreq, Charsets.UTF_8);) {
			String line = null;
			while (null != (line = breader.readLine())) {
				line = line.replaceAll("\\p{Punct}", " ").replaceAll("\\pP", " ").replaceAll("　", " ")
						.replaceAll("\\p{Blank}", " ").replaceAll("\\p{Space}", " ").replaceAll("\\p{Cntrl}", " ")
						.replaceAll("[的很了么呢是嘛]", " ");
				for (String sen : Splitter.on(" ").omitEmptyStrings().splitToList(line)) {
					sen = reverse(sen.trim());
					sen = "$" + sen + "$";
					System.out.println(sen);
					System.out.println(sen.length());
					for (int i = 0; i < sen.length(); ++i) {
						for (int j = i + 1; j < i + maxLen + 1 && j <= sen.length(); ++j) {
							String w = sen.substring(i, j);
							writer.write(w + "\n");
						}
					}
				}
			}
			sortFile(ngramFile, ngramSort);

			try (BufferedReader nsr = Files.newReader(ngramSort, Charsets.UTF_8)) {

				String ngram = null;
				String curr = null;
				List<String> sameWord = Lists.newLinkedList();
				boolean pause = false;
				while (pause || null != (curr = nsr.readLine())) {
					if (null == ngram) {
						sameWord.add(curr);
						ngram = curr;
					} else {
						if (curr.startsWith(ngram)) {
							sameWord.add(curr);
							pause = false;
						} else {
							if (sameWord.isEmpty()) {
								pause = false;
								sameWord.add(curr);
								ngram = curr;
								continue;
							}
							CounterMap right = new CounterMap();
							int freq = 0;
							for (String w : sameWord) {
								if (!w.startsWith(ngram)) {
									break;
								}
								if (w.equals(ngram)) {
									continue;
								}
								++freq;
								right.incr(w.substring(ngram.length()));
							}
							double re = 0.0;
							for (String t : right.countAll().keySet()) {
								double p = right.get(t) * 1.0 / freq;
								re += -1 * p * Math.log(p);
							}
							freqWriter.write(reverse(ngram) + "\t" + re + "\n");
							List<String> newlist = Lists.newLinkedList();
							for (String w : sameWord) {
								if (!w.equals(ngram)) {
									newlist.add(w);
								}
							}
							sameWord = newlist;
							if (sameWord.isEmpty()) {
								pause = false;
								sameWord.add(curr);
								ngram = curr;
								continue;
							}
							ngram = sameWord.get(0);
							if (curr.startsWith(ngram)) {
								sameWord.add(curr);
								pause = false;
							} else {
								pause = true;
							}
						}
					}
				}
			}
			sortFile(ngramfreq, ngramFreqSort);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return ngramFreqSort.getAbsolutePath();
	}

	public String genFreqRight(String rawTextFile, int maxLen, int memSize) {
		File rawFile = new File(rawTextFile);
		File dir = rawFile.getParentFile();
		File ngramFile = new File(dir, "ngram.data");
		File ngramSort = new File(dir, "ngram_sort.data");
		File ngramfreq = new File(dir, "freq_ngram.data");
		File ngramfreqSort = new File(dir, "freq_ngram_sort.data");
		try (BufferedReader breader = Files.newReader(rawFile, Charsets.UTF_8);
				BufferedWriter writer = Files.newWriter(ngramFile, Charsets.UTF_8);
				BufferedWriter freqWriter = Files.newWriter(ngramfreq, Charsets.UTF_8);) {
			String line = null;
			while (null != (line = breader.readLine())) {
				line = line.replaceAll("\\p{Punct}", " ").replaceAll("\\pP", " ").replaceAll("　", " ")
						.replaceAll("\\p{Blank}", " ").replaceAll("\\p{Space}", " ").replaceAll("\\p{Cntrl}", " ")
						.replaceAll("[的很了么呢是嘛]", " ");
				for (String sen : Splitter.on(" ").omitEmptyStrings().splitToList(line)) {
					sen = sen.trim();
					sen = "$" + sen + "$";
					System.out.println(sen);
					System.out.println(sen.length());
					for (int i = 0; i < sen.length(); ++i) {
						for (int j = i + 1; j < i + maxLen + 1 && j <= sen.length(); ++j) {
							String w = sen.substring(i, j);
							writer.write(w + "\n");
						}
					}
				}
			}
			System.out.println("gen sorting...");
			sortFile(ngramFile, ngramSort);
			try (BufferedReader nsr = Files.newReader(ngramSort, Charsets.UTF_8)) {
				String ngram = null;
				String curr = null;
				List<String> sameWord = Lists.newLinkedList();
				boolean pause = false;
				while (pause || null != (curr = nsr.readLine())) {
					if (null == ngram) {
						sameWord.add(curr);
						ngram = curr;
					} else {
						if (curr.startsWith(ngram)) {
							sameWord.add(curr);
						} else {
							if (sameWord.isEmpty()) {
								pause = false;
								sameWord.add(curr);
								ngram = curr;
								continue;
							}
							CounterMap right = new CounterMap();
							int freq = 0;
							for (String w : sameWord) {
								if (!w.startsWith(ngram)) {
									break;
								}
								if (w.equals(ngram)) {
									continue;
								}
								++freq;
								right.incr(w.substring(ngram.length()));
							}
							double re = 0.0;
							for (String t : right.countAll().keySet()) {
								double p = right.get(t) * 1.0 / freq;
								re += -1 * p * Math.log(p);
							}
							freqWriter.write(ngram + "\t" + freq + "\t" + re + "\n");
							List<String> newlist = Lists.newLinkedList();
							for (String w : sameWord) {
								if (!w.equals(ngram)) {
									newlist.add(w);
								}
							}
							sameWord = newlist;
							if (sameWord.isEmpty()) {
								pause = false;
								sameWord.add(curr);
								ngram = curr;
								continue;
							}
							ngram = sameWord.get(0);
							if (curr.startsWith(ngram)) {
								sameWord.add(curr);
							} else {
								pause = true;
							}
						}
					}
				}
			}

			sortFile(ngramfreq, ngramfreqSort);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return ngramfreqSort.getAbsolutePath();
	}

	public String mergeEntropy(String freqRight, String left) {

		// Sorter sorter = new TextFileSorter(
		// new SortConfig().withMaxMemoryUsage(1024 * 1000 * 1000));

		File frFile = new File(freqRight);
		File lFile = new File(left);
		File mergeTmp = new File(frFile.getParentFile(), "merge.tmp");
		File mergeTmp2 = new File(frFile.getParentFile(), "merge.tmp2");
		File mergeFile = new File(frFile.getParentFile(), "merge_entropy.data");

		try (BufferedReader rr = Files.newReader(frFile, Charsets.UTF_8);
				BufferedReader lr = Files.newReader(lFile, Charsets.UTF_8);
				BufferedWriter mw = Files.newWriter(mergeTmp, Charsets.UTF_8);
				BufferedWriter mf = Files.newWriter(mergeFile, Charsets.UTF_8);) {
			String line = null;
			while (null != (line = rr.readLine())) {
				mw.write(line + "\n");
			}
			line = null;
			while (null != (line = lr.readLine())) {
				mw.write(line + "\n");
			}

			// sorter.sort(new FileInputStream(mergeTmp), new FileOutputStream(
			// mergeTmp2));
			sortFile(mergeTmp, mergeTmp2);

			BufferedReader br = Files.newReader(mergeTmp2, Charsets.UTF_8);

			String line1 = null;
			String line2 = null;
			line1 = br.readLine();
			line2 = br.readLine();
			while (true) {

				if (null == line1 || null == line2)
					break;
				String[] seg1 = line1.split("\t");
				String[] seg2 = line2.split("\t");
				if (!seg1[0].equals(seg2[0])) {
					line1 = new String(line2.getBytes());
					line2 = br.readLine();
					continue;
				}
				if (seg1.length < 2) {
					line1 = new String(line2.getBytes());
					line2 = br.readLine();
					continue;
				}
				double le = seg1.length == 2 ? Double.parseDouble(seg1[1]) : Double.parseDouble(seg2[1]);
				double re = seg1.length == 3 ? Double.parseDouble(seg1[2]) : Double.parseDouble(seg2[2]);
				int freq = seg1.length == 3 ? Integer.parseInt(seg1[1]) : Integer.parseInt(seg2[1]);
				double e = Math.min(le, re);
				mf.write(seg1[0] + "\t" + freq + "\t" + e + "\n");

				line1 = br.readLine();
				line2 = br.readLine();
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return mergeFile.toString();
	}

	public void extractWords(String freqFile, String entropyFile) {

		TreeMap<String, Integer> freq = new TreeMap<>();

		File ffile = new File(freqFile);
		File efile = new File(entropyFile);
		File wfile = new File(efile.getParentFile(), "words.data");

		try (BufferedReader fr = Files.newReader(ffile, Charsets.UTF_8);
				BufferedReader er = Files.newReader(efile, Charsets.UTF_8);
				BufferedWriter ww = Files.newWriter(wfile, Charsets.UTF_8);) {

			String line = null;
			while (null != (line = fr.readLine())) {
				String[] seg = line.split("\t");
				if (seg.length < 3)
					continue;
				freq.put(seg[0], Integer.parseInt(seg[1]));
			}
			line = null;
			while (null != (line = er.readLine())) {
				String[] seg = line.split("\t");
				if (3 != seg.length)
					continue;
				String w = seg[0];
				int f = Integer.parseInt(seg[1]);
				double e = Double.parseDouble(seg[2]);
				long max = -1;
				for (int s = 1; s < w.length(); ++s) {
					String lw = w.substring(0, s);
					String rw = w.substring(s);
					if (!freq.containsKey(lw) || !freq.containsKey(rw))
						continue;
					long ff = freq.get(lw) * freq.get(rw);
					if (ff > max)
						max = ff;
				}
				double pf = f * 2000000.0 / max;
				if (pf < 10 || e < 2)
					continue;
				ww.write(w + "\t" + pf + "\t" + e + "\n");
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
