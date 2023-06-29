1. Quais são os contras de utilizar-se herança entre classes? Quais alternativas você adotaria caso quisesse deixar de usar herança em um relacionamento específico? Dê um exemplo

Na minha opinião, os maiores contras de se usar herança entre classes estão relacionados a hierarquia das classes, pois a classe filha vai herdar todas as características da clase pai sendo que alterações feitas na pai podem gerar alterações nas classes filhas também e podem ser alterações indesejadas, muitas vezes deixando o código confuso e difícil de dar manutenção ou reutilizar o código, se for o caso.

Pra substituir a utilização da herança em um relacionamento específico, uma alternativa é uma reutilização de código mais flexível, a composição. Na composição, uma classe contém instâncias de outras classes como membros, delegando as funcionalidades necessárias aos objetos contidos.

um exemplo prático:

public class Carro {
    private Motor motor;

    public Carro() {
        this.motor = new Motor();
    }

    public void ligar() {
        motor.ligar();
    }

    public void desligar() {
        motor.desligar();
    }
}

public class Motor {
    public void ligar() {
        System.out.println("Motor ligado");
    }

    public void desligar() {
        System.out.println("Motor desligado");
    }
}

Nesse exemplo, em vez de criar uma classe "Carro" que herda de uma classe "Veiculo", utilizamos composição para incluir um objeto "Motor" dentro da classe "Carro". Dessa forma, a classe "Carro" pode utilizar as funcionalidades do motor por meio de chamadas de métodos, delegando as operações necessárias ao objeto "Motor".


2. Suponha que você tem uma classe final, da qual você não tem o código-fonte, e que você deseja adicioná-la a uma estrutura de polimorfismo, mas cuja interface pública é ligeiramente diferente da classe. Que padrão de projeto você poderia utilizar para aproveitar o código desta classe, mas fazendo com que ela atenda à interface da esperada na estrutura de polimorfismo?

Nessa situação,  seria possível fazer uso de um padrão de projeto Adaptador (Adapter). Porque ele permitiria envolver uma classe existente com uma nova interface, podendo ser utilizada em um contexto diferente sem modificar seu código-fonte original.

O passo a passo pra essa situação seria algo como: 
I. Criar uma nova interface que represente a interface desejada na estrutura de polimorfismo.
II. Implementar essa nova interface em uma nova classe, que será o adaptador.
III. Incluir nesse Adaptador uma instância da classe final (para a qual você não tem acesso ao código-fonte) como um atributo.
IV. Nos métodos do Adaptador, utilizar os métodos da classe final para realizar as operações necessárias, adaptando a chamada aos métodos da nova interface.
Assim, o Adaptador poderá ser usado como se fosse uma instância da interface desejada, aproveitando o código da classe final sem precisar modificá-la.


3. Em que cenários você poderia usar um proxy? Dê um exemplo real.

Em cenários onde é necessário fazer o controle de acesso a um objeto ou fornecer funcionalidaes adicionais como acesso remoto, inicialização tardia, logging, cache, entre outros.
Por exemplo, permitindo ou negando a chamada de determinados métodos com base em critérios definidos. Um proxy de segurança pode verificar as permissões do usuário antes de permitir o acesso a certas funcionalidades.

Acesso remoto: Quando você precisa acessar um objeto remoto, como um serviço web ou um servidor, o proxy pode ser usado para fornecer uma representação local desse objeto remoto. O proxy gerencia a comunicação com o objeto remoto, tratando detalhes de rede e fornecendo uma interface simplificada para o cliente.

Um exemplo real de uso desse padrão é um proxy de imagens em um aplicativo web. 
Suponha que você esteja construindo um site que exiba várias imagens. Em vez de carregar todas as imagens de uma vez, você pode usar um proxy de imagem. Ele seria responsável por carregar as imagens somente quando elas são realmente necessárias, em vez de carregá-las todas de uma vez. Além disso, o proxy pode implementar recursos de cache para armazenar as imagens já carregadas, evitando o carregamento repetido e pode também pode lidar com casos em que as imagens não estão disponíveis ou fornecer uma versão substituta em caso de falha de carregamento.


4. Você prefere utilizar domínios anêmicos ou ricos? Como avalia os prós e contras de cada?

