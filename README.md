# ActiveMQ to DB - Spring Boot and Apache Camel

En este proyecto crearemos un consumidor para ActiveMQ con *Apache Camel* y realizaremos inserciones en H2 DB.

1. [Descargar](http://activemq.apache.org/activemq-5155-release.html) ActiveMQ.

2. Descomprimir e ingresar al folder de ActiveMQ:
```
$ cd apache-activemq-x.y.z
```
3. Run ActiveMQ:
```
$ ./bin/activemq console
```
4. Crear *message.q* queue en admin *http://0.0.0.0:8161/admin/queues.jsp*.

5. Agregar mensaje y enviarlo:
```
{"id": 1, "name": "One", "username": "one"}
```
6. Correr el Proyecto y verificar que el registro fue insertado en la DB, para eso utilizaremos la consola de H2: *http://localhost:8080/h2-console*