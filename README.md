— внедрила в проекте концепцию MVC (основные составляющие приложение - модели таблиц БД, контроллеры и html-шаблоны, а также репозитории, сервисы, dto и мапперы, что позволило снизить связанность кода)

— проработала вопросы безопасности в базе данных: пароли обрабатываются BCryptPasswordEncoder, права доступа, аутентификация и авторизация контролируются с помощью WebSecurityConfig

— работу с моделями БД построила через DTO, что позволяет установить дополнительно важные связи в БД между таблицами (например, список купленных позиций в заказе или заказов у клиента), но избежать бесконечных ошибок StackOverFlow

— воплотила в проекте принципы ООП (абстракция, наследование, инкапсуляция, полиморфизм)
