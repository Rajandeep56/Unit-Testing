package com.currencyconverter;

public class ValidateLibrarian {

	
	public static boolean validate(String name,String password){
		

        // will create an array to add

        boolean status=false;
		// try{
		// 	if (name == "Rajan" && password =="RajanTest"){
        //         status = true;
        //     }
		// }catch(Exception e){System.out.println(e);}
        if(name.equals("Rajan") && password.equals("test")){
             status = true;
        }
       // System.out.print(status);
		return status;
	}

}
