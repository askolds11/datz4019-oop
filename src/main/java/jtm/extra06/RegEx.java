package jtm.extra06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegEx {

	/**
	 * This method finds out if we can make lucky number from numbers in input
	 * string. Lucky number is number with digit sum equal to 25
	 * 
	 * @param string
	 *            , needed to be checked
	 * @return true if numbers in this number are lucky, false if not.
	 */
	public boolean isLuckyNumber(String input) {

		// TODO #1 Remove all non digits from the input.
		// HINT: use negation pattern.

		// TODO #2 count the sum of all digits, and check if the sum is lucky
		return false;

	}

	/**
	 * This method finds Kenny or Kelly hiding in this list. "Kenny" or "Kelly" can be written with
	 * arbitrary number of "n"s or "l"s starting with two.
	 * 
	 * @param input
	 *            — input string
	 * @return — position of "Kenny" string starting with zero. If there are no
	 *         "Ken..ny" return -1.
	 */
	public int findKenny(String input) {
		return -1;
	}

	/**
	 * THis method checks if input string is correct telephone number. Correct
	 * Riga phone number starts with 67 or 66 and is followed by 6 other digits.
	 * not obligate prefix +371
	 * 
	 * @param telephoneNumber
	 *            - number, needed to be checked.
	 * @return true if number is valid Riga city number.
	 */
	public boolean isGood(String telephoneNumber) {
		// TODO #5 check with "matches" method if this number is valid.
		return false;
	}
}