Eu particularmente não tenho experiência com Java, mas de acordo com as minhas pesquisas, entendo que a escolha entre um desses dois domínios vai depender muito do contexto do projeto, da complexidade do problema e das preferências da equipe de desenvolvimento. Em alguns casos, um domínio anêmico pode ser suficiente e mais fácil de manter. Em outros casos, um domínio rico pode fornecer uma modelagem mais expressiva e coesa. A melhor abordagem depende das necessidades e requisitos específicos do projeto.

No domínio anêmico, as classes são frequentemente simples contêineres de dados sem comportamentos significativos.
As regras de negócio são implementadas em serviços ou classes externas, deixando as classes de domínio com pouca ou nenhuma lógica.
As classes de domínio anêmicas geralmente refletem as estruturas dos dados do domínio, mas não possuem comportamentos complexos, pois fogem do conceito de Orientação a Objeto.
Prós:
Simplicidade: As classes anêmicas são fáceis de entender e manter, pois seu foco principal é apenas armazenar dados e as regras de negócio são mantidas separadas das classes de domínio, facilitando a manutenção e testabilidade.
Contras:
Elas podem resultar em baixa coesão, pois a lógica de negócio é espalhada por toda a aplicação.
Dificuldade de evolução: Adicionar ou alterar regras de negócio pode exigir modificações em vários serviços externos.

No domínio rico, as classes contêm tanto os dados quanto o comportamento relacionado às regras de negócio e são modeladas de forma mais expressiva, encapsulando a lógica de negócio e permitindo interações mais ricas entre os objetos.
Prós:
Coesão e encapsulamento: As classes de domínio ricas encapsulam o comportamento relacionado às regras de negócio, resultando em maior coesão.
Legibilidade: O domínio rico reflete com mais precisão o domínio do problema, tornando o código mais legível e compreensível.
Contras:
Complexidade: À medida que as classes de domínio se tornam mais ricas em comportamento, a complexidade do código pode aumentar e o domínio rico pode exigir mais tempo e esforço para entender e desenvolver, especialmente para desenvolvedores menos familiarizados com o domínio do problema.


5. Dê um exemplo do bom uso do princípio OCP, da sigla SOLID.

S.O.L.I.D: Os 5 princípios da POO:
S — Single Responsiblity Principle (Princípio da responsabilidade única)
O — Open-Closed Principle (Princípio Aberto-Fechado)
L — Liskov Substitution Principle (Princípio da substituição de Liskov)
I — Interface Segregation Principle (Princípio da Segregação da Interface)
D — Dependency Inversion Principle (Princípio da inversão da dependência)

Esses princípios ajudam o programador a escrever códigos mais limpos, separando responsabilidades, diminuindo acoplamentos, facilitando na refatoração e estimulando o reaproveitamento do código.

OCP: Open-Closed Principle (Princípio Aberto-Fechado)
Desenvolvimento de softwares, objetos ou entidades devem estar abertos para extensão, mas fechados para modificação, ou seja, quando novos comportamentos e recursos precisam ser adicionados no software, devemos estender e não alterar o código fonte original.

Um caso que pode ser exemplificado seria o desenvolvimento de um sistema de processamento financeiro que precisa lidar com diferentes tipos de pagamentos, como cartão de crédito, transferência bancária e PayPal. Você deseja garantir que o sistema seja flexível para permitir a adição de novos tipos de pagamento no futuro sem precisar modificar o código existente.
Em vez de implementar diretamente a lógica de processamento de pagamentos dentro de uma única classe, você pode seguir o princípio OCP usando uma abordagem baseada em interfaces e implementações específicas para cada tipo de pagamento. 
Poderia ser criada uma interface "Pagamento" que define o contrato para o processamento de pagamentos e algumas implementações necessárias pra cada tipo específico (crédito, pix, PayPal), cada uma com sua própria lógica para processar o respectivo tipo de pagamento. Quando for necessário adicionar uma nova forma de pagamento basta criar uma nova implementação da interface "Pagamento" com a lógica específica para esse tipo. O restante do código existente não precisa ser modificado, pois ele já está aberto para extensão através da interface Pagamento.
Isso permite que você adicione facilmente novos tipos de pagamento ao sistema sem afetar o código existente, seguindo o princípio OCP.


6. Qual é a diferença entre requisitos funcionais, não-funcionais e regras de negócio. Dê um exemplo de cada.

São termos comuns da engenharia de software para descrever diferentes tipos de necessidades de um sistema.

