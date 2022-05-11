Feature: Отправить письмо

  Background:
    Given Авторизция на сайте

  Scenario:
    When Логин
    And Отправка почты другому пользователю
    Then Проверка отправки