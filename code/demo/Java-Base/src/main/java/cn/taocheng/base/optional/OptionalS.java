package cn.taocheng.base.optional;

import java.util.Optional;

public class OptionalS {
	public static String getChampionName(UserEntity comp) throws IllegalArgumentException {
		return Optional.ofNullable(comp).map(c -> c.getNickName()).orElseThrow(
				() -> new IllegalArgumentException("The value of param comp isn't available."));
	}

	public static String getName(UserEntity u) {
		return Optional.ofNullable(u).map(user -> user.getUserName()).orElse("Unknown");
	}

	public static String setName(String name) throws IllegalArgumentException {
		return Optional.ofNullable(name).filter(UserEntity::isNameValid).orElseThrow(
				() -> new IllegalArgumentException("Invalid username."));
	}
}
