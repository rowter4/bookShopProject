import { HttpClient, HttpParams } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { firstValueFrom } from "rxjs";
import { BookOrderHistory, LineItem } from "../model";

@Injectable()
export class PastOrderListService {

    constructor(private http: HttpClient) {}

    username = JSON.parse(sessionStorage.getItem('username') || '{}');
   

    getAllPastOrders() : Promise<BookOrderHistory[]> {
        const params = new HttpParams().set("username", this.username)

        return firstValueFrom(
            this.http.get<BookOrderHistory[]>(`/pastorders/${this.username}`, { params })
        )
        
    }

   

}