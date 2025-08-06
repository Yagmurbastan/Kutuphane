package Model;
import Model.Book;
import Model.BookRepository;
import Model.BookService;

public class Book {

private int id;
private String baslik;
private String yazar;
private BookStatus status;
public Book(int id,String baslik,String yazar,BookStatus status) {
this.baslik=baslik;	
this.yazar=yazar;
this.id=id;
this.status=BookStatus.AVAILABLE;
}
public int getId() {
	return id;
}
public String getBaslik() {
	return baslik;
}
public BookStatus getStatus() {
	return status;
}
public void setStatus(BookStatus status) {
	this.status=status;
}
public String getYazar() {
	return yazar;
}
@Override
public String toString() {
	return baslik+ " " +yazar +" "+id+" "+  status;
}
}
