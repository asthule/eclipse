import { OrderedItem } from "./orderedItem";

export class UserOrder {
    id: number;
    orderedItems: OrderedItem[] = [];
    totalPrice: number;
    
    status: string;

    constructor(
        id: number,
        orderedItems: OrderedItem[],
        orderedItemTotalPrice: number,
        status: string,

    ){
        this.orderedItems = orderedItems;
        this.totalPrice = orderedItemTotalPrice;
        this.status = status;
        this.id = id;

    }

}