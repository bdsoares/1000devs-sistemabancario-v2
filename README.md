
# Sistema Bancario

A proposta do projeto é refatorar o sistema desenvolvido na atividade anterior só que dessa vez persistindo os dados dos clientes em um banco de dados.

Exemplo da atividade anterior disponível em:
https://github.com/bdsoares/1000devs-sistema-bancario

## Sobre

Modele um sistema bancário, através do qual o gerente vai ser capaz de gerenciar os seus clientes.

Nesse sistema os clientes podem ser tanto de pessoa física quanto de pessoa jurídica (PF e PJ).

Os clientes, independente do tipo, tem um número de conta, agência, telefone, saldo e limite de cheque especial.

Os clientes PJ tem no seu cadastro o cnpj, razão social e nome fantasia.

Os clientes PF tem no seu cadastro o cpf, nome e idade.

O gerente é capaz de cadastrar novos clientes (ler todas as informações do teclado);

Remover clientes de sua carteira pelo número de conta (ler o número do teclado);

Consultar cliente pelo número da conta (ler o número do teclado);

Aumentar e diminuir o limite do cheque especial do cliente (ler todas as informações do teclado);

Fazer transferências entre seus clientes (somente se o cliente que transfere tiver saldo) (ler todas as informações do teclado);

Adicionar saldo a um cliente (somente valores positivos) (ler todas as informações do teclado);

Imprimir um relatório com todos os seus clientes (em tela);

## Requisitos

- Utilize o mesmo esquema de classes da atividade anterior;

- Remova o atributo sócios do cliente PJ para esse exercício;

- Você deverá manter duas tabelas no seu BD, uma para clientes PJ, outra para clientes PF;

- Reorganize os pacotes (e classes dentro deles) e sua nomenclatura utilizando a lógica que discutimos em sala;

- Você poderá usar Collections para dar suporte as operações mas todos os dados devem ser persistidos no BD e não devem ser mantidos em memória;

- Crie uma fábrica de conexões;

- Crie um (ou mais de um) DAO com as operações que julgar necessárias para o as suas tabelas, você deverá manter todas as funcionalidades propostas no exercício anterior;

- O banco de dados utilizado deverá ser o POSTGRES;

- O grupo deve usar as ferramentas discutidas em sala até o dia 23/11;

## Equipe

- [@bdsoares](https://www.github.com/bdsoares) Bruno Daniel Soares dos Santos
- [@igorferreira007](https://www.github.com/igorferreira007) Igor Ferreira
- [](https://www.github.com/) Neto Santos
- [@LucasSSoares32](https://www.github.com/LucasSSoares32) Lucas Soares
- [@eduardocf2003](https://www.github.com/eduardocf2003) Eduardo Floriano
- [@amanda-sgl](https://www.github.com/amanda-sgl) Amanda S G Lacerda
- [@angelica-lima](https://www.github.com/angelica-lima) Angelica Lima
- [@TwFelps](https://www.github.com/TwFelps) Felipe Lopes


