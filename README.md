# Parcial2_Tecnicas_Programacion

Mi reppositorio: https://github.com/AnaGarciaDelAlamo/Parcial2_Tecnicas_Programacion.git

# Ejercicio 1
## 1) Los elementos que definen a un objeto son:

b) La identidad, los tributos que representan su estado y los métodos que representan su comportamiento

## 2) El hecho de que un método pueda recibir un número variable de atributos se denomina:

b) Polimorfismo

## 3) Imagine que la clase C hereda de la clase B. Y la clase B hereda de la clase A. Cuando se cree un objeto de la clase C, ¿cuál será la secuencia en que se ejecutarán los constructores?

a) Primero el constructor de C, luego constructor de B y, finalmente, el constructor de A

## 4) Para referenciar los atributos de un objeto en un método de la misma clase

a) Debo utilizar la palabra reservada self como prefijo

## 5) En el paradigma de la programación orientado a objetos:

b) Se favorece la semántica y la reutilización de código en detrimento del rendimiento.

# Ejercicio 2

## ¿Cuáles son las características de la programación orientada a objetos?

Abstracción: Permite definir y trabajar con conceptos abstractos, como clases y objetos, que representan entidades del mundo real.
Encapsulamiento: Se refiere a la capacidad de ocultar los detalles de implementación de una clase y exponer solo su interfaz pública, lo que permite controlar el acceso a los datos y protegerlos de modificaciones no autorizadas.
Herencia: Permite crear nuevas clases basadas en clases existentes, heredando sus propiedades y métodos y agregando nuevas funcionalidades.
Polimorfismo: Se refiere a la capacidad de diferentes objetos de una misma clase (o de clases relacionadas) de responder a un mismo mensaje o método de diferentes maneras, adaptándose al contexto en el que son utilizados.

# Ejercicio 3

## ¿Qué es la visibilidad de una variable o un método? ¿Qué tipos hay? ¿Cuándo debe utilizarse cada tipo?

La visibilidad en POO se refiere a la accesibilidad que tienen los atributos y métodos de una clase desde otros objetos o clases. Es decir, define quien tiene permitido acceder y modificar los datos en funciones de un objeto.

Hay 3 tipos de visibilidad: Public: los atributos y los métodos con esta visibilidad pueden ser accedidos y modificados desde cualquier objeto o clase.

Private: los atributos y métodos con esta visibilidad solo pueden ser accedidos y modificados desde la misma clase en la que se definen

Protected: los atributos y métodos solo pueden ser accedidos y modificados desde la misma clase en la que se definen y desde las subclases que heredan de esa clase

La elección de la visibilidad adecuada depende del diseño de la clase y del comportamiento que se quiera obtener. En general, se recomienda seguir el principio de encapsulamiento, que sugiere que los atributos y métodos deben ser privados por defecto, y solo se deben hacer públicos aquellos que sean necesarios para el uso de la clase desde el exterior. De esta manera, se protege el estado de los objetos y se evita que otros objetos modifiquen datos que no deberían.
