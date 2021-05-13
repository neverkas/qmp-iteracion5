## Monedero

### Code Smells detectados

1. La clase *Movimiento* tenía demasiada *responsabilidad* era una *clase dios*
 decidimos separar en dos clases según su tipo Extracción y Depósito
 delegando en ellas 
*code smells detectados:*
  1.clase dios/clase muy grande
  2. Divergent Change

2. Las clases Extracción y Depósito se preguntaban a ellas mismas quienes eran
 decidimos remover esa pregunta, tipico del
*code smells detectados:*
  1. type tests
  2. Data Clumps

3. Dividimos el metodo *sacar* de Cuenta, delegando comportamiento de validación 
en distintos metodos

*code smells detectados:*
  1.long method

### Contexto

Este repositorio contiene el código de un _monedero virtual_, al que podemos agregarle y quitarle dinero, a través 
de los métodos `Monedero.sacar` y `Monedero.poner`, respectivamente. 
Pero hay algunos problemas: por un lado el código no está muy bien testeado, y por el otro, hay numeros _code smells_. 

### Consigna

Tenés seis tareas: 

 1. :fork_and_knife: Hacé un _fork_ de este repositorio (presionando desde Github el botón Fork)
 2. :arrow_down: Descargalo y construí el proyecto, utilizando `maven`
 2. :nose: Identificá y anotá todos los _code smells_ que encuentres 
 3. :test_tube: Agregá los tests faltantes y mejorá los existentes. 
     * :eyes: Ojo: ¡un test sin ningún tipo de aserción está incompleto!
 4. :rescue_worker_helmet: Corregí smells, de a un commit por vez. 
 5. :arrow_up: Subí todos los cambios a tu _fork_

### Tecnologías usadas

* Java 8.
* JUnit 5. :warning: La versión 5 de JUnit es la más nueva del framework y presenta algunas diferencias respecto a la versión "clásica" (JUnit 4). Para mayores detalles, ver:
    *  [Apunte de herramientas](https://docs.google.com/document/d/1VYBey56M0UU6C0689hAClAvF9ILE6E7nKIuOqrRJnWQ/edit#heading=h.dnwhvummp994)
    *  [Entrada de Blog (en inglés)](https://www.baeldung.com/junit-5-migration)
    *  [Entrada de Blog (en español)](https://www.paradigmadigital.com/dev/nos-espera-junit-5/)
* Maven 3.3 o superior
 

  


