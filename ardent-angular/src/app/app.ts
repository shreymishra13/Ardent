import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { Navbar } from "./layout/navbar/navbar";
import { Carousel } from "./components/carousel/carousel";
import { Footer } from "./components/footer/footer";

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, Navbar, Carousel, Footer],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
  protected title = 'ardent-angular';
}
