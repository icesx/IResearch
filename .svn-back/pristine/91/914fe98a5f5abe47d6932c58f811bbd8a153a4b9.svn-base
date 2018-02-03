package com.javapatterns.multilingual;

public class LingualResourceTester
{
    public static void main(String[] args) throws Exception
    {
		LingualResource ling = LingualResource.getInstance("en" , "US");

        String usDollar = ling.getLocaleString("USD");

        System.out.println("USD in English=" + usDollar);

		LingualResource lingZh = LingualResource.getInstance("zh" , "CH");

        String usDollarZh = lingZh.getLocaleString("USD");

        System.out.println("USD in Chinese=" + usDollarZh);
    }
}

