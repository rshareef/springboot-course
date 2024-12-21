package guru.springframework.spring6webapp.repositories;

import guru.springframework.spring6webapp.domain.Book;
import org.springframework.data.repository.CrudRepository;

// same concept as written in 'AuthorRepository'.
// Book = domain type managed by the repository
// Long = type of the id of the entities managed by the repository (i.e. id field of 'Book' entities are of type 'long').
public interface BookRepository extends CrudRepository<Book, Long> {
    // the interface BookRepository extends, the interface CrudRepository with the generics Book and Long.
    // we DO NOT have to provide any implementation in these interfaces as the Spring Data JPA will detect these as spring components
    // and generate inherited method implementations at runtime.
}
