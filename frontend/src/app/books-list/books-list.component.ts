import { Component, OnInit } from '@angular/core';
import { BookDetail, BookSummary } from '../model';
import { BooksListService } from './books-list.service';

@Component({
  selector: 'app-books-list',
  templateUrl: './books-list.component.html',
  styleUrls: ['./books-list.component.css']
})
export class BooksListComponent implements OnInit {

  constructor(private booksListSvc : BooksListService) { }

  booksList: BookSummary[] = []

  ngOnInit(): void {
    this.callAllBooks()
  }

  callAllBooks() {
    this.booksListSvc.getDetails()    
      .then(result => {
        console.info('>>> all books list result : ', result)
        this.booksList = result
      })
      .catch(error => {
        console.error('>>>> error from books list : ', error)
      })
  }

}
