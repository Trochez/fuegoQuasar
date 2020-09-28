Fuego Quasar

Esta es una herramienta clasificada desarrollada por las fuerzas rebeldes para detectar naves que envíen mensajes de auxilio

Para esta explicación se asume un despliegue en máquina local


Constal de 3 servicios web: 2 post y 1 get

A continueación se enlistan y se explican los tres servicios:

* topsecret (Post) [http://localhost:8080/fuegoQuasar/topsecret]

	Recibe como parámetro un objecto json con la infromación proveniente de cada satelite (distancia hasta el emisor, mensaje recibido y nombre)

* topsecret_split/{nombre_satelite} (Post) [http://localhost:8080/fuegoQuasar/topsecret_split/{nombre_satelite}]

	Recibe como parámetro un objecto json con la infromación proveniente de un satelite (distancia hasta el emisor, mensaje recibido)
	También recibe el nombre del satélite como variable Path

* topsecret_split/{nombre_satelite} (Get) [http://localhost:8080/fuegoQuasar/topsecret_split/{nombre_satelite}]

	Recibe dos parámentros:
	 - distance: distancia entre el satélite y el emisor
	 - message: arreglo con las palabras recibidas del emisor
	También recibe el nombre del satélite como variable Path




Despliegue:
	
	Requerimientos:

		Para desplegar la aplicación solo se necesita tener instalado un entorno java superior al 8 
		con las variables de entorno definidas

	Procedimiento:
	
		Construir artefacto del proyecto ( en netbeans clean and build)

		Abrir una ventana de comandos, ubicarse en donde esta el archivo .jar 
		(lo más probable es que se llame swagger-0.0.1-SNAPSHOT.jar) y ejecutar
		el siguiente comando: 
		java -jar nombredelarchivo.jar
		El sistema desplegará la aplicación y esta quedara escuchando por el 
		puerto 8080


Prueba:

	La aplicación cuenta con una interfaz que permite probar los servicios incorporada.
	Esta interfaz no solo permite probar cada servicio sino que funciona como documentación
	interactiva que explica cada método y entidad de la aplicación

	Para acceder a dicha interfaz debe entrar al siguiente url una vez que la aplicación 
	esté desplegada:

	http://localhost:8080/swagger-ui.html


URL cloud:

	Esta aplicación se desplegó en una plataforma cloud para ser utilizada desde cualquier parte,
	la plataforma que se seleccionó se llama Heroku.

	Heroku es una plataforma de aplicaciones cloud que permite desplegar aplicaciónes web 
	serverless de tal forma que se pueda utilizar desde cualquier parte del mundo.

	Se eligió Heroku debido a que permite desplegar aplicaciones sin costo en un nivel básico
	y sin especificar un medio de pago

	Al utilizar el link de la aplicación, este puede demorarse un poco en responder en la primera
	llamada debido a que heroku "duerme" las aplicaciones cuando llevan algún tiempo sin utilizarse
	al desplegarse en la forma más básica.

	El URL para utilizar la aplicación desplegada en Heroku es:
	https://fuegoquasar.herokuapp.com/fuegoQuasar
