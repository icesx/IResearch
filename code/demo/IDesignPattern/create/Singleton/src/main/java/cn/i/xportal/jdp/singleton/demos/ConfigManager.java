package cn.i.xportal.jdp.singleton.demos;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

/**
 * Only once instance of the class may be created during the execution of any
 * given program. Instances of this class should be aquired through the
 * getInstance() method. Notice that there are no public constructors for this
 * class.
 */
public class ConfigManager {
	/** The fully qualified name of the properties file */
	private static final String PFILE = System.getProperty("user.dir") + "/Singleton.properties";

	/**
	 * The File object corresponding to the file that contains the properties
	 */
	private File mFile = null;

	/** The last modified time of the properties file */
	private long mLastModifiedTime = 0;

	/** The cached properties */
	private Properties mProps = null;

	/**
	 * The only instance of this class
	 * 
	 * @label Creates
	 */
	private static ConfigManager mInstance = new ConfigManager();

	/** The private constructor (enforces single instance) */
	private ConfigManager() {
		mFile = new File(PFILE);
		mLastModifiedTime = mFile.lastModified();

		if (mLastModifiedTime == 0) {
			System.err.println(PFILE + " file does not exist!");
		}

		mProps = new Properties();

		try {
			mProps.load(new FileInputStream(PFILE));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Returns the singleton ConfigManager
	 * 
	 * @return The one and only instance of the ConfigManager
	 */
	public static synchronized ConfigManager getInstance() {
		return mInstance;
	}

	/**
	 * Gets a configuration item
	 * 
	 * @param name
	 *            The name of the item
	 * @param defaultVal
	 *            The default value if name is not found
	 * @return The value for the specified name
	 */
	public final Object getConfigItem(String name, Object defaultVal) {
		long newTime = mFile.lastModified();

		// Check to see if configuration file has been modified
		// since the previous request. If so, then read in the new
		// contents
		if (newTime == 0) {
			// The props file was deleted or does not exist (!!)
			if (mLastModifiedTime == 0) {
				System.err.println(PFILE + " file does not exist!");
			} else {
				System.err.println(PFILE + " file was deleted!!");
			}
			return defaultVal;
		} else if (newTime > mLastModifiedTime) {
			mProps.clear(); // Get rid of the old properties
			try {
				mProps.load(new FileInputStream(PFILE));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		mLastModifiedTime = newTime;

		Object val = mProps.getProperty(name);
		if (val == null) {
			return defaultVal;
		} else {
			return val;
		}
	}
}
