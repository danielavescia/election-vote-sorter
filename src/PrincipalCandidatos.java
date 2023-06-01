import java.util.Random;
import java.util.Scanner;
import java.util.regex.Pattern;

public class PrincipalCandidatos {
	
	public static void main(String[] args) {
		
		//variaveis
		Candidato [] principaisCandidatos;
		
		String[] nomesCandidatos = {"Ana", "Anna", "Carlos", "David", "Eduardo", "Fabiana", "Gustavo", "Henrique", "Isabela", "Joao",
                					"Karen", "Lara", "Marcela", "Natalia", "Otavio", "Paula", "Quiteria", "Roberto", "Silvia", "Thiago", 
                					"Ana", "Carlos", "Eduardo", "Gustavo", "Isabela", "Joao", "Lara", "Otávio", "Roberto", "Thiago"};
		
		String[] nomePartidos = {"Partido Republicano", "Partido Comunista", "Partido Conservador", "Partido Democrata", "Partido Nacional", "Partido Verde"};
		
		int indiceElementoPesquisado;

		
		//Criação do array de candidatos e impressão deste array
		principaisCandidatos = criaArrayCandidatos(nomesCandidatos, nomePartidos);
		System.out.println("Candidatos criados(não ordenados):");
		System.out.println("________________________________");
		for (Candidato candidato : principaisCandidatos) {
			System.out.println(candidato.toString());
		}
		
		
		// Ordenação do array por nome  do partido e depois imprime este array
		ordenaCandidatosPorPartido(principaisCandidatos);
		
		//Ordenacao por numero de votos e depois imprime este array
		ordenaCandidatosPorVotos(principaisCandidatos);
		
		// Ordenação do array por nome e depois imprime este array
		ordenaCandidatosPorNome(principaisCandidatos);
		System.out.println("Candidatos ordenados por NOME:");
		System.out.println("________________________________");
		
		for (Candidato candidato : principaisCandidatos) {
			System.out.println(candidato.toString());
		}
		
		//Pesquisa binária de candidato de interesse do usuário e impressão do resultado da pesquisa
		indiceElementoPesquisado = pesquisaBinariaCandidatos(principaisCandidatos);
		imprimeResultadoPesquisaBinaria(principaisCandidatos, indiceElementoPesquisado);
		
	}
	
	
	//gera um número aleatorio para obter indices utilizados na criação do array de Candidatos
	public static int geraNumeroAleatorio(int numeroMinimo, int numeroMaximo)throws IllegalArgumentException {
		
		if (numeroMaximo <= numeroMinimo) {
	        throw new IllegalArgumentException("O número máximo deve ser maior do que o número mínimo.");
	    }
		
		int sorteado;
		Random aleatorio = new Random();
		
		sorteado = aleatorio.nextInt(numeroMaximo) + numeroMinimo;
		return sorteado;		
	}
				
	//cria um array de objetos Candidatos(min 1  e max 100) de forma aleatoria, bem como gera atributos aleatorios para cada Candidato criado.
	public static Candidato[] criaArrayCandidatos(String [] nomeCadidatos, String [] nomePartidos) {
		
		int tamanhoArrayCandidato = nomeCadidatos.length-1;
		int tamanhoArrayPartidos = nomePartidos.length-1;
		int tamanhoArray;

		tamanhoArray = geraNumeroAleatorio(1,100);
		Candidato[] principaisCandidatos = new Candidato[tamanhoArray];
			
		for(int i =0; i < tamanhoArray; i++) {
			
			principaisCandidatos[i] = new Candidato(nomeCadidatos[geraNumeroAleatorio(0,tamanhoArrayCandidato)],
													nomePartidos[geraNumeroAleatorio(0,tamanhoArrayPartidos)], 	
													geraNumeroAleatorio(0, 15));
		}
		System.out.printf("Quantidade total de candidatos: %d %n", tamanhoArray);
		return principaisCandidatos;
	}
	
	//ordena Array de Candidatos pelo atributo nome através do método de ordenação inserção direta
	private static void ordenaCandidatosPorNome(Candidato [] principaisCandidatos) {
		 
		int tamanhoArray = principaisCandidatos.length ;
		
		for(int indiceAtual = 1; indiceAtual < tamanhoArray; indiceAtual++) {
			
            int indiceAux = indiceAtual;
            Candidato candidatoAtual = principaisCandidatos[indiceAtual];
            
            while((indiceAux > 0) && (principaisCandidatos[indiceAux-1].getNome().compareToIgnoreCase(candidatoAtual.getNome()) > 0)) {
            	principaisCandidatos[indiceAux] = principaisCandidatos[indiceAux-1];
            	indiceAux--;
            }
            principaisCandidatos[indiceAux] = candidatoAtual;
		}
	}
	
