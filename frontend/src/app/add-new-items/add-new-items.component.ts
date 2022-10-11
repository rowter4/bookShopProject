import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { DatePipe } from '@angular/common';
import { AddNewItemsService } from './add-new-items.service';
import { AddNewItem } from './add-new-items.model';

@Component({
  selector: 'app-add-new-items',
  templateUrl: './add-new-items.component.html',
  styleUrls: ['./add-new-items.component.css']
})
export class AddNewItemsComponent implements OnInit {

  @ViewChild('bookPhotoUpload')
  bookPhotoUpload!: ElementRef
  
  constructor(private fb: FormBuilder, private addNewItemsSvc: AddNewItemsService) { }

  itemForm!: FormGroup
  user = JSON.parse(sessionStorage.getItem('username') || '{}');

  ngOnInit(): void {

    this.itemForm = this.intialiseForm()

    

    
  }

  intialiseForm() {
    return  this.fb.group({
      username: this.fb.control<string>(this.user),
      genre: this.fb.control<string>('', [Validators.required]),
      bookTitle: this.fb.control<string>('', [Validators.required]),
      edition: this.fb.control<string>('', [Validators.required]),
      authors: this.fb.control<string>('', [Validators.required]),
      format: this.fb.control<string>('', [Validators.required]),
      bookPhoto: this.fb.control<any>('', [ Validators.required ]),
      description: this.fb.control<string>('', [ Validators.required ]),
      price: this.fb.control<string>("0.10",[ Validators.required ]),
      pages: this.fb.control<number>(100,[ Validators.required ]),
      rating: this.fb.control<string>("5.5",[ Validators.required ])
    })
  }

  saveBook() {
    console.info(">>>>>> save button pressed")
    console.info(">>>> form details", this.itemForm.value)
    console.info('>>> book Upload Link ', this.bookPhotoUpload.nativeElement.files[0])

    const myFile = this.bookPhotoUpload.nativeElement.files[0]
    const form = this.itemForm.value as AddNewItem


    this.addNewItemsSvc.upload(myFile, form)
      .then(result => {
        console.info('>>> result from upload: ', result)
        this.intialiseForm();

      }) .catch(error => {
        console.error('>> error: ', error)
      })

    

  }

}