Os requisitos funcionais descrevem as funcionalidades, ações e os comportamentos específicos que o sistema deve realizar. Eles definem o que o sistema deve fazer para atender às necessidades e expectativas dos usuários e estão relacionados diretamente com as operações e ações do sistema. 
Alguns exemplos de requisitos funcionais em um sistema de vendas online podem ser:
- O sistema deve permitir que os usuários adicionem itens ao carrinho de compras.
- O sistema deve permitir que os usuários realizem o pagamento dos produtos selecionados.
- O sistema deve enviar uma confirmação de pedido por e-mail após a conclusão da compra.

Os requisitos não funcionais descrevem as características e as qualidades gerais do sistema,  eles se concentram em aspectos como desempenho, segurança, usabilidade e confiabilidade, definindo como o sistema deve ser em termos de seus atributos e propriedades, como por exemplo:
- O sistema deve ter uma resposta de tempo de carregamento das páginas de no máximo 2 segundos.
- O sistema deve suportar simultaneamente 1000 usuários ativos.
- O sistema deve garantir a segurança das informações do usuário por meio de criptografia.

Já as regras de negócio são declarações que definem os procedimentos, restrições, políticas  e os comportamentos que governam o funcionamento do negócio, são geralmente independentes de um sistema específico e se aplicam a diferentes processos e sistemas dentro de uma organização. 
Exemplos de regras de negócio podem incluir:
- Um cliente só pode fazer uma compra se estiver registrado no sistema.
- O desconto de um produto não pode exceder 20% do preço original.
- Um usuário não pode alterar suas informações pessoais após o envio do pedido.

É importante compreender e documentar adequadamente os requisitos funcionais, não funcionais e as regras de negócio para garantir que o sistema seja desenvolvido de acordo com as necessidades e expectativas dos usuários e com os padrões e requisitos estabelecidos pela organização.


7. Quais estratégias de diagramação você utiliza em seus projetos? Quais diagramas e por quê?

Eu ainda não fiz nenhum projeto em Java, mas sei que que os diagramas são ferramentas de comunicação e documentação, utilizados para melhorar a compreensão e a colaboração entre a equipe de desenvolvimento do projeto e essa escolha vai depender das necessidades específicas de cada projeto, do estágio de desenvolvimento e das áreas de foco, como estrutura, comportamento, arquitetura ou interação. 
Considero importante o diagrama de classes porque é fundamental para modelar as classes e relacionamentos no sistema. Ele representa as classes, interfaces, atributos, métodos e suas relações, como associações, heranças e implementações, ajuda a visualizar a estrutura do sistema, identificar as classes principais e suas interações, e auxiliar no design da arquitetura orientada a objetos.


8. Você está utilizando GitFlow e precisa fazer uma alteração na versão em desenvolvimento de um projeto. Quais etapas você teria que realizar?

1- Verificar a branch atual e me certificar de estar na branch correta de desenvolvimento antes de fazer alterações (comando git branch)

2- Criar uma nova  branch de feature para adicionar a alteração (comando git flow feature start <nome-da-feature> para criar e mudar para o novo branch de feature)

3- Realizar as alterações necessárias no código-fonte do projeto para adicionar a funcionalidade ou corrigir o problema desejado.

4- Fazer commits das alterações com mensagens claras e descritivas (comando git commit )

5- Publicar essa branch de feature no repositório remoto (comando git flow feature publish <nome-da-feature>)

6- Concluir a feature e mesclar as alterações no branch de desenvolvimento (comando git flow feature finish <nome-da-feature>)

7- Sincronizar a branch e garantir a atualização dela (comando git pull origin develop para obter as últimas alterações do repositório remoto)

Após concluir a alteração e sincronizar o branch de desenvolvimento, é só continuar trabalhando nele para adicionar mais funcionalidades ou correções.


9. O que você deve ter feito para que uma funcionalidade que você pegou para implementar seja considerada como 'done'?

É recomendado seguir um protocolo de boas práticas comuns de desenvolvimento de software e garantir que a funcionalidade seja testada, revisada, documentada e validada de acordo com as diretrizes e os padrões estabelecidos pela equipe.
Eis alguns pontos importantes a se considerar:

