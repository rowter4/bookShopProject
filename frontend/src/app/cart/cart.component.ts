import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormArray, FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Subscription } from 'rxjs';
import { LineItem, NewOrder } from '../model';
import { CartService } from './cart.service';
import { SubmitOrderService } from './submitorder.service';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {

  constructor(private cartSvc: CartService, private fb: FormBuilder, private submitSvc: SubmitOrderService,
              private router: Router ) { }
  // sub$ !: Subscription
  // allItems !: any

  productList: any = []
  grandTotal : number = 0

  todoForm!: FormGroup
  todoArrayCtrl!: FormArray
  

  ngOnInit(): void {
    this.cartSvc.getAllItems()
      .subscribe(result => {
        this.productList = result
        this.grandTotal = this.cartSvc.getTotalPrice()
        
        this.todoForm = this.createForm()        
        for (let i=0; i<this.productList.length; i++) {
          this.addToDo(this.productList[i])
        }

        console.info('>>> in subscription: ', this.productList)
        console.info('>>> grand total: ', this.grandTotal)
        console.info('>>> todo Form: ', this.todoForm.value)
      })

      
    
     
    // this.orderForm = this.createOrder()
  //   this.sub$ = this.cartSvc.onUpdatedItemsList.subscribe(data => {
  //     console.info('>>> in subscription: ', data)
  //     // this.todos = data
  //   })
  //   this.allItems = this.cartSvc.onUpdatedItemsList
  //   console.info(">>>>> cart from all items: " , this.allItems)
  // }

  }

  createForm() {
    this.todoArrayCtrl = this.fb.array([]) 
    
    return this.fb.group({
      todos: this.todoArrayCtrl
    })
  }

  addToDo(productList : any) {
    const todoItem = this.fb.group({
      title: this.fb.control<string>(productList.title),
      book_id : this.fb.control<string>(productList.book_id),
      quantity: this.fb.control<number>(1),
      price: this.fb.control<number>(productList.price)
    })

    this.todoArrayCtrl.push(todoItem)
  }

  removeItem(item: any) {
    console.info(">>>> remove item triggered")
    this.cartSvc.removeCartItem(item)
  }

  processForm() {
    console.info(">>> form is being processed")
    const newOrder = this.todoForm.value as NewOrder

    this.submitSvc.processOrder(newOrder)
      .then(result => {
        console.info('>>>> result: ', result)
        this.cartSvc.removeAllCart()
        // this.todoForm = this.formReset()
        this.router.navigate(['books-list'])
        // alert(`Your registration ID is ${result.message}`)
      })
      .catch((error: HttpErrorResponse) => {
        console.error('>>>> error: ', error)
        alert(`Error: message=${error.message}, data=${error.error}`)
      })
  }


  
}
