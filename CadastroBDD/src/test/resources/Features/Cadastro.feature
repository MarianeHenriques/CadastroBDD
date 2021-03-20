# Author
# Date
# Description
Feature: Validar Usuario cadastrado com sucesso
  não possuir cadastro com e-mail
  Usar um nome de usuatio novo

  Scenario: Cadastrar um novo usuario com sucesso
    Given Estando na Pagina de Cadastro
    When Inserir Nome de usuario, email, senha e confirmacao de senha
    And Clicar no Checbox e acionar o botao registrar
    Then Validar usuario Cadastrado
