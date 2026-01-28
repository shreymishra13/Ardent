import { HttpClient } from '@angular/common/http';
import { Component, inject } from '@angular/core';
import { FormControl, ReactiveFormsModule, Validators } from '@angular/forms';
import { ApiResponse } from '../../models/api-response.model';
import { CommonModule } from '@angular/common';


@Component({
  selector: 'app-contact',
  imports: [ReactiveFormsModule, CommonModule],
  templateUrl: './contact.html',
  styleUrl: './contact.css',
})
export class Contact {

 name = new FormControl('', [Validators.required, Validators.minLength(2)]);
email = new FormControl('', [Validators.required, Validators.email]);
contact = new FormControl('', [Validators.required, Validators.pattern(/^\d{10}$/)]);
message = new FormControl('', [Validators.required, Validators.minLength(10)]);

  private http = inject(HttpClient);

  apiResponse: ApiResponse<any> | undefined ;

  submitForm(){
    // Validate all fields
    if(this.name.invalid || this.email.invalid || this.contact.invalid || this.message.invalid) {
      return;
    }

    const messageRequest = {
      name : this.name.value,
      email : this.email.value,
      contact : this.contact.value,
      message : this.message.value
    }

    this.http.post("http://localhost:8080/api/contact" , 
      messageRequest
    ).subscribe((res : any)=>{
        this.apiResponse = res;
        // Clear the form after successful submission
        this.clearForm();
    

    })
  }

  clearForm(){
    this.name.reset();
    this.email.reset();
    this.contact.reset();
    this.message.reset();
  }

}
