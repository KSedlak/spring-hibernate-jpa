package pl.spring.demo.searchcriteria;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import pl.spring.demo.enums.LibraryType;

public class LibrarySearchCriteria implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
    private String name;
    private LibraryType type;
    
    public LibraryType getType() {
		return type;
	}

	public void setType(LibraryType type) {
		this.type = type;
	}

	private Set<String> anyBook = new HashSet<>();

    private LibrarySearchCriteria() {

    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Set<String> getAnyBook() {
        return new HashSet<>(anyBook);
    }

    public static class LibrarySearchCriteriaBuilder {
        private LibrarySearchCriteria librarySearchCriteria = new LibrarySearchCriteria();

        public LibrarySearchCriteriaBuilder witId(long id) {
            librarySearchCriteria.id = id;
            return this;
        }

        public LibrarySearchCriteriaBuilder withName(String name) {
            librarySearchCriteria.name = name;
            return this;
        }

        public LibrarySearchCriteriaBuilder withBook(String bookTitile) {
            librarySearchCriteria.anyBook.add(bookTitile);
            return this;
        }
        
        public LibrarySearchCriteriaBuilder withType(LibraryType type) {
            librarySearchCriteria.type=type;
            return this;
        }

        public LibrarySearchCriteria build() {
            return librarySearchCriteria;
        }
    }
}
