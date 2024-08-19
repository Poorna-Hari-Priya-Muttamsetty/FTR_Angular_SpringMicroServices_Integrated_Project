export class Terminal {
    constructor(
        public terminal_id: number,
        public terminal_name: string,
        public country: string,
        public item_type: string,
        public terminal_description: string,
        public capacity: number,
        public status: string,
        public harbor_location: string,
        public available_capacity: number
    ) { }
}