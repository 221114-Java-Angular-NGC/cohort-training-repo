export class User{
    id: number;
    username: string;
    password: string;
    firstname: string;
    lastname: string;
    email: string;

    constructor(id: number, uname: string, pw: string, fname: string, lname: string, email: string){
        this.id = id;
        this.username = uname;
        this.password = pw;
        this.firstname = fname;
        this.lastname = lname;
        this.email = email;
    }
}