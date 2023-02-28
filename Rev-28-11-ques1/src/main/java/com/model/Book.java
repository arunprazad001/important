package com.model;

import javax.persistence.*;

import lombok.*;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Book {

@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private int BookId ;
private String name;
private String author;
private String publication;
private String category;
private int pages;
private int price;
	
}
