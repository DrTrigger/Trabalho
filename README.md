<h1 align="center">Projeto GymTech</h1>
<img src="https://github.com/user-attachments/assets/3b7dd01e-48f7-4ebc-8b24-00af713e16c1" height=500px width=100%>


<h2>Visão geral</h2>

<p>Este projeto visa auxiliar uma pequena academia de bairro a melhor gerir seus recursos de forma que, 
  a longo prazo, ela possa criar oportunidades de expansão e ter condições para gerir esses recursos em um escopo maior.</p>

<p>As ideias do projeto visam fazer a solução do mesmo disponibilizar:</p>
<ul>
  <li>Oferecimento de planos de assinatura</li>
  <li>Interação entre aluno e professor</li>
  <li>Acesso a fichas de academia de maneira remota</li>
  <li>Ferramentas de gerenciamento para professores</li>
</ul>

<p> A primeira versão deste projeto conta somente com o backend inicial da aplicação, sendo necessário a instalação de uma 
  ferramenta de envio de requisições no caso do desejo de testar as funcionalidades server-side da solução(como, por exemplo, o Postman ou o DogAPI).</p>

<h2>Estrutura de diretório(src/main/java/com/example/demo)</h2>
<ul>
  <li><b>controller:</b> Possui as classes de controle de transmissão de dados da aplicação</li>
  <li><b>model:</b> Contém as classes que representam as entidades do banco de dados da aplicação.</li>
  <li><b>repository:</b> Classes que realizam ações diretas no banco de dados (como por exemplo, inserção de dados)</li>
  <li><b>service:</b> Classes que comunicam com as classes do repository e oferecem métodos de verificação para as classes do diretório controller</li>
  <li><b>utils:</b> Contém a classe DtoConversorToEntity, responsável pela conversão entre DTO e registro do banco de dados</li>
</ul>

