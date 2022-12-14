import { CommonModule } from '@angular/common';
import { Component, NgModule, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { CartService } from '../cart/cart.service';
import { BookDetail } from '../model';
import { BooksDetailService } from './books-detail.service';
import { DecimalPipe } from '@angular/common';


@Component({
  selector: 'app-books-detail',
  templateUrl: './books-detail.component.html',
  styleUrls: ['./books-detail.component.css']
})


export class BooksDetailComponent implements OnInit {

  constructor(private activatedRoute: ActivatedRoute, private booksDetailSvc: BooksDetailService,
              private router : Router, private cartSvc : CartService, private _decimalPipe: DecimalPipe) { }

  bookID!: string
  rating!: any
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
    pic: new Blob()
    
  }
  

  ngOnInit(): void {
    this.bookID = this.activatedRoute.snapshot.params['book_id']
    
    console.info("Book id being passed: ", this.bookID)
    this.booksDetailSvc.getBookDetailById(this.bookID)
      .then(result => {
        console.info("result from calling the individual Id: ", result)
        this.bookDetailFromId = result
        this.rating = this.transformDecimal(result.rating)
        
      })
      .catch(error => {
        console.info("error getting detail from Id : ", error)
      })
    
  }

  transformDecimal(rating: number) {
    return this._decimalPipe.transform(rating, '1.2-2' )
  }


  navigateBack() {
    this.router.navigate(['books-list'])
  }

  addItem() {
    console.info(">>>> add to cart button pressed")
    this.cartSvc.addToCart(this.bookDetailFromId)
  }

}
