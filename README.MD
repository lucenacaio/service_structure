# Projeto E-commerce com Java, Spring e MySQL (Docker) - Service Structure

Este projeto tem como objetivo fornecer uma plataforma de e-commerce completa, construída com Java, Spring e MySQL, para fins de estudo de tecnologia. A aplicação será executada localmente com o uso do Docker e Docker Compose para gerenciar as dependências.


## Requisitos
- Docker
- Docker Compose
- Java 8 ou superior
- Maven

## Instalação
1. Clone o repositório em sua máquina local:

``` git clone https://github.com/lucenacaio/service_structure.git```

2. Navegue até a pasta do projeto:
    ```cd service_structure```
3. Inicie o Docker Compose:
    ``` docker-compose up ```
4. Acesse a aplicação em `http://localhost:8080`.

## Banco de Dados
O banco de dados MySQL utilizado neste projeto está sendo gerenciado pelo Docker Compose. As configurações do banco de dados podem ser encontradas no arquivo `docker-compose.yml`.

# Ferramentas de Monitoramento

Este projeto inclui o uso do [Grafana](https://grafana.com/), uma plataforma de visualização de métricas, e do [Prometheus](https://prometheus.io/), um sistema de coleta e armazenamento de métricas. Juntos, eles fornecem uma solução completa para monitorar e visualizar a saúde e o desempenho do sistema.

## Bibliotecas utilizadas

- [TestContainers](https://www.testcontainers.org/): biblioteca Java que fornece recursos para inicializar contêineres de teste com facilidade.
