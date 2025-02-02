## DispatcherServlet

Что такое DispatcherServlet? Это центральный элемент Spring MVC, который обрабатывает
абсолютно все входящие HTTP-запросы. Он выступает, как фронт-контроллер, перенаправляющий
запросы на соответствующие контролеры.

Жизненный цикл запроса, проходящего через DispatcherServlet:

1. Клиент отправляет запрос.
2. Обработка запроса с фильтрами:
   Запрос, прежде, чем попасть к DispatcherServlet, проходит цепочку фильтров
   например - фильтр аутентификации
3. Запрос пришёл в DispatcherServlet. DS (DispatcherServlet) использует, для определения
   нужного контроллера - HandlerMapping. HandlerMapping - компоненте, который сопоставляет URL запроса с конкретным контроллером.
4. После того, как HM (HandlerMapping) определил нужный нам контроллер, DS использует HandlerAdapter (HA), который нужен
   который нужен для того, что бы вызвать нужный метод контроллера. HandlerAdapter - компонент, который преобразует входные данные
   запроса, в формат данных, который понятен контроллеру. HA находит нужный метод контроллера и запускает его.
5. После выполнения бизнес-логики(функциональности), наш контроллер возвращает объект ModelAndView, который содержит два основных компонента:
    - Model - данные, которые нужно передать в представление
    - View - отображение, в которое нам нужно подставить наши данные.
6. DS получает ModelAndView и идет к ViewResolver (чья задача найти правильное представление для отображения данных) и отдает ему данные.
   Как работает VR:
   Если контроллер вернул строку, то VR будет искать файл с именем, которое указано внутри строки
   (т.е. если вернули "example", то VR будет искать файл с именем "example.jsp" или другое расширение, указанное при настройке VR)
7. Ответ клиенту. После того, как VR нашел нужное представление, оно используется для генерации HTML-страницы или другого контента. 
   Данные из модели подставляются на свои места и после этого все это отправляется обратно к клиенту в виде HTTP-ответа.