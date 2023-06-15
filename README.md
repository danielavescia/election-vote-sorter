# **Projeto de Pesquisa e Ordenação de Candidatos**
Este projeto tem como objetivo exercitar o método de pesquisa binária e ordenação através ds métodos de inserção direta e seleção direta

## *Classe Candidato*
A classe Candidato possui os seguintes atributos:
- nome: armazena apenas o primeiro nome do candidato.
- partido: uma string que representa o partido ao qual o candidato pertence.
- intencoesVotos: um inteiro que representa a quantidade de intenções de voto obtidas na pesquisa.
- A classe Candidato possui os seguintes métodos:

Métodos de acesso para os atributos (getNome(), getPartido(), getIntencoesVoto()).
Um construtor que recebe informações para inicializar todos os atributos.
O método toString() para retornar uma representação em string dos atributos do candidato.

## *Classe PrincipalCandidatos*
A classe PrincipalCandidatos contém o método main, que é o ponto de entrada do programa.

No método main, é realizado:

- Criação de um array de objetos Candidato com tamanho aleatório entre 1 e 100, preenchendo-o com objetos do tipo Candidato com informações aleatórias.
- Impressão das informações dos candidatos criados, antes da ordenação.
- Ordenação do array de candidatos pelo nome do partido e impressão das informações.
- Ordenação do array de candidatos pelo número de intenções de voto (do maior para o menor) e impressão das informações.
- Ordenação do array de candidatos pelo nome e impressão das informações.
- Pesquisa binária de um candidato pelo nome informado pelo usuário, utilizando o método pesquisaBinariaCandidatos.
- Impressão do resultado da pesquisa binária, mostrando as informações do candidato encontrado ou indicando que não existe candidato com esse nome.

Métodos de Ordenação
- Foram implementados três métodos de ordenação na classe PrincipalCandidatos:
-  ordenaCandidatosPorNome: realiza a ordenação do array de candidatos pelo nome utilizando o método de ordenação por inserção direta.
-  ordenaCandidatosPorVotos: realiza a ordenação do array de candidatos pelo número de intenções de voto (do maior para o menor) utilizando o método de ordenação por inserção direta.
-  ordenaCandidatosPorPartido: realiza a ordenação do array de candidatos pelo nome do partido utilizando o método de seleção direta.

Método de Pesquisa Binária
Foi implementado o método pesquisaBinariaCandidatos na classe PrincipalCandidatos para realizar a pesquisa binária de um candidato pelo nome informado pelo usuário.

Esse método utiliza a busca binária para localizar o candidato pelo nome e retorna a posição em que o candidato foi encontrado ou -1 caso não exista candidato com esse nome no array.

## *Utilização dos Métodos*
- No método main, o array de candidatos é ordenado primeiro pelo nome do partido, em seguida pelo número de intenções de voto e finalmente pelo nome. Após cada ordenação, as informações dos candidatos são impressas.

- Em seguida, o usuário é solicitado a digitar o nome de um candidato para realizar a pesquisa binária. O resultado da pesquisa é impresso, mostrando as informações do candidato encontrado ou indicando que não existe candidato com esse nome.

##  *Observações:*

- Os nomes e partidos dos candidatos foram definidos em arrays fixos, mas é possível modificá-los de acordo com a necessidade.
- O código utiliza a classe Random para gerar números aleatórios.
- Para realizar a pesquisa binária corretamente, o array de candidatos deve estar ordenado pelo nome.
- O código utiliza expressões regulares para validar a entrada do nome do candidato. A entrada só é válida se conter apenas letras.
