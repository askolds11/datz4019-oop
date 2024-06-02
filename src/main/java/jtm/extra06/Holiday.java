package jtm.extra06;

/**
 * This enum represents holidays, displayed as month + day value. This enum can
 * give nearest holiday.
 */
public enum Holiday {
	NEW_YEAR(1, 1), WOMAN_DAY(3, 8), CHUCK_NORRIS_BIRTHSDAY(3, 10), FOOLS_DAY9(4, 1), WORLD_END(12, 21);
	int month;
	int day;

	Holiday(int month, int day) {
		// #1 implement class variables for month and day of the holiday
		this.month = month;
		this.day = day;
	}

	public static Holiday getNearest(int currentMonth, int currentDay) {
		Holiday returnHoliday = Holiday.NEW_YEAR;
		for (Holiday h: Holiday.values()) {
			if (h.getMonth() > currentMonth) {
				return h;
			} else if (h.getDay() > currentDay) {
				return h;
			}
		}

		// #2 implement method which will return the nearest holiday.
		// HINT: note, that holidays is arranged by date ascending, so if there
		// are
		// no more holidays this year, first holiday in the list will be the
		// next.

		return returnHoliday;
	}

	public int getMonth() {
		return month;
	}

	public int getDay() {
		return day;
	}
}
