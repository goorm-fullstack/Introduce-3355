echo ${SECURE_KEY} >> ./src/main/resources/Key/testKey.json
java -Dserver.port=$PORT $JAVA_OPTS -Dspring.profiles.active=prod -jar ./build/libs/*.jar
