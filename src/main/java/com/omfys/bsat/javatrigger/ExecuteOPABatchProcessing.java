package com.omfys.bsat.javatrigger;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ExecuteOPABatchProcessing {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int scheme_id = 1808;
		
		String schemebatfilename = "BPIL_SCH_ML2_1808_1819_SCH_AN_Batch.bat";
		String schemedirname = "BPIL_SCH_ML2_1808_1819";
		String BatfilePath = "F:/Omfys Lapi/Oracle/OPA/OPA Setups/OPA_Nov2016_v12.2.5.644.0/opa/examples/determinations-batch";
		
		System.out.println("sch bat file name = " + schemebatfilename + " schdir name = " + schemedirname);

		System.out.println("sch bat file BatfilePath = " + BatfilePath);
		
		System.out.println("Running Sch Batch DB processing for schid = " + scheme_id);
		List<String> cmdAndArgs = new ArrayList<String>();
		
		String[] arg = { "cmd", "/c", schemebatfilename };
		cmdAndArgs = Arrays.asList(arg);
		
		File dir = new File(BatfilePath + "/" + schemedirname);
		
		ProcessBuilder pb = new ProcessBuilder(cmdAndArgs);
		pb.directory(dir);
		Process process;
		try {
			process = pb.start();
		

		int waitForprocess = process.waitFor();
		
		if (waitForprocess == 0) {

			System.out.println("BAT script " + schemebatfilename + " process executed properly");

			String message = "Batch processing completed successfully";

			System.out.println(message);
			
			InputStream processIn = process.getInputStream();
			ByteArrayOutputStream processInbaos = new ByteArrayOutputStream();

			int processInch = -1;
			while ((processInch = processIn.read()) != -1) {
				processInbaos.write(processInch);
			}
			
			String processresponse = new String(processInbaos.toByteArray());
			System.out.println("process Response From Exe : " + processresponse);
			
			boolean schexp = processresponse.contains("Exception caught during processing");
			if(schexp) {
				System.out.println("Exception caught during processing BAT script " + schemebatfilename);
			}
			
			System.out.println("Batch Processing Completed");
			
		} else {
			System.out.println("BAT script " + schemebatfilename + " process not executed properly");

			String message = "Batch processing not completed successfully";

			System.out.println(message);
			
			InputStream processErrStream = process.getErrorStream();
			ByteArrayOutputStream processErbaos = new ByteArrayOutputStream();

			int processErrch = -1;
			while ((processErrch = processErrStream.read()) != -1) {
				processErbaos.write(processErrch);
			}

			String processErresponse = new String(processErbaos.toByteArray());
			System.out.println("process Error From Exe : " + processErresponse);
			
			System.out.println("Batch Processing Not Completed");
		}
			
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
