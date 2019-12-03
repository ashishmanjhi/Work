export class Customer
{
    custId:Number;
    FName:string;
    LName:string;
    ContactNo:Number;
    Address:string;
    Email:string;
    
    constructor( id:Number,FName:string,  LName:string, ContactNo:Number, Address:string, Email:string )
    {
        this.custId=id;
        this.FName=FName;
        this.LName=LName;
        this.ContactNo=ContactNo;
        this.Address=Address;
        this.Email=Email;
    }
}