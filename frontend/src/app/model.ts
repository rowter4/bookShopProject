export interface Login {
    userId: string
    password: string
}

export interface BookDetail {
    genre: string
    title: string
    edition: string
    authors: string
    format: string
    description: string

    price: number
    pages: number
    rating: number

    book_id: number,
    pic: Blob 
    
}



export interface BookSummary {
   
    title: string
    price: number
    book_id: number
    pic: Blob

}



// export interface Order {
// 	orderId?: string   
// 	lineItems: LineItem[]
// }

// export type OrderDB = {
// 	[key:string]: Order
// }

export interface NewOrder {
    user_id?: string
    todos: LineItem[]
    
}

export interface LineItem {
	title: string
	book_id: number
    price: number
    quantity: number
}


