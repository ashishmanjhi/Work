export class Employee {
    empId: Number;
    Name: string;
    Designation: string;
    ContactNo: Number;
    Address: string;
    Email: string;
    Salary: Number;
    Age: Number;
    userId: string;
    password: string;
    type: string;

    constructor(empId: Number, Name: string, Designation: string, ContactNo: Number, Address: string, Email: string, Salary: Number, Age: Number, userId: string, password: string, type: string) {
        this.empId = empId;
        this.Name = Name;
        this.Designation = Designation;
        this.ContactNo = ContactNo;
        this.Address = Address;
        this.Salary = Salary;
        this.Email = Email;
        this.Age = Age;
        this.userId = userId;
        this.password = password;
        this.type = type;
    }
}
