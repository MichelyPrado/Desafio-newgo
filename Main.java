import java.util.ArrayList;
import java.util.List;

//importação das listas do pacote java.util (usadas no código)

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

//classe Arquivo e construtor Arquivo (que inicializa os atributos do objeto)
//o método "getTamanho()" retorna o tamanho do arquivo e imprime nome e tipo

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

    public Pasta getSubpasta(String nome) {
        for (Pasta subpasta : subpastas) {
            if (subpasta.nome.equals(nome)) {
                return subpasta;
            }
        }
        return null;
    }
}

//classe Pasta (representa uma pasta, subpastas e arquivos), construtor Pasta (inicializa os atributos da pasta)
//métodos responsáveis pela criação de Pasta e Arquivo
//método calcularTamanho percorre de maneira recursiva todas as pastas e arquivos calculando o tamanho total da pasta
//método excluir remove todas as pastas e arquivos 
//método getSubpasta busca subpastas pelo nome dentro da lista de subpastas da pasta atual
//recebe um nome como parâmetro e compara com a variável "subpasta"
//se encontrar uma subpasta com o nome desejado retorna ela, se não encontrar retorna null

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

//classe que representa o Disco contendo uma pasta raiz
//método "getRaiz" retorna a pasta raiz

public class Main {
    public static void main(String[] args) {
        Disco gdrive = new Disco("GDrive");

        gdrive.criarPasta("Documents");
        gdrive.criarPasta("Pictures");

        Pasta documents = gdrive.getRaiz().getSubpasta("Documents");
        if (documents != null) {
            documents.criarPasta("Work");
            documents.criarPasta("Personal");

            documents.criarArquivo("Report.docx", "Documento", 1024);
            documents.criarArquivo("Image.jpg", "Imagem", 2048);

            long tamanhoDocuments = documents.calcularTamanho();
            System.out.println("Tamanho total da pasta Documents: " + tamanhoDocuments + " bytes");

            documents.excluir();
        } else {
            System.out.println("Pasta Documents não encontrada.");
        }
    }
}
//na main o disco virtual é de fato usado criando um objeto Disco chamado "gdrive"
//em seguida é calculado o tamanho total da pasta "Documents" e o resultado é printado na saída
//Documents e suas subpastas são excluídos