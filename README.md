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
<img src="https://github-production-user-asset-6210df.s3.amazonaws.com/103284616/394981271-fd7fd9f3-4f31-47bd-9ec1-9b8a967e5b7f.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Credential=AKIAVCODYLSA53PQK4ZA%2F20241212%2Fus-east-1%2Fs3%2Faws4_request&X-Amz-Date=20241212T021645Z&X-Amz-Expires=300&X-Amz-Signature=fdbcf5a8e18a4d9b595645e9b287641579237a6fce557946bbc5d0f7d3f6259c&X-Amz-SignedHeaders=host">
<!--![Gymtech_conceitual](https://github.com/user-attachments/assets/fd7fd9f3-4f31-47bd-9ec1-9b8a967e5b7f)-->

