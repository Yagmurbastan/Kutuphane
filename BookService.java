package Model;
import java.util.ArrayList;
import java.util.List;
import Model.BookStatus;

public class BookService {

    private BookRepository repository;

    public BookService(BookRepository repository) {
        this.repository = repository;
    }

    public boolean addBook(Book book) {
        if (repository.exists(book.getId())) {
            return false;
        }
        repository.addBook(book);
        return true;
    }

    public boolean deleteBook(int id) {
        if (repository.exists(id)) {
            repository.deleteBook(id);
            return true;
        }
        return false;
    }

    public boolean borrowBook(int id) {
        Book book = repository.getBookById(id);
        if (book == null) {
            return false;
        }
        if (book.getStatus() == BookStatus.BORROWED) {
            return false;
        }
        book.setStatus(BookStatus.BORROWED);
        repository.updateBook(book);
        return true;
    }

    public boolean returnBook(int id) {
        Book book = repository.getBookById(id);
        if (book == null) {
            return false;
        }
        if (book.getStatus() == BookStatus.AVAILABLE) {
            return false;
        }
        book.setStatus(BookStatus.AVAILABLE);
        repository.updateBook(book);
        return true;
    }

    public List<Book> searchByBaslik(String baslik) {
        List<Book> allBooks = repository.getAllBook();
        List<Book> result = new ArrayList<>();

        for (Book book : allBooks) {
            if (book.getBaslik().contains(baslik)) {
                result.add(book);
            }
        }
        return result;
    }

    public List<Book> searchByYazar(String yazar) {
        List<Book> allBooks = repository.getAllBook();
        List<Book> result = new ArrayList<>();

        for (Book book : allBooks) {
            if (book.getYazar().contains(yazar)) {
                result.add(book);
            }
        }
        return result;
    }

    public void printAllBooks() {
        List<Book> books = repository.getAllBook();
        if (books.isEmpty()) {
            System.out.println("Kütüphanede kitap yok.");
        } else {
            for (Book book : books) {
                System.out.println(book);
            }
        }
    }
}

