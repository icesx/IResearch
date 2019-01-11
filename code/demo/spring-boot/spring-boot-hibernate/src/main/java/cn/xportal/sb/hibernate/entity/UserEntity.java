package cn.xportal.sb.hibernate.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "users")
public class UserEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id", nullable = false)
	private Long id;

	@Column(name = "userName")
	private String userName;

	@Column(name = "passWord")
	private String passWord;

	@Enumerated(EnumType.STRING)
	@Column(name = "user_sex")
	private UserSexEnum userSex;

	@Column(name = "nick_name")
	private String nickName;

	public UserEntity() {
	}

	public UserEntity(String userName, String passWord, UserSexEnum userSex) {
		this.passWord = passWord;
		this.userName = userName;
		this.userSex = userSex;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public UserSexEnum getUserSex() {
		return userSex;
	}

	public void setUserSex(UserSexEnum userSex) {
		this.userSex = userSex;
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
				+ ", userSex="
				+ userSex
				+ ", nickName="
				+ nickName
				+ "]";
	}

	public static UserEntity empty() {
		return new UserEntity();
	}

}