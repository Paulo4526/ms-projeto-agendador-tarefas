<h1 align="center">🗓️ ms-projeto-agendador-tarefas</h1>

<p align="center">
  <strong>Microserviço de gerenciamento de tarefas agendadas</strong><br>
  Parte integrante do <strong>Projeto Agendador</strong>
</p>

<p align="center">
  Java • Spring Boot • MongoDB • JWT • Feign • Microsserviços • Docker • CI/CD
</p>

<hr>

<h2>📌 Sobre o Microserviço</h2>

<p>
  O <strong>ms-projeto-agendador-tarefas</strong> é o <strong>segundo microsserviço</strong>
  do <strong>Projeto Agendador</strong>, responsável pelo
  <strong>cadastro, gerenciamento e execução de tarefas agendadas</strong>.
</p>

<p>
  Ele centraliza as regras de negócio relacionadas às tarefas, como criação,
  atualização, listagem e exclusão, integrando-se de forma segura
  com os demais microsserviços do ecossistema.
</p>

<p>
  ⚠️ Este microsserviço <strong>depende diretamente</strong> do
  <strong>ms-projeto-agendador-usuario</strong> estar
  <strong>em execução (UP)</strong>, pois utiliza autenticação e validação
  de tokens JWT fornecidos pelo serviço de usuários.
</p>

<hr>

<h2>🧩 Papel na Arquitetura</h2>

<p>
  No ecossistema do <strong>Projeto Agendador</strong>, este microsserviço
  se integra da seguinte forma:
</p>

<ul>
  <li>
    <strong>1️⃣ ms-projeto-agendador-usuario</strong> – Serviço central de autenticação e usuários<br>
    🔗
    <a href="https://github.com/Paulo4526/ms-projeto-agendador-usuario" target="_blank">
      https://github.com/Paulo4526/ms-projeto-agendador-usuario
    </a>
  </li>

  <li>
    <strong>3️⃣ ms-projeto-agendador-notificacao</strong> – Envio de notificações (e-mails)<br>
    🔗
    <a href="https://github.com/Paulo4526/ms-projeto-agendador-notificacao" target="_blank">
      https://github.com/Paulo4526/ms-projeto-agendador-notificacao
    </a>
  </li>

  <li>
    <strong>4️⃣ ms-projeto-agendador-bff</strong> – Backend for Frontend (orquestração de APIs)<br>
    🔗
    <a href="https://github.com/Paulo4526/ms-projeto-agendador-bff" target="_blank">
      https://github.com/Paulo4526/ms-projeto-agendador-bff
    </a>
  </li>
</ul>

<hr>

<h2>🚀 Tecnologias Utilizadas</h2>

<h3>🧠 Linguagem & Framework</h3>
<ul>
  <li><strong>Java 21</strong></li>
  <li><strong>Spring Boot</strong></li>
  <li>Spring Web</li>
  <li>Spring Data MongoDB</li>
  <li>Spring Security</li>
</ul>

<h3>🔐 Segurança</h3>
<ul>
  <li>JWT (JSON Web Token)</li>
  <li>Filtro de autenticação customizado</li>
  <li>Validação de token entre microsserviços</li>
</ul>

<h3>🗄️ Persistência</h3>
<ul>
  <li>MongoDB</li>
  <li>Spring Data MongoDB</li>
</ul>

<h3>🔗 Integrações</h3>
<ul>
  <li>Feign Client para comunicação entre microsserviços</li>
  <li>Integração com o microserviço de usuários</li>
  <li>Integração com o microserviço de notificações</li>
</ul>

<h3>🛠 Build & Infraestrutura</h3>
<ul>
  <li>Gradle</li>
  <li>Docker</li>
  <li>Docker Compose</li>
  <li>GitHub Actions (CI)</li>
</ul>

<hr>

<h2>🐳 Execução com Docker</h2>

<h3>📦 Criar a imagem Docker</h3>

<pre><code>docker build -t ms-projeto-agendador-tarefas .</code></pre>

<h3>🚀 Subir a aplicação com Docker Compose</h3>

<pre><code>docker compose build api .</code></pre>
<pre><code>docker compose up -d</code></pre>

<p>
  ⚠️ Certifique-se de que o <strong>ms-projeto-agendador-usuario</strong>
  já esteja em execução antes de iniciar este serviço.
</p>

<hr>

<h2>🏗️ Conceitos Arquiteturais</h2>

<ul>
  <li>Arquitetura de <strong>Microsserviços</strong></li>
  <li>Separação de responsabilidades (Controller, Service, Repository)</li>
  <li>DTO para transporte de dados</li>
  <li>Mapeamento DTO ↔ Entity</li>
  <li>Injeção de Dependência (IoC / DI)</li>
  <li>Comunicação síncrona entre microsserviços</li>
  <li>Autenticação e autorização via JWT</li>
  <li>Tratamento de exceções personalizadas</li>
  <li>Configuração por variáveis de ambiente</li>
  <li>Containerização com Docker</li>
</ul>

<hr>

<h2>📦 Benefícios da Solução</h2>

<ul>
  <li>Centralização das regras de negócio de tarefas</li>
  <li>Escalabilidade independente do serviço</li>
  <li>Alta coesão e baixo acoplamento</li>
  <li>Integração segura entre microsserviços</li>
  <li>Preparado para ambientes cloud</li>
</ul>

<hr>

<p align="center">
  <strong>Projeto Agendador</strong><br>
  Microsserviços • Java • Spring Boot • MongoDB
</p>

<p align="center">
  Desenvolvido por <strong>Paulo Bueno</strong>
</p>
