package photos.brooklyn.learn.springproperties.repo;

import photos.brooklyn.learn.springproperties.model.Person;

import java.util.List;

public interface DbRepo {
    List<Person> findPeople();
}
