package mapcolorfinal;

/**
 *
 * @author kulkarni
 */
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;
import java.util.concurrent.ConcurrentHashMap;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class MapColorFinal
{	
	
	static ConcurrentHashMap<String, ArrayList<String>> domain = new ConcurrentHashMap<String, ArrayList<String>>();
	static HashMap<String, ArrayList<String>> constraints = new HashMap<String, ArrayList<String>>();
	static ConcurrentHashMap<String,String> mapColor = new ConcurrentHashMap<String,String>();
	static ConcurrentHashMap<String, ArrayList<String>> output = new ConcurrentHashMap<String, ArrayList<String>>();
	static Stack<ConcurrentHashMap<String,ArrayList<String>>> colorStack =new Stack<ConcurrentHashMap<String,ArrayList<String>>>();
	static ConcurrentHashMap<String,ArrayList<String>> failureList = new ConcurrentHashMap<String,ArrayList<String>>();
	static Maps maps = new Maps();
	static String[] colors;
	static int leastDomain;
	static String keyMin;
	static String previousMinimumKey = "";
	static boolean Backtracked = false;
	static boolean Backtracked_with_Heuristics = false;
	static String Tcolor = "";
	static String [] state;
	static boolean isAustralia = false;
        static int cnum1 = 4;
        static int cnum2 = 3;	
	static ArrayList<String> domainList = new ArrayList<String>();
	static int k = 0;
	static int loop = 0;
	static int backTrackCount = 0;
	static ConcurrentHashMap<String,ArrayList<String>> heuristicList=new ConcurrentHashMap<String,ArrayList<String>>();
	
	
	public static void main (String [] args) throws FileNotFoundException, IOException, ParseException
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("For Map of United States of America ENTER NUMBER - 1\nFor Map of Australia ENTER NUMBER - 2 \n");		
		JSONParser parser = new JSONParser();
		JSONObject jsonObject;
		if(scan.nextInt() == 1)
		{

			Object obj = parser.parse(maps.USANeighbors);
			jsonObject = (JSONObject) obj;
			String[] colors_temp = {"red\n", "green\n", "blue\n","yellow\n"};
			colors = colors_temp;
                        System.out.println("Chromatic Number for USA Map Coloring = "+cnum1);
		}
		else
		{

			Object obj = parser.parse(maps.AustraliaNeighbors);
			jsonObject = (JSONObject) obj;
			String[] colors_temp = {"red\n", "green\n", "blue\n"};
			colors = colors_temp;
			isAustralia = true;
                        System.out.println("Chromatic Number for Australia Map Coloring = "+cnum2);
		}
		leastDomain = colors.length;
                Set<String> keys = jsonObject.keySet();
		state = new String[keys.size()];	

//storing list of all states
	        int a = 0; 
	        Iterator<String> keysItr = keys.iterator();
                while(keysItr.hasNext())
                {
        	String key = keysItr.next();
                JSONArray value = (JSONArray)jsonObject.get(key);
                state[a++] = key;            
                ArrayList<String> valueList = new ArrayList<String>(); 
                for (int i=0; i<value.size(); i++)
                { 
                valueList.add(value.get(i).toString());
                }             
                constraints.put(key, valueList);	
                }
     
            for(int i=0; i<state.length; i++)              //creating color domain by assigning colors to all state
            {
            colors = copyArray(colors);          
            ArrayList<String> domainColors = new ArrayList<String>();        
            for (String c : colors)
            domainColors.add(c);
            domain.put(state[i],domainColors);		

//hashMap for state and its available colors
            }               
            keyMin = state[0];        
            System.out.println("\nWITH HEURISTICS TECNIQUES \nEnter Number - 1 for Depth First Search\nEnter Number - 2 for Depth First Search with forward checking\nEnter Number - 3 for Depth First Search with forward checking and singleton propagation\n");
            System.out.println("WITHOUT HEURISTICS TECNIQUES \nEnter Number - 4 for Depth First Search without heuristics \nEnter Number - 5 for Depth First Search with forward checking without heuristics\nEnter Number - 6 for Depth First Search with forward checking and singleton propagation without heuristics \n ");
        
            switch(scan.nextInt())
            {
        	case 1:
        		double startTime1 = System.currentTimeMillis();
        		DFS(true);
        		double endTime1 = System.currentTimeMillis();
        		double time1 = (endTime1 - startTime1); 
        		System.out.println("Time Required in Seconds =  " + time1/1000);
        		break;
        	case 2:
        		double startTime2 = System.currentTimeMillis();
        		DFS_FW(true);
        		double endTime2 = System.currentTimeMillis();
        		double time2 = (endTime2 - startTime2); 
        		System.out.println("Time Required in Seconds =  " + time2/1000);        		
        		break;
        	case 3:
        		double startTime3 = System.currentTimeMillis();
        		DFS_FW_SINGLETON(true);
        		double endTime3 = System.currentTimeMillis();
        		double time3 = (endTime3 - startTime3); 
        		System.out.println("Time Required in Seconds =  " + time3/1000);        		
        		break;
        	case 4:
        		double startTime4 = System.currentTimeMillis();
        		DFS(false);
        		double endTime4 = System.currentTimeMillis();
        		double time4 = (endTime4 - startTime4); 
        		System.out.println("Time Required in Seconds =  " + time4/1000);        		
        		break;
        	case 5:
        		double startTime5 = System.currentTimeMillis();
        		DFS_FW(false);
        		double endTime5 = System.currentTimeMillis();
        		double time5 = (endTime5 - startTime5); 
        		System.out.println("Time Required in Seconds =  " + time5/1000);
        		break;
        	case 6:
        		double startTime6 = System.currentTimeMillis();
        		DFS_FW_SINGLETON(false);
        		double endTime6 = System.currentTimeMillis();
        		double time6 = (endTime6 - startTime6); 
        		System.out.println("Time Required in Seconds =  " + time6/1000);        		
        		break;
            }
            }
	
            static void DFS_FW_SINGLETON(boolean heuristics) throws IOException
            {
		int i = 0;
             
		while(i < 2)
		{
			mapColor.clear();
			String [] state1 = maps.state4;
                      
			if(isAustralia)
			{
				String [] state2 = maps.state5;
				state1 = state2;
			}	
		
			if(!heuristics)		


//for not using heuristics
			{
				ArrayList<String> tempStateList = shuffleState(state1);
				
				for(String s : tempStateList)
		        	domainList.add(s);
			}
			
			while(mapColor.size() <= state.length-1)
	        {
	        	String key = (heuristics)? heuristics(constraints, domain) : domainList.get(k);
	        	Assigning_Color(key);
                       
	            k++;
	            leastDomain = colors.length;
	        }
			i++;
			domainList.clear();
			
			k = 0;
			
//assigning colors to all state (creating domain)
                    for(int j=0; j<state.length; j++)
                    {
                    colors = copyArray(colors);          
                    ArrayList<String> domainColors = new ArrayList<String>();        
                    for (String c : colors)
                    domainColors.add(c);
                    domain.put(state[j],domainColors);		

//hashMap for state and its available colors
	        }
		}
		
                    System.out.println("Color Assignment "+mapColor);
                    System.out.println("Number of Backtracking = " + backTrackCount);
                 		 
                }
	
	static public void FW_Check_BT(String leastKey)
	{		
		for(Map.Entry<String,ArrayList<String>> domainEntry: domain.entrySet() )
		{	
			String previousState;
			
			if(domainEntry.getKey().equals(leastKey))		


//finding the domain with key=leastKey
			{
				if(Backtracked)
				{
					
					if(domainEntry.getValue().size() == 1)

					{
						k--;
						previousState = domainList.get(k);

						Tcolor = mapColor.get(previousState);
						Backtracked = true;

						reinitialiseColor(previousState, Tcolor);						
						mapColor.remove(previousState);
						
						FW_Check_BT(previousState);
						Backtracked = false;
						backTrackCount++;
						break;
					}
				}
				
				if(domainEntry.getValue().size() == 0)
				{					
					k--;
					previousState = domainList.get(k);

					Tcolor = mapColor.get(previousState);
					Backtracked = true;				
					reinitialiseColor(previousState, Tcolor);					
					mapColor.remove(previousState);					
					ArrayList<String> TcolorList = new ArrayList<String>();
					TcolorList.add(Tcolor);
					if(!failureList.containsKey(previousState))
					{
						failureList.put(previousState,TcolorList);

					}
					else
					{						
						for(Map.Entry<String, ArrayList<String>> failureEntry : failureList.entrySet())
						{
							if(failureEntry.getKey().equals(previousState))
							{
								failureEntry.getValue().add(Tcolor);
							}
					        }
					}
								
					FW_Check_BT(previousState);
					Backtracked = false;
					backTrackCount++;
					break;
				}

				String removedColor = domainEntry.getValue().get(0);
				String currentState = domainEntry.getKey();				
				for(Map.Entry<String, ArrayList<String>> failureEntry : failureList.entrySet())
				{
					if(failureEntry.getKey().equals(currentState) && failureEntry.getValue().contains(removedColor))
					{
						k--;
						previousState = domainList.get(k);
						Tcolor = mapColor.get(previousState);
						Backtracked = true;
                                                reinitialiseColor(previousState, Tcolor);						
						mapColor.remove(previousState);						
						FW_Check_BT(previousState);
						Backtracked = false;
						backTrackCount++;
						break;
					}
	
				}										
				domainEntry.getValue().remove(removedColor);		


//removing the color from domain
				mapColor.put(currentState, removedColor);
				if(Backtracked_with_Heuristics)
				   heuristicList.remove(currentState);				
				for(Map.Entry<String, ArrayList<String>> constraintEntry : constraints.entrySet())	

//finding all constraints for leastKey
				{
					if(constraintEntry.getKey().equals(currentState))
					{
						ArrayList <String> constaraintList =  constraintEntry.getValue();		

//storing constraints in list
						int i = 0;
						while(i < constaraintList.size())
						{
							for(Map.Entry<String,ArrayList<String>> ouputEntry : domain.entrySet())

	//removing color from each constraint
							{
								if(constaraintList.get(i).equals(ouputEntry.getKey()))		//comparing constraint list with each key in domain
									ouputEntry.getValue().remove(removedColor);		
							}
							i++; 
						}	
					}
				}
			}
		}
	}
	
	
	static public void reinitialiseColor(String previousState, String Tcolor)
	{
		for(Map.Entry<String, ArrayList<String>> constraintEntry : constraints.entrySet())	


//finding all the satisfying constraints for leastKey
		{
			if(constraintEntry.getKey().equals(previousState))
			{
				ArrayList <String> constraintList =  constraintEntry.getValue();
				int j = 0;
				while(j < constraintList.size())
				{
					for(Map.Entry<String,ArrayList<String>> ouputEntry : domain.entrySet())	

//removing the corresponding color from each constraint
					{
						if(constraintList.get(j).equals(ouputEntry.getKey()))		
//comparing constraint list with each key in domain
							ouputEntry.getValue().add(Tcolor);
					}
					j++; 
				}	

			}
		}
	}
	
	static void DFS(boolean heuristics) throws IOException
	{
		int i = 0;
		while(i < 1)
		{
			mapColor.clear();
			String [] state1 = maps.state3;	
			
			if(heuristics)
				Backtracked_with_Heuristics = true;
			
			if(isAustralia)
			{
				String [] state2 = maps.state5;
				state1 = state2;
			}	
			 for(String s : state1)
		        	domainList.add(s);
			
			while((!isAustralia)? (mapColor.size() != state.length) : (output.size() != state.length))
	        {
				if(k == 0 && heuristics)
					heuristicList = domain;
					
	        	String key = (heuristics)? heuristics(constraints, heuristicList) : domainList.get(k);
	        	if(!heuristics || isAustralia)
	        		backtracking(constraints,domain,key);
	        	else 
	        		heuWithBacktrack(key);
		        k++;
	        }       
			
			i++;
			domainList.clear();
			heuristicList.clear();
			colorStack.clear();
			output.clear();
			
			k = 0;
			//assigning colors to all state (creating domain)
	        for(int j=0; j<state.length; j++)
	        {
	          colors = copyArray(colors);          
	          ArrayList<String> domainColors = new ArrayList<String>();        
	          for (String c : colors)
	        	  domainColors.add(c);
	          domain.put(state[j],domainColors);		//hashMap for state and its available colors
	        }
		}        
        System.out.println("Color Assignment = " + mapColor);
        System.out.println("Number of Backtracking = " + backTrackCount); 		        
    	}
	
	static void DFS_FW(boolean heuristics) throws IOException
	{
		int i = 0;
		backTrackCount = 0;
		while(i < 1)
		{
			mapColor.clear();
			String [] state1 = maps.state3;
			
			if(heuristics)		//if heursitics not used
				Backtracked_with_Heuristics = true;
			
			if(isAustralia)
			{
				String [] state2 = maps.state5;
				state1 = state2;
			}	
			 for(String s : state1)
		        	domainList.add(s);
			
			while(mapColor.size() <= state.length-1)
	        {
				if(k==0 && heuristics)
					heuristicList = domain;
				String key = (heuristics)? heuristics(constraints, heuristicList) : domainList.get(k);
	        	FW_Check_BT(key);
	            k++;
	        }
			i++;
			domainList.clear();
			failureList.clear();
			heuristicList.clear();
			k = 0;
		
	        for(int j=0; j<state.length; j++)
	        {
	          colors = copyArray(colors);          
	          ArrayList<String> domainColors = new ArrayList<String>();        
	          for (String c : colors)
	        	  domainColors.add(c);
	          domain.put(state[j],domainColors);		//hashMap for state and its available colors
	        }
	      
		}
		
        System.out.println("Color Assignment = "+mapColor);
        System.out.println("Number of Backtracking = " + backTrackCount); 
     	}
	
	public static ArrayList<String> shuffleState(String[]state)
	{
	 ArrayList<String> stateList = new ArrayList<String>(Arrays.asList(state));
         Collections.shuffle(stateList);
         System.out.println(stateList);
         return stateList;
	}
	static String[] copyArray(String[] colors)
	{
		String [] newArray = colors;
		return newArray;
	}	
	static public String heuristics(HashMap<String,ArrayList<String>> constraints, ConcurrentHashMap<String,ArrayList<String>> domain) 
	{
		for (Map.Entry<String,ArrayList<String>> entry : domain.entrySet()) 
		{
			 if(domain.size() == 1)
			 {
				 keyMin = entry.getKey();
			 }
			 else
			 {
				 if(entry.getValue().size() < leastDomain)		

//choosing the domain with least legal values
				   {
					   leastDomain = entry.getValue().size();
					   keyMin = entry.getKey();
				   }
				   else if(entry.getValue().size() == leastDomain) //when more than 1 legal values are available
				   {	 
					   int currentConstraint = constraints.get(entry.getKey()).size();
					   if((currentConstraint == 0)? (true) : (currentConstraint > constraints.get(keyMin).size()) )
						   keyMin = entry.getKey();
				   }
				   if(!domain.containsKey(keyMin) && Backtracked_with_Heuristics)
				   {
					   keyMin = heuristicList.keys().nextElement();
				   }
			 }				   
		}	
                return keyMin;		
	}	
	static public void Assigning_Color(String leastKey)
	{
		for(Map.Entry<String,ArrayList<String>> entry: domain.entrySet() )
		{
			if(entry.getKey().equals(leastKey))		

//finding te domain with key=leastKey
			{
				String removedColor = entry.getValue().get(0);
				String currentState = entry.getKey();				
				entry.getValue().remove(removedColor);		//removing the color from leastKey
				mapColor.put(currentState, removedColor);
				domain.remove(currentState);			//removing the assigned state from domain list				
				for(Map.Entry<String, ArrayList<String>> constraintEntry : constraints.entrySet())	//finding all constraints for leastKey
				{
					if(constraintEntry.getKey().equals(currentState))
					{
						ArrayList <String> constaraintList =  constraintEntry.getValue();		//storing constraints in list
						int i = 0;
						while(i < constaraintList.size())
						{
							for(Map.Entry<String,ArrayList<String>> ouputEntry : domain.entrySet())	//removing color from each constraint
							{

								if(constaraintList.get(i).equals(ouputEntry.getKey()))		//comparing constraint list with each key in domain
									ouputEntry.getValue().remove(removedColor);								
								singleDomain(domain);
							}
							i++; 
						}	
					}
				}
			}
		}
	}
	
	public static void singleDomain(ConcurrentHashMap<String,ArrayList<String>> domain)
	{
		for (Map.Entry<String,ArrayList<String>> entry : domain.entrySet()) 
		{
			if(entry.getValue().size() == 1)
			{
				Assigning_Color(entry.getKey());
			}
		}
	}
	public static void backtracking(HashMap<String,ArrayList<String>> constraints, ConcurrentHashMap<String,ArrayList<String>> domain,String leastKey)
	{
		int flag = 0;
		
		for(Map.Entry<String,ArrayList<String>> domainEntry : domain.entrySet())  //choosing each state from domain hashMap
		{
			if(flag == 1)
			{
				if(colorStack.peek().get(leastKey) != null)
			    output.put(leastKey, colorStack.peek().get(leastKey));
				mapColor.put(leastKey, colorStack.peek().get(leastKey).get(0));
				heuristicList.remove(leastKey);
			    break;
			}
			if(domainEntry.getKey().equals(leastKey)) 
			{
				int limit = 0;
				ArrayList<String> TcolorList = new ArrayList<String>();
				for(int j=0; j<colors.length; j++)
				{   
					if(flag == 1)
					{
						if(colorStack.peek().get(leastKey) != null)
						output.put(leastKey, colorStack.peek().get(leastKey));
						mapColor.put(leastKey, colorStack.peek().get(leastKey).get(0));
						heuristicList.remove(leastKey);
						break;
					}
					TcolorList.clear();
					ConcurrentHashMap<String,ArrayList<String>> domainCopy =  new ConcurrentHashMap<String,ArrayList<String>>();

					if(!Backtracked)
					{	
						TcolorList.add(colors[j]);
						domainCopy.put(leastKey,TcolorList);
						colorStack.push(domainCopy);		


//storing new available color from the stack
					}
					else			


//when backtracking is done
					{
						ConcurrentHashMap<String, ArrayList<String>> tempHashmap = colorStack.peek();
						String currentKey = tempHashmap.keys().nextElement();
						String currentValue = tempHashmap.get(currentKey).get(0);
						
						output.remove(currentKey);		


//removing the wrongly assigned value
						colorStack.pop();
						
						if(currentValue == colors[colors.length-1])

 //if the last color is tried then backtrack again
						{	
							tempHashmap = colorStack.peek();
							currentKey = tempHashmap.keys().nextElement();
							k--;
							backtracking(constraints, domain, currentKey);
							backTrackCount++;
							break;
						}
						else			

//else assign the next available color
						{
							int colorIndex = 0;
							for(String x : colors)
							{	
								colorIndex++;
								if(x == currentValue)
									break;
							}
							limit = colorIndex;
														
							TcolorList.add(colors[colorIndex]);
							domainCopy.put(leastKey,TcolorList);
							colorStack.push(domainCopy);		


//storing new available color in the stack
							j = colorIndex;		
						}
						Backtracked = false;
					}
					for(Map.Entry<String, ArrayList<String>> constraintEntry : constraints.entrySet()) 


//checking if any of its constraints have the assigned color 
					{
						if(constraintEntry.getKey().equals(leastKey))
						{
							if(!output.isEmpty())
							{
								for(Map.Entry<String, ArrayList<String>> ouputEntry : output.entrySet())
								{
								if(constraintEntry.getValue().contains(ouputEntry.getKey())  && ouputEntry.getValue().equals(TcolorList))
									{
									colorStack.pop();
									flag = 0;
									limit++;
									if(limit != colors.length)
									break;
									}
									else if(limit == colors.length)		


//backtrack when there are no more colors to assign for that state 
									{
									String keyName = colorStack.peek().keys().nextElement();
									Backtracked = true;
									k--;							
									backtracking(constraints, domain, keyName);	
									limit = 0;
									backTrackCount++;
									break;										
									}
									else
									flag = 1;
								}
							}
							else
							flag = 1;
						}
					}
				}
			}
		}
		if(!colorStack.isEmpty() && (colorStack.peek().get(leastKey) != null))		


//adding the last color in output list
		{
			output.put(leastKey, colorStack.peek().get(leastKey));		
			mapColor.put(leastKey, colorStack.peek().get(leastKey).get(0));
			heuristicList.remove(leastKey);
		}			
	}
	static public void heuWithBacktrack(String leastKey)
	{		
		for(Map.Entry<String,ArrayList<String>> domainEntry: domain.entrySet() )
		{	
			String previousState;
			
			if(domainEntry.getKey().equals(leastKey))		//finding domain with key=leastKey
			{
				if(Backtracked)
				{
					
					if(domainEntry.getValue().size() == 1)
					{
						k--;
						previousState = domainList.get(k);
						Tcolor = mapColor.get(previousState);
						Backtracked = true;
						reinitialiseColor(previousState, Tcolor);						
						mapColor.remove(previousState);						
						FW_Check_BT(previousState);
						Backtracked = false;
						break;
					}
				}
				
				if(domainEntry.getValue().size() == 0)
				{				
					k--;
					previousState = domainList.get(k);
//					System.out.println("***BACKTRACKED FOR STATE: "+ previousState);
					Tcolor = mapColor.get(previousState);
					Backtracked = true;				
//					domain.get(previousState).add(Tcolor);					
					reinitialiseColor(previousState, Tcolor);					
					mapColor.remove(previousState);					
					ArrayList<String> TcolorList = new ArrayList<String>();
					TcolorList.add(Tcolor);
					if(!failureList.containsKey(previousState))
					{
					failureList.put(previousState,TcolorList);
					}
					else
					{						
					for(Map.Entry<String, ArrayList<String>> failureEntry : failureList.entrySet())
					{
					if(failureEntry.getKey().equals(previousState))
					{
					failureEntry.getValue().add(Tcolor);
					}			
					}
					}					
					FW_Check_BT(previousState);
					Backtracked = false;
					break;
				}
				String removedColor = domainEntry.getValue().get(0);
				String currentState = domainEntry.getKey();				
				for(Map.Entry<String, ArrayList<String>> failureEntry : failureList.entrySet())
				{
					if(failureEntry.getKey().equals(currentState) && failureEntry.getValue().contains(removedColor))
					{
						k--;
						previousState = domainList.get(k);
						Tcolor = mapColor.get(previousState);
						Backtracked = true;
						reinitialiseColor(previousState, Tcolor);						
						mapColor.remove(previousState);							
						FW_Check_BT(previousState);
						Backtracked = false;
						break;
					}
					}			
						
				domainEntry.getValue().remove(removedColor);		//removing the color from domain
				mapColor.put(currentState, removedColor);
				if(Backtracked_with_Heuristics)
				heuristicList.remove(currentState);
				
				for(Map.Entry<String, ArrayList<String>> constraintEntry : constraints.entrySet())	//finding all constraints for leastKey
				{
					if(constraintEntry.getKey().equals(currentState))
					{
						ArrayList <String> constaraintList =  constraintEntry.getValue();		//storing constraints in list
						int i = 0;
						while(i < constaraintList.size())
						{
							for(Map.Entry<String,ArrayList<String>> ouputEntry : domain.entrySet())	
							{
								if(constaraintList.get(i).equals(ouputEntry.getKey()))		//comparison constraint list with each key in domain
									ouputEntry.getValue().remove(removedColor);		
							}
							i++; 
						}	
					}
				}
			}
		}
	}	
}