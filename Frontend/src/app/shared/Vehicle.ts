export class Vehicle {
    vehicle_number: string;
    vehicle_name: string;
    max_lifting_capacity: number;
    retire_date: Date;
    vehicle_status: string;
    harbor_location: string;
    country: string;

    constructor(
        vehicle_number: string = "",
        vehicle_name: string = "",
        max_lifting_capacity: number = 0,
        retire_date: Date = new Date(), // Default to current date
        vehicle_status: string = "",
        harbor_location: string = "",
        country: string = ""
    ) {
        this.vehicle_number = vehicle_number;
        this.vehicle_name = vehicle_name;
        this.max_lifting_capacity = max_lifting_capacity;
        this.retire_date = retire_date;
        this.vehicle_status = vehicle_status;
        this.harbor_location = harbor_location;
        this.country = country;
    }
}
