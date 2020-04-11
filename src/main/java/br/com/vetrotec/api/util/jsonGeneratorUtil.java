package br.com.vetrotec.api.util;

import com.google.gson.Gson;

import br.com.vetrotec.api.model.Cliente;

public class jsonGeneratorUtil {
	
	public static void main(String[] args) {
		Gson gson = new Gson();
	    String jsonString = null;
	    try {
	        jsonString = gson.toJson(new Cliente());
	        System.out.println(jsonString);
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}

}
