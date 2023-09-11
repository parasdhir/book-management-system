package com.example.bookmanagementback;

public class Books {

	private int id;
	private String name;
	private String author;
	private String genre;
	private int numberofpages;
	private int price;
	private int rating;
	
	public Books() {
		
	}
	public Books(String name, String author, String genre, int numberofpages, int price, int rating) {
		super();
		this.name = name;
		this.author = author;
		this.genre = genre;
		this.numberofpages = numberofpages;
		this.price = price;
		this.rating = rating;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public int getNumberofpages() {
		return numberofpages;
	}
	public void setNumberofpages(int numberofpages) {
		this.numberofpages = numberofpages;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	
	@Override
	public String toString() {
		return "Books [id=" + id + ", name=" + name + ", author=" + author + ", genre=" + genre + ", numberofpage="
				+ numberofpages + ", price=" + price + ", rating=" + rating + "]";
	}
	
	
}
