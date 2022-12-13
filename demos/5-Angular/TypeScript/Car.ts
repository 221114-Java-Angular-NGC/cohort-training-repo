
//We use 'export' to declare that this class can be used in other scripts!
export class Car{
    
    constructor(public name: string,public mileage: number){

    }

    public drive(): void{
        console.log("I'm driving!")
        this.mileage += 1;
    }
}