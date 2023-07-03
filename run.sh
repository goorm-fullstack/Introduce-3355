echo ${SECURE_KEY} >> env.json
sed 's/*/"/g' env.json >> ./src/resources/Key/testKey.json
java -Dserver.port=$PORT $JAVA_OPTS -jar build/libs/*.jar
