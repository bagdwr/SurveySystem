# Online Survey System

1. Чтобы скачать проект с github запускаем команду:
   ```git clone https://github.com/bagdwr/SurveySystem.git```


2. В application.properties есть url базы данных
   ```jdbc:mysql://localhost:3306/surveySystem?useUnicode=true&serverTimezone=UTC```

   Вам необходимо запустить xampp/wampp/mampp запустить сервер и в phpmyadmin создать базу данных с названием **testDB**


3. Запускаете программу  


4. Ждём, когда запуститься сервер. После запуска сервера, отправляем Post запрос, чтобы сгенерировать JWT:

   ```http://localhost:8080/login``` 


5. После того как вы сгенерировали jwt token, можете скопировать x-csrf-token и вставить в headers всех запросов, чтобы проверить все запросы.