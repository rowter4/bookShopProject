import { Component, OnInit } from '@angular/core';
import { FormArray, FormBuilder, FormGroup } from '@angular/forms';
import { Subscription } from 'rxjs';
import { CartService } from './cart.service';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {

  constructor(private cartSvc: CartService, private fb: FormBuilder) { }
  // sub$ !: Subscription
  // allItems !: any

  productList: any = []
  grandTotal : number = 0


  

  ngOnInit(): void {
    this.cartSvc.getAllItems()
      .subscribe(result => {
        this.productList = result
        this.grandTotal = this.cartSvc.getTotalPrice()
        console.info('>>> in subscription: ', this.productList)
        console.info('>>> grand total: ', this.grandTotal)
      })

  
  //   this.sub$ = this.cartSvc.onUpdatedItemsList.subscribe(data => {
  //     console.info('>>> in subscription: ', data)
  //     // this.todos = data
  //   })
  //   this.allItems = this.cartSvc.onUpdatedItemsList
  //   console.info(">>>>> cart from all items: " , this.allItems)
  // }

  }


  removeItem(item: any) {
    console.info(">>>> remove item triggered")
    this.cartSvc.removeCartItem(item)
  }
  
}
