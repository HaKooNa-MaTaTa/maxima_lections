## Жизненный цикл бина Spring

1 этап - этап Создания:
1. На этом этапе Spring сканирует все, указанные в его конфигурации, области для нахождения бинов.
2. Spring создает указанный бин.

2 этап - этап Инициализации:
3. Происходит внедрение зависимостей. Через конструкторы, через поля или через сеттеры.
4. 