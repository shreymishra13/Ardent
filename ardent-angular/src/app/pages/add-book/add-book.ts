import { CommonModule } from '@angular/common';
import { HttpClient } from '@angular/common/http';
import { Component, inject, OnInit } from '@angular/core';

@Component({
  selector: 'app-add-book',
  imports: [CommonModule],
  standalone: true, 
  templateUrl: './add-book.html',
  styleUrl: './add-book.css',
})
export class AddBook implements OnInit {

  private http = inject(HttpClient);

  genres : any[] = [] ;
  ngOnInit(): void {
    this.getAllGenres();
  }

  getAllGenres(){
    this.http.get("http://localhost:8080/genres").subscribe((res : any)=>{
      console.log('API Response:', res);
      this.genres = res.data || res;
      console.log('Genres set to:', this.genres);
    })
  }


}
