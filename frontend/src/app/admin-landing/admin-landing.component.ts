import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-admin-landing',
  templateUrl: './admin-landing.component.html',
  styleUrls: ['./admin-landing.component.css']
})
export class AdminLandingComponent implements OnInit {

  constructor(private router : Router) { }

  username = sessionStorage.getItem("username")

  ngOnInit(): void {
    
  }

  addItem() {
    console.info(">>>> add item clicked")
    this.router.navigate(['add-item'])
  }

  seeAll() {
    this.router.navigate(['books-list'])
  }

  getPastOrder() {
    console.info("past information button triggered")
    this.router.navigate(['pastorders'])
  }

}
