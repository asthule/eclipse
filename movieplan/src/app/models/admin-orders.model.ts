import { OrderedItem } from './orderedItem';
import { User } from './user.model';

export class AdminOrders {

    orderId: number;
    user: User;
    orderedItems: OrderedItem[] = [];
    totalPrice: number;
    status: string;

    constructor(
        orderId: number,
        user: User,
        orderedItems: OrderedItem[],
        totalPrice: number,
        status: string,
    ){
        this.orderId = orderId;
        this.user = user;
        this.orderedItems = orderedItems;
        this.totalPrice = totalPrice;
        this.status = status;

    }
}