<h2>Modelo Conceitual</h2>
<p>O diagrama abaixo ilustra as relações entre as principais entidades desta aplicação:</p>
<img src="https://github.com/DrTrigger/Trabalho/blob/GBLucas1809-patch-1/Gymtech_conceitual.png?raw=true">
<!--![Gymtech_conceitual](https://github.com/user-attachments/assets/fd7fd9f3-4f31-47bd-9ec1-9b8a967e5b7f)-->

<h2>Documentação</h2>

<a name="_page2_x72.00_y72.00"></a>**EQUIPE**



|**Nome**|**Papel**|
| - | - |
|Gabriel Barbosa Lucas|Desenvolvedor, Documentador, Designer de Software|
|Breno Ricardo Ferreira Antunes|Desenvolvedor Back-end, Designer de Software|

<a name="_page2_x72.00_y310.99"></a>**OBJETIVO ESTRATÉGICO DO PROJETO**

O objetivo estratégico do projeto é definido pela seguinte fras

**“Criar uma solução cuja proposta de funcionamento que seja expansível e venha auxiliar no gerenciamento em um futuro cenário de expansão”.**

<a name="_page2_x72.00_y441.38"></a>**RESUMO DO PROJETO**

**Minimundo**

Zezinho é o proprietário da GymTech, uma academia que combina tecnologia e musculação em um ambiente moderno e convidativo, voltado para pessoas que valorizam a saúde e o bem-estar.

Inicialmente, o negócio de Zezinho começou pequeno, com um baixo fluxo de clientes devido ao pouco reconhecimento que o negócio tinha em seu bairro. Porém, com o tempo seu negócio se popularizou, fazendo com que a quantidade de clientes em sua academia aumentasse significativamente. Apesar da GymTech possuir estrutura para comportar essa crescente quantidade de clientes, ela não tem um meio eficiente para gerenciar esse crescimento na clientela. Para resolver esse problema, Zezinho decidiu investir no desenvolvimento de um sistema de gestão para otimizar o controle dos processos na GymTech e proporcionar mais eficiência no atendimento ao cliente e na assistência ao mesmo em seu acompanhamento de

treinos e planos de assinatura.

<a name="_page3_x72.00_y72.00"></a>**IMERSÃO**

A GymTech enfrenta dificuldades em gerenciar o aumento de clientes e oferecer um atendimento eficiente devido à ausência de um sistema organizado para controle de informações e acompanhamento de treinos e planos.

Os clientes poderão realizar cadastro e login, consultar horários de funcionamento e aulas disponíveis, visualizar e assinar planos de maneira autônoma e acompanhar treinos personalizados, permitindo um engajamento direto com seus objetivos.

Do lado administrativo, o sistema permitirá gerenciar perfis de clientes, criar e organizar planos de assinatura, configurar promoções e registrar treinos personalizados para cada cliente. Além disso, incluirá um painel de métricas com informações importantes, como o número de clientes ativos e renovações pendentes, otimizando a tomada de decisões.

<a name="_page3_x72.00_y359.15"></a>**PROBLEMAS QUE O PROJETO VISA RESOLVER**

- **1. Gerenciamento Ineficiente de Clientes:**

  Dificuldade em organizar e acessar informações sobre os clientes, como dados cadastrais, planos ativos e histórico de treinos.

- **2. Acompanhamento de Treinos Personalizados:**

  Ausência de um método prático para os instrutores criarem e atualizarem treinos personalizados e para os clientes acompanharem seu progresso.

- **3. Controle Manual de Planos de Assinatura:**

  Falta de uma ferramenta centralizada para gerenciar planos, renovações e promoções, dificultando o controle e aumentando o trabalho manual.

- **4. Dificuldade de Consulta para Clientes:**

  Clientes não conseguem acessar facilmente informações como horários de funcionamento, aulas disponíveis e status de seus planos.

- **5. Ausência de Dados para Decisões Estratégicas:**

  Falta de métricas claras sobre a operação da academia, como número de clientes ativos, renovações pendentes e adesão a promoções, limitando a tomada de decisões informadas.

<a name="_page4_x72.00_y204.81"></a>**PESSOAS QUE O PROJETO VISA AJUDAR**

1. **Clientes Atuais da GymTech:**

   Pessoas que já frequentam a academia e precisam de uma experiência mais prática para acessar seus planos, acompanhar seus treinos e consultar informações importantes, como horários e promoções.

2. **Novos Clientes Potenciais:**

   Indivíduos interessados em se matricular na GymTech que buscam informações claras sobre os planos disponíveis, promoções e facilidades oferecidas pela academia.

3. **Equipe Administrativa:**

   Fulano e seus funcionários, responsáveis por gerenciar os processos da academia, como cadastro de clientes, criação de planos, personalização de treinos e monitoramento de métricas.

4. **Professores:**

   Profissionais responsáveis pela criação e acompanhamento de treinos personalizados, que precisam de uma ferramenta para organizar e registrar os treinos dos alunos de forma eficiente.

**BENEFÍCIOS DO PROJETO**

1. **Para a administração da GymTech:**
- Maior eficiência no gerenciamento de clientes, planos e treinos.
- Redução de tarefas manuais e economia de tempo.
- Automação de notificações e lembretes para facilitar a comunicação com os clientes.
- Acesso a métricas e relatórios detalhados para decisões estratégicas e crescimento

sustentável.

2. **Para os clientes:**
- Experiência mais prática e moderna, com acesso fácil a informações importantes.
  - Ferramentas para acompanhar treinos personalizados e gerenciar planos de forma

autônoma.

- Atendimento mais ágil e completo, aumentando a satisfação e o engajamento.
3. **Para os instrutores/professores:**
- Mais eficiência na assistência aos clientes em seu acompanhamento de treino;
- Praticidade no gerenciamento das fichas de treino;

<a name="_page5_x72.00_y428.15"></a>**PRODUTOS SEMELHANTES**

Em academias de alcance regional baixo(no contexto do mercado de academias no Brasil), é relativamente comum elas terem seus próprios sistemas de gerenciamento semelhantes à solução proposta por este projeto. Um exemplo de academia é a Engenharia do Corpo (que fica no Shopping Montserrat, Serra, ES, Brasil); que utiliza um sistema para gerenciar a entrada e saída de clientes; bem como a geração de fichas de treino para impressão.

<a name="_page5_x72.00_y571.02"></a>**PERSONAS**

1\. Pessoa jovem-adulta, residente local(que more na região), pratica musculação,

possui dispositivo móvel ou PC(Personal Computer)

**SOLUÇÕES ENCONTRADAS**

- **GymPass:** A proposta do aplicativo se apresenta semelhante no que diz respeito a oferecer planos de assinatura para acesso a academias.

**DIFERENCIAL DO PROJETO**

Capacidade de interagir com professores remotamente e acessar fichas de treino personalizadas via aplicação, sem a necessidade de pedir pela impressão da mesma no atendimento da academia; ou seja, representa um gasto menor por geração de ficha.

<a name="_page6_x72.00_y296.07"></a>**BACKLOG DO PROJETO**



|**ID**|**História do Usuário**|**MoSCoW**|**Importância**|**RoadMap**|
| - | - | - | - | - |
|001|Como Aluno, Instrutor ou Administrador, eu quero poder fazer cadastro e login no sistema|Must Have|Alta|<p>Primeira entrega (19/11)</p><p>~ Segunda entrega</p>|
|002|Como Professor, quero gerenciar os planos de assinatura dos alunos|Must Have|Alta|<p>Primeira entrega (19/11)</p><p>~ Segunda entrega</p>|
|003|Como Professor, quero gerenciar as fichas de treino dos alunos|Must Have|Alta|<p>Primeira entrega (19/11)</p><p>~ Segunda entrega</p>|
|004|Como Cliente, quero gerenciar meu plano de assinatura|Must Have|Alta|<p>Primeira entrega (19/11)</p><p>~ Segunda entrega</p>|
|005|Como Aluno, quero solicitar a mudança da minha ficha de treino|Should Have|Média|<p>Primeira entrega (19/11)</p><p>~ Segunda entrega</p>|
|006|Como Professor, quero gerenciar os cadastros dos alunos|Must Have|Média|<p>Primeira entrega (19/11)</p><p>~ Segunda entrega</p>|



|007|Como Professor, quero gerenciar os equipamentos da academia|Should Have|Baixa|<p>Primeira entrega (19/11)</p><p>~ Segunda entrega</p>|
| - | :- | - | - | :- |

<a name="_page7_x72.00_y191.39"></a>**CONSTRUÇÃO**

<a name="_page7_x72.00_y245.89"></a>**TECNOLOGIA UTILIZADA**

**Java(Ling. de programação) -** O Java foi a linguagem de programação escolhida para este projeto (do lado do servidor), por causa dos seguintes motivos:

1. **"Write Once, Run Anywhere" (WORA)**: O código Java é compilado em bytecode, que é executado pela Java Virtual Machine (JVM). Isso significa que o código pode ser executado em qualquer plataforma que tenha a JVM instalada, independentemente do sistema operacional (Windows, Linux, macOS);
1. **Sintaxe de Orientação a Objetos(O.O):** A sintaxe das estruturas, bem como dos conceitos de Orientação a Objetos aplicados no código, são bastante legíveis e de fácil entendimento. Apesar de ser uma linguagem, no geral, verbosa, possui uma leitura e escrita fácil de assimilar quando o assunto é escrever programas orientados a objetos.

**Spring + Springboot(framework backend) -** O Spring framework (juntamente com o pacote Springboot), foi escolhido pelos seguintes motivos:

1. **Injeção de Dependência (DI):** O Spring promove uma abordagem de Injeção de Dependência, que facilita o gerenciamento de dependências entre os componentes e melhora a modularidade e testabilidade do código.
1. **Configuração Simplificada:** O Spring permite configurações por meio de anotações ou arquivos XML, e, com o Spring Boot, a configuração automática torna o processo ainda mais simples e rápido.

**Framework Front-end: A decidir antes da 2ª entrega do projeto.**

<a name="_page8_x72.00_y72.00"></a>**DIAGRAMA DE PROJETO**

O diagrama abaixo mostra de forma simplificada todas as etapas inerentes ao planejamento e execução deste projeto de software:

![](Aspose.Words.9ce64c67-a686-4f44-a31e-47a0412bee2b.001.jpeg)

O início do projeto, juntamente com o seu planejamento e análise de requisitos, tem uma projeção de duração de 2 semanas, esta maior parte do tempo sendo usada para definir os principais requisitos funcionais (RFs) não-funcionais (RNFs) e regras de negócio (RN) do projeto. A modelagem e documentação serão feitas de forma simultânea, uma vez que a etapa de documentação não necessariamente depende da modelagem para ser iniciada (durante a modelagem, podem vir a surgir alterações na documentação, como, por exemplo, na mudança de prioridade entre casos de uso registrados no backlog, mudança de tecnologias a serem utilizadas, etc).

Obs.: O commit não é uma etapa de ação única. Serão vários commits realizados por implementação, correção ou atualização de recursos do software.

Obs.: O principal foco para a primeira entrega do projeto na parte do desenvolvimento será o lado do back-end, o front-end será implementado na 2ª versão de entrega do projeto.

<a name="_page9_x72.00_y443.79"></a>**DIAGRAMA DE CLASSES![](Aspose.Words.9ce64c67-a686-4f44-a31e-47a0412bee2b.002.jpeg)**

O diagrama acima ilustra um modelo com as principais classes e telas de interface do projeto que são desejadas implementar até o prazo de entrega do mesmo. Pelo diagrama, as telas do pacote “view” dependem das classes do pacote “control”, estas por sua vez dependendo das classes entidade do pacote “model”(consequentemente fazendo do pacote “view” dependente indireto do pacote “model”).

As classes do pacote “model” possuem, cada uma, os seguintes atributos:

1. PessoaEntity
- **id** (private, Long);
- **nome** (private, String);.
- **data\_nascimento** (private, LocalDateTime);
- **cpf** (private, String);
- **email** (private, String);
- **senha** (private, String);
2. AlunoEntity
- ***atributos de PessoaEntity***
- **matricula\_aluno** (private, String);
- **data\_matricula** (private, LocalDateTime);
  1. **restricao\_medica** (private, String);
3. ProfessorEntity
   1. **atributos de PessoaEntity;**
   1. **salario** (private, double);
   1. **cref** (private, String);
   1. **carga\_horaria\_semanal** (private, int)
4. FichaEntity
- **id** (private, Long);
- **data\_inicio** (private, LocalDateTime);
- **data\_fim** (private, LocalDateTime);
- **aluno** (private, AlunoEntity);
- **professor** (private, ProfessorEntity)
5. PlanoEntity
- **id** (private, Long);
- **nome** (private, String);
- .**descricao** (private, String);
- **valor** (private, double);
- **duracao\_meses** (private, int)
6. EquipamentoEntity
- **idEquipamento** (private, Long);
- **nome** (private, String);
- **peso** (private, double);
- **fabricante** (private, String);
- **data\_aquisicao** (private, LocalDateTime);
- **estado** (private, String);
- **descricao** (private, String);
7. ContratoEntity
- **id** (private, Long);
- **aluno**.(private, AlunoEntity);
- **data\_inicio** (private, LocalDateTime);
- **data\_fim** (private, LocalDateTime);
- **data\_vencimento** (private, LocalDateTime);
- **nome** (private, String);
- **status** (private, String);
- **valor\_pago** (private, double)
8. ExercicioFichaEntity
- **id\_exercicio\_ficha** (private, Long);
- **exercício** (private, ExercicioEntity);
- **ficha** (private, FichaEntity);
- **equipamento** (private, EquipamentoEntity);
- **numero\_repeticao** (private, int);
- **tempo\_descanso** (private, int)
- **peso** (private, int)
9. TipoEquipamentoEntity
- **idTipo** (private, Long);
- **nomeTipo** (private, String);
- **descricao** (private, String)
10. SolicitacaoAlteracaoEntity
- **idSolicitacao** (private, Long);
- **idFicha** (private, Long);
- **tipoAlteracao** (private, String);
- **detalhes** (private, String);
- **dataSolicitacao** (private, LocalDateTime);
- **status** (private, String);
- **idAprovador** (private, Long);
- **dataresposta** (private, LocalDateTime)

Da mesma forma, para as classes do pacote “control”, cada uma terá pelo menos 1 dos seguintes métodos:

- criarX();
- editarX();
- deletarX;
- getX();
- listarX();
- atualizarX().

obs.:

X - Nome correspondente à classe no pacote “model” (exemplo: a classe em “control” correspondente a classe FichaEntity em “model” seria Ficha. Então os métodos teeriam os nomes **criarFicha, editarFicha, deletarFicha, getFicha, listarFicha**). Esta informação também se aplica aos parâmetros dos métodos(onde tem XDTO, no exemplo da ficha, seria **FichaDTO**).

Com relação às telas do pacote “view”, cada uma possui uma função:

**TelaCadastro -** Realizar um novo registro de usuário (seja aluno ou professor. Somente um professor pode cadastrar outro professor. Um aluno cadastra a si próprio ou um professor o cadastra).

**TelaLogin -** Fazer login na aplicação.

**TelaPaginaPrincipal -** Página principal da aplicação. A partir dela serão acessadas as outras telas.

**TelaPerfil -** Vai mostrar as informações de perfil do usuário.

**TelaPlanos -** Mostra as opções de planos disponíveis para compra(exclusivo para usuários do tipo Aluno).

**TelaFichaTreino -** Layout que mostrará as informações da ficha de treino personalizada do aluno registrado.

**TelaAlteracaoFicha -** Layout com formulário para abertura de solicitação de alteração de ficha (Esse layout, para um usuário do tipo Professor, aparecerá como uma listagem de solicitações).

**TelaGerenciamento -** Layout voltado para usuários do tipo Professor. A partir deste layout, o usuário será capaz de gerenciar todos os recursos registrados da academia.

<a name="_page13_x72.00_y406.56"></a>**DIAGRAMA DE CASO DE USO**

O diagrama de casos de uso abaixo demonstra as interações entre os agentes Aluno e Professor. O Professor, no contexto da GymTech, atua também como uma espécie de administrador da aplicação; podendo não somente gerenciar as fichas, mas também os cadastros de alunos, professores, gerenciar os planos de assinatura e os equipamentos da academia.

![](Aspose.Words.9ce64c67-a686-4f44-a31e-47a0412bee2b.003.jpeg)



