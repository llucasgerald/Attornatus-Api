# Test Attornatus Back-end

## Desafio:
Usando Spring boot, crie uma API simples para gerenciar Pessoas. Esta API deve permitir:  
•	Criar uma pessoa
•	Editar uma pessoa
•	Consultar uma pessoa
•	Listar pessoas
•	Criar endereço para pessoa
•	Listar endereços da pessoa
•	Poder informar qual endereço é o principal da pessoa  


Uma Pessoa deve ter os seguintes campos:
```json
{
  "nome": "xxxxxxxxx",
  "dataDeNascimento": "2023-03-04",
  "enderecos": [
    {
      "logradouro": "xxxxxx xxxxxxx xxxxxxx",
      "cep": "0000-000",
      "numero": 00,
      "cidade": "xxxxxxx"
    },
    {
      "logradouro": "xxxxxxxxx",
      "cep": "00000-000",
      "numero": 00,
      "cidade": "xxxx xxxxx"
    }
  ],
  "enderecoPrincipal": {
    "logradouro": "xxxxxxxx",
    "cep": "00000-000",
    "numero": 00,
    "cidade": "xxxxxxxxxx"
  }
}
```
## Requisitos  
•	Todas as respostas da API devem ser JSON  
•	Banco de dados H2

## Tecnologias
•Java 17
•Lombok
•h2 database
•Spring web
•Spring jpa

