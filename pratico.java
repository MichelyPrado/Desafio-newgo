import java.util.ArrayList;
import java.util.List;

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
        return tamanho;
    }
}

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
}

class Disco {
    private String nome;
    private Pasta raiz;

    public Disco(String nome) {
        this.nome = nome;
        this.raiz = new Pasta("Raiz");
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
}

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
