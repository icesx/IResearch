package cn.i.xportal.jdp.prototype.deep;

import java.io.*;
import java.util.Date;

public class Monkey implements Cloneable, Serializable {
	private int height;
	private int weight;
	private GoldRingedStaff staff;
	private Date birthDate;

	public Monkey() {
		this.birthDate = new Date();
		this.staff = new GoldRingedStaff();
	}

	public Object deepClone() throws IOException, OptionalDataException, ClassNotFoundException {
		// write to stream
		ByteArrayOutputStream bo = new ByteArrayOutputStream();
		ObjectOutputStream oo = new ObjectOutputStream(bo);
		oo.writeObject(this);

		// read from stream
		ByteArrayInputStream bi = new ByteArrayInputStream(bo.toByteArray());
		ObjectInputStream oi = new ObjectInputStream(bi);

		return (oi.readObject());
	}

	public Object clone() {
		Monkey temp = null;
		try {
			temp = (Monkey) super.clone();
		} catch (CloneNotSupportedException e) {
			System.out.println("Clone failed");
		} finally {
			return temp;
		}
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public GoldRingedStaff getStaff() {
		return staff;
	}
}
