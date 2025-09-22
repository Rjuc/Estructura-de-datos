# Estructura-de-datos
Laboratorio 2

# Árbol Binario de Búsqueda - Estructura de Datos

## Descripción del Proyecto

Este proyecto implementa un árbol binario de búsqueda diseñado para gestionar una colección ordenada de países. La estructura permite operaciones eficientes de inserción, búsqueda y eliminación, manteniendo los datos organizados alfabéticamente de manera automática. El desarrollo se realizó como parte del segundo laboratorio de la asignatura de Estructuras de Datos, aplicando los conceptos teóricos estudiados sobre árboles binarios y aprovechando el conocimiento previo adquirido en la implementación de listas doblemente enlazadas del primer laboratorio.

La implementación utiliza Java como lenguaje de programación y emplea las colecciones estándar del lenguaje, específicamente LinkedList, para gestionar los resultados de los recorridos del árbol. Esta decisión se tomó para mantener consistencia con el trabajo anterior donde se exploró la manipulación de listas, pero ahora aprovechando las librerías predefinidas para optimizar el tiempo de desarrollo y concentrar el esfuerzo en la lógica específica del árbol binario.

## Estructura de Clases

El proyecto se organiza en tres clases principales que trabajan en conjunto para proporcionar la funcionalidad completa del árbol binario de búsqueda. La clase NodoBinario encapsula la información de cada elemento del árbol, manteniendo referencias a su valor (el nombre del país), sus hijos izquierdo y derecho, y su nodo padre. Esta inclusión del nodo padre, aunque incrementa ligeramente el uso de memoria, simplifica significativamente las operaciones de eliminación y navegación en el árbol.

La clase ArbolBinariodeBusqueda constituye el núcleo del proyecto, implementando todas las operaciones requeridas sobre la estructura. Los métodos de inserción y búsqueda siguen el principio fundamental de los árboles binarios de búsqueda, comparando alfabéticamente los valores para determinar la dirección de navegación. El método de eliminación maneja los tres casos posibles: nodos hoja, nodos con un hijo y nodos con dos hijos, utilizando la estrategia del sucesor inorden para el caso más complejo. Los recorridos (preorden, inorden y posorden) se implementan recursivamente, acumulando los resultados en listas que se retornan al usuario sin realizar impresiones directas durante el recorrido.

La clase ArbolTest proporciona un conjunto completo de pruebas automáticas que verifican cada funcionalidad implementada, seguido de un menú interactivo que permite al usuario experimentar con las operaciones del árbol. Esta estructura dual garantiza tanto la validación del código como la demostración práctica de las capacidades del sistema.

## Decisiones de Diseño

Cada decisión técnica tomada durante el desarrollo se basó en criterios específicos de eficiencia, mantenibilidad y experiencia previa. La elección de trabajar con nombres de países como strings en lugar de crear una clase País completa se fundamentó en la simplicidad y claridad del código, considerando que el objetivo principal era demostrar el funcionamiento del árbol binario sin añadir complejidad innecesaria. Esta decisión también mantiene coherencia con el enfoque pedagógico del curso, donde se prioriza la comprensión de las estructuras de datos sobre la complejidad del dominio de aplicación.

El uso de atributos privados con métodos de acceso (getters y setters) responde a los principios de encapsulación estudiados en la asignatura, protegiendo la integridad de la estructura de datos y previniendo modificaciones no controladas. La decisión de no incluir un setter para el valor del nodo refuerza esta protección, garantizando que una vez creado un nodo, su valor permanece inmutable, lo cual es consistente con la naturaleza de un árbol de búsqueda donde cambiar el valor de un nodo podría violar el orden de la estructura.

La implementación de métodos auxiliares como esHoja(), tieneUnHijo() y getUnicoHijo() surgió de la necesidad de simplificar el código del método de eliminación, convirtiendo verificaciones complejas en llamadas a métodos con nombres autodescriptivos. Esta decisión mejora significativamente la legibilidad del código y reduce la probabilidad de errores en la lógica de eliminación, que es típicamente la operación más compleja en un árbol binario de búsqueda.

## Uso de Inteligencia Artificial en el Desarrollo

El desarrollo de este proyecto contó con el apoyo de herramientas de inteligencia artificial como asistente de programación, principalmente para resolver dudas sintácticas específicas de Java y verificar la correctitud de los algoritmos implementados. Sin embargo, todas las decisiones arquitectónicas y de diseño fueron tomadas por el estudiante basándose en los conceptos teóricos estudiados y la experiencia adquirida en el laboratorio anterior. La IA funcionó como un tutor disponible para consultas puntuales, similar a como se consultaría documentación o a un compañero más experimentado, pero sin delegar las decisiones críticas del diseño.

La selección de LinkedList sobre ArrayList para los recorridos, por ejemplo, fue una decisión consciente basada en el análisis de que los recorridos solo requieren añadir elementos al final de la lista, operación en la que LinkedList es eficiente. La estructura del menú interactivo y los casos de prueba fueron diseñados específicamente para demostrar comprensión completa de los casos límite del árbol binario, incluyendo situaciones como eliminación de la raíz, manejo de árboles vacíos y búsqueda de elementos inexistentes.

## Instrucciones de Ejecución

Para ejecutar el programa desde el archivo JAR proporcionado, se debe utilizar el siguiente comando en la terminal:

"java -jar ArbolBinarioBusqueda.jar"

Si se desea compilar desde el código fuente, los pasos son:javac arbolbinario/*.java
java arbolbinario.ArbolTestEjemplo de UsoEl programa inicia ejecutando automáticamente una batería de pruebas que demuestran todas las funcionalidades implementadas. Posteriormente, presenta un menú interactivo donde el usuario puede insertar países como "España" o "Argentina", visualizando cómo se mantiene automáticamente el orden alfabético. Al solicitar la impresión del árbol, el sistema muestra la estructura jerárquica completa, permitiendo observar visualmente cómo se distribuyen los elementos según el algoritmo de inserción del árbol binario de búsqueda.Los recorridos retornan listas que pueden ser procesadas por otras partes de un sistema más grande, cumpliendo con el requisito de no mezclar la lógica de recorrido con la presentación de resultados. Esta separación de responsabilidades permite que el árbol sea reutilizable en diferentes contextos sin modificación del código base.
