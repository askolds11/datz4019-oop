package jtm.extra11;

import jtm.activity03.RandomPerson;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public interface PersonMatcher {

	void addPerson(RandomPerson person);

	List<RandomPerson> getPersonList();

	Stream<RandomPerson> getPersonStream();

	default Stream<RandomPerson> getMatchedPersonStream(
			Stream<RandomPerson> persons,
			boolean isFemale,
			int ageFrom,
			int ageTo,
			float weightFrom,
			float weightTo
	) {
		return persons
				.filter(person -> person.isFemale() == isFemale)
				.filter(person -> person.getAge() >= ageFrom && person.getAge() <= ageTo)
				.filter(person -> person.getWeight() >= weightFrom && person.getWeight() <= weightTo);
	}

	static List<RandomPerson> getPersonList(Stream<RandomPerson> persons) {
		return persons.collect(Collectors.toList());
	}

	static PersonMatcher getPersonManager() {
		return new PersonMatcherImpl();
	}

}
