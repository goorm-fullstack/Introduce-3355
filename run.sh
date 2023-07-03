echo ${SECURE_KEY} >> env.json
sed 's/*/"/g' env.json >> ./src/main/resources/Key/testKey.json
java -Dserver.port=$PORT $JAVA_OPTS -Dspring.profiles.active=prod -jar ./build/libs/*.jar
