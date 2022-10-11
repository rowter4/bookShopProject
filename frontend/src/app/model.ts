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
    bookPhoto: any
    
}



export interface BookSummary {
   
    title: string
    price: number
    book_id: number

}


export interface LineItem {
	title: string
	book_id: number
    price: number
}

export interface Order {
	orderId?: string
    quantity: number
	lineItems: LineItem[]
}

export type OrderDB = {
	[key:string]: Order
}

