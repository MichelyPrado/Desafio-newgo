class Arquivo {
    private nome: string;
    private tipo: string;
    private tamanho: number;

    constructor(nome: string, tipo: string, tamanho: number) {
        this.nome = nome;
        this.tipo = tipo;
        this.tamanho = tamanho;
    }

    public getTamanho(): number {
        return this.tamanho;
    }
}

class Pasta {
    private nome: string;
    private subpastas: Pasta[];
    private arquivos: Arquivo[];

    constructor(nome: string) {
        this.nome = nome;
        this.subpastas = [];
        this.arquivos = [];
    }

    public criarPasta(nome: string): void {
        const pasta: Pasta = new Pasta(nome);
        this.subpastas.push(pasta);
    }

    public criarArquivo(nome: string, tipo: string, tamanho: number): void {
        const arquivo: Arquivo = new Arquivo(nome, tipo, tamanho);
        this.arquivos.push(arquivo);
    }

    public calcularTamanho(): number {
        let tamanhoTotal: number = 0;
        for (const subpasta of this.subpastas) {
            tamanhoTotal += subpasta.calcularTamanho();
        }
        for (const arquivo of this.arquivos) {
            tamanhoTotal += arquivo.getTamanho();
        }
        return tamanhoTotal;
    }

    public excluir(): void {
        for (const subpasta of this.subpastas) {
            subpasta.excluir();
        }
        this.subpastas = [];
        this.arquivos = [];
    }
}

class Disco {
    private nome: string;
    private raiz: Pasta;

    constructor(nome: string) {
        this.nome = nome;
        this.raiz = new Pasta("Raiz");
    }

    public criarPasta(nome: string): void {
        this.raiz.criarPasta(nome);
    }

    public criarArquivo(nome: string, tipo: string, tamanho: number): void {
        this.raiz.criarArquivo(nome, tipo, tamanho);
    }

    public calcularTamanho(): number {
        return this.raiz.calcularTamanho();
    }

    public excluir(): void {
        this.raiz.excluir();
    }
}

const gdrive: Disco = new Disco("GDrive");

// Criar pastas
gdrive.criarPasta("Documents");
gdrive.criarPasta("Pictures");

// Criar subpastas
const documents: Pasta = gdrive.getRaiz().getSubpasta("Documents");
documents.criarPasta("Work");
documents.criarPasta("Personal");

// Criar arquivos
documents.criarArquivo("Report.docx", "Documento", 1024);
documents.criarArquivo("Image.jpg", "Imagem", 2048);

// Calcular tamanho total da pasta "Documents"
const tamanhoDocuments: number = documents.calcularTamanho();
console.log("Tamanho total da pasta Documents: " + tamanhoDocuments + " bytes");

// Excluir a pasta "Documents" e todos os seus arquivos e subpastas
documents.excluir();
