package Model;
import Model.BookStatus;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
Scanner scanner=new Scanner(System.in);
BookRepository repository= new BookRepository();
BookService service= new BookService(repository);
while(true) {
	System.out.println("Kütüphane sistemine hoşgeldiniz:");
	System.out.println("1.Kitap ekle");
	System.out.println("2.kitap sil");
	System.out.println("3.kitapları listele");
	System.out.println("4.kitap ara başlığa göre");
	System.out.println("5.kitap ara yazara göre");
	System.out.println("6.kitap ödünç al");
	System.out.println("7.kitabı iade et");
	System.out.println("8.Çıkış");
	System.out.println("Seçiminiz:");
	int secim=scanner.nextInt();
	scanner.nextLine();
	switch(secim) {
	case 1:
			System.out.println("Kitap id giriniz:");
			int id=scanner.nextInt();
			scanner.nextLine();
			System.out.println("Kitap ismi giriniz:");
			String baslik=scanner.nextLine();
			System.out.println("Kitap yazar ismi griniz:");
			String yazar=scanner.nextLine();
			Book book=new Book(id,baslik,yazar,BookStatus.AVAILABLE);
			if(service.addBook(book)) {
				System.out.println("Başarıyla eklendi");
			}
			else {
				System.out.println("zaten vae");}
				break;
			
	case 2:
		System.out.println("Silmek istediğiniz id giriniz:");
	
		int deleteId=scanner.nextInt();
		scanner.nextLine();
		if(service.deleteBook(deleteId)) {
			System.out.println("Başarıyla silindi");
		}
		else {
			System.out.println("zaten yok");
		}
		break;
	case 3:
		service.printAllBooks();
		break;
	case 4:
		System.out.println("aranacak başlık:");	
		String searchBaslik=scanner.nextLine();
		for(Book b:service.searchByBaslik(searchBaslik)) {
			System.out.println(b);
		}
		break;
	case 5:
		System.out.println("Yazara göre arama");
		String searchYazar=scanner.nextLine();
		for(Book b:service.searchByYazar(searchYazar)) {
			System.out.println(b);
		}
		break;
	case 6:
		System.out.println("Ödünç almak istesiğiniz kitap idsi:");
		int borrowId=scanner.nextInt();
		scanner.nextLine();
		if(service.borrowBook(borrowId)) {
			System.out.println("Başarıyla ödünç alındı");
			
		}
		else {
			System.out.println("Hayır");
		}
		break;
	case 7:
		System.out.println("iade etmek istediğiniz kitap idsi:");
		int returnId=scanner.nextInt();
		scanner.nextLine();
		if(service.returnBook(returnId)) {
			System.out.println("İade edildi");
		}
		else {
			System.out.println("Hayır");
		}
		break;
	case 8:
		System.out.println("Programdan çıkılıyır");
		System.exit(0);
		default:
			System.out.println("Seçim yapmadınız lğtfen yapınız");
}
	}

}
	}
