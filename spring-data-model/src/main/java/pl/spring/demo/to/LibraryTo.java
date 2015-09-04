package pl.spring.demo.to;

import java.util.Set;

import pl.spring.demo.enums.LibraryType;

public class LibraryTo {
    private Long id;
    private String name;
    private AddressTo address;
    private Set<BookTo> books;
    private long version;
    private LibraryType typeL;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AddressTo getAddress() {
        return address;
    }

    public void setAddress(AddressTo address) {
        this.address = address;
    }

    public Set<BookTo> getBooks() {
        return books;
    }

    public void setBooks(Set<BookTo> books) {
        this.books = books;
    }

    public long getVersion() {
        return version;
    }

    public void setVersion(long version) {
        this.version = version;
    }

	public LibraryType getTypeL() {
		return typeL;
	}

	public void setTypeL(LibraryType typeL) {
		this.typeL = typeL;
	}
}
