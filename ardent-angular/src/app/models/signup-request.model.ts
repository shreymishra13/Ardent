import { userRole } from "./enums/userRole.enum";

export interface SignupRequest{
    name : String , 
    email :String, 
    password : String,
    contactNo : String , 
    address : String ,
    pincode : String ,
    userRole : userRole
}