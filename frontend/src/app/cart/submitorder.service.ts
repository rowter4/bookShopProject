import { HttpClient, HttpHeaders } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { lastValueFrom } from "rxjs";
import { NewOrder } from "../model";

@Injectable()
export class SubmitOrderService {

    constructor(private http: HttpClient) {}

    processOrder(newOrder: NewOrder): Promise<Response> {

        const headers = new HttpHeaders()
            .set('Content-Type', 'application/json')
            .set('Accept', 'application/json')
    
          return lastValueFrom(
            this.http.post<Response>('/submit-order', newOrder, { headers })
          )
      }
}