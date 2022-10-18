import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { BookOrderHistory, LineItem } from '../model';
import { PastOrderListService } from './past-order-list.service';

@Component({
  selector: 'app-past-order-list',
  templateUrl: './past-order-list.component.html',
  styleUrls: ['./past-order-list.component.css']
})
export class PastOrderListComponent implements OnInit {

  constructor(private pastOrderSvc : PastOrderListService, private router : Router) { }
  
  bookOrderHistory : BookOrderHistory[] = []
  

  ngOnInit(): void {
    this.pastOrderSvc.getAllPastOrders()
    .then(result => {
      console.info(">>>>> result from order history", result)
      this.bookOrderHistory = result
    })
    .catch(error => {
      console.info(">>>>>> error from order history: ", error)
    })
  }

  getOrderDetail(h : BookOrderHistory) {
    console.info(">>> more buttons pressed")
    this.router.navigate(['orderdetail', h.ord_id, {date: h.ts}])     
    
    

    let date = h.ts // ts is timestamp
    console.info(">>> order id obtained : ", h.ord_id)
   
  }
}
