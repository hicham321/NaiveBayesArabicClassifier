import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class vectorisation {
	
	public int nbrMotVide;
	
	
public vectorisation(File textFile) throws IOException,FileNotFoundException,UnsupportedEncodingException {
	
	TraitmentDocument(textFile);
	
	}

private void TraitmentDocument(File textFile) throws FileNotFoundException,UnsupportedEncodingException,IOException{
		
	StopWordElimination st =new StopWordElimination(textFile);
		
		
		ArrayList<String>list=st.EliminerStopWord();
		this.nbrMotVide= st.nombredemotvides;
		
		Map <String,Integer> mapfortext=new HashMap<String,Integer>();
		
		
		for(int k=0;k<list.size();k++){
			int compteur=0;
			for(int j=0;j<list.size();j++){
				
				if(list.get(k).equals(list.get(j))){
					
					compteur++;
					
				}
			}

			mapfortext.put(list.get(k), compteur);
		}
		ArrayList <String> cles = new ArrayList<String>(mapfortext.keySet());

		for(String cle: cles){
			
		    System.out.println(cle + ": " + mapfortext.get(cle));

		}

}

public static void main(String[] args) throws IOException,UnsupportedEncodingException,FileNotFoundException {
	
	File file= new File("C:/Users/Hicham/Desktop/stop-words_arabic_1_ar.txt");
	
	vectorisation v = new vectorisation(file);
	
	

	
	
	
}

	
}

