export class Workitem {
    constructor(
        public workitem_id: string,
        public user_id: number,
        public item_name: string,
        public item_type: string,
        public item_description: string,
        public message_to_recipient: string,
        public quantity: string,
        public source_country: string,
        public destination_country: string,
        public selected_harbor_location: string,
        public shipping_date: Date,
        public amount: number
    ) { }
}