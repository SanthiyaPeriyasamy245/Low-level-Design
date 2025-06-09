package Transaction;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class TransactionHandler {
	
	public void writeTransaction(int custId,Transaction transaction) throws IOException
	{
		String fileName=custId+".txt";
		File file=new File(fileName);
		if(!file.exists())
		{
			file.createNewFile();
		}
		try (FileWriter writer = new FileWriter(file,true)) {
			writer.write(transaction.toString()+"\n");
			
		}
		catch(Exception e)
		{
			System.out.println("Exception");
		}
	}
	public int getLastTransactionId(int custId)
	{
		String fileName=custId+".txt";
		File file=new File(fileName);
		if(!file.exists())
		{
			return 0;
		}
		String trans=" ";
		try {
			Scanner sc=new Scanner(file);
			while(sc.hasNext())
			{
				trans=sc.nextLine();
			}
			Transaction transactionInfo=castToTransaction(trans);
			sc.close();
			return transactionInfo.trancsactionId;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
		
	}
	private Transaction castToTransaction(String transaction)
	{
		String[]transactions=transaction.split("\t");
		return new Transaction(Integer.parseInt(transactions[0]),transactions[1],Double.parseDouble(transactions[2]),Double.parseDouble(transactions[3]));
		
	}
	public void printTransactionHistory(int custId)
	{	String fileName=custId+".txt";
	File file=new File(fileName);
	if(!file.exists())
	{
		return ;
	}
	String trans=" ";
	try {
		Scanner sc=new Scanner(file);
		while(sc.hasNext())
		{
			trans=sc.nextLine();
			System.out.println(trans);
		}
		
		sc.close();
		
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return ;
		
	}

}
