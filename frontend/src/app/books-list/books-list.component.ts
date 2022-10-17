import { Component, OnInit } from '@angular/core';
import { BookDetail, BookSummary } from '../model';
import { BooksListService } from './books-list.service';
import { DomSanitizer } from '@angular/platform-browser';

@Component({
  selector: 'app-books-list',
  templateUrl: './books-list.component.html',
  styleUrls: ['./books-list.component.css']
})
export class BooksListComponent implements OnInit {

  constructor(private booksListSvc : BooksListService, public _DomSanitizer: DomSanitizer) { }

  booksList: BookSummary[] = []
  imagePath!: string

  ngOnInit(): void {
    this.callAllBooks()
  }

  callAllBooks() {
    this.booksListSvc.getDetails()    
      .then(result => {
        console.info('>>> all books list result : ', result)
        this.booksList = result
        // this.imagePath = this._DomSanitizer.bypassSecurityTrustResourceUrl('data:image/jpg;base64,'+ toReturnImage.base64string);
      })
      .catch(error => {
        console.error('>>>> error from books list : ', error)
      })
  }

}
