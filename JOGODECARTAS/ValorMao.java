//this file was written by Valdivino Morais


import java.util.*;


public class ValorMao {
//Deve ser alterado para conter as cartas do jogador
	ArrayList<String> cartaLista;
	String[] carta = {"Ac", "1d", "2h", "3s", "4c", "5d", "6h"};


	public ValorMao(ArrayList<String> cartaLista) {
		this.reset(cartaLista);
	}


	String[] convertList(ArrayList<String> cartaLista){
		String[] cartas = new String[7];
		for(int i = 0; i < 7; i++){
			cartas[i] = cartaLista.get(i);
		}
		return cartas;

	}

	void reset(ArrayList<String> cartaLista){
		this.cartaLista = cartaLista;
		carta = convertList(cartaLista);
	}


	String classificaMao(){
		String valorMao;
		valorMao = "";
		if(checarRoyalFlush()){
			valorMao = "royalFlush";
		}else{
			if(checarStraightFlush()){
				valorMao = "straightFlush";
			}else{
				if(checarQuadra()){
					valorMao = "quadra";
				}else{
					if(checarFullHouse()){
						valorMao = "fullHouse";
					}else{
						if(checarFlush()){
							valorMao = "flush";
						}else{
							if(checarSequencia()){
								valorMao = "sequencia";
							}else{
								if(checarTrinca()){
									valorMao = "trinca";
								}else{
									if(checarDuasDuplas()){
										valorMao = "duasDuplas";
									}else{
										if(checarDupla()){
											valorMao = "dupla";
										}else{
											valorMao = checarMaiorCarta();
										}
									}
								}
							}
						}
					}
				}
			}
		}
		return valorMao;
	}

	Boolean checarRoyalFlush(){
		return((checarMaiorSequencia() == 14)&&(checarStraightFlush()));
	}

	String checarMaiorCarta(){
		int[] a = new int[7];
		a = arrayNumeroCarta();
		Arrays.sort(a);
		int n = a[6];
		return ""+n;
	}

	Boolean checarStraightFlush(){
		return((checarFlush())&&(checarSequencia()));
	}

	Boolean checarFlush(){
		String[] a = new String[7];
		a = arrayNaipeCarta();
		int cont0 = 0, cont1 = 0, cont2 = 0, cont3 = 0;
		for(int i = 0; i < 7; i++){
			if (a[i].equals("c")){
				cont0++;
			}
			if (a[i].equals("d")){
				cont1++;
			}
			if (a[i].equals("h")){
				cont2++;
			}
			if (a[i].equals("s")){
				cont3++;
			}
		}
		return((cont0 >= 5)||(cont1 >= 5)||(cont2 >= 5)||(cont3 >= 5));
	}

	Boolean checarQuadra(){
		int contQuadra = contaNumerosIguais(4);
		return (contQuadra == 1);
	}

	Boolean checarFullHouse(){
		return(((checarTrinca())&&((checarDupla())||(checarDuasDuplas())))||(checarDuasTrincas()));
	}

	Boolean checarTrinca(){
		int contTrinca = contaNumerosIguais(3);
		return (contTrinca == 1);
	}

	Boolean checarDuasTrincas(){
		int contTrinca = contaNumerosIguais(3);
		return (contTrinca == 2);
	}

	Boolean checarDuasDuplas(){
		int contDupla = contaNumerosIguais(2);
		return((contDupla == 2)||(contDupla == 3));//||(contDupla == 3)
	}

	Boolean checarDupla(){
		int contDupla = contaNumerosIguais(2);
		return (contDupla == 1);
	}

	int contaNumerosIguais(int n){
		int[] a = new int[7];
		int[] cont = new int[13];
		int contNumero = 0;
		a = arrayNumeroCarta();
		for(int j = 0; j < 13; j++){
			for(int i = 0; i < 7; i++){
				if (a[i] == j+1) cont[j]++;
			}
		}
		for(int i = 0; i < 13; i++){
			if(cont[i] == n)contNumero++;
		}
		return contNumero;

	}

	Boolean checarSequencia(){
		int[] a = new int[7];
		a = arrayNumeroCarta();
		Arrays.sort(a);
		int cont1 = 0, cont2 = 0, cont3 = 0;
		for(int i = 0; i < 4; i++){
			if (a[i + 1] - a[i] == 1) cont1++;
		}
		for(int i = 1; i < 5; i++){
			if (a[i + 1] - a[i] == 1) cont2++;
		}
		for(int i = 2; i < 6; i++){
			if (a[i + 1] - a[i] == 1) cont3++;
		}
		return((cont1 == 4)||(cont2 == 4)||(cont3 == 4));
	}

	int checarMaiorSequencia(){
		int[] a = new int[7];
		int s1 = 0, s2 = 0, s3 = 0;
		a = arrayNumeroCarta();
		Arrays.sort(a);
		int cont1 = 0, cont2 = 0, cont3 = 0;
		for(int i = 0; i < 4; i++){
			if (a[i + 1] - a[i] == 1) cont1++;
			if(cont1 == 4)s1 = a[4];
		}
		for(int i = 1; i < 5; i++){
			if (a[i + 1] - a[i] == 1) cont2++;
			if(cont2 == 4)s2 = a[5];
		}
		for(int i = 2; i < 6; i++){
			if (a[i + 1] - a[i] == 1) cont3++;
			if(cont3 == 4)s3 = a[6];
		}
		if((s2>s1)&&(s2>s3)){
			return s2;
		}else if((s1>s2)&&(s1>s3)){
			return s1;
		}else{
			return s3;
		}
	}


	int[] arrayNumeroCarta(){
		int[] mao = new int[7];
		for(int i = 0; i < 7; i++){
			if((""+carta[i].charAt(0)).equals("A")){
				mao[i] = 14;
			}else if((""+carta[i].charAt(0)).equals("K")){
				mao[i] = 13;
			}else if((""+carta[i].charAt(0)).equals("Q")){
				mao[i] = 12;
			}else if((""+carta[i].charAt(0)).equals("J")){
				mao[i] = 11;
			}else{
				if(((""+carta[i].charAt(0)).equals("1"))&&((""+carta[i].charAt(1)).equals("0"))){
					mao[i] = 10;
				}else{
					mao[i] = Integer.parseInt(""+carta[i].charAt(0));
				}
			}
		}
		return mao;
	}

	String[] arrayNaipeCarta(){
		String[] mao = new String[7];
		for(int i = 0; i < 7; i++){
			if(((""+carta[i].charAt(0)).equals("1"))&&((""+carta[i].charAt(1)).equals("0"))){
				mao[i] = ""+carta[i].charAt(2);
			}else{
				mao[i] = ""+carta[i].charAt(1);
			}
		}
		return mao;
	}

}
