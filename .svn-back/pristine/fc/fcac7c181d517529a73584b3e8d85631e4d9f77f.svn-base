package com.javapatterns.multilingual;

import java.util.HashMap;
import java.util.Locale;
import java.util.ResourceBundle;
import java.io.UnsupportedEncodingException;

public class LingualResource
{
    private String language = "en";
    private String region = "US";
    private String localeCode = "en_US";
    private static final String FILE_NAME = "res";

    private static HashMap instances = new HashMap(19);
    private Locale locale = null;
    private ResourceBundle resourceBundle = null;

    private LingualResource(String language, String region)
    {
        localeCode = language;
        this.region = region;
        localeCode = makeLocaleCode(language , region);

        locale = new Locale(language, region);

        resourceBundle = ResourceBundle.getBundle(FILE_NAME, locale);

        instances.put(makeLocaleCode(language, region), this);
    }

    private LingualResource()
    {
        //do nothing
    }

    public synchronized static LingualResource getInstance(String language, String region)
    {
        if (instances.containsKey(makeLocaleCode(language, region )))
        {
            return (LingualResource) instances.get(makeLocaleCode(language, region ));
        }
        else
        {
            return new LingualResource(language, region);
        }
    }

    public String getLocaleString(String code) throws Exception
    {
        return LingualResource.utf8ToUcs2(resourceBundle.getString(code));
    }

    private static String makeLocaleCode(String language, String region)
    {
        return language + "_" + region;
    }
	/**
	 * This method will convert a ucs2 string to a utf8 string.
	 * @return java.lang.String
	 * @param utf8String java.lang.String
	 */
	private static String ucs2ToUtf8(String ucs2String) throws UnsupportedEncodingException
	{

		if(ucs2String == null || ucs2String.length() == 0)
			return ucs2String;

		String utf8String = new String(ucs2String.getBytes("utf-8"));
		return utf8String;
	}
	/**
	 * This method will convert a utf8 string to a ucs2 string.
	 * @return java.lang.String
	 * @param utf8String java.lang.String
	 */
	private static String utf8ToUcs2(String utf8String) throws UnsupportedEncodingException
	{

		if(utf8String == null || utf8String.length() == 0)
		{
			return utf8String;
		}

		int len = utf8String.length();
		byte[] utf8Bytes = new byte[len];
		for (int i = 0; i < len; i++)
		{
			utf8Bytes[i] = (byte)utf8String.charAt(i);
		}
		String ucs2String = new String(utf8Bytes, "utf-8");
		return ucs2String;
	}

}

