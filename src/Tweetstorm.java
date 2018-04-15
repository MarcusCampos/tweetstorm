import java.util.LinkedList;

public class Tweetstorm {
	
	public static void main (String [] args) {
		System.out.println("Recebemos o seu texto para o TweetStorm");
		if(args != null) {
			for (String s : args) {
				System.out.println(s.toString() + " ");
			}
			System.out.println(args.toString());
			System.out.println("Tamanho do seu texto em caracteres" + tamanhotexto(args));
			int numeroCarac = tamanhotexto(args);
			String [] text = args;
			LinkedList<String> tweets = montaTweets(text);
			for(int i = 0; i < tweets.size();i ++){
				int indexForTerminal = i - tweets.size();
				System.out.println("Tweet: " + " [" + tweets.get(i) + "].");
			}
		}else {
			System.out.println("Ops, não foi possível identificar os texto passado como argumento.\n Execute o promograma novamernto com argumentos");
			
		}
	}
	public static int tamanhotexto(String [] texto ) {
		int sizetexto =0;
		for(int i =0; i<texto.length; i++) {
			sizetexto +=texto[i].length()+1; 
		}
		return sizetexto;
	}
	
	public static LinkedList<String> montaTweets (String [] texto) {
		String caracteres = "";
		LinkedList<String> breakdown = new LinkedList<String>();
		LinkedList<String> tweets = new LinkedList<String>();
		int index =1; 
		for (String t : texto) {
			if(caracteres.length() > 0 && caracteres.trim().length() <= 138 && caracteres.trim().endsWith(".") ||
					caracteres.length() >= 120  && caracteres.trim().endsWith(",")||
							caracteres.length() >= 90  && caracteres.trim().endsWith("—")) {
				//caracteres = index +"/" +caracteres;
				breakdown.addLast(caracteres);
				caracteres = "";
				caracteres = caracteres + t.toString() + " ";
			}else if (caracteres.length() + t.length() < 138 ) {
				caracteres = caracteres + t.toString() + " ";
			}else {
				//caracteres = index +"/" +caracteres;
				breakdown.addLast(caracteres);
				caracteres = "";
				
			}
		}
		caracteres = "";
		
		for (String frase : breakdown) {
			if(caracteres.trim().length() + frase.trim().length() <= 138) {
				caracteres +=  frase;
			}else {
				caracteres = index +"/" +caracteres;
				tweets.addLast(caracteres.trim());
				caracteres = "";
				caracteres +=  frase;
				index++;
				
			}
		}
		return tweets;
	}
}