- Implementação do código de acordo com os requisitos e especificações estabelecidos: sintaxe correta e um código escrito corretamente, seguindo boas práticas de programação e que seja de fácil manutenção. 
- Testar a funcionalidade adequadamente sempre que possível fazendo testes unitários que cubram cenários de testes relevantes.
- Manter uma integração contínua do código, onde ele é compilado, testado e verificado automaticamente. Isso ajuda a identificar problemas o mais cedo possível e manter a qualidade do código.
- Revisão de código: sempre que possível, pedir pra um colega de equipe revisar seu código. Isso ajuda a identificar possíveis melhorias, erros ou problemas de legibilidade.
- Manter a documentação técnica atualizada daquele código, seja com javadocs, comentários no código ou até mesmo criar uma documentação do usuário. A documentação clara e precisa é importante para ajudar outros desenvolvedores a entenderem e utilizarem a funcionalidade.
- Quando pertinente, fazer testes de aceitação ou testes de sistema para verificar se a funcionalidade atende aos requisitos do usuário final, especialistas no domínio ou pela equipe de controle de qualidade.
- Finalmente a implantação da funcionalidade em ambiente de produção. Verificando se a implantação foi realizada com sucesso e se a funcionalidade está performando corretamente no ambiente de destino.


10. Quais são as cerimônias do SCRUM e como você avalia a importância de cada?

O Scrum é um framework ágil de gerenciamento de projetos composto por cerimônias (ou eventos) importantes que ajudam a manter o desenvolvimento do projeto alinhado, promovem a colaboração e fornecem transparência sobre o progresso do trabalho.
A importância de cada cerimônia varia dependendo do contexto do projeto, mas, de maneira geral, todas desempenham um papel fundamental no sucesso do Scrum, ajudando a alinhar as metas da equipe e a entrega de valor de forma frequente e desenvolta.

As cerimônias são:
Sprint Planning (Planejamento da Sprint):Uma sequência de prioridades (Blacklog) acompanhada de um prazo é uma Sprint, uma reunião que ocorre no início de cada projeto onde a equipe de desenvolvimento, o Scrum Master e o Product Owner colaboram para definir os objetivos, metas e prazos do time.
Nesta cerimônia, é estabelecida a direção do trabalho e o alinhamento de todos da equipe.

Daily Scrum (Scrum Diário):
Reunião diária curta (15 minutos) em que a equipe compartilha o progresso do trabalho, discute os desafios enfrentados e se alinha para o dia. Cada membro da equipe responde a três perguntas: O que foi feito desde a última reunião? O que será feito até a próxima reunião? Quais são os impedimentos? Essa cerimônia é importante para manter todos na equipe atualizados, identificar problemas e promover a colaboração e o alinhamento diário.

Ao final de cada Sprint, existem duas etapas:
A primeira é a Sprint Review (Revisão da Sprint), onde o time inteiro revisa a Sprint entregue e é uma oportunidade para a equipe demonstrar as funcionalidades concluídas ao Product Owner e outras partes interessadas. É importante para obter feedback, validar as entregas e garantir que o trabalho esteja alinhado com as expectativas do cliente. 
A segunda é a Sprint Retrospective (Retrospectiva da Sprint)  onde o time verifica as ações tomadas durante o processo, se foram corretas e o que pode ser melhorado para os próximos ciclos. Essa cerimônia é essencial para promover a aprendizagem contínua, aprimorar o processo de trabalho e fortalecer a colaboração e o trabalho em equipe.


11. Você conhece e utiliza Docker nos seus projetos? Se sim, para que?

Eu nunca utilizei essa ferramenta, mas fiz uma pesquisa a respeito e entendi que é uma forma de "transportar" meu software do ambiente de desenvolvimente para a Produção propriamente dita.

E pra realizar este "transporte", preciso garantir que o ambiente de Produção tenha todos os pré-requisitos instalados, de preferência uma versão do S.O. parecida com a do ambiente de Desenvolvimento entre outros cuidados que devem ser tomados (relacionados a permissionamento, serviços dependentes e etc...).

Com o Docker temos um container com nosso software. Esse container é levado inteiro para o outro ambiente.
Com isso não preciso me preocupar com pré-requisitos instalados no outro ambiente, versão do S.O., permissionamento e se quiser posso ter containers para os serviços dependentes também. Dessa forma minimiza-se muito a divergência entre os ambientes.

Em resumo, o Docker oferece um ambiente isolado, portátil e consistente para executar os programas necessários, simplificando o gerenciamento de dependências, aumentando a reprodutibilidade e facilitando a escalabilidade. Ele se tornou uma ferramenta popular no desenvolvimento de aplicativos modernos, permitindo a adoção de práticas como DevOps, microservices e computação em nuvem de forma mais eficiente.