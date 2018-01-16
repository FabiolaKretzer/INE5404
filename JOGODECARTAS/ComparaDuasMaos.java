//this file was written by Valdivino Morais


public class ComparaDuasMaos {
	String mao1 = "", mao2 = "";

	public ComparaDuasMaos(String mao1, String mao2) {
		this.reset(mao1, mao2);
	}

	void reset(String mao1, String mao2){
		this.mao1 = mao1;
		this.mao2 = mao2;
	}

	String comparaMaos(){
		if(valorInteiroMao(mao1)<valorInteiroMao(mao2)){
			return "Jogador2 venceu";
		}else{
			return "Jogador1 venceu";
		}
	}

	String getMao1(){
		return "Jogador 1: " +mao1;
	}

	String getMao2(){
		return "Jogador 2: " +mao2;
	}

	int valorInteiroMao(String mao){
		int n;
		if(mao.equals("royalFlush")){
			n = 10;
		}else if(mao.equals("straightFlush")){
			n = 9;
		}else if(mao.equals("quadra")){
			n = 8;
		}else if(mao.equals("fullHouse")){
			n = 7;
		}else if(mao.equals("flush")){
			n = 6;
		}else if(mao.equals("sequencia")){
			n = 5;
		}else if(mao.equals("trinca")){
			n = 4;
		}else if(mao.equals("duasDuplas")){
			n = 3;
		}else if(mao.equals("dupla")){
			n = 2;
		}else{
			n = 1;
		}
		return n;
	}
}
