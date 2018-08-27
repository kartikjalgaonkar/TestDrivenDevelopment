package yash.trainging.tdd;

import java.util.regex.Pattern;

public class PasswordVarifier {
	public boolean verify(String password) {
		Pattern mustContainSmallLetterPattern = Pattern.compile("[a-z]");
		Pattern capitalPattern = Pattern.compile("[A-Z]");
		Pattern digitPattern = Pattern.compile("[0-9]");
		Pattern lengthPattern = Pattern.compile("\\w{9,}");
		int count = 0;

		if (password == null)
			throw new RuntimeException("Password cannot be null");

		if (mustContainSmallLetterPattern.matcher(password).find()) {
			if (capitalPattern.matcher(password).find())
				count++;
			else if (digitPattern.matcher(password).find())
				count++;
			else if (lengthPattern.matcher(password).find())
				count++;
		} else
			throw new RuntimeException("Password must contain atleast one small letter");
		if (count == 1)
			return true;
		else
			throw new RuntimeException("Password is not OK");

	}

}
