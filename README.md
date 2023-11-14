# Liga Futmassa

## Objetivo:

O objetivo deste trabalho é a criação de uma aplicação utilizando Spring Boot. O objetivo da aplicação foi deixado em aberto, podendo ser escolhido pelo aluno.

## Descrição:

A aplicação escolhida foi um sistema de cadastro de clubes, onde o usuário pode cadastrar, editar, excluir e listar os clubes. Também é possível criar partidas contra outros clubes e atribuir gols para cada um, formando uma tabela de pontuação. As regras da tabela de pontuação seguem o padrão do Campeonato Brasileiro.

## Tecnologias utilizadas:

- [Java 17](https://www.oracle.com/java/technologies/downloads/#java17)
- [Maven](https://maven.apache.org/)
- [Spring Boot](https://spring.io/projects/spring-boot)
- [Spring Data JPA](https://spring.io/projects/spring-data-jpa)
- [Banco em memória H2](https://www.h2database.com/html/main.html)

## Como executar:

### Clonando o projeto

No terminal execute o comando na pasta desejada
- Se estiver usando HTTPS: 

```bash
   git clone https://github.com/FlavioZanoni/booksFag.git
```

- Se estiver usando SSH: 

```bash
   git clone git@github.com:FlavioZanoni/booksFag.git
```

### De cd até o projeto

```bash
   cd booksFag
```
## Maven
Digite o comando abaixo para rodar o projeto com o maven. Lembrando que dessa forma você precisará estar com o [JAVA_HOME](https://confluence.atlassian.com/confbr1/configurando-a-variavel-java_home-no-windows-933709538.html) configurado.

./mvnw spring-boot:run

[http://localhost:8080](http://localhost:8080)

### 1. Listagem da tabela

- **URL**: `/`
- **Descrição**: Retorna a tabela dos clubes de forma atualizada.
![image](https://github.com/rbortoli21/trab-liga-futmassa/assets/71893509/bc9055ce-4ee0-4459-b3f5-90be61ceaf0d)


### 2. Adicionar clube
- **Descrição**: Redireciona para uma tela de cadastro de clube.
![image](https://github.com/rbortoli21/trab-liga-futmassa/assets/71893509/78930749-88af-48ec-8405-c48dfc6c2102)
![image](https://github.com/rbortoli21/trab-liga-futmassa/assets/71893509/6aec5a30-e2f4-4a93-8f62-7b31140c3818)


### 3. Criar uma partida
- **Descrição**: Redireciona para a criação de uma nova partida.
![image](https://github.com/rbortoli21/trab-liga-futmassa/assets/71893509/1ff33f69-5bac-43b3-abc3-094e3e143d2e)
![image](https://github.com/rbortoli21/trab-liga-futmassa/assets/71893509/94664d25-8a27-4f87-94bc-bbc4841405bd)
Dois clubes podem ser selecionados juntamente com a quantidade de gols que cada clube fez na partida que será cadastrada.

Exemplo: Palmeiras 2 x Corinthians 0

### 4. Listar últimas partidas
- **Descrição**: Lista as últimas partidas cadastradas.
![image](https://github.com/rbortoli21/trab-liga-futmassa/assets/71893509/c8be8f37-14bc-4d10-acfa-7132002f8f59)
![image](https://github.com/rbortoli21/trab-liga-futmassa/assets/71893509/fff7b22b-f6d8-42a1-8ade-efadfa3629a8)


### 5. Deletar clube
- **Descrição**: Deleta um clube caso ele não esteja vinculado à nenhuma partida.
![image](https://github.com/rbortoli21/trab-liga-futmassa/assets/71893509/1da8855c-576c-4e42-888d-c5ac07302413)


### 6. Editar clube
- **Descrição**: Permite a edição de um clube.
![image](https://github.com/rbortoli21/trab-liga-futmassa/assets/71893509/5b4681ce-ccd8-4579-bf12-1edfa274b636)
![image](https://github.com/rbortoli21/trab-liga-futmassa/assets/71893509/2264b73b-4978-4caf-91e1-35d1095f049a)


## Contabilização
A cada nova partida, os clubes relacionados são atualizados e contabilizados de acordo com o resultado da partida.
- Número de jogos é incrementado a cada partida
- Número de vitórias é incrementado caso o placar for maior que o do adversário
- Número de derrotas é incrementado caso o placar for menor que o do adversário
- Número de empates é incrementado caso o placar for igual ao do adversário
- Número de gols feitos é incrementado de acordo com os gols feitos na partida
- Número de gols sofridos é incrementado de acordo com os gols sofridos na partida
- Saldo de gols é atualizado a cada partida, contabilizando como: gols feitos - gols sofridos
- Os pontos são incrementados como: 3 pontos em caso de vitória, 1 ponto em caso de empate e 0 pontos em caso de derrota