	//ordena Array de Candidatos pelo atributo de intenções de voto da ordem decrescente para a crescente através do método de ordenação inserção direta 
	public static void ordenaCandidatosPorVotos(Candidato [] principaisCandidatos) {
		
		int tamanhoArray = principaisCandidatos.length ;
		
		 for(int i = 1; i < tamanhoArray; i++) {
	            
			 	int indiceAux = i;
	            Candidato candidatoAtual = principaisCandidatos[i];
	            
	            while((indiceAux > 0) && (principaisCandidatos[indiceAux-1].getIntencoesVoto() < candidatoAtual.getIntencoesVoto())) {
	            	principaisCandidatos[indiceAux] = principaisCandidatos[indiceAux-1];
	            	indiceAux--;
	            }
	            principaisCandidatos[indiceAux] = candidatoAtual;
	        }
	}
		
	//metodo que utiliza  oo método de seleção direta  para ordenar os candidatos conforme o nome do partido
	public static void ordenaCandidatosPorPartido(Candidato [] principaisCandidatos) {
		
		int indiceMenorCandidato = 0;
		int tamanhoArray = principaisCandidatos.length ;
		
		for (int indiceAtual = 0; indiceAtual < tamanhoArray - 1; indiceAtual++) {
			for (int indicePosterior = indiceAtual+1; indicePosterior < tamanhoArray; indicePosterior++) {
				
				String  nomeAtual = principaisCandidatos[indiceAtual].getPartido();
				String  nomePosterior = principaisCandidatos[indicePosterior].getPartido();
				
			    if(nomePosterior.compareToIgnoreCase(nomeAtual) < 0) { // verdadeiro caso candidato[indicePosterior] vem antes do candidato[i]
			    	indiceMenorCandidato = indicePosterior; 
			    }
			}
			
			//realiza a troca de posicoes 
            Candidato aux = principaisCandidatos[indiceAtual];
            principaisCandidatos[indiceAtual] = principaisCandidatos[indiceMenorCandidato];
            principaisCandidatos[indiceMenorCandidato] = aux;
        }
		
	}

	//método que realiza a pesquisa do nome do candidato digitado pelo usuário através da busca binária. 
	public static int pesquisaBinariaCandidatos(Candidato [] principaisCandidatos) {
		
		int ultimoElemento = principaisCandidatos.length-1;
		int primeiroElemento = 0;
		int indiceEncontrado = -1;
		String nomeCandidato = recebeInputCandidato();
		
		while(primeiroElemento <= ultimoElemento) { // enquanto eu não ir até os limites do array eu realizo a comparação
			
			int centralElemento = (ultimoElemento + primeiroElemento)/2;	
			int elementosSaoIguais = principaisCandidatos[centralElemento].getNome().compareToIgnoreCase(nomeCandidato);
			
			if(elementosSaoIguais == 0) {  // elementosSaoIguais retorna 0 indicando que são iguais
				 indiceEncontrado = centralElemento;
				 ultimoElemento = centralElemento - 1;
				
			} else if(elementosSaoIguais > 0) { 
				ultimoElemento = centralElemento - 1;
			
			} else if(elementosSaoIguais < 0) { 
				primeiroElemento = centralElemento + 1;
			}
		}
		return indiceEncontrado;
			
	}
	
	//método que pede input do nome do candidato pelo usuário. 
	public static String recebeInputCandidato() {
		
		Scanner input = new Scanner (System.in);
		String nome = null;
		boolean isStringValida = false;
		
		
			while(!isStringValida) {
	        System.out.println("Digite o nome do candidato que deseja pesquisar:");
	        nome = input.nextLine();
	        isStringValida = isEntradaValida(nome);
	        
	        if(isStringValida == false) {
				System.out.println("Entrada inválida! Só são aceitas letras!"); 
				
			} else {	
	        return nome;
	        }
		}
		input.close();
		return nome;
		
	}
	
	//método que verifica se o input e valido
	public static boolean isEntradaValida(String input) {	
		
		String regex = "^[a-zA-Z]+$";	//regex que verifica  a presença do padrão ()
		return Pattern.matches(regex, input);

	}

	public static void imprimeResultadoPesquisaBinaria(Candidato [] principaisCandidatos, int indice) {
		
		if (principaisCandidatos == null || indice >= principaisCandidatos.length) {
			System.out.println("Índice inválido ou não há candidatos registrados");
	    }
		
		else if (indice == -1) {
			System.out.println("Não existe nenhum candidato com este nome");
		}
		
		else {
			System.out.println();
			System.out.printf("Candidato encontrado no indice: %s! %n", indice);
			System.out.println(principaisCandidatos[indice].toString());
		}
	}
}
