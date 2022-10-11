import { CommonModule } from '@angular/common';
import { Component, NgModule, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { CartService } from '../cart/cart.service';
import { BookDetail } from '../model';
import { BooksDetailService } from './books-detail.service';


@Component({
  selector: 'app-books-detail',
  templateUrl: './books-detail.component.html',
  styleUrls: ['./books-detail.component.css']
})


export class BooksDetailComponent implements OnInit {

  constructor(private activatedRoute: ActivatedRoute, private booksDetailSvc: BooksDetailService,
              private router : Router, private cartSvc : CartService) { }

  bookID!: string
  // bookDetailFromId !: BookDetail
  bookDetailFromId: BookDetail = {
    genre: "",
    title: "",
    edition: "",
    authors: "",
    format: "",
    description: "",
    price: 0,
    pages: 0,
    rating: 0,
    book_id: 0,
    bookPhoto: ""
  }
  

  ngOnInit(): void {
    this.bookID = this.activatedRoute.snapshot.params['book_id']
    console.info("Book id being passed: ", this.bookID)
    this.booksDetailSvc.getBookDetailById(this.bookID)
      .then(result => {
        console.info("result from calling the individual Id: ", result)
        this.bookDetailFromId = result
       
        
      })
      .catch(error => {
        console.info("error getting detail from Id : ", error)
      })
    
  }

  navigateBack() {
    this.router.navigate(['books-list'])
  }

  addItem() {
    console.info(">>>> add to cart button pressed")
    this.cartSvc.addToCart(this.bookDetailFromId)
  }

}
