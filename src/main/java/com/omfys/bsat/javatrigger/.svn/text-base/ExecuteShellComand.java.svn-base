package com.omfys.bsat.javatrigger;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ExecuteShellComand {

	public static void main(String[] args) {

		ExecuteShellComand obj = new ExecuteShellComand();

//		String domainName = "google.com";

		//in mac oxs
//		String command = "ping -c 3 " + domainName;

		//in windows
//		String command = "ping " + domainName;
		
		String javacommand = "java -jar ../../../bin/determinations-batch/determinations-batch.jar --config BPIL_SCH_ML3_067_1718_SCH_AN_CONFIG.xml";

//		String output = obj.executeCommand(command);
		String javaoutput = obj.executeCommand(javacommand);

//		System.out.println(output);
		System.out.println(javaoutput);

	}
	
	private String executeCommand(String command) {

		StringBuffer output = new StringBuffer();

		Process p;
		try {
			p = Runtime.getRuntime().exec(command);
			p.waitFor();
			BufferedReader reader =
                            new BufferedReader(new InputStreamReader(p.getInputStream()));

                        String line = "";
			while ((line = reader.readLine())!= null) {
				output.append(line + "\n");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return output.toString();

	}
	
}
