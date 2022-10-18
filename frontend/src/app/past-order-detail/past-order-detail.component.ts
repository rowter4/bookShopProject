import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { LineItem } from '../model';
import { PastORderDetailService } from './past-order-detail.service';

@Component({
  selector: 'app-past-order-detail',
  templateUrl: './past-order-detail.component.html',
  styleUrls: ['./past-order-detail.component.css']
})
export class PastOrderDetailComponent implements OnInit {

  constructor(private pastOrderDetailSvc : PastORderDetailService, private activatedRoute : ActivatedRoute) { }

  bookOrderDetail : LineItem[] = []
  ordID = this.activatedRoute.snapshot.params['ord_id']
  ts = this.activatedRoute.snapshot.paramMap.get('date')

  ngOnInit(): void {

    console.info(">>>>> timestamp that is seen inside the detail : ", this.ts)
    
    this.pastOrderDetailSvc.getPastDetailOrders(this.ordID)
    .then(result => {
      console.info(">>>>> order details : ", result)
      this.bookOrderDetail = result
    })
    .catch(error => {
      console.info(">>>>>> error order details: ", error)
    })
  }

}
