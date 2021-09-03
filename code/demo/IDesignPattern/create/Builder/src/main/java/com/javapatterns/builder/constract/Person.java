/**
 * Program  : Person.java<br/>
 * Author   : i<br/>
 * Create   : Mar 28, 2017 5:14:22 PM<br/>
 *
 * Copyright 1997-2013 by III.cn ltd.,
 * All rights reserved.
 */
package com.javapatterns.builder.constract;

public class Person {
	private String name, sex, sity, eage;

	public static class Builder {
		private String name, sex, sity, eage;

		public Builder name(String name) {
			this.name = name;
			return this;
		}

		public Builder sex(String sex) {
			this.sex = sex;
			return this;
		}

		public Builder city(String city) {
			this.sity = city;
			return this;
		}

		public Builder eage(String eage) {
			this.eage = eage;
			return this;
		}

		public Person build() {
			return new Person(name, sex, sity, eage);
		}
	}

	private Person(String name2, String sex2, String sity2, String eage2) {
		this.name = name2;
		this.sex = sex2;
		this.sity = sity2;
		this.eage = eage2;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getSity() {
		return sity;
	}

	public void setSity(String sity) {
		this.sity = sity;
	}

	public String getEage() {
		return eage;
	}

	public void setEage(String eage) {
		this.eage = eage;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", sex=" + sex + ", sity=" + sity + ", eage=" + eage + "]";
	}

	public static Builder builder() {
		return new Builder();
	}
}
