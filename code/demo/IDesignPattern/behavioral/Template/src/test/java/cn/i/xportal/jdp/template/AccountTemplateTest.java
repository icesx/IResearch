package cn.i.xportal.jdp.template;

import com.javapatterns.templatemethod.InterestRate.Account;
import com.javapatterns.templatemethod.InterestRate.CDAccount;
import com.javapatterns.templatemethod.InterestRate.MoneyMarketAccount;

public class AccountTemplateTest {
	private static Account acct = null;

	public static void main(String[] args) {
		acct = new MoneyMarketAccount();
		System.out.println("Interest earned from Money Market account = " + acct.calculateInterest());
		acct = new CDAccount();
		System.out.println("Interest earned from CD account = " + acct.calculateInterest());
	}
}
