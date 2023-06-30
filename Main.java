import java.util.ArrayList;
import java.util.List;
//importando as classes do pacote java.util que serão usadas pra armazenar arquivos dentro da classe Pasta

class Arquivo {
    private String nome;
    private String tipo;
    private long tamanho;

    public Arquivo(String nome, String tipo, long tamanho) {
        this.nome = nome;
        this.tipo = tipo;
        this.tamanho = tamanho;
    }

    public long getTamanho() {
        System.out.println("Nome do arquivo: " + nome);
        System.out.println("Tipo do arquivo: " + tipo);
        return tamanho;
    }
}
//definição da classe Arquivo (representa um arquivo dentro do disco virtual)
//o construtor Arquivo inicializa os atributos e possui o método getTamanho() que retorna o tamanho do arquivo

class Pasta {
    private String nome;
    private List<Pasta> subpastas;
    private List<Arquivo> arquivos;

    public Pasta(String nome) {
        this.nome = nome;
        this.subpastas = new ArrayList<>();
        this.arquivos = new ArrayList<>();
    }

    public void criarPasta(String nome) {
        Pasta pasta = new Pasta(nome);
        subpastas.add(pasta);
    }

    public void criarArquivo(String nome, String tipo, long tamanho) {
        Arquivo arquivo = new Arquivo(nome, tipo, tamanho);
        arquivos.add(arquivo);
    }
    //definição da classe Pasta, a lista "subpastas" armazena os arquivos ali contidos
    //o construtor Pasta inicializa os atributos da classe
    //os métodos permitem adicionar subpastas e arquivos e criam os objetos "Pasta" e "Arquivo"

    public long calcularTamanho() {
        long tamanhoTotal = 0;
        for (Pasta subpasta : subpastas) {
            tamanhoTotal += subpasta.calcularTamanho();
        }
        for (Arquivo arquivo : arquivos) {
            tamanhoTotal += arquivo.getTamanho();
        }
        return tamanhoTotal;
    }

    public void excluir() {
        for (Pasta subpasta : subpastas) {
            subpasta.excluir();
        }
        subpastas.clear();
        arquivos.clear();
    }
}
//método "calcularTamanho()" calcula o tamanho total da pasta (com chamada recursiva)
//método "excluir()" é responsável por excluir as pastas e subpastas (também de forma recursiva)

class Disco {
    private String nome;
    private Pasta raiz;

    public Disco(String nome) {
        this.nome = nome;
        this.raiz = new Pasta("Raiz");
    }

    public String getNome() {
        return nome;
    }

    public void criarPasta(String nome) {
        raiz.criarPasta(nome);
    }

    public void criarArquivo(String nome, String tipo, long tamanho) {
        raiz.criarArquivo(nome, tipo, tamanho);
    }

    public long calcularTamanho() {
        return raiz.calcularTamanho();
    }

    public void excluir() {
        raiz.excluir();
    }

    public Pasta getRaiz() {
        return raiz;
    }
}

// a classe Disco representa o disco virtual (com atributo "nome" e objeto "Pasta" com nome "raiz")
//os métodos são chamados na pasta raiz e fornecem um ponto de entrada 
//pra calcular o tamanho total e exclusão recursiva de todos os elementos

public class Main {
    public static void main(String[] args) {
        Disco gdrive = new Disco("GDrive");

        // Criar pastas
        gdrive.criarPasta("Documents");
        gdrive.criarPasta("Pictures");

        // Criar subpastas
        Pasta documents = gdrive.getRaiz().getSubpasta("Documents");
        documents.criarPasta("Work");
        documents.criarPasta("Personal");

        // Criar arquivos
        documents.criarArquivo("Report.docx", "Documento", 1024);
        documents.criarArquivo("Image.jpg", "Imagem", 2048);

        // Calcular tamanho total da pasta "Documents"
        long tamanhoDocuments = documents.calcularTamanho();
        System.out.println("Tamanho total da pasta Documents: " + tamanhoDocuments + " bytes");

        // Excluir a pasta "Documents" e todos os seus arquivos e subpastas
        documents.excluir();
    }
}
//na main o disco virtual é de fato usado criando um objeto Disco chamado "gdrive"
//em seguida é calculado o tamanho total da pasta "Documents" e o resultado é printado na saída
//Documents e suas subpastas são excluídos