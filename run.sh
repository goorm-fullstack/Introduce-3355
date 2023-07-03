echo ${SECURE_KEY} >> ./src/main/resources/Key/testKey.json
 java -Dserver.port=$PORT -jar target/Introduce-0.0.1.jar
