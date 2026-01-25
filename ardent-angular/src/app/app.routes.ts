import { Routes } from '@angular/router';
import { RefundPolicies } from './pages/refund-policies/refund-policies';
import { AboutUs } from './pages/about-us/about-us';
import { AddBook } from './pages/add-book/add-book';
import { Contact } from './pages/contact/contact';
import { Seller } from './pages/seller/seller';
import { Admin } from './pages/admin/admin';
import { Books } from './pages/books/books';
import { Reviews } from './pages/reviews/reviews';
import { PrivacyPolicies } from './pages/privacy-policies/privacy-policies';
import { TermAndConditions } from './pages/term-and-conditions/term-and-conditions';
import { Carousel } from './components/carousel/carousel';
import { Home } from './pages/home/home';

export const routes: Routes = [
    {
        path:"",
        component:Home
    },
    {
        path:"refundPolifies",
        component:RefundPolicies
    },
    {
        path:"aboutUs",
        component:AboutUs
    },
    {
        path:"addBook",
        component:AddBook
    },
    {
        path:"contact", 
        component:Contact
    },
    {
        path:"seller",
        component:Seller
    },{
        path:"admin",
        component:Admin
    },{
        path:"books", 
        component:Books
    },{
        path:"reviews",
        component:Reviews
    },{
        path:"privacyPolicy",
        component:PrivacyPolicies
    },{
        path:"refund",
        component:RefundPolicies
    },{
        path:"termsConditions",
        component:TermAndConditions
    }
    
    
];
