public class Pessoa implements Comparable {
    //protected String nome;
    //protected int idade;
    private int chave;

    /*public Pessoa(String nome,int idade,int id){
        this.nome=nome;
        this.idade=idade;
        this.chave=id;
    }*/
    public Pessoa(int id){
        this.chave=id;
    }

    public int getKey() {
        return chave;
    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof Pessoa){
            if (getKey()>((Pessoa)o).getKey()){
                return 1;
            }else if (getKey()<((Pessoa)o).getKey()){
                return -1;
            }else {
                return 0;
            }
        }
        return 1;

    }
}
