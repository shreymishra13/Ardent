import { CommonModule } from '@angular/common';
import { HttpClient } from '@angular/common/http';
import { Component, inject, OnInit } from '@angular/core';

@Component({
  selector: 'app-books',
  standalone:true,
  imports: [CommonModule],
  templateUrl: './books.html',
  styleUrl: './books.css',
})
export class Books implements OnInit{

  private http = inject(HttpClient);

  books : any[] = [];
  ngOnInit(): void {

    this.getAllBooks();

    
  }

  getAllBooks(){
    this.http.get("http://localhost:8080/books").subscribe((res : any)=>{
      this.books = res.data;
      console.log(this.books);
    })
  }
  

}
