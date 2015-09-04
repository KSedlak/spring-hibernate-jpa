package pl.spring.demo.entity;

import javax.persistence.*;

import pl.spring.demo.enums.LibraryType;

import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "LIBRARY")
public class LibraryEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @OneToOne(optional = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "address_id", nullable = true)
    private AddressEntity address;
    @OneToMany(mappedBy = "library", orphanRemoval = false, cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private Set<BookEntity> books;
    @Version
    private long version;
   @Enumerated(EnumType.STRING)
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

    public AddressEntity getAddress() {
        return address;
    }

    public void setAddress(AddressEntity address) {
        this.address = address;
    }

    public Set<BookEntity> getBooks() {
        return books;
    }

    public void setBooks(Set<BookEntity> books) {
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
