export class WorkitemVehicle {
    constructor(
        public workitem_id: string,
        public vehicle_number: string,
        public driver_id: string,
        public assigned_workitem_status: string,
    ) { }
}