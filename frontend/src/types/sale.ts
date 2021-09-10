import { Seller } from "./seller"

export type SaleSum = {
    sellerName: string,
    total: number
}

export type Sale = {
    id : number;
    visited : number;
    deals : number;
    amount : number;
    date : string;
    seller : Seller;

}

export type salePage = {
    content? : Sale[];
    last : boolean;
    totalElements : number;
    totalPages : number;
    size? : number;
    first : boolean;
    numberOfElements? : number;
    empty? : boolean;
    number: number;

}