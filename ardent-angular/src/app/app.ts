import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { Navbar } from "./layout/navbar/navbar";
import { Carousel } from "./components/carousel/carousel";

import { AboutUs } from "./pages/about-us/about-us";
import { PrivacyPolicies } from "./pages/privacy-policies/privacy-policies";
import { RefundPolicies } from "./pages/refund-policies/refund-policies";
import { TermAndConditions } from "./pages/term-and-conditions/term-and-conditions";
import { AddBook } from "./pages/add-book/add-book";
import { Footer } from './layout/footer/footer';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, Navbar, AddBook , Footer],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
  protected title = 'ardent-angular';
}
