import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;



public class MonteCarlo {
	public static void main(String[] args) {
		Principal programme = new Principal();
		
		System.out.println("Haha");
		programme.start();
	}
}



class Principal{
	
	int start(){
		double x = 0.0;
		double y = 0.0;
		int tiragesDansLeDisque = 0;
		int nombreDeTirages = (int)Math.pow(10,  6);
		
		for (double i = 1; i<10000; i++){
			//x = Math.random();
			//y = Math.random();
			//if (x*x + y*y <= 1){tiragesDansLeDisque++;}
			if (isPrimary(i)){tiragesDansLeDisque++;}
			nombreDeTirages++;
		}
		
		double estimation = 4.0 * tiragesDansLeDisque / nombreDeTirages;
		
		System.out.println("Estimation de Pi : "+estimation);
		System.out.println("Valeur Exacte de Pi : "+ Math.PI);
		System.out.println("Taux d'erreur : "+ Math.abs(estimation - Math.PI)/Math.PI);
		
		read("FichierAAnalyser.txt");
		write("FichierEcriture.txt", "Yahoooouyama ! Petit bambou aussi.");
		
		return 0;	
	}
	
	
	
	// Teste si un nombre est premier 
		boolean isPrimary(double nombre){
			for (double i=2; i<nombre; i++){
				if (nombre%i == 0){return false;}
			}
			return true;
		}
		
		
		
		
		
		int read(String nomFichier){
			int i = 0;
			String donnees;
			
			try{

				//BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
				
				InputStream ips = new FileInputStream(nomFichier); 
				InputStreamReader ipsr = new InputStreamReader(ips);
				BufferedReader br = new BufferedReader(ipsr);
					
				while ((donnees=br.readLine())!=null){
					String tokens[] = donnees.split(" ");
	                for(i = 0; i < tokens.length; i++) {
						System.out.println(tokens[i]);
					}
					System.out.println(donnees);
					System.out.println(tokens[0]);
				}
				br.close(); 
				
			}		
			catch (Exception e){
				System.out.println(e.toString());
			}
		return 0;
		}
		
		
		
		
		int write(String nomFichier, String donnees){
			
			try{
		        PrintWriter fichier_mots  = new PrintWriter(new FileWriter(nomFichier));
		        fichier_mots.println(donnees);
		        fichier_mots.close();
	        }
	        catch(Exception e){
	        	e.printStackTrace();
	        }
	        
			return 0;
		}
		
		
}


