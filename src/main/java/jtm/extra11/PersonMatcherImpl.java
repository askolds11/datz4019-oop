package jtm.extra11;

import jtm.activity03.RandomPerson;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

public class PersonMatcherImpl implements PersonMatcher {
    List<RandomPerson> randomPersons;

    public PersonMatcherImpl() {
        randomPersons = new LinkedList<>();
    }

    @Override
    public void addPerson(RandomPerson person) {
        randomPersons.add(person);
    }

    @Override
    public List<RandomPerson> getPersonList() {
        return randomPersons;
    }

    @Override
    public Stream<RandomPerson> getPersonStream() {
        return randomPersons.stream();
    }
}
