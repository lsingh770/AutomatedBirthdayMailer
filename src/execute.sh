 
javac	-cp "src/com/java/resources/lib/activation-1.1.jar:src/com/java/resources/lib/commons-collections4-4.3.jar:src/com/java/resources/lib/commons-lang3-3.7.jar:src/com/java/resources/lib/commons-lang3-3.7-sources.jar:src/com/java/resources/lib/commons-logging-1.2.jar:src/com/java/resources/lib/commons-logging-1.2-sources.jar:src/com/java/resources/lib/commons-logging-api-1.1.jar:src/com/java/resources/lib/json-20180130.jar:src/com/java/resources/lib/json-20180130-sources.jar:src/com/java/resources/lib/log4j-1.2.14.jar:src/com/java/resources/lib/log4j-1.2.14-sources.jar:src/com/java/resources/lib/mail-1.4.7.jar:src/com/java/resources/lib/poi-3.15.jar:src/com/java/resources/lib/poi-3.15-sources.jar:src/com/java/resources/lib/poi-ooxml-3.15.jar:src/com/java/resources/lib/poi-ooxml-3.15-sources.jar:src/com/java/resources/lib/poi-ooxml-schemas-3.15.jar:src/com/java/resources/lib/xmlbeans-2.6.0.jar:src:" com/java/main/*.java

echo "Compilation completed, now trying to execute..."

pwd

java -Duser.timezone=Asia/Kolkata -cp ".:src/com/java/resources/lib/activation-1.1.jar:src/com/java/resources/lib/commons-collections4-4.3.jar:src/com/java/resources/lib/commons-lang3-3.7.jar:src/com/java/resources/lib/commons-lang3-3.7-sources.jar:src/com/java/resources/lib/commons-logging-1.2.jar:src/com/java/resources/lib/commons-logging-1.2-sources.jar:src/com/java/resources/lib/commons-logging-api-1.1.jar:src/com/java/resources/lib/json-20180130.jar:src/com/java/resources/lib/json-20180130-sources.jar:src/com/java/resources/lib/log4j-1.2.14.jar:src/com/java/resources/lib/log4j-1.2.14-sources.jar:src/com/java/resources/lib/mail-1.4.7.jar:src/com/java/resources/lib/poi-3.15.jar:src/com/java/resources/lib/poi-3.15-sources.jar:src/com/java/resources/lib/poi-ooxml-3.15.jar:src/com/java/resources/lib/poi-ooxml-3.15-sources.jar:src/com/java/resources/lib/poi-ooxml-schemas-3.15.jar:src/com/java/resources/lib/xmlbeans-2.6.0.jar:src:" com.java.main.User


echo "Execution completed."
