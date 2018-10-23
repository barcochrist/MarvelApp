# MarvelApp
App Móvil para dispositivos móviles Android. Muestra la información de personajes, comics y series de Marvel. 
Consume una base de datos NoSQL creada en Firebase.

![marvelapp-characters](https://user-images.githubusercontent.com/13221671/34645169-6e3d8b82-f314-11e7-83c3-6c02d9bae521.png)

## Características
* Muestra información en tiempo real
* Busqueda en cada página
* Permite ver el detalle de cada item (Personaje, Comic, Serie)

## Librerias y servicios utilizados
* [Firebase Realtime Database](https://firebase.google.com/products/realtime-database/)
* [Picasso](https://square.github.io/picasso/)

## Como ejecutar

1. Descargar el repositorio desde Github.
2. Es necesario crear un proyecto en Firebase desde la consola de Firebase con los siguientes datos:

    Nombre del proyecto:  MarvelApp
    Nombre del paquete:   co.hackaton.marvelapp

3. Descargar el archivo de configuración "google-services.json" y pegarlo dentro del directorio /MarvelApp/app
4. Dentro del proyecto de Firebase dirigirse a la pestaña "Database" y crear la base de datos con el archivo JSON "marvelapp-8f4a7-export.json" que se encuentra en la raiz del actual repositorio

5. Ejecutar la aplicación con Android Studio

Nota: Es posible que Android Studio solicite la actualización de algunos componentes o la descarga de algunos componentes faltantes, que son necesarios para ejecutar la aplicación correctamente
