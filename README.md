# ForumHub

Um projeto de fórum online desenvolvido em **Java** com **Spring Boot**, permitindo a criação, listagem e gerenciamento de tópicos e respostas. Ideal para aprendizado de **desenvolvimento full-stack**, integração com banco de dados relacional e boas práticas de API REST.


## 🚀 Tecnologias utilizadas

- **Backend:** Java, Spring Boot, Spring Data JPA, Hibernate, Spring Security (opcional para autenticação)
- **Banco de dados:** PostgreSQL
- **Validação:** Jakarta Validation (`@Valid`)
- **Build:** Maven
- **Outras ferramentas:** Lombok


## 📋 Funcionalidades

- **Tópicos**
  - Criar novos tópicos com título, mensagem, autor e curso
  - Listar tópicos paginados
  - Visualizar detalhes de um tópico específico
  - Atualizar informações de um tópico
  - Deletar tópicos

- **Respostas**
  - Adicionar respostas a tópicos
  - Marcar respostas como solução
  - Deletar respostas

- **Usuários**
  - Cadastro de usuários
  - Relacionamento com perfis (roles)

- **Cursos**
  - Cadastro e categorização de cursos
  - Relacionamento com tópicos

## 🗂 Estrutura do banco de dados

Tabelas principais:

- `Usuario`: armazena informações de usuários (nome, email, senha)
- `Perfil`: define perfis de acesso
- `Usuario_Perfil`: relaciona usuários e perfis
- `Curso`: armazena cursos relacionados aos tópicos
- `Topico`: tópicos criados pelos usuários, vinculados a curso e autor
- `Resposta`: respostas dos usuários aos tópicos

## 📌 Endpoints principais

### Tópicos
| Método | Endpoint | Descrição |
|--------|---------|-----------|
| POST | `/topicos` | Criar novo tópico |
| GET | `/topicos` | Listar tópicos paginados |
| GET | `/topicos/{id}` | Detalhar tópico |
| PUT | `/topicos` | Atualizar tópico |
| DELETE | `/topicos/{id}` | Deletar tópico |

