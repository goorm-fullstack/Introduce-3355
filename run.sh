echo ${SECURE_KEY} >> ./src/main/resources/Key/testKey.json
 java -Dserver.port=$PORT $JAVA_OPTS -jar target/Introduce-0.0.1.jar
