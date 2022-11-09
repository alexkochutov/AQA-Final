### Этапы выполнения
1. [Планирование](docs/Plan.md)
2. [Отчет по итогам тестирования](docs/Report.md)
3. [Отчет по итогам автоматизации](docs/Summary.md)

### Запуск SUT
1. Клонировать текущий репозиторий с помощью команды 
```markdown
git clone https://github.com/alexkochutov/AQA-Final.git
```
2. Открыть проект в IntelliJ IDEA
3. Запустить Docker-контейнер с помощью команды
```dockerfile
docker-compose up -d
```
4. Для запуска приложения в терминале ввести команду
```shell
java -jar artifacts/aqa-shop.jar
```
5. Открыть в браузере новую вкладку с адресом - http://localhost:8080

### Запуск тестов
1. В терминале ввести команду
```shell
./gradlew clean test
```