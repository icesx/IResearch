package cn.taocheng.base.optional;

import java.io.Serializable;

public class UserEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;

	private String userName;

	private String passWord;

	private String nickName;

	public Long getId() {
		return id;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	@Override
	public String toString() {
		return "UserEntity [id=" + id
				+ ", userName="
				+ userName
				+ ", passWord="
				+ passWord
				+ ", nickName="
				+ nickName
				+ "]";
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public UserEntity setUserName(String userName) {
		this.userName = userName;
		return this;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public static boolean isNameValid(String name) {
		return true;
	}

}