# Gestor de Cuentas Bancarias

## Descripción

El **Gestor de Cuentas Bancarias** es una aplicación simple en Java que permite a los usuarios gestionar sus cuentas bancarias. Los usuarios pueden realizar operaciones como depositar y retirar dinero, así como consultar su saldo. La aplicación maneja excepciones personalizadas para situaciones como saldo insuficiente y entradas no válidas.

## Características

- **Depositar dinero**: Permite a los usuarios agregar fondos a su cuenta.
- **Retirar dinero**: Permite a los usuarios retirar fondos, con manejo de excepciones para saldo insuficiente.
- **Consultar saldo**: Muestra el saldo actual de la cuenta.
- **Manejo de errores**: Utiliza excepciones personalizadas para manejar errores de manera efectiva.

## Requisitos

- Java Development Kit (JDK) 8 o superior.
- Un entorno de desarrollo integrado (IDE) como IntelliJ IDEA, Eclipse o NetBeans (opcional).

## Instalación

1. Clona este repositorio en tu máquina local:

   ```bash
   git clone https://github.com/tu_usuario/gestor-cuentas-bancarias.git
Navega al directorio del proyecto:

bash
Run
Copy code
cd gestor-cuentas-bancarias
Abre el proyecto en tu IDE favorito o compílalo desde la línea de comandos.

## Uso

Ejecuta la clase Main para iniciar la aplicación.
Sigue las instrucciones en pantalla para realizar operaciones en tu cuenta bancaria.
Puedes elegir entre las siguientes opciones:
Depositar dinero
Retirar dinero
Ver saldo
Salir
Ejemplo de Uso
plaintext
Run
Copy code
--- Menú ---
1. Depositar dinero
2. Retirar dinero
3. Ver saldo
4. Salir
   Selecciona una opción: 1
   Introduce la cantidad a depositar: 200
   Se han depositado 200. Nuevo saldo: 300.0
   Excepciones Personalizadas
   La aplicación incluye una excepción personalizada llamada SaldoInsuficienteException, que se lanza cuando un usuario intenta retirar más dinero del que tiene en su cuenta. Esto permite un manejo de errores más claro y específico.

## Contribuciones

Las contribuciones son bienvenidas. Si deseas mejorar este proyecto, por favor sigue estos pasos:

Haz un fork del repositorio.
Crea una nueva rama (git checkout -b feature/nueva-caracteristica).
Realiza tus cambios y haz commit (git commit -m 'Añadir nueva característica').
Haz push a la rama (git push origin feature/nueva-caracteristica).
Abre un Pull Request.

## Licencia

Este proyecto está bajo la Licencia MIT. Consulta el archivo LICENSE para más detalles.