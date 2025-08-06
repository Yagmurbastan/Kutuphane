package Model;
import Model.Book;
import Model.BookRepository;
import Model.BookService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookRepository {
private Map<Integer,Book>bookMap=new HashMap<>();
public void addBook(Book book) {
	bookMap.put(book.getId(), book);
}
public void deleteBook(int id) {
	bookMap.remove(id);
}
public void updateBook(Book book) {
	bookMap.put(book.getId(), book);
}
public Book getBookById(int id) {
	return bookMap.get(id);
}
public List<Book>getAllBook(){
	return new ArrayList<>(bookMap.values()) ;
}
public boolean exists(int id) {
	// TODO Auto-generated method stub
	return bookMap.containsKey(id);
}
}
