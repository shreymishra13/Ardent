import { CommonModule } from '@angular/common';
import { HttpClient } from '@angular/common/http';
import { Component, inject, OnInit } from '@angular/core';

@Component({
  selector: 'app-sign-up',
  standalone : true ,
  imports: [CommonModule],
  templateUrl: './sign-up.html',
  styleUrl: './sign-up.css',
})
export class SignUp implements OnInit{

  private http  = inject(HttpClient);
  roles : any[] = [];
  ngOnInit() : void {

      this.getRoles();

  }

  getRoles(){
    this.http.get("http://localhost:8080/roles").subscribe((res : any)=>{
      this.roles = res;
      console.log(this.roles);

    })
  }



}
