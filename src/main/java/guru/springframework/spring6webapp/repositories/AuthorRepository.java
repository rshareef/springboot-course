// package to contain all Sprig Data Repositories used.
package guru.springframework.spring6webapp.repositories;


import guru.springframework.spring6webapp.domain.Author;
import org.springframework.data.repository.CrudRepository;

/*
interfaces extend other interfaces.
'AuthorRepository' will inherit methods declared in 'CrudRepository' and is also allowed to have its own abstract methods.
Spring Data JPA Framework will automatically provide implementations for the methods at runtime.

"CrudRepository is a part of the Spring Data JPA framework, which provides a set of predefined methods
for performing basic CRUD (Create, Read, Update, Delete) operations on entities in a database."
*/
public interface AuthorRepository extends CrudRepository<Author, Long> {
    // ensure to set up generics for the CrudRepository: <T, ID> as <Author, Long>. (Ctrl + Click on CrudRepository nterface to see source code).

}
