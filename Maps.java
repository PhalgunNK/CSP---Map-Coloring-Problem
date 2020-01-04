/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mapcolorfinal;

/**
 *
 * @author kulkarni
 */
public class Maps {
     String AustraliaNeighbors=
                           "{\r\n" + 
			"	\"Western Australia\" :[\"Northern Territory\",\"South Australia\"],\r\n" + 
			"	\"Northern Territory\" : [\"Western Australia\",\"South Australia\",\"Queensland\"],\r\n" + 
			"	\"South Australia\": [\"Western Australia\",\"Northern Territory\",\"Queensland\",\"New South Wales\",\"Victoria\"],\r\n" + 
			"	\"Queensland\" : [\"Northern Territory\",\"South Australia\",\"New South Wales\"],\r\n" + 
			"	\"New South Wales\": [\"Queensland\",\"South Australia\",\"Victoria\"],\r\n" + 
			"    \"Victoria\":[\"New South Wales\",\"South Australia\"],\r\n" + 
			"	\"Tasmania\" : []\r\n" + 
			"}";
	String USANeighbors=
                        "{\r\n" 
                        + 
                        "\"North Carolina\":[\"Georgia\",\"South Carolina\",\"Tennessee\",\"Virginia\"],\r\n" 
                        + 
			"\"South Carolina\":[\"Georgia\",\"North Carolina\"],\r\n"
		        +                                     
			"\"Arizona\":[\"California\",\"Colorado\",\"Nevada\",\"New Mexico\",\"Utah\"],\r\n" 
                        + 
			"\"Arkansas\":[\"Louisiana\",\"Mississippi\",\"Missouri\",\"Oklahoma\",\"Tennessee\",\"Texas\"], \"California\":[\"Arizona\",\"Nevada\",\"Oregon\"],\r\n"
                        + 
			"\"Colorado\":[\"Arizona\",\"Kansas\",\"Nebraska\",\"New Mexico\",\"Oklahoma\",\"Utah\",\"Wyoming\"],\r\n" 
                        + 
			"\"Delaware\":[\"Maryland\",\"New Jersey\",\"Pennsylvania\"],\r\n" 
                        + 
			"\"Florida\":[\"Alabama\",\"Georgia\"],\r\n" 
                        + 
			"\"Georgia\":[\"Alabama\",\"Florida\",\"North Carolina\",\"South Carolina\",\"Tennessee\"],\r\n" 
                        + 
			"\"Hawaii\":[],\r\n" 
                        + 
			"\"Idaho\":[\"Montana\",\"Nevada\",\"Oregon\",\"Utah\",\"Washington\",\"Wyoming\"],\r\n" 
                        + 
			"\"Illinois\":[\"Indiana\",\"Iowa\",\"Michigan\",\"Kentucky\",\"Missouri\",\"Wisconsin\"],\r\n" 
                        + 
			"\"Indiana\":[\"Illinois\",\"Kentucky\",\"Michigan\",\"Ohio\"],\r\n" 
                        + 
			"\"Iowa\":[\"Illinois\",\"Minnesota\",\"Missouri\",\"Nebraska\",\"South Dakota\",\"Wisconsin\"],\r\n"
                        + 
			"\"Kansas\":[\"Colorado\",\"Missouri\",\"Nebraska\",\"Oklahoma\"],\r\n" 
                        +
                        "\"Connecticut\":[\"Massachusetts\",\"New York\",\"Rhode Island\"],\r\n" 
                        + 
			"\"Kentucky\":[\"Illinois\",\"Indiana\",\"Missouri\",\"Ohio\",\"Tennessee\",\"Virginia\",\"West Virginia\"],\r\n" 
                        + 
			"\"Louisiana\":[\"Arkansas\",\"Mississippi\",\"Texas\"],\r\n"
                        + 
			"\"Maryland\":[\"Delaware\",\"Pennsylvania\",\"Virginia\",\"West Virginia\"],\r\n" 
                        + 
			"\"Massachusetts\":[\"Connecticut\",\"New Hampshire\",\"New York\",\"Rhode Island\",\"Vermont\"],\r\n" 
                        + 
			"\"Michigan\":[ \"Illinois\",\"Indiana\",\"Minnesota\",\"Ohio\",\"Wisconsin\"],\r\n"
                        + 
			"\"Minnesota\":[\"Iowa\",\"Michigan\" ,\"North Dakota\",\"South Dakota\",\"Wisconsin\"],\r\n" 
                        + 
			"\"Mississippi\":[ \"Alabama\",\"Arkanssas\",\"Louisiana\",\"Tennessee\"],\r\n"
                        + 
                        "\"Maine\":[\"New Hampshire\"],\r\n" 
                        + 
			"\"Missouri\":[\"Arkansas\",\"Illinois\",\"Iowa\",\"Kansas\",\"Kentucky\",\"Nebraska\",\"Oklahoma\", \"Tennessee\"],\r\n" 
                        + 
			"\"Montana\":[\"Idaho\",\"North Dakota\",\"South Dakota\",\"Wyoming\"],\r\n"
                        + 
			"\"Nebraska\":[\"Colorado\",\"Iowa\",\"Kansas\",\"Missouri\",\"South Dakota\",\"Wyoming\"],\r\n" 
                        + 
			"\"Nevada\":[\"Arizona\",\"California\",\"Idaho\",\"Oregon\",\"Utah\"],\r\n"
                        + 
			"\"New Hampshire\":[\"Maine\",\"Massachusetts\",\"Vermont\"],\r\n" 
                        + 
			"\"New Jersey\":[\"Delaware\",\"New York\",\"Pennsylvania\"],\r\n" 
                        + 
			"\"New Mexico\":[\"Arizona\",\"Colorado\",\"Oklahoma\", \"Texas\",\"Utah\"],\r\n" 
                        + 
			"\"New York\":[\"Connecticut\",\"Massachusetts\",\"New Jersey\",\"Pennsylvania\",\"Rhode Island\", \"Vermont\"],\r\n" 
                        +                        
			"\"Ohio\":[\"Indiana\",\"Kentucky\",\"Michigan\",\"Pennsylvania\",\"West Virginia\"],\r\n" 
                        + 
			"\"Oklahoma\":[\"Arkansas\",\"Colorado\",\"Kansas\",\"Missouri\",\"New Mexico\",\"Texas\"],\r\n" 
                        + 
			"\"Oregon\":[\"California\",\"Idaho\",\"Nevada\",\"Washington\"],\r\n"
                        +
                        "\"North Dakota\":[ \"Minnesota\",\"Montana\",\"South Dakota\"],\r\n" 
                        + 
			"\"Pennsylvania\":[\"Delaware\",\"Maryland\",\"New Jersey\",\"New York\",\"Ohio\",\"West Virginia\"],\r\n"
                        + 
			"\"Rhode Island\":[\"Connecticut\",\"Massachusetts\",\"New York\"],\r\n"
                        + 
			"\"South Dakota\":[\"Iowa\",\"Minnesota\",\"Montana\",\"Nebraska\",\"North Dakota\",\"Wyoming\"],\r\n" 
                        + 
			"\"Tennessee\":[\"Alabama\",\"Arkansas\",\"Georgia\",\"Kentucky\",\"Mississippi\",\"Missouri\",\"North Carolina\",\"Virginia\"],\r\n"
                        + 
			"\"Texas\":[\"Arkansas\",\"Louisiana\",\"New Mexico\",\"Oklahoma\"],\r\n" 
                        + 
			"\"Utah\":[\"Arizona\",\"Colorado\",\"Idaho\",\"Nevada\",\"New Mexico\",\"Wyoming\"],\r\n" 
                        + 
			"\"Vermont\":[\"Massachusetts\",\"New Hampshire\",\"New York\"],\r\n"
                        + 
			"\"Virginia\":[\"Kentucky\",\"Maryland\",\"North Carolina\",\"Tennessee\",\"West Virginia\"],\r\n" 
                        + 
			"\"Washington\":[\"Idaho\",\"Oregon\"],\r\n" 
                        + 
			"\"West Virginia\":[\"Kentucky\",\"Maryland\",\"Ohio\",\"Pennsylvania\",\"Virginia\"],\r\n" 
                        + 
			"\"Wisconsin\":[\"Illinois\",\"Iowa\",\"Michigan\",\"Minnesota\"],\r\n" 
                        + 
			"\"Wyoming\":[\"Colorado\",\"Idaho\",\"Montana\",\"Nebraska\",\"South Dakota\",\"Utah\"]\r\n" 
                        + 
                        "\"Alabama\":[\"Florida\", \"Georgia\", \"Mississippi\", \"Tennessee\"],\r\n"
                        +
                        "\"Alaska\":[],\r\n"        
                        +
			"}";
	      String [] state1 = {"Georgia", "California", "Minnesota", "Iowa", "Maine", "Connecticut", "Mississippi", "Ohio", "Vermont", "Washington", "Louisiana", "Indiana", "Arizona", "Idaho", "Wisconsin", "Hawaii", "Florida", "Virginia", "Michigan", "Illinois", "Missouri", "Oregon", "Colorado", "North Dakota", "Tennessee", "New Jersey", "Alabama", "Delaware", "South Carolina", "Nebraska", "New York", "West Virginia", "Maryland", "Pennsylvania", "Massachusetts", "Alaska", "Kentucky", "Kansas", "North Carolina", "Arkansas", "New Mexico", "Montana", "South Dakota", "Wyoming", "Oklahoma", "Nevada", "Texas", "Utah", "Rhode Island", "New Hampshire"};
	      String [] state2 = {"Oregon", "North Carolina", "Mississippi", "Georgia", "New Hampshire", "Connecticut", "New York", "Virginia", "Tennessee", "New Jersey", "Nebraska", "Ohio", "Colorado", "Massachusetts", "Indiana", "Delaware", "Wyoming", "Hawaii", "Wisconsin", "Texas", "Idaho","Kansas", "Montana", "Pennsylvania", "New Mexico", "South Dakota", "Minnesota", "Iowa", "West Virginia", "Utah", "Louisiana", "Missouri", "Arizona", "North Dakota", "California", "Kentucky", "Oklahoma", "Rhode Island", "Nevada", "South Carolina", "Arkansas", "Alaska", "Michigan", "Florida", "Vermont", "Maryland", "Washington", "Alabama", "Maine", "Illinois"};
	      String [] state3 = {"Washington", "Oregon", "California", "Nevada", "Idaho", "Montana", "Wyoming", "Utah", "Arizona", "New Mexico", "Colorado", "North Dakota", "South Dakota", "Nebraska", "Kansas", "Oklahoma", "Texas", "Minnesota", "Iowa", "Missouri", "Arkansas", "Louisiana", "Mississippi", "Alabama", "Florida", "Georgia", "South Carolina", "North Carolina", "Tennessee", "Kentucky", "Virginia", "Delaware", "Maryland", "West Virginia", "Ohio", "Indiana", "Illinois", "Wisconsin", "Michigan", "Pennsylvania", "New Jersey", "Connecticut", "Rhode Island", "New York", "Vermont", "New Hampshire", "Massachusetts", "Maine", "Alaska", "Hawaii"};
	      String [] state4 = {"Connecticut", "Alabama", "Missouri", "Nevada", "Virginia", "Oklahoma", "Montana", "North Dakota", "Texas", "Idaho", "Minnesota", "West Virginia", "Utah", "Tennessee", "Michigan", "Wyoming", "Oregon", "California", "New York", "New Jersey", "Vermont", "Hawaii", "Delaware", "Kansas", "Florida", "Massachusetts", "Iowa", "Mississippi", "Ohio", "Illinois", "Arkansas", "Maine", "North Carolina", "New Hampshire", "Wisconsin", "South Dakota", "Indiana", "Georgia", "Colorado", "Nebraska", "Kentucky", "South Carolina", "Alaska", "Washington", "Arizona", "New Mexico", "Pennsylvania", "Rhode Island", "Maryland", "Louisiana"};
	      String [] state5 = {"Western Australia","Northern Territory","South Australia","Queensland","New South Wales","Victoria","Tasmania"};
	      
    
}
