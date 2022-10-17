import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { firstValueFrom } from "rxjs";
import { BookDetail, BookSummary } from "../model";

@Injectable()
export class BooksListService {

    constructor(private http: HttpClient) {}

    getDetails() : Promise<BookSummary[]> {
        return firstValueFrom(
            this.http.get<BookSummary[]>('/book-summary')
        )              
    }

}