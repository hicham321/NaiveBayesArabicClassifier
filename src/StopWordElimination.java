
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;


//This class is used to remove Stop Words and other Strings that are unrelated to the task of text classification

public class StopWordElimination {
	
	
	private FileInputStream fichtxt;
	
	private InputStreamReader lecteur;
	
	
	//
	
	private ArrayList<String> ListeDesMots;
		
	private InputStreamReader lecteurStopWord;
	
	private ArrayList<String> ListeDesStopWord;
	
	public int nombredemotvides=0;
	
	
	public StopWordElimination(File fichiertext) throws IOException,FileNotFoundException,UnsupportedEncodingException{
		
		this.fichtxt= new FileInputStream(fichiertext);
		
		this.lecteur= new InputStreamReader(this.fichtxt, "UTF-8");
		
		
		this.lecteurStopWord= this.LireStopWordFichier();
		
		this.LectureStopWords();
		this.LectureText();
		
		
		
		
	}
	
	
	public void LectureText() throws IOException{
		
		BufferedReader br = new BufferedReader(this.lecteur);
		
	    ArrayList<String> ListeDesMots = new ArrayList<String>();
	    
		String ligne = null;

		while( (ligne = br.readLine())!= null ){
		        // \\s+ means any number of whitespaces between tokens
		    String [] tokens = ligne.split("\\s+");
		    for(int i=0;i< tokens.length;i++){
		    	
		    ListeDesMots.add(tokens[i]);
		    
		    }
		    
		    }
	this.ListeDesMots=ListeDesMots;
		}
	
	public InputStreamReader LireStopWordFichier() throws FileNotFoundException,UnsupportedEncodingException{
		
		
		
        FileInputStream fichierTextStopWord = new FileInputStream("C:/Users/Hicham/Desktop/stop-words_arabic_1_ar.txt");
		
		InputStreamReader LecteurFichierStopWord = new InputStreamReader(fichierTextStopWord, "UTF-8");
		
		return LecteurFichierStopWord;
		
	}
	
	public void LectureStopWords() throws IOException{
		
        BufferedReader br = new BufferedReader(this.lecteurStopWord);
		
	    ArrayList<String> ListeDesStopWord = new ArrayList<String>();
	    
		String ligne = null;

		while( (ligne = br.readLine())!= null ){
		        // \\s+ means any number of whitespaces between tokens
		    String [] tokens = ligne.split("\\s+");
		    for(int i=0;i< tokens.length;i++){
		    	
		    ListeDesStopWord.add(tokens[i]);
		    
		    }

		    }
		this.ListeDesStopWord= ListeDesStopWord;
	}
	
	
	public ArrayList<String> EliminerStopWord(){
		
		ArrayList<String> ListeDesMotsFinale= new ArrayList<String>();
		
		for(int i=0; i<this.ListeDesMots.size();i++){
			Boolean StopWordTrouver=false;

		    for(int j=0; j<this.ListeDesStopWord.size();j++){
				//la condition d'elemination
				if(this.ListeDesStopWord.get(j).equals(ListeDesMots.get(i)) ) {
				    	StopWordTrouver=true;
				    	this.nombredemotvides++;
				    	break;
				}
				
			
			}
		    
		    if(StopWordTrouver==false){
		    	ListeDesMotsFinale.add(ListeDesMots.get(i));
		    }
			
		}
	
		return ListeDesMotsFinale ;
	}
	
	
	
	
    public ArrayList<String> getListedesmot(){
    	
    	return this.ListeDesMots ;
    }
	
	public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException,IOException {
		
      
		File file= new File("C:/Users/Hicham/Desktop/stop-words_arabic_1_ar.txt");
		File file2= new File("liens vers la ripertoire des fichiers dans le stock ");
		
		StopWordElimination StopWordObject= new StopWordElimination(file);
		
		ArrayList<String> list=  StopWordObject.EliminerStopWord();
		
		for(int i=0; i<list.size();i++){
			
		System.out.print(list.get(i));	
		}
	   
	}

}
