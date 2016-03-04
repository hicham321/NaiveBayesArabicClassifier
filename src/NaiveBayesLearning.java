import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;



// This class does the learning part 

public class NaiveBayesLearning {
	// list des vecteur de chaque document
    public ArrayList<ArrayList<String>> VecteurDesFichiers=new ArrayList<ArrayList<String>>();

	
	//Hashmap pour memoriser les frequeces de chaque mot 
	
	private ArrayList<Map<String, Integer>> map=new ArrayList<Map<String,Integer>>();
	 
	 //list des mots tries
	
	private ArrayList<ArrayList<String>> listDesMotsTries=new ArrayList<ArrayList<String>>();
	 
	 //liste de tout les mot du corpus(pas de duplication)
	
	private ArrayList<String> listeFinal =new ArrayList<String>();
	
	//liste des occurences des mot dans chaque niveau d'impostance (inferieur au nombre d'etat:nbrEtat)
	
	private ArrayList<HashMap<String, Integer>> listeDesoccurenceParNiveau=new ArrayList<HashMap<String,Integer>>();
	
	//la somme de nombre d'occurence de tout les mots dans le corpus
	
	private int SommeFrequence;
	
	private HashMap<String, Integer> hashForFrequencies=new HashMap<>();
	
	private int NombreDeDocuments;
	
	private Set<String> test = new HashSet<>();

	public ArrayList<HashMap<String, Double>> LesEtatsFinal=new ArrayList<HashMap<String,Double>>();


		

	
private ArrayList<ArrayList<String>>   FichierAuVecteur (String LienVersRepertoire) throws FileNotFoundException , UnsupportedEncodingException ,IOException{
 	    

	 	
 		File dir = new File(LienVersRepertoire);
 		
 		  File[] ListeDeRepertoire = dir.listFiles();
 		  
 		  int compteur =0;
 		  if (ListeDeRepertoire != null) {
 		    for (File child : ListeDeRepertoire) {
 		      // Do something with child
 		    	
 		    	ArrayList<String> VecteurFichier =new ArrayList<>();
 		    	
 		    	StopWordElimination st =new StopWordElimination(child);
 		    	VecteurFichier= st.EliminerStopWord();
 		    	
 		    	
 		   
 		    	
 		    	
 		    	
 		        this.VecteurDesFichiers.add(VecteurFichier);
 		        compteur++;
 		      
 		    }
 		  } else {
 		    // Handle the case where dir is not really a directory.
 		    // Checking dir.isDirectory() above would not be sufficient
 		    // to avoid race conditions with another process that deletes
 		    // directories.
 			  System.out.println(" Ce n'est pas une repertoire de fichiers ");
 		  }
 		
 	this.NombreDeDocuments=compteur;
 	
 	
 	return VecteurDesFichiers;
 }
	
	

}
