import { Component, Inject, OnInit } from '@angular/core';
import { BookDetail, BookSummary } from '../model';
import { BooksListService } from './books-list.service';
import { MatDialog, MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';

@Component({
  selector: 'app-books-list',
  templateUrl: './books-list.component.html',
  styleUrls: ['./books-list.component.css']
})

export class BooksListComponent implements OnInit {

  constructor(private booksListSvc : BooksListService, public dialog: MatDialog)  { }

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
        
      })
      .catch(error => {
        console.error('>>>> error from books list : ', error)
      })
  }

  openDialog(title: string): void {
    

    let dialogRef = this.dialog.open(BooksListDialog, {
      height: '200px',
      width: '300px',
      data: { name: title },
    });

    dialogRef.afterClosed().subscribe(result => {
      if (result)
        console.log(`Dialog result: ${result}`); // Pizza!
    });
  }


}


@Component({
  selector: 'books-list-dialog',
  templateUrl: './books-list-dialog.html',
})

export class BooksListDialog {
  constructor(public dialogRef: MatDialogRef<BooksListDialog>, 
              @Inject (MAT_DIALOG_DATA) public data: {name: string}) {}

  onNoClick(): void {
    this.dialogRef.close(false);
  }

  onYesClick(): void {
    this.dialogRef.close(true);
  }
}
