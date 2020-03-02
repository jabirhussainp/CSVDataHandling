package filereading;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;


import gui.FormDesign;




/**
 * @author jabirhussain
 *
 */
public class FileReading {
	
	
	//Reading csv file
	public ArrayList<PersonData> readData()
	{
		String file = "data/titanic.csv";
		ArrayList<PersonData> list = new ArrayList<PersonData>();
		FileReader fins = null;
		
		
		
		
		try {
			int id = 0;
			String name = "";
			int age = 0;
			String sex="";
			int pclass = 0;
			int survived = 0;
			double fare = 0;
			
			fins = new FileReader(file);
			BufferedReader br= new BufferedReader(fins);
			
			String line=null;
			int i=0;
			while((line= br.readLine()) != null) {
				
				if(i++==0) {
					continue;
				}
				String data[]= line.split(",");
				
				
				id = Integer.parseInt(data[0].trim());
				name = data[1].trim();
				age = Integer.parseInt(data[2].trim());
				sex = data[3].trim();
				pclass = Integer.parseInt(data[4].trim());
				survived = Integer.parseInt(data[5].trim());
				fare = Double.parseDouble(data[6].trim());
			
				PersonData da = new PersonData(id, name, age, sex, pclass, survived, fare);
				
				list.add(da);
			}
				
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return list;
		
	}
	//Method to find Max of Age
	
	public PersonData getMax(ArrayList<PersonData> list) {
		
		PersonData max=null;
		
		if(list==null)
			return null;
		if(list.size()>0)
		max=list.get(0);
		
		for(int i=1;i<list.size();i++) {
			if(list.get(i).getAge() > max.getAge()) {
				max= list.get(i);
			}
		}
		
		return max;
	}
	
		//Method to find Min of Age
		public PersonData getMin(ArrayList<PersonData> list) {
			
			if(list==null)
				return null;
			
			PersonData min=null;
			
			if(list.size()>0)
			min=list.get(0);
			
			for(int i=1;i<list.size();i++) {
				if(list.get(i).getAge() < min.getAge()) {
					min= list.get(i);
				}
			}
			
			return min;
		
  /*public void getMaxAge()
  {
	  FormDesign fd = new FormDesign();
	ArrayList<Integer> maxi = new ArrayList<Integer>();
	for(int i=0;i<fd.table.getRowCount();i++) {
		maxi.add(Integer.parseInt(fd.table.getValueAt(i, 2).toString()));
	}
		
	int max = Collections.max(maxi);
	//int min = Collections.min(maxmin);
	  
	
	fd.textField.setText(Integer.toString(max));*/
	//return 0; 
		
}
			public PersonData getMaxFare(ArrayList<PersonData> list) {
				
				PersonData max=null;
				
				if(list==null)
					return null;
				if(list.size()>0)
				max=list.get(0);
				
				for(int i=1;i<list.size();i++) {
					if(list.get(i).getFare() > max.getFare()) {
						max= list.get(i);
					}
				}
				
				return max;
			}
			
			public PersonData getMinFare(ArrayList<PersonData> list) {
				
				if(list==null)
					return null;
				
				PersonData min=null;
				
				if(list.size()>0)
				min=list.get(0);
				
				for(int i=1;i<list.size();i++) {
					if(list.get(i).getFare() < min.getFare()) {
						min= list.get(i);
					}
				}
				
				return min;

}

}